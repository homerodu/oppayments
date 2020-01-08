package com.coe.cloud.openpay.payments.entities;

import java.math.BigInteger;

public class CardPoints {
    private BigInteger used;
    private BigInteger remaining;
    private BigInteger ammount;
    private String caption;
	
    public BigInteger getUsed() {
		return used;
	}
	public void setUsed(BigInteger used) {
		this.used = used;
	}
	public BigInteger getRemaining() {
		return remaining;
	}
	public void setRemaining(BigInteger remaining) {
		this.remaining = remaining;
	}
	public BigInteger getAmmount() {
		return ammount;
	}
	public void setAmmount(BigInteger ammount) {
		this.ammount = ammount;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
}
