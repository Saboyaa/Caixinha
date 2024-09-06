package com.classes;

import jakarta.persistence.*;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column
	String clientName;
	@Column
	float totalMoney;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	// public List<Bank> getBankList() {
	// 	return bankList;
	// }
	// public void setBankList(List<Bank> bankList) {
	// 	this.bankList = bankList;
	// }

	
}