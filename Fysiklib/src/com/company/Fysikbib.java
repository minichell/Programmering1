package com.company;

public class Fysikbib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(fahrenheitToCelsius(50));

	

	}
	
	/**
	 * En metod f�r att konvertera temperaturen fr�n fahrenheit till celsius
	 * @param fahrenheit - variabel som �r temperaturen
	 * @return - Celsius
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		double celsius = (fahrenheit - 32)*5/9;
		return celsius;
	}	
	
	

}