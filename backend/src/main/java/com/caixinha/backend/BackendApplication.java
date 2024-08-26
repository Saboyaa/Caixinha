package com.caixinha.backend;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.CascadeType;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.JoinColumn;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}

// @Entity
// class Bank {
// 	@Id
// 	Long id;
// 	String bankName;
// 	String bankPhoto;
// 	float moneyPerBank;
// 	public String getBankName() {
// 		return bankName;
// 	}
// 	public void setBankName(String bankName) {
// 		this.bankName = bankName;
// 	}
// 	public String getBankPhoto() {
// 		return bankPhoto;
// 	}
// 	public void setBankPhoto(String bankPhoto) {
// 		this.bankPhoto = bankPhoto;
// 	}
// 	public float getMoneyPerBank() {
// 		return moneyPerBank;
// 	}
// 	public void setMoneyPerBank(float moneyPerBank) {
// 		this.moneyPerBank = moneyPerBank;
// 	}

	
// }

@Entity
class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	String clientName;
	float totalMoney;
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JoinColumn(name = "client_id") // Creates a foreign key in the Bank table
	// List<Bank> bankList;

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

@RestController
@RequestMapping("/api")
class backendControler{

	@Autowired
	BackendRepository backendRepository;
	
	@GetMapping("/getAllClient")
	public ResponseEntity<List<Client>> getAllClient(){
		try{
			List<Client> clientList = new ArrayList<>();
			backendRepository.findAll().forEach(clientList::add);
			if (clientList.isEmpty()){	
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(clientList,HttpStatus.OK);
		} catch (Exception ex){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	


	@GetMapping("/getClientById/{id}")
	public ResponseEntity<Client> getClient(@PathVariable("id") Long id){
		Optional<Client> clientData = backendRepository.findById(id);
		if(clientData.isPresent()){
			return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	};	

	@PostMapping("/addClient")
	public ResponseEntity<Client> addClient(@RequestBody Client client) {
		try {
            Client clientObj = backendRepository.save(client);
            return new ResponseEntity<>(clientObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PostMapping("/updateClient/{id}")
	public ResponseEntity<Client> updateClient(@RequestBody Client client,@PathVariable Long id) {
		Optional<Client> oldClientData = backendRepository.findById(id);
		if (oldClientData.isPresent()){
			Client updateClient = oldClientData.get();
			updateClient.setClientName(client.getClientName());
			updateClient.setTotalMoney(client.getTotalMoney());
			// updateClient.setBankList(client.getBankList());
			Client clientData = backendRepository.save(updateClient);
			return new ResponseEntity<>(clientData,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Client> deleteById(@PathVariable Long id){
		backendRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}



@Repository
interface BackendRepository extends JpaRepository<Client,Long>{

}