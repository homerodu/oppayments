package com.coe.cloud.openpay.payments.utils;

import com.coe.cloud.openpay.payments.entities.AddressTable;

import mx.openpay.client.Address;


public class AddressConversion {
    public Address converAddressTableToAddress(AddressTable addressTable) {
    	Address address=new Address();
    	address.setCity(addressTable.getCity());
    	address.setCountryCode(addressTable.getCountry_code());
    	//address.setId(addressTable.getId());
    	address.setLine1(addressTable.getLine1());
    	address.setLine2(addressTable.getLine2());
    	address.setLine3(addressTable.getLine3());
    	address.setPostalCode(addressTable.getPostal_code());
    	address.setState(addressTable.getState());
    	return address;
    }
}
