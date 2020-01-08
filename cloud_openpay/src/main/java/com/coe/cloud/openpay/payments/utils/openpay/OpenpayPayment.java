package com.coe.cloud.openpay.payments.utils.openpay;

import com.coe.cloud.openpay.payments.entities.PaymentRequest;
import com.coe.cloud.openpay.payments.utils.ErrorMapping;

import mx.openpay.client.core.OpenpayAPI;
import mx.openpay.client.core.requests.transactions.CreateCardChargeParams;
import mx.openpay.client.exceptions.OpenpayServiceException;
import mx.openpay.client.exceptions.ServiceUnavailableException;

public class OpenpayPayment {	
	private String privateKey;
	private String urlBase;
	private String merchantId;
	private int statusCode;
	
	public int getStatusCode() {
		return statusCode;
	}
	
	public Object createPayment(String cardId, String customerId, PaymentRequest paymentRequest) {		
		OpenpayAPI api = new OpenpayAPI(urlBase, privateKey, merchantId);
		CreateCardChargeParams requestParams = new CreateCardChargeParams();
		statusCode=0;
		requestParams.cardId(cardId);
		requestParams.amount(paymentRequest.getAmount());
		requestParams.description(paymentRequest.getDescription());
		requestParams.orderId(paymentRequest.getOrder_id());
		requestParams.deviceSessionId(paymentRequest.getDevice_session_id());
		requestParams.customer(null);
		Object object=null;
		try {
			object = api.charges().createCharge(customerId, requestParams);
		} catch (OpenpayServiceException | ServiceUnavailableException e) {
			statusCode=9999;
			//e.printStackTrace();
			System.out.println(e.toString());
			ErrorMapping errorMapping=new ErrorMapping();
			object=errorMapping.mapErrorToCharge(e.toString());
			errorMapping=null;
		}
		return object;
	}
	
	public OpenpayPayment(String urlBase, String privateKey, String merchantId){    	
    	this.urlBase=urlBase;
    	this.privateKey=privateKey;
    	this.merchantId=merchantId;
    }
	
	/*
	public static void main(String[] args) {
		String securityString="sk_9efab730c12d410fa4f44dfaaf3454d7";
		String urlBase="https://sandbox-api.openpay.mx";
		String merchantId="mi7vk6z6booivz5t8hmp";
		OpenpayPayment openpayPayment=new OpenpayPayment(urlBase, securityString, merchantId);
		ChargeCard chargeCard=new ChargeCard();
		chargeCard.setSource_id("k99x97scnehx1mpdmux0");
		chargeCard.setMethod("card");
		chargeCard.setAmmount(new BigDecimal(124.00));
		chargeCard.setDescription("Compra de equipo Electronico");
		chargeCard.setOrder_id("oid-2019099");
		chargeCard.setDevice_session_id("kR1MiQhz2otdIuUlQkbEyitIqVMiI16f");

		Charge charge=openpayPayment.createPayment(chargeCard, "andyisjeilox5vmh2vzd");
		chargeCard=null;
		openpayPayment=null;
	}
	*/
}
