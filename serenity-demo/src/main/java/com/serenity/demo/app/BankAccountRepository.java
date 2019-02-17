package com.serenity.demo.app;

import java.util.ArrayList;
import java.util.List;

import com.serenity.demo.model.BankAccount;

public class BankAccountRepository {
	
	private List<BankAccount> bankAccounts = new ArrayList<>();
	private static BankAccountRepository instance;
	
	private BankAccountRepository() {}
	
	// singletone
	public static BankAccountRepository getInstance(){
		if(instance == null){
			instance = new BankAccountRepository();
		}
		return instance;
	}
	
	public void saveAccount(BankAccount bankAccount){
		this.bankAccounts.add(bankAccount);
	}
	
	public void saveAccounts(List<BankAccount> bankAccounts){
		this.bankAccounts.addAll(bankAccounts);
	}
	
	public BankAccount findByAccountNumber(String accountNumber){
		for (BankAccount bankAccount : bankAccounts) {
			if(bankAccount.getAccountNumber().equalsIgnoreCase(accountNumber)){
				return bankAccount;
			}
		}
		return null;
	}
}
