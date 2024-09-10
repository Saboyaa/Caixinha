package com.controler;



import com.classes.*;
import com.repos.BankRepository;
import com.repos.TransactionsRepository;

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
@RequestMapping("/transactions")
class transactionsControler{

    @Autowired
    TransactionsRepository transactionsRepository;

	@Autowired
    BankRepository bankRepository;

	@GetMapping()
	public String teste(){
		return "Testando";
	}
    @GetMapping("/getAllTransactions")
	public ResponseEntity<List<Transactions>> getAllTransactions(){
		try{
			List<Transactions> transactionsList = new ArrayList<>();
			transactionsRepository.findAll().forEach(transactionsList::add);
			if (transactionsList.isEmpty()){	
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(transactionsList,HttpStatus.OK);
		} catch (Exception ex){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/getTransactionsById/{id}")
	public ResponseEntity<List<Transactions>> getTransactions(@PathVariable("id") Long id){
		List<Transactions> transactionsData = transactionsRepository.findByClientId(id);
		if(!transactionsData.isEmpty()){
			return new ResponseEntity<>(transactionsData, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	};	

	@PostMapping("/addTransactions")
	public ResponseEntity<Transactions> addTransactions(@RequestBody Transactions transactions) {
		try {
			Transactions transactionsObj = transactionsRepository.save(transactions);
			List<Bank> bankObjList = bankRepository.findByBankName(transactions.getBankName());
			if (!bankObjList.isEmpty()) {
				for (Bank bank : bankObjList) {
					bank.setMoneyBank(bank.getMoneyBank() + transactions.getMoneyBank());
					bankRepository.save(bank); 
				}
			} else {
				
				Bank newBank = new Bank();
				newBank.setBankName(transactions.getBankName());
				newBank.setBankPhoto(transactions.getBankPhoto());
				newBank.setClientId(transactions.getClientId());
				newBank.setMoneyBank(transactions.getMoneyBank());
				bankRepository.save(newBank);
			}
			return new ResponseEntity<>(transactionsObj, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/updateTransactions/{id}")
	public ResponseEntity<Transactions> updateTransactions(@RequestBody Transactions transactions, @PathVariable Long id) {
		Optional<Transactions> oldTransactionsData = transactionsRepository.findById(id);
		if (oldTransactionsData.isPresent()) {
			Transactions oldTransaction = oldTransactionsData.get();

			float amountDifference = transactions.getMoneyBank() - oldTransaction.getMoneyBank();

			oldTransaction.setMoneyBank(transactions.getMoneyBank());

			Transactions updatedTransaction = transactionsRepository.save(oldTransaction);

			List<Bank> bankObjList = bankRepository.findByBankName(oldTransaction.getBankName());
			if (!bankObjList.isEmpty()) {
				for (Bank bank : bankObjList) {
					bank.setMoneyBank(bank.getMoneyBank() + amountDifference);
					bankRepository.save(bank); 
				}
			}

			return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@DeleteMapping("/deleteById/{id}")
public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    Optional<Transactions> transactionData = transactionsRepository.findById(id);
    if (transactionData.isPresent()) {
        Transactions transaction = transactionData.get();

        List<Bank> bankObjList = bankRepository.findByBankName(transaction.getBankName());
        if (!bankObjList.isEmpty()) {
            for (Bank bank : bankObjList) {
                bank.setMoneyBank(bank.getMoneyBank() - transaction.getMoneyBank());
                bankRepository.save(bank); 
            }
        }
        transactionsRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

	

}