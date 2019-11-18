package com.company;

import static com.company.FluidTable.H20;

public class Fysikbib<thePressure> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fahrenheitToCelsius(50));
		System.out.println(kelvinToCelsius(0));
		System.out.println(fluidPressure(FluidTable.WATER, 10));
		System.out.println(pressureUnderWater(10));

	}

	/**
	 * En metod f�r att konvertera temperaturen fr�n fahrenheit till celsius
	 *
	 * @param fahrenheit - variabel som �r temperaturen
	 * @return - Celsius
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		double celsius = (fahrenheit - 32) * 5 / 9;
		return celsius;
	}

	/**
	 * En metod f�r att konvertera temperaturen fr�n kelvin till celsius
	 *
	 * @param kelvin - En variabel som �r temperaturen
	 * @return - Celsius
	 */
	public static double kelvinToCelsius(double kelvin) {
		double celsius = kelvin - 273.15;
		return celsius;
	}

	/**
	 * En metod som r�knar ut v�tsketrycket i en v�tska vid ett visst djup.
	 *
	 * @param fluid - En variabel som �r densitetet
	 * @param deep  - En variabel som �r h�jden
	 * @return - thePressure
	 */
	public static double fluidPressure(FluidTable fluid, double deep) {
		double thePressure = 0;
		thePressure = fluid.density * 9.82 * deep;
		return thePressure;

	}

	/**
	 * En metod som r�knar ut v�tsketrycket i vatten vid ett visst djup
	 * @param deep - En variabel som �r h�jden
	 * @return - thePressure
	 */
	public static double pressureUnderWater(double deep) {
		double thePressure = H20.density*9.82*deep;
		return thePressure;
}
}