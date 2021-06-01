package com.demo.resuable.dataaccesslayer.entities;

public class ProductList {

	
	private int productCode;
	private int quantity;
	
	
	public ProductList() {
		super();
	}
	public ProductList(int productCode, int quantity) {
		super();
		this.productCode = productCode;
		this.quantity = quantity;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductList [productCode=" + productCode + ", quantity=" + quantity + "]";
	}
	
	
	
}
