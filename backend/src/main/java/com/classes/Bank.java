package com.classes;


import jakarta.persistence.*;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column
	Long clientId;
	@Column
	String bankName;
	@Column
	String bankPhoto;
	@Column
	Float moneyBank;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankPhoto() {
		return bankPhoto;
	}
	public void setBankPhoto(String bankPhoto) {
		this.bankPhoto = bankPhoto;
	}
	public float getMoneyBank() {
		return moneyBank;
	}
	public void setMoneyBank(float moneyBank) {
		this.moneyBank = moneyBank;
	}
	
}
