package com.cognizant.productservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill_details")
public class BillDetails {
	
	@Id
	@Column(name = "b_d_id")
	int billDetailsId;
	
	@Column(name = "bill_b_id")
	int billId;
	
	@Column(name = "product_pt_id")
	int productId;
	
	@Column(name = "quantity")
	int quantity;
	
	@Column(name = "bill_b_id1")
	int billId1;

	public BillDetails(int billId, int productId, int quantity) {
		super();
		this.billId = billId;
		this.productId = productId;
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
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BillDetails [billDetailsId=" + billDetailsId + ", billId=" + billId + ", productId=" + productId
				+ ", quantity=" + quantity + ", billId1=" + billId1 + "]";
	}

	
	
	
}
