package com.serenity.demo.app;

import java.util.List;

import com.serenity.demo.model.BankAccount;

public class BankAccountService {
	
	private static BankAccountService instance;
	private BankAccountRepository bankAccountRepository;

	private BankAccountService() {
		bankAccountRepository = BankAccountRepository.getInstance();
	}
	
	public static BankAccountService getInstance(){
		if(instance == null){
			instance = new BankAccountService();
		}
		return instance;
	}
	
	public void createBankAccount(BankAccount bankAccount){
		bankAccountRepository.saveAccount(bankAccount);
	}
	
	public void createBankAccounts(List<BankAccount> bankAccounts){
		bankAccountRepository.saveAccounts(bankAccounts);
	}
	
	public void deposit(String accountNumber, int amount){
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
		if(bankAccount == null){
			throw new RuntimeException("No Bank Account with account number: " + accountNumber);
		}
		
		int balance = bankAccount.getCurrentBalance() + amount;
		bankAccount.setCurrentBalance(balance);
	}
	
	public void withdraw(String accountNumber, int amount){
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
		if(bankAccount == null){
			throw new RuntimeException("No Bank Account with account number: " + accountNumber);
		}
		
		int balance = bankAccount.getCurrentBalance() - amount;
		bankAccount.setCurrentBalance(balance);
	}
	
	public int getCurrentBalance(String accountNumber){
		BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber);
		if(bankAccount == null){
			throw new RuntimeException("No Bank Account with account number: " + accountNumber);
		}
		
		return bankAccount.getCurrentBalance();
	}
}
