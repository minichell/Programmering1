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

	/**
	 * En metod som r�knar ut kinetisk energi med hj�lp av massa och hastighet
	 * @param mass - En variabel som �r vikten/massa
	 * @param velocity - En variabel som �r hastigheten
	 * @return - KineticEnergi
	 *
	 */
	public static double kineticEnergi(double mass, double velocity){
		double kineticEnergi = 0.5*mass*velocity*velocity;
		return kineticEnergi;
	}


    /**
     * En metod som r�knar ut potentiell energi med massa och h�jden
     * @param mass - En variabel som �r massan
     * @param height - En variabel som �r h�jden
     * @return - potentialEnergy
     */
	public static double potentialEnergy(double mass, double height){
        double potentialEnergy = mass*9.82*height;
        return potentialEnergy;
}

    /**
     * En metod som r�knar ut hur h�g hastighet man kommer upp i som man sl�pper f�rem�l fr�n en viss h�jd
     * @param height - En variabel som �r h�jden
     * @return - fallSpeed
     */
    public static double fallSpeed(double height){
	    double fallSpeed = 9.82/height;
	    return fallSpeed;
    }
}