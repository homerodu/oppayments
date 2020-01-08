package com.coe.cloud.openpay.payments.entities;

public class UnitProductSelling {
    private Product product;
    private int unitsSold;
    
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getUnitsSold() {
		return unitsSold;
	}
	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}
}
