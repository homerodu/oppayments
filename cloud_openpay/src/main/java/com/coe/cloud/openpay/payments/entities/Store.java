package com.coe.cloud.openpay.payments.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Stores")
@Table(name="stores", schema="payments")
public class Store {
    private String id_store;
    private String id;
    private String name;
    private LocalDate lastUpdated;
    private GeoLocation geoLocation;
    private AddressTable address;
    private PaynetChain paynetChain;
	public String getId_store() {
		return id_store;
	}
	public void setId_store(String id_store) {
		this.id_store = id_store;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDate lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	public AddressTable getAddress() {
		return address;
	}
	public void setAddress(AddressTable address) {
		this.address = address;
	}
	public PaynetChain getPaynetChain() {
		return paynetChain;
	}
	public void setPaynetChain(PaynetChain paynetChain) {
		this.paynetChain = paynetChain;
	}
}
