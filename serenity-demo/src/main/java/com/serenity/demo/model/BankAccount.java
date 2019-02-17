package com.serenity.demo.model;

public class BankAccount {

	private String name;
	private String accountNumber;
	private int initialDeposit;
	private int currentBalance;
	
	public BankAccount(String accountNumber, String accountName, int initialDeposit) {
		this.name = accountName;
		this.initialDeposit = initialDeposit;
		this.accountNumber = accountNumber;
		this.currentBalance = initialDeposit;
	}
	
	public void setInitialDeposit(int initialDeposit){
		this.initialDeposit = initialDeposit;
		this.currentBalance = this.initialDeposit;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(int currentBalance) {
		this.currentBalance = currentBalance;
	}

	public int getInitialDeposit() {
		return initialDeposit;
	}
	
}
