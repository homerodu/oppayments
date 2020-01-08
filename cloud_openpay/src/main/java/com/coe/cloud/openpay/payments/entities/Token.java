package com.coe.cloud.openpay.payments.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Tokens")
@Table(name="tokens", schema="payments")
public class Token {
    private String idOpenpay;
    private String idChipNfc;
    private Card card;
    
	public String getIdOpenpay() {
		return idOpenpay;
	}
	public void setIdOpenpay(String idOpenpay) {
		this.idOpenpay = idOpenpay;
	}
	public String getIdChipNfc() {
		return idChipNfc;
	}
	public void setIdChipNfc(String idChipNfc) {
		this.idChipNfc = idChipNfc;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
}
