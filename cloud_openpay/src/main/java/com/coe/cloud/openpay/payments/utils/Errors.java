package com.coe.cloud.openpay.payments.utils;

import com.coe.cloud.openpay.payments.entities.TransactionError;

public class Errors {
	public TransactionError createErrorNoDeviceFound() {
        TransactionError transactionError=new TransactionError();
        transactionError.setCategory("No device found");
        transactionError.setDescription("No device found");
        transactionError.setErrorCode(10000);
        transactionError.setFraud_rules(null);
        transactionError.setHttpCode(500);
        transactionError.setRequestId("no-request_id-generated");
        return transactionError;
	}
	
	public TransactionError createErrorRequestException() {
        TransactionError transactionError=new TransactionError();
        transactionError.setCategory("Exception");
        transactionError.setDescription("Json Request Exception");
        transactionError.setErrorCode(10001);
        transactionError.setFraud_rules(null);
        transactionError.setHttpCode(400);
        transactionError.setRequestId("no-request_id-generated");
        return transactionError;
	}
	
	public TransactionError createErrorOrderIdDuplicated() {
        TransactionError transactionError=new TransactionError();
        transactionError.setCategory("Duplicate");
        transactionError.setDescription("Duplicate OrderId");
        transactionError.setErrorCode(10001);
        transactionError.setFraud_rules(null);
        transactionError.setHttpCode(400);
        transactionError.setRequestId("no-request_id-generated");
        return transactionError;
	}
}
