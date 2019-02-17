package com.serenity.demo.cucumber.stepdefinitions;

import java.util.List;

import com.serenity.demo.model.BankAccount;
import com.serenity.demo.steps.BankAccountSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class BankAccountTransactionStepDefinitions {
	
	@Steps
	BankAccountSteps bankAccountStep;
	
	//first scenario
	@Given("^A bank account opening for (.*) with account number of (.*)$")
    public void createNewBankAccount(String name, String accountNumber) {
		bankAccountStep.createBankAccount(accountNumber, name, 0);
    }
	
	@When("^(.*) made an initial deposit of (\\d+)$")
    public void initialDeposit(String accountNumber, int deposit) {
		bankAccountStep.deposit(accountNumber, deposit);
    }
	
	@Then("^Current balance of (.*) should be (\\d+)$")
    public void currentBalanceAfterDepositShouldBe(String accountNumber, int balance) {
		bankAccountStep.shouldHaveCorrectBalance(accountNumber, balance);
    }
	
	
	//second scenario
	@Given("^A bulk bank accounts opening$")
    public void createBulkAccounts(List<BankAccount> bankAccounts) {
		bankAccountStep.createBulkBankAccounts(bankAccounts);
    }
	
	@When("^(.*) deposits (\\d+)$")
    public void depositAmount(String accountNumber, int depositAmount) {
		bankAccountStep.depositOnAccount(accountNumber, depositAmount);
    }
	
	@And("^(.*) withdraws (\\d+)$")
    public void withdrawAmount(String accountNumber, int withdrawalAmount) {
		bankAccountStep.withdrawOnAccount(accountNumber, withdrawalAmount);
    }
	
	@And("^Accounts current balance should be$")
    public void accountBalanceAfterTransactions(List<BankAccount> bankAccounts) {
		for (BankAccount bankAccount : bankAccounts) {
			bankAccountStep.shouldHaveCorrectBalance(bankAccount.getAccountNumber(), bankAccount.getCurrentBalance());
		}
    }
}
