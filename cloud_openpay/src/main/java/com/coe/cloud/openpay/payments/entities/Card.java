package com.coe.cloud.openpay.payments.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Cards")
@Table(name="cards", schema="payments")
public class Card {
	@Id
	private String id;
	private String card_number;
	private String cvv2;	
	private String holder_name;
	private String expiration_year;
	private String expiration_month;
	private AddressTable address;
	private LocalDate creation_date;
	private Boolean allows_charges;
	private Boolean allows_payouts;
	private String brand;
	private String type;
	private String bank_name;
	private String bank_code;
	private String customer_id;
	private boolean points_card;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getAllows_charges() {
		return allows_charges;
	}
	public void setAllows_charges(Boolean allows_charges) {
		this.allows_charges = allows_charges;
	}
	public Boolean getAllows_payouts() {
		return allows_payouts;
	}
	public void setAllows_payouts(Boolean allows_payouts) {
		this.allows_payouts = allows_payouts;
	}
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public String getCvv2() {
		return cvv2;
	}
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	public String getHolder_name() {
		return holder_name;
	}
	public void setHolder_name(String holder_name) {
		this.holder_name = holder_name;
	}
	public String getExpiration_year() {
		return expiration_year;
	}
	public void setExpiration_year(String expiration_year) {
		this.expiration_year = expiration_year;
	}
	public String getExpiration_month() {
		return expiration_month;
	}
	public void setExpiration_month(String expiration_month) {
		this.expiration_month = expiration_month;
	}
	public AddressTable getAddress() {
		return address;
	}
	public void setAddress(AddressTable address) {
		this.address = address;
	}
	public LocalDate getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public boolean isPoints_card() {
		return points_card;
	}
	public void setPoints_card(boolean points_card) {
		this.points_card = points_card;
	}
}
