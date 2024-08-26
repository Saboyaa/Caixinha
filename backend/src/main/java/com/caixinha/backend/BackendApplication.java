package com.caixinha.backend;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}

class bank {
	String bankName;
	String bankPhoto;
	float moneyPerBank;
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
	public float getMoneyPerBank() {
		return moneyPerBank;
	}
	public void setMoneyPerBank(float moneyPerBank) {
		this.moneyPerBank = moneyPerBank;
	}

	
}
class Client {
	long id;
	String clientName;
	float totalMoney;
	List<bank> bankList;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public List<bank> getBankList() {
		return bankList;
	}
	public void setBankList(List<bank> bankList) {
		this.bankList = bankList;
	}

	
}
