package com.demo.resuable.dataaccesslayer.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offer")
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "of_id")
	int id;
	@Column(name = "of_date")
	Date offerDate;
	@Column(name = "of_discount_percent")
	int discountPercent;
	@Column(name = "of_pt_code")
	int productCode;
	public Offer() {
		super();
	}
	public Offer(int id, Date offerDate, int discountPercent, int productCode) {
		super();
		this.id = id;
		this.offerDate = offerDate;
		this.discountPercent = discountPercent;
		this.productCode = productCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOfferDate() {
		return offerDate;
	}
	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}
	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	@Override
	public String toString() {
		return "Offer [id=" + id + ", offerDate=" + offerDate + ", discountPercent=" + discountPercent
				+ ", productCode=" + productCode + "]";
	}
	
	

}
