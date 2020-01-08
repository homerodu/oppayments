package com.coe.cloud.openpay.payments.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Customers")
@Table(name="customers", schema="payments")
public class CustomerTable {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String id;
	private LocalDateTime creation_date;
	private String name;
	private String last_name;
	private String email;
	private String phone_number;
	private String external_id;
	private String status;
	private BigDecimal balance;
	private String clabe;
	
	@OneToOne
	private AddressTable address;
	
	//private Store store;
	private Boolean requires_account;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDateTime getCreation_date() {
		return creation_date;
	}
	public Date getCreation_date_legacy() {
		return Timestamp.valueOf(creation_date);
	}	
	public void setCreation_date(LocalDateTime creation_date) {
		this.creation_date = creation_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getExternal_id() {
		return external_id;
	}
	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getClabe() {
		return clabe;
	}
	public void setClabe(String clabe) {
		this.clabe = clabe;
	}
	public AddressTable getAddress() {
		return address;
	}
	public void setAddress(AddressTable address) {
		this.address = address;
	}
	//public Store getStore() {
	//	return store;
	//}
	//public void setStore(Store store) {
	//	this.store = store;
	//}
	public Boolean getRequires_account() {
		return requires_account;
	}
	public void setRequires_account(Boolean requires_account) {
		this.requires_account = requires_account;
	}
}
