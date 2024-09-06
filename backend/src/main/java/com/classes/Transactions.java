package com.classes;

import jakarta.persistence.*;
import java.sql.Timestamp;

import org.hibernate.annotations.CurrentTimestamp;
@Entity
public class Transactions{
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
	@Column
	@CurrentTimestamp
	Timestamp timeOfTransaction;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClient_id(Long clientId) {
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
