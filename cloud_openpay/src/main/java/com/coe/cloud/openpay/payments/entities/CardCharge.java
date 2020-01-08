package com.coe.cloud.openpay.payments.entities;

import java.math.BigDecimal;

public class CardCharge {
    private String source_id;
    private String method;
    private BigDecimal ammount;
    private String description;
    private String order_id;
    private String device_session_id;
    
	public String getSource_id() {
		return source_id;
	}
	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getDevice_session_id() {
		return device_session_id;
	}
	public void setDevice_session_id(String device_session_id) {
		this.device_session_id = device_session_id;
	}
}
