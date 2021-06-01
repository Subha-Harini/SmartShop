package com.cognizant.productservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.resuable.dataaccesslayer.entities.Bill;
import com.demo.resuable.dataaccesslayer.entities.BillDetails;
import com.demo.resuable.dataaccesslayer.entities.Product;
import com.demo.resuable.dataaccesslayer.entities.ProductList;
import com.demo.resuable.dataaccesslayer.entities.User;
import com.demo.resuable.dataaccesslayer.entities.UserBill;
import com.demo.resuable.dataaccesslayer.repository.interfaces.BillRepository;
import com.demo.resuable.dataaccesslayer.repository.interfaces.OfferRepository;
import com.demo.resuable.dataaccesslayer.repository.interfaces.ProductRepository;
import com.demo.resuable.dataaccesslayer.repository.interfaces.UserRepository;
import com.demo.resuable.exceptionhandler.exception.ProductExpiredException;

@Service
public class BillService {
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;

	public List<Bill> getAllBills(){
		return this.billRepository.findAll();
	}
	
	public Bill getBillByBillId(int id){	
		return billRepository.findByBillId(id).get();
	}
	
	public Bill userBills(UserBill userBill) throws ProductExpiredException {
		float total = 0;
		float discountedTotal = 0;
		Bill bill = new Bill();
		bill.setPurchaseDate(userBill.getPurchaseDate());
		User userDetails = new User();
		System.out.println(userRepository.findByUserId(userBill.getUserId()));
		userDetails = userRepository.findByUserId(userBill.getUserId());
		System.out.println(userDetails);
		bill.setUser(userDetails);
		int billId;
		try {
			billId = billRepository.findMaximunBillId();
		}catch(Exception e) {
			billId=1;
		}
		System.out.println(billId);
		Bill bill1 = billRepository.findByBillId(billId).get();
		
		System.out.println(bill1);
		System.out.println(userBill);
		
		List<Product> productList = new ArrayList<Product>();
		List<BillDetails> billDetailsList = new ArrayList<BillDetails>();
		List<Integer> offerCodes = new ArrayList<Integer>(); 
	
		float dt = 0 ;
		for(int i=0; i<userBill.getProductList().size() ;i++) {	
				ProductList pd = userBill.getProductList().get(i);
				Product product = productRepository.findByCode(pd.getProductCode());
				System.out.println(product.getDateOfExpiry());
				Date dateOfExpiry = product.getDateOfExpiry();
				System.out.println(dateOfExpiry);
				if(dateOfExpiry.compareTo( bill.getPurchaseDate()) > 0) {
					billRepository.save(bill);
					offerCodes = offerRepository.findOfferCodes(userBill.getPurchaseDate());
					if(offerCodes.contains(pd.getProductCode())) {
						float rate1 = (float)(( offerRepository.findDiscountByCode(pd.getProductCode(), bill1.getPurchaseDate()) * product.getRatePerQuantity()/100));
						int quantity = pd.getQuantity();
						dt+=(rate1 * quantity);
					}
				
					float rate = product.getRatePerQuantity();
					int quantity = pd.getQuantity();
					total+=(rate * quantity);
					System.out.println(dt);
					product.setStockCount(product.getStockCount()-quantity);
			
					System.out.println(pd.getQuantity());
					billDetailsList.add( new BillDetails( billId, pd.getProductCode(), pd.getQuantity()));
					System.out.println(billDetailsList);
				}
				else {
					throw new ProductExpiredException();
				}
		}
		discountedTotal = total-dt;
		bill1.setDiscountedTotal(discountedTotal);
		bill1.setTotalAmount(total);
		bill1.setRewardPoints((int)(total/100) *20);
		bill1.setBillDetailsList(billDetailsList);
		
		System.out.println(bill1);
			
		return billRepository.save(bill1);	
		
	}
	
	public List<Bill> getUserBills(int id){
		System.out.println(id);
		System.out.println( billRepository.getUserBills(id));
		return billRepository.getUserBills(id);
	}
	
}
