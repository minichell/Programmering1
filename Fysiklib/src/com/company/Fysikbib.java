package com.company;

import static com.company.FluidTable.H20;

public class Fysikbib<thePressure> {
	static double G = 9.82;
	static double P_0 = 101.3E3;
	static double R = 8.3145;
	static double C = 2.99792458;
	static double G_= 6.6726 * 1E-11;
	static double LY = 9.46055 * 1E15;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fahrenheitToCelsius(50));
		System.out.println(kelvinToCelsius(0));
		System.out.println(fluidPressure(FluidTable.WATER, 10));
		System.out.println(pressureUnderWater(10));
		System.out.println(kineticEnergi(2,2));
        System.out.println(potentialEnergy(2,5));
		System.out.println(fallSpeed(2.5));
	}

	/**
	 * En metod för att konvertera temperaturen från fahrenheit till celsius
	 *
	 * @param fahrenheit - variabel som är temperaturen
	 * @return - Celsius
	 */
	public static double fahrenheitToCelsius(double fahrenheit) {
		double celsius = (fahrenheit - 32) * 5 / 9;
		return celsius;
	}

	/**
	 * En metod för att konvertera temperaturen från kelvin till celsius
	 *
	 * @param kelvin - En variabel som är temperaturen
	 * @return - Celsius
	 */
	public static double kelvinToCelsius(double kelvin) {
		double celsius = kelvin - 273.15;
		return celsius;
	}

	/**
	 * En metod som räknar ut vätsketrycket i en vätska vid ett visst djup.
	 *
	 * @param fluid - En variabel som är densitetet
	 * @param deep  - En variabel som är höjden
	 * @return - thePressure
	 */
	public static double fluidPressure(FluidTable fluid, double deep) {
		double thePressure = 0;
		thePressure = fluid.density * 9.82 * deep;
		return thePressure;

	}

	/**
	 * En metod som räknar ut vätsketrycket i vatten vid ett visst djup
	 * @param deep - En variabel som är höjden
	 * @return - thePressure
	 */
	public static double pressureUnderWater(double deep) {
		double thePressure = H20.density*9.82*deep;
		return thePressure;
}

	/**
	 * En metod som räknar ut kinetisk energi med hjälp av massa och hastighet
	 * @param mass - En variabel som är vikten/massa
	 * @param velocity - En variabel som är hastigheten
	 * @return - KineticEnergi
	 *
	 */
	public static double kineticEnergi(double mass, double velocity){
		double kineticEnergi = 0.5*mass*velocity*velocity;
		return kineticEnergi;
	}


    /**
     * En metod som räknar ut potentiell energi med massa och höjden
     * @param mass - En variabel som är massan
     * @param height - En variabel som är höjden
     * @return - potentialEnergy
     */
	public static double potentialEnergy(double mass, double height){
        double potentialEnergy = mass*9.82*height;
        return potentialEnergy;
}

    /**
     * En metod som räknar ut hur hög hastighet man kommer upp i som man släpper föremål från en viss höjd
     * @param height - En variabel som är höjden
     * @return - fallSpeed
     */
    public static double fallSpeed(double height){
	    double fallSpeed = 9.82/height;
	    return fallSpeed;
    }
}