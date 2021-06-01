
package com.demo.resuable.dataaccesslayer.entities;

import java.sql.Date;
import java.util.List;

public class UserBill {
	private String userId;
	private Date purchaseDate;
	private List<ProductList> productList;
	private int billId;
	
	
	public UserBill() {
		super();
	}

	public UserBill(String userId, Date purchaseDate, List<ProductList> productList, int billId) {
		super();
		this.userId = userId;
		this.purchaseDate = purchaseDate;
		this.productList = productList;
		this.billId = billId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<ProductList> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductList> productList) {
		this.productList = productList;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}

	@Override
	public String toString() {
		return "UserBill [userId=" + userId + ", productList=" + productList + ", billId=" + billId + "]";
	}
	
	
}
