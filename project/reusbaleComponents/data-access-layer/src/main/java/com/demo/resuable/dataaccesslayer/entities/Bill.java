package com.demo.resuable.dataaccesslayer.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id")
	int id;
	@Column(name = "b_purchase_date")
	Date purchaseDate;
	@Column(name = "b_total_amount", columnDefinition = "DECIMAL(8,2)")
	float totalAmount;
	@Column(name = "b_discount_amount", columnDefinition = "DECIMAL(8,2)")
	float discountedTotal;
	@Column(name = "b_reward_points")
	int rewardPoints;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "bill_details", joinColumns = @JoinColumn(name = "bill_b_id"), inverseJoinColumns = @JoinColumn(name = "product_pt_code"))
//	private List<Product> productList;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_us_id", nullable = false)
    User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="bill_b_id")
	private List<BillDetails> billDetailsList;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Bill(int id, Date purchaseDate, float totalAmount, int rewardPoints) {
		super();
		this.id = id;
		this.purchaseDate = purchaseDate;
		this.totalAmount = totalAmount;
		this.rewardPoints = rewardPoints;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public float getDiscountedTotal() {
		return discountedTotal;
	}


	public void setDiscountedTotal(float discountedTotal) {
		this.discountedTotal = discountedTotal;
	}


	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}


	public List<BillDetails> getBillDetailsList() {
		return billDetailsList;
	}


	public void setBillDetailsList(List<BillDetails> billDetailsList) {
		this.billDetailsList = billDetailsList;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Bill [id=" + id + ", purchaseDate=" + purchaseDate + ", totalAmount=" + totalAmount + ", rewardPoints="
				+ rewardPoints + ", user=" + user + ", billDetailsList=" + billDetailsList + "]";
	}

	


	
}
