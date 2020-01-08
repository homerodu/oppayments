package com.coe.cloud.openpay.payments.utils;

import com.coe.cloud.openpay.payments.entities.CustomerTable;

import mx.openpay.client.Address;
import mx.openpay.client.Customer;

public class CustomerMapping {
    public Customer createCustomer(CustomerTable customerTable) {
    	Customer customer=new Customer();
    	//AddressConversion addressConversion=new AddressConversion(); 
    	//Address address=addressConversion.converAddressTableToAddress(customerTable.getAddress());    	
        //customer.setAddress(address);
        //customer.setBalance(customerTable.getBalance());
        //customer.setClabe(customerTable.getClabe());
        //customer.setCreationDate(customerTable.getCreation_date_legacy());
        customer.setEmail(customerTable.getEmail());
        //customer.setExternalId(customerTable.getExternal_id());
        //customer.setId(customerTable.getId());
        customer.setLastName(customerTable.getLast_name());
        customer.setName(customerTable.getName());
        customer.setPhoneNumber(customerTable.getPhone_number());
        //customer.setRequiresAccount(customerTable.getRequires_account());
        //customer.setStatus(customerTable.getStatus());
        //addressConversion=null;
        return customer;
    }
    public Customer getCustomerTableToCustomer(CustomerTable customerTable) {
    	Customer customer=new Customer();
    	AddressConversion addressConversion=new AddressConversion(); 
    	Address address=addressConversion.converAddressTableToAddress(customerTable.getAddress());    	
        customer.setAddress(address);
        customer.setBalance(customerTable.getBalance());
        customer.setClabe(customerTable.getClabe());
        customer.setCreationDate(customerTable.getCreation_date_legacy());
        customer.setEmail(customerTable.getEmail());
        customer.setExternalId(customerTable.getExternal_id());
        customer.setId(customerTable.getId());
        customer.setLastName(customerTable.getLast_name());
        customer.setName(customerTable.getName());
        customer.setPhoneNumber(customerTable.getPhone_number());
        customer.setRequiresAccount(customerTable.getRequires_account());
        customer.setStatus(customerTable.getStatus());
        addressConversion=null;
        return customer;
    }
}
