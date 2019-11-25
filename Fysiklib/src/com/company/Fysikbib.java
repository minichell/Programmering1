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
	 * En metod f�r att konvertera temperaturen fr�n fahrenheit till celsius
	 *
	 * @param fahrenheit - variabel som �r temperaturen i fahrenheit
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
        double potentialEnergy = mass*G*height;
        return potentialEnergy;
}
    /**
     * En metod som r�knar ut hur h�g hastighet man kommer upp i som man sl�pper f�rem�l fr�n en viss h�jd
     * @param height - En variabel som �r h�jden
     * @return - fallSpeed
     */
    public static double fallSpeed(double height){
	    double fallSpeed = Math.sqrt(2*G*height);
	    return fallSpeed;
    }

	/**
	 * En metod som r�knar ut skillnaden mellan tv� givna v�rden
	 * @param first - Den f�rsta v�rden
	 * @param last - Den andra v�rden
	 * @return -  delta
	 */
    public static double delta(double first, double last){
    	double delta = last - first;
    	return delta;
	}

    /**
     * En metod som g�r en viss volym av v�tska till en massa
     * @param fluid - En variabel som �r densitetet
     * @param volume - En variabel som �r volumen
     * @return - volumeToMass
     */
	public static double volumeToMass(FluidTable fluid, double volume){
        double volumeToMass = 0;
        volumeToMass = volume*fluid.density;
        return  volumeToMass;
    }

	/**
	 * En metod som r�knar ut vad en gas volym v�ger i massa
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
	 * En metod som g�r en viss volym av materia till en massa.
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
	 * En metod som r�knar ut medelhastigheten med hj�lp av str�cka och tid
	 * @param distance - En variabel som �r distans
	 * @param time - En variabel som �r tiden
	 * @return - Velocity
	 */
	public static double svtVelocity(double distance, double time){
		double Velocity = 0;
		Velocity = distance/time;
		return Velocity;
	}

	/**
	 * En medtod som r�knar ut str�cka med hj�lp av hastighet och tid
	 * @param velocity - En variabel som �r hastigheten
	 * @param time - En variabel som �r tid
	 * @return - Distance
	 */
	public static double svtDistance(double velocity, double time){
		double Distance = 0;
		Distance = velocity*time;
		return Distance;
	}

	/**
	 * En metid som r�knar ut tid med hj�lp av str�cka och hastighet.
	 * @param distance - En variabel som �r str�cka
	 * @param velocity - En variabel som �r hastigheten
	 * @return - Time
	 */
	public static double svtTime(double distance, double velocity){
		double Time = 0;
		Time = distance/velocity;
		return Time;
	}

	/**
	 * En metod som r�knar ut arbete med hj�lp av kraft och str�cka
	 * @param force - En variabel som �r kraft
	 * @param distance - En variabel som �r str�cka
	 * @return - work
	 */
	public static double work(double force, double distance){
		double work = 0;
		work = force*distance;
		return work;
	}

	/**
	 * En metod som r�knar ut effekt med hj�lp av arbete och tid
	 * @param work - En variabel som �r arbete
	 * @param time - En variabel som �r tiden
	 * @return - power
	 */
	public static double power(double work, double time){
		double power = 0;
		power = work/time;
		return power;
	}
}
