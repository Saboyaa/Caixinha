package com.caixinha.backend;

import java.util.Optional;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}

@Entity
class Bank {
	@Id
	Long id;
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

@Entity
class Client {
	@Id
	Long id;
	String clientName;
	float totalMoney;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id") // Creates a foreign key in the Bank table
	List<Bank> bankList;

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
	public List<Bank> getBankList() {
		return bankList;
	}
	public void setBankList(List<Bank> bankList) {
		this.bankList = bankList;
	}

	
}

@RestController
@RequestMapping("/demo")
class backendControler{
	BackendService backendService;
	
	public backendControler(BackendService backendService) {
		this.backendService = backendService;
	}

	@GetMapping("/{id}")
	public Client getClient(@PathVariable("id") Long id){
		return backendService.getClient(id).orElse(null);
	};	
	
}

@Service
class BackendService {
	BackendRepository backendRepository;

	public BackendService(BackendRepository backendRepository) {
		this.backendRepository = backendRepository;
	}

	public Optional<Client> getClient(Long id){
		return backendRepository.findById(id);
	}
}

interface BackendRepository extends JpaRepository<Client,Long>{

}