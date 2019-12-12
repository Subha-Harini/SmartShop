package com.cognizant.productservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pt_code")
	int code;
	@Column(name = "pt_name")
	String name;
	@Column(name = "pt_type")
	int type;
	@Column(name = "pt_brand")
	String brand;
	@Column(name = "pt_quantity_type")
	long quantityType;
	@Column(name = "pt_rate_per_quantity")
	int ratePerQuantity;
	@Column(name = "pt_stock_count")
	int stockCount;
	@Column(name = "pt_add_date")
	Date addDate;
	@Column(name = "pt_aisle")
	String aisle;
	@Column(name = "pt_shelf")
	String shelf;
	@Column(name = "pt_date_of_manufacture")
	Date dateOfManufacture;
	@Column(name = "pt_date_of_expiry")
	Date dateOfExpiry;
	@Column(name = "pt_image")
	String image;
	
	

	public Product() {
		super();
	}

	public Product(int code, String name, int type, String brand, long quantityType, int ratePerQuantity,
			int stockCount, Date addDate, String aisle, String shelf, Date dateOfManufacture, Date dateOfExpiry,
			String image) {
		super();
		this.code = code;
		this.name = name;
		this.type = type;
		this.brand = brand;
		this.quantityType = quantityType;
		this.ratePerQuantity = ratePerQuantity;
		this.stockCount = stockCount;
		this.addDate = addDate;
		this.aisle = aisle;
		this.shelf = shelf;
		this.dateOfManufacture = dateOfManufacture;
		this.dateOfExpiry = dateOfExpiry;
		this.image = image;
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (code != other.code)
			return false;
		return true;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getQuantityType() {
		return quantityType;
	}

	public void setQuantityType(long quantityType) {
		this.quantityType = quantityType;
	}

	
	public int getRatePerQuantity() {
		return ratePerQuantity;
	}



	public void setRatePerQuantity(int ratePerQuantity) {
		this.ratePerQuantity = ratePerQuantity;
	}



	public int getStockCount() {
		return stockCount;
	}



	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}


	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}


	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", type=" + type + ", brand=" + brand + ", quantityType="
				+ quantityType + ", ratePerQuantity=" + ratePerQuantity + ", stockCount=" + stockCount + ", addDate="
				+ addDate + ", aisle=" + aisle + ", shelf=" + shelf + ", dateOfManufacture=" + dateOfManufacture
				+ ", dateOfExpiry=" + dateOfExpiry + ", image=" + image + "]";
	}
	


}
