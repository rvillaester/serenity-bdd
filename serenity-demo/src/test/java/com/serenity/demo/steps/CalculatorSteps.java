package com.serenity.demo.steps;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.serenity.demo.app.CalculatorService;

import net.thucydides.core.annotations.Step;

public class CalculatorSteps {

	CalculatorService service = CalculatorService.getInstance();
	
	@Step("Given that Jason had calculator")
	public void initializeCalculator() {
		service.initializeCalculator();
	}

	@Step("When Jason add tow numbers: {0} and {1}")
	public void addTwoNumbers(int firstNumber, int secondNumber) {
		service.addition(firstNumber, secondNumber);
	}

	@Step("When Jason subtract numbers: {0} and {1}")
	public void subtractTwoNumbers(int minuend, int subtrahend) {
		service.minus(minuend, subtrahend);
	}

	@Step("Then answer should be: {0}")
	public void asnwerShouldBe(int answer) {
		assertThat(service.getAnswer(), equalTo(answer));
	}

}
