package com.company;

import com.sun.org.apache.bcel.internal.util.ClassStack;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

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
		System.out.println(delta(1,10));
        System.out.println(volumeToMass(FluidTable.WATER, 1));
		System.out.println(volumeToMass(GasTable.AIR,1));
		System.out.println(volumeToMass(SolidTable.IRON,1));
		System.out.println(svtVelocity(10,5));
		System.out.println(svtDistance(10,5));
		System.out.println(svtTime(10,2));
		System.out.println(work(50,10));
		System.out.println(power(1000,2));
	}
	/**
	 * En metod för att konvertera temperaturen från fahrenheit till celsius
	 *
	 * @param fahrenheit - variabel som är temperaturen i fahrenheit
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
        double potentialEnergy = mass*G*height;
        return potentialEnergy;
}
    /**
     * En metod som räknar ut hur hög hastighet man kommer upp i som man släpper föremål från en viss höjd
     * @param height - En variabel som är höjden
     * @return - fallSpeed
     */
    public static double fallSpeed(double height){
	    double fallSpeed = Math.sqrt(2*G*height);
	    return fallSpeed;
    }

	/**
	 * En metod som räknar ut skillnaden mellan två givna värden
	 * @param first - Den första värden
	 * @param last - Den andra värden
	 * @return -  delta
	 */
    public static double delta(double first, double last){
    	double delta = last - first;
    	return delta;
	}

    /**
     * En metod som gör en viss volym av vätska till en massa
     * @param fluid - En variabel som är densitetet
     * @param volume - En variabel som är volumen
     * @return - volumeToMass
     */
	public static double volumeToMass(FluidTable fluid, double volume){
        double volumeToMass = 0;
        volumeToMass = volume*fluid.density;
        return  volumeToMass;
    }

	/**
	 * En metod som räknar ut vad en gas volym väger i massa
	 *
	 * @param gas -  en variabel
	 * @param volume - en variabel
	 * @return - gasMass
	 */
	public static double volumeToMass(GasTable gas, double volume){
		double gasMass = 0;
		gasMass = volume*gas.density;
		return gasMass;
	}

	/**
	 * En metod som gör en viss volym av materia till en massa.
	 * @param solid - En variabel
	 * @param volume - En variabel
	 * @return solidMass
	 */
	public static double volumeToMass(SolidTable solid, double volume){
		double solidMass = 0;
		solidMass = volume*solid.density;
		return solidMass;
	}

	/**
	 * En metod som räknar ut medelhastigheten med hjälp av sträcka och tid
	 * @param distance - En variabel som är distans
	 * @param time - En variabel som är tiden
	 * @return - Velocity
	 */
	public static double svtVelocity(double distance, double time){
		double Velocity = 0;
		Velocity = distance/time;
		return Velocity;
	}

	/**
	 * En medtod som räknar ut sträcka med hjälp av hastighet och tid
	 * @param velocity - En variabel som är hastigheten
	 * @param time - En variabel som är tid
	 * @return - Distance
	 */
	public static double svtDistance(double velocity, double time){
		double Distance = 0;
		Distance = velocity*time;
		return Distance;
	}

	/**
	 * En metid som räknar ut tid med hjälp av sträcka och hastighet.
	 * @param distance - En variabel som är sträcka
	 * @param velocity - En variabel som är hastigheten
	 * @return - Time
	 */
	public static double svtTime(double distance, double velocity){
		double Time = 0;
		Time = distance/velocity;
		return Time;
	}

	/**
	 * En metod som räknar ut arbete med hjälp av kraft och sträcka
	 * @param force - En variabel som är kraft
	 * @param distance - En variabel som är sträcka
	 * @return - work
	 */
	public static double work(double force, double distance){
		double work = 0;
		work = force*distance;
		return work;
	}

	/**
	 * En metod som räknar ut effekt med hjälp av arbete och tid
	 * @param work - En variabel som är arbete
	 * @param time - En variabel som är tiden
	 * @return - power
	 */
	public static double power(double work, double time){
		double power = 0;
		power = work/time;
		return power;
	}
}
