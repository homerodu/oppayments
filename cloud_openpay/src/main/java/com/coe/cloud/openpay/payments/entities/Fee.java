package com.coe.cloud.openpay.payments.entities;

import java.math.BigDecimal;

public class Fee {
	private BigDecimal ammount;
	private BigDecimal tax;
	private String currency;
	
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
