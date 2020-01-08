package com.coe.cloud.openpay.payments.entities;

import java.math.BigDecimal;

public class PaynetChain {
	private String name;
	private String logo;
	private String thumb;
	private BigDecimal maxAmmount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public BigDecimal getMaxAmmount() {
		return maxAmmount;
	}
	public void setMaxAmmount(BigDecimal maxAmmount) {
		this.maxAmmount = maxAmmount;
	}
}
