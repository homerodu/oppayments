package com.coe.cloud.openpay.payments.entities;

public class TransactionError {
    private String category;
    private Integer errorCode;
    private Integer httpCode;
    private String description;
    private String requestId;
    private String[] fraud_rules;
    
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public Integer getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String[] getFraud_rules() {
		return fraud_rules;
	}
	public void setFraud_rules(String[] fraud_rules) {
		this.fraud_rules = fraud_rules;
	}
}
