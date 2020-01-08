package com.coe.cloud.openpay.payments.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Addresses")
@Table(name="addresses", schema="payments")
public class AddressTable {
	@Id
	@Column(name="id", updatable=false, nullable=false)
	private String id;
	
	@Column(name="street", nullable=false)
	private String line1;		//street
	@Column(name="external_number", nullable=false)
	private String line2;		//external_number
	@Column(name="suburb", nullable=false)
	private String line3;		//suburb
	private String state;
	private String city;
	private String postal_code;
	private String country_code;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1=line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2=line2;
	}
	public String getLine3() {
		return line3;
	}
	public void setLine3(String line3) {
		this.line3=line3;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state=state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code=postal_code;
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code=country_code;
	}
}
