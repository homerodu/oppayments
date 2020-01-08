package com.coe.cloud.openpay.payments.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	public Properties readFile(String filePropAndPath) {
		Properties prop=null;    	
		//try (InputStream input = new FileInputStream(filePropAndPath)) {
		try (InputStream input = ReadProperties.class.getClassLoader().getResourceAsStream(filePropAndPath)){
			prop = new Properties();
			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}
}
