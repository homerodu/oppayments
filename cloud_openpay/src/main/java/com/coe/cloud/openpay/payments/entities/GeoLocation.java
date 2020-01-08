package com.coe.cloud.openpay.payments.entities;

import java.math.BigDecimal;

public class GeoLocation {
    private BigDecimal lng;
    private BigDecimal lat;
    private String placeId;
    
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
}
