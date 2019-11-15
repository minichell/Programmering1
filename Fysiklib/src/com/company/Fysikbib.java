package com.company;

public class Fysikbib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(fahrenheitToCelsius(50));

	

	}
	
	/**
	 * En metod för att konvertera temperaturen från fahrenheit till celsius
	 * @param fahrenheit - variabel som är temperaturen
	 * @return - Celsius
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		double celsius = (fahrenheit - 32)*5/9;
		return celsius;
	}	
	
	

}