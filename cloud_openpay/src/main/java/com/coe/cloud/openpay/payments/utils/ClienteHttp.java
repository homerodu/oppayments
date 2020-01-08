package com.coe.cloud.openpay.payments.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;

public class ClienteHttp {
	private String json;
	
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
	public int createPayment(StringEntity body, Header[] headers, String paymentCreateUrl) {
		int codigoEstatus=-1;
		CloseableHttpClient client = HttpClients.createDefault();
		System.out.println("uriPagos:"+paymentCreateUrl);
	    HttpPost httpPost = new HttpPost(paymentCreateUrl);
	    httpPost.setEntity(body);
	    HttpEntity entity=null;
	    try {
	    	httpPost.setHeaders(headers);
			CloseableHttpResponse response = client.execute(httpPost);
			codigoEstatus=response.getStatusLine().getStatusCode();
			entity = response.getEntity();
			setJson(EntityUtils.toString(entity, StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    httpPost=null;
	    return codigoEstatus;
	}
	
	public int retrievePayment(Header[] headers, String paymentRetrieveUrl) {
		int codigoEstatus=-1;
		CloseableHttpClient client = HttpClients.createDefault();
		System.out.println("uriPagos:"+paymentRetrieveUrl);
	    HttpGet httpGet = new HttpGet(paymentRetrieveUrl);	    
	    HttpEntity entity=null;
	    try {
	    	httpGet.setHeaders(headers);
			CloseableHttpResponse response = client.execute(httpGet);
			codigoEstatus=response.getStatusLine().getStatusCode();
			entity = response.getEntity();
			setJson(EntityUtils.toString(entity, StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    httpGet=null;
	    return codigoEstatus;
	}
	
	
	
	public ClienteHttp(){}   
}