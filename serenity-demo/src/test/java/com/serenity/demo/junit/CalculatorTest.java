package com.serenity.demo.junit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.serenity.demo.steps.CalculatorSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class CalculatorTest {
	
	@Steps
	CalculatorSteps steps;
	
	@Test
	@Title("Serentiy - Can perfrom addtion")
	public void shouldPerformAddition(){
		// given
		steps.initializeCalculator();
		// when
		steps.addTwoNumbers(2, 3);
		//then
		steps.asnwerShouldBe(5);
	}
}
