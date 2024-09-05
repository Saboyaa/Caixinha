package com.classes;

import jakarta.persistence.*;
import java.sql.Timestamp;
public 
@Entity
class Transactions{
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
	@Column
	Timestamp timeOfTransaction;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClient_id() {
		return client_id;
	}
	public void setClient_id(Long client_id) {
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
	public Float getMoneyBank() {
		return moneyBank;
	}
	public void setMoneyBank(Float moneyBank) {
		this.moneyBank = moneyBank;
	}
	public Timestamp getTimeOfTransaction() {
		return timeOfTransaction;
	}
	public void setTimeOfTransaction(Timestamp timeOfTransaction) {
		this.timeOfTransaction = timeOfTransaction;
	}
	

}
