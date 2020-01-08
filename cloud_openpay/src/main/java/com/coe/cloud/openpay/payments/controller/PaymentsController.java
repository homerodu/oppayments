package com.coe.cloud.openpay.payments.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coe.cloud.openpay.payments.dao.ChargeDao;
import com.coe.cloud.openpay.payments.dao.DeviceDao;
import com.coe.cloud.openpay.payments.entities.ChargeTable;
import com.coe.cloud.openpay.payments.entities.DeviceTable;
import com.coe.cloud.openpay.payments.entities.PaymentRequest;
import com.coe.cloud.openpay.payments.entities.TransactionError;
import com.coe.cloud.openpay.payments.mapping.PaymentRequestMapping;
import com.coe.cloud.openpay.payments.utils.Conversion;
import com.coe.cloud.openpay.payments.utils.Errors;
import com.coe.cloud.openpay.payments.utils.ReadProperties;
import com.coe.cloud.openpay.payments.utils.openpay.OpenpayPayment;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class PaymentsController {
	private String privateKey;  //"sk_9efab730c12d410fa4f44dfaaf3454d7"
	private String urlBase;         //"https://sandbox-api.openpay.mx"
	private String merchantId;	    //"mi7vk6z6booivz5t8hmp"
	private int counter;
	//@Autowired
	//private ApplicationArguments applicationArguments;
	
	@PostMapping("/openpay/payments/card")
	public Object createCreditcardPayment(@RequestBody Map<String, Object> mapBody, HttpServletRequest request, 
	        HttpServletResponse response) {
		Conversion conversion=new Conversion();
		String bodyJson=conversion.convierteMapaJsonString(mapBody);
		OpenpayPayment openpayPayment=new OpenpayPayment(urlBase, privateKey, merchantId);		
		PaymentRequest paymentRequest=null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			paymentRequest=objectMapper.readValue(bodyJson, PaymentRequest.class);
			objectMapper=null;
		} catch (IOException e) {
			e.printStackTrace();
			Errors errors=new Errors();
			TransactionError transactionError= errors.createErrorRequestException();
			errors=null;
			return transactionError;
		}
		DeviceDao deviceDao=new DeviceDao();
		int countDevices=deviceDao.countDevicesByDeviceId(paymentRequest.getDevice_id());		
		if(countDevices==0) {
			Errors errors=new Errors();
			TransactionError transactionError= errors.createErrorNoDeviceFound();
			errors=null;
			deviceDao=null;
			return transactionError;
		}
		DeviceTable device=deviceDao.getDevice(paymentRequest.getDevice_id());
		deviceDao=null;
		PaymentRequestMapping paymentRequestMapping=new PaymentRequestMapping();
		String cardId=device.getCard_id();
		String customerId=device.getCustomer_id();
		ChargeTable chargeTable= paymentRequestMapping.mappToCharge(cardId, customerId, paymentRequest);
		ChargeDao chargeDao=new ChargeDao();		
		chargeDao.saveCharge(chargeTable);
		int countOcurrences=chargeDao.countChargesByOrderId(paymentRequest.getOrder_id());
		if(countOcurrences>1) {
			Errors errors=new Errors();
			TransactionError transactionError= errors.createErrorOrderIdDuplicated();
			errors=null;
			deviceDao=null;
			return transactionError;
		}
		
		Object object=openpayPayment.createPayment(cardId, customerId, paymentRequest);	
		return object;
	}
	
	//@GetMapping("/","/wakeup")
	@RequestMapping(value={"/", "/wakeup"}, method=RequestMethod.GET)
	public String wakeUp() {
		Map<String, Object> mapEndpoints=new HashMap<String, Object>();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		mapEndpoints.put("Greetings: ","Welcome to Openpay payments:");
		mapEndpoints.put("Current Time: ",formatter.format(date));
		mapEndpoints.put("Visitor: ",counter++);
		Conversion conversion=new Conversion();
		String jsonResponse=conversion.convierteMapaJsonString(mapEndpoints);
		conversion=null;
		return jsonResponse;
    }
	
	@PostConstruct
	void init() {
        ReadProperties readProperties=new ReadProperties();      
        Properties properties=readProperties.readFile("openpay.properties");
        privateKey=properties.getProperty("openpay.privateKey");  //"sk_9efab730c12d410fa4f44dfaaf3454d7"
    	urlBase=properties.getProperty("openpay.urlBase");         //"https://sandbox-api.openpay.mx"
    	merchantId=properties.getProperty("openpay.merchantId");	    //"mi7vk6z6booivz5t8hmp"
    	readProperties=null;
    	properties=null;
		//privateKey="sk_9efab730c12d410fa4f44dfaaf3454d7";
    	//urlBase="https://sandbox-api.openpay.mx";
    	//merchantId="mi7vk6z6booivz5t8hmp";
	}
}