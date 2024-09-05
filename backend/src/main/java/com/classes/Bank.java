package com.classes;


import jakarta.persistence.*;

@Entity
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column
	Long client_id;
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
	public long getClient_id() {
		return client_id;
	}
	public void setClient_id(long client_id) {
		this.client_id = client_id;
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
