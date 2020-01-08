package com.coe.cloud.openpay.payments.entities;

import java.math.BigDecimal;

public class PaymentRequest {
	private BigDecimal amount;
	private String currency;
	private String description;
	private String method;
	private String order_id;
	private String device_id;
    private String device_type;
	private String device_session_id;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getDevice_type() {
		return device_type;
	}
	public void setDevice_type(String device_type) {
		this.device_type = device_type;
	}
	public String getDevice_session_id() {
		return device_session_id;
	}
	public void setDevice_session_id(String device_session_id) {
		this.device_session_id = device_session_id;
	}
}
