package com.controler;

import com.classes.Client;
import com.repos.ClientRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/client")
class clientControler{

	@GetMapping()
	public String teste(){
		return "Testando";
	}
	public String getMethodName(@RequestParam String param) {
		return new String();
	}
	
	@Autowired
	ClientRepository clientRepository;
	
	@GetMapping("/getAllClient")
	public ResponseEntity<List<Client>> getAllClient(){
		try{
			List<Client> clientList = new ArrayList<>();
			clientRepository.findAll().forEach(clientList::add);
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
		Optional<Client> clientData = clientRepository.findById(id);
		if(clientData.isPresent()){
			return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	};	

	@PostMapping("/addClient")
	public ResponseEntity<Client> addClient(@RequestBody Client client) {
		try {
            Client clientObj = clientRepository.save(client);
            return new ResponseEntity<>(clientObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PostMapping("/updateClient/{id}")
	public ResponseEntity<Client> updateClient(@RequestBody Client client,@PathVariable Long id) {
		Optional<Client> oldClientData = clientRepository.findById(id);
		if (oldClientData.isPresent()){
			Client updateClient = oldClientData.get();
			updateClient.setClientName(client.getClientName());
			updateClient.setTotalMoney(client.getTotalMoney());
			// updateClient.setBankList(client.getBankList());
			Client clientData = clientRepository.save(updateClient);
			return new ResponseEntity<>(clientData,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Client> deleteById(@PathVariable Long id){
		clientRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
