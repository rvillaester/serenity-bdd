@tool:cucumber
@issue:461
Feature: Bank account transaction

  Scenario Outline: Cucumber - Can open accounts with initial deposit
    Given A bank account opening for <name> with account number of <accountNumber>
    When <accountNumber> made an initial deposit of <initialDeposit>
    Then Current balance of <accountNumber> should be <currentBalance>
  Examples:
  	| accountNumber |	name	|	initialDeposit	|	currentBalance	|
  	| Mason-1X3Yre2 |	Mason	|	100							|	100							|
  	| JR-JKH1X3YreS |	JR		|	200							|	200							|
  	| Rey-9X3GFYreD |	Rey		|	50							|	50							|
  	
	Scenario: Cucumber - Can open bulk bank accounts and do transactions
    Given A bulk bank accounts opening
  	| accountNumber |	name	|	initialDeposit		|	currentBalance	|
  	| Andy-DRF54353 |	Andy	|	1000							| 1000						|
  	| Jiel-PKT6LE4K |	Jiel	|	2000							| 2000						|
  	| Rigs-2JKH234S |	Rigs	|	500								| 500							|
    When Jiel-PKT6LE4K deposits 600
    And Andy-DRF54353 withdraws 200
    Then Accounts current balance should be
  	|	accountNumber	|	currentBalance		|
  	|	Andy-DRF54353	|	800								|
  	|	Jiel-PKT6LE4K	|	2600							|
  	|	Rigs-2JKH234S	|	500								|