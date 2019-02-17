package com.serenity.demo.jbehave.stepdefinitions;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.serenity.demo.steps.CalculatorSteps;

import net.thucydides.core.annotations.Steps;

public class CalculatorStepDefinitions {
	
	@Steps CalculatorSteps calculatorSteps;
	
	@Given("Mason has calculator")
	public void createCalculator(){
		calculatorSteps.initializeCalculator();
	}
	
	@When("Mason add two numbers $firstNumber and $secondNumber")
	public void addTwoNumbers(int firstNumber, int secondNumber){
		calculatorSteps.addTwoNumbers(firstNumber, secondNumber);
	}
	
	@When("Mason perform subtraction $minuend minus $subtrahend")
	public void doSubtraction(int minuend, int subtrahend){
		calculatorSteps.subtractTwoNumbers(minuend, subtrahend);
	}
	
	@Then("Calculator should return $answer")
	public void answerShouldBe(int answer){
		calculatorSteps.asnwerShouldBe(answer);
	}
}
