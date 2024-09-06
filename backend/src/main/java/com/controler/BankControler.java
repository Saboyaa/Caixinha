package com.controler;



import com.classes.Bank;
import com.repos.BankRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/bank")
class bankControler{

    @Autowired
    BankRepository bankRepository;

	@GetMapping()
	public String teste(){
		return "Testando";
	}
    @GetMapping("/getAllBank")
	public ResponseEntity<List<Bank>> getAllBank(){
		try{
			List<Bank> bankList = new ArrayList<>();
			bankRepository.findAll().forEach(bankList::add);
			if (bankList.isEmpty()){	
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(bankList,HttpStatus.OK);
		} catch (Exception ex){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/getBankById/{id}")
	public ResponseEntity<List<Bank>> getBank(@PathVariable("id") Long id){
		List<Bank> bankData = bankRepository.findByClientId(id);
		if(!bankData.isEmpty()){
			return new ResponseEntity<>(bankData, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	};	

	@PostMapping("/addBank")
	public ResponseEntity<Bank> addBank(@RequestBody Bank bank) {
		try {
            Bank bankObj = bankRepository.save(bank);
            return new ResponseEntity<>(bankObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	@PostMapping("/updateBank/{id}")
	public ResponseEntity<Bank> updateBank(@RequestBody Bank bank,@PathVariable Long id) {
		Optional<Bank> oldBankData = bankRepository.findById(id);
		if (oldBankData.isPresent()){
			Bank updateBank = oldBankData.get();
			updateBank.setMoneyBank(bank.getMoneyBank());
			// updateBank.setBankList(bank.getBankList());
			Bank bankData = bankRepository.save(updateBank);
			return new ResponseEntity<>(bankData,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Bank> deleteById(@PathVariable Long id){
		bankRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}