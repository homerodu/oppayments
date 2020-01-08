package com.coe.cloud.openpay.payments.utils;

public class FolioUtils {
	private static int consecutivo;
    public static String generateFolio() {
    	consecutivo++;
    	return String.format("%08d", consecutivo);
    }
    
    public FolioUtils(){
    	consecutivo=98765;
    }
    
    public FolioUtils(int consecutivo) {
    	FolioUtils.consecutivo=consecutivo;
    }
}
