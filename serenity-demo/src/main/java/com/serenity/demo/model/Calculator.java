package com.serenity.demo.model;

public class Calculator {
	
	private int answer;

	public void add(int firstNumber, int secondNumber) {
		answer = firstNumber + secondNumber;
	}

	public void multiply(int firstNumber, int secondNumber) {
		answer = firstNumber * secondNumber;
	}

	public void divide(int firstNumber, int secondNumber) {
		answer = firstNumber / secondNumber;
	}

	public void minus(int firstNumber, int secondNumber) {
		answer = firstNumber - secondNumber;
	}

	public int getAnswer(){
		return answer;
	}
}
