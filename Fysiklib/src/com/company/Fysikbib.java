package com.company;

public class Fysikbib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println(fahrenheitToCelsius(50));
	System.out.println(kelvinToCelsius(0));
	

	}
	
	/**
 * En metod för att konvertera temperaturen från fahrenheit till celsius
	 * @param fahrenheit
	 * @return
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		double celsius = (fahrenheit - 32)*5/9;
		int hej = 0;
		return celsius;
	}	
	
	
	/**
 * En metod för att konvertera temperaturen från kelvin till celsius
	 * @param kelvin
	 * @return
	 */
		public static double kelvinToCelsius(double kelvin) {
			double celsius = kelvin - 273.15;
			return celsius;
	}
}