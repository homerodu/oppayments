package com.coe.cloud.openpay.payments.utils;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class HeadersUtils {
	private Header[] duplicateHeaders= {new BasicHeader("Content-Length","")};
    public Header[] getAllHeaders(HttpServletRequest request) {
    	int countHeaders=0;
    	int countDuplicates=0;    	
    	Enumeration<String> headerNames = request.getHeaderNames();		
		List<String> list = Collections.list(headerNames);
		int totalHeadersTemp=list.size();
		ListIterator<String> iterator=list.listIterator();
		Header[] headersTemp =new Header[totalHeadersTemp];
		Header[] headers;
		while(iterator.hasNext()) {
            String name = (String)iterator.next();
            String value = request.getHeader(name);
            Header header=new BasicHeader(name, value);
            if(!isDuplicated(name, value)) {
            	headersTemp[countHeaders++]=header;	
            } else {
            	countDuplicates++;
            }
        }
		if(countDuplicates>0) {			
			headers=new Header[countHeaders];
			System.arraycopy(headersTemp, 0, headers, 0, countHeaders);
		} else {
			headers=null;
			headers=headersTemp;
		}
		return headers;
    }
    
    public boolean isDuplicated(String name, String value) {
    	boolean isDupl=false;
    	int count=0;
    	int total=duplicateHeaders.length;
    	while(!isDupl&&(count<total)){
    		if(name.equalsIgnoreCase(duplicateHeaders[count].getName())) {
    			isDupl=true;
    		} else {
    			count++;
    		}
    	}
    	return isDupl;
    }
}
