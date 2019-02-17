package com.serenity.demo.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.serenity.demo.app.BankAccountService;
import com.serenity.demo.model.BankAccount;

import net.thucydides.core.annotations.Step;

public class BankAccountSteps {
	
	private BankAccountService bankAccountService = BankAccountService.getInstance();
	
	@Step("Creating bank account for {1}")
	public void createBankAccount(String accountNumber, String accountName, int initialDeposit){
		BankAccount bankAccount = new BankAccount(accountNumber, accountName, initialDeposit);
		bankAccountService.createBankAccount(bankAccount);
	}
	
	@Step("{0} deposits amounting to {1}")
	public void deposit(String accountNumber, int amount){
		bankAccountService.deposit(accountNumber, amount);
	}
	
	@Step("{0} current balance should be {1}")
	public void shouldHaveCorrectBalance(String accountNumber, int balance){
		assertThat(bankAccountService.getCurrentBalance(accountNumber), equalTo(balance));
	}
	
	@Step("Opening bulk bank accounts")
	public void createBulkBankAccounts(List<BankAccount> bankAccounts){
		bankAccountService.createBankAccounts(bankAccounts);
	}
	
	@Step("{0} withdraws amounting to {1}")
	public void withdrawOnAccount(String accountNumber, int withdrawalAmount){
		bankAccountService.withdraw(accountNumber, withdrawalAmount);
	}
	
	@Step("{0} deposits amounting to {1}")
	public void depositOnAccount(String accountNumber, int depositAmount){
		bankAccountService.deposit(accountNumber, depositAmount);
	}
}
