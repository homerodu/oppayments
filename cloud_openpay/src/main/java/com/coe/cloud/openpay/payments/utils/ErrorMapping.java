package com.coe.cloud.openpay.payments.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.coe.cloud.openpay.payments.entities.TransactionError;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorMapping {
    public TransactionError mapErrorToCharge(String errorString) {
    	String[] errorItems=errorString.split(",");
    	String[] keyValue;
    	Map<String, Object> mapsErrors=new HashMap<String, Object>();
    	int totalKeyValue=errorItems.length;
    	for(int ciclo=1;ciclo<(totalKeyValue-1);ciclo++) {
    		keyValue=errorItems[ciclo].split("=");
    		mapsErrors.put(keyValue[0].trim(),keyValue[1].trim());
    	}
    	Conversion conversion=new Conversion();
    	String bodyJson=conversion.convierteMapaJsonString(mapsErrors);
    	ObjectMapper objectMapper = new ObjectMapper();
    	TransactionError transactionError=null;
		try {
			transactionError=objectMapper.readValue(bodyJson, TransactionError.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		objectMapper=null;
		mapsErrors=null;
		errorItems=null;
		conversion=null;
    	return transactionError;
    }
}
