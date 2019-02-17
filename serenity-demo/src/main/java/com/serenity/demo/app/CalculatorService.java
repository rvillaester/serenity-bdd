package com.serenity.demo.app;

import com.serenity.demo.model.Calculator;

public class CalculatorService {

	private static CalculatorService instance;
	private Calculator calculator;
	
	private CalculatorService() {}
	
	public static CalculatorService getInstance(){
		if(instance == null){
			instance = new CalculatorService();
		}
		return instance;
	}
	
	public void initializeCalculator(){
		if(calculator == null){
			calculator = new Calculator();
		}
	}
	
	public void addition(int firstNumber, int secondNumber){
		calculator.add(firstNumber, secondNumber);
	}
	
	public void multiply(int firstNumber, int secondNumber){
		calculator.multiply(firstNumber, secondNumber);
	}
	
	public void divide(int firstNumber, int secondNumber){
		calculator.multiply(firstNumber, secondNumber);
	}
	
	public void minus(int firstNumber, int secondNumber){
		calculator.minus(firstNumber, secondNumber);
	}
	
	public int getAnswer(){
		return calculator.getAnswer();
	}
}
