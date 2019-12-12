package com.cognizant.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill_details")
public class BillDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_d_id")
	int billDetailsId;
	
	@Column(name = "bill_b_id")
	int billId;
	
	@Column(name = "product_pt_code")
	int productCode;
	
	@Column(name = "quantity")
	int quantity;
	

	public BillDetails(int billId, int productId, int quantity) {
		super();
		this.billId = billId;
		this.productCode = productId;
		this.quantity = quantity;
		
	}

	public BillDetails(int billDetailsId, int billId, int productCode, int quantity) {
		super();
		this.billDetailsId = billDetailsId;
		this.billId = billId;
		this.productCode = productCode;
		this.quantity = quantity;
	
	}

	public BillDetails() {
		super();
	}


	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getProductId() {
		return productCode;
	}

	public void setProductId(int productId) {
		this.productCode = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BillDetails [billDetailsId=" + billDetailsId + ", billId=" + billId + ", productCode=" + productCode
				+ ", quantity=" + quantity + "]";
	}

	
	
	
}
