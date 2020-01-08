package com.coe.cloud.openpay.payments.utils;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Conversion {
	public String convierteMapaJsonString(Map<String, Object> mapBody) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json=null;
		try {
			objectMapper.setSerializationInclusion(Include.NON_DEFAULT);
			objectMapper.setSerializationInclusion(Include.NON_NULL);
			json = objectMapper.writeValueAsString(mapBody);
			//json = objectMapper.writeValue(jsonGenerator, mapBody);
			System.out.println("json = " + json);
		} catch (JsonProcessingException jpe) {
			jpe.printStackTrace();
		}
		return json;
	}
}
