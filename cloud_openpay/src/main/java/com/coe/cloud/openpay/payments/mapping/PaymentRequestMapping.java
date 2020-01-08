package com.coe.cloud.openpay.payments.mapping;

import com.coe.cloud.openpay.payments.entities.ChargeTable;
import com.coe.cloud.openpay.payments.entities.PaymentRequest;

public class PaymentRequestMapping {
   public ChargeTable mappToCharge(String cardId, String customerId, PaymentRequest paymentRequest) {
	   ChargeTable chargeTable=new ChargeTable();
	   chargeTable.setAmmount(paymentRequest.getAmount());
	   chargeTable.setCurrency(paymentRequest.getCurrency());
	   chargeTable.setCustomer_id(customerId);
	   chargeTable.setMethod(paymentRequest.getMethod());
	   chargeTable.setDescription(paymentRequest.getDescription());
	   chargeTable.setDevice_id(paymentRequest.getDevice_id());
	   chargeTable.setDevice_session_id(paymentRequest.getDevice_session_id());
	   chargeTable.setDevice_type(paymentRequest.getDevice_type());
	   chargeTable.setOrder_id(paymentRequest.getOrder_id());
	   chargeTable.setSource_id(cardId);
	   return chargeTable;
   }
}
