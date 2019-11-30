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
		System.out.println("Hur mycket väger 60 dm^3 järn?");
		// 60dm^3 är 0,6m^3
		System.out.println(volumeToMass(SolidTable.IRON,0.06) + "kg");
		System.out.println("Hur långt hinner Tomas om han löper med medelhastigheten 2.7 m/s i 50 minuter?");
		// 50 minuter är 3000 sekunder
		System.out.println(svtDistance(2.7,3000));
		System.out.println("Hur mycket energi krävs för att värma upp 4 liter vatten från rumstemperatur (22 grader) till kokpunkten?");
		// 4 liter vatten är 4 kilogram och deltaT är 100-22= 78
		System.out.println(heat(FluidTable.WATER,4,78));
		System.out.println("Hur stort är det totala trycket 75 meter under havsytan?");
		System.out.println(fluidPressure(FluidTable.WATER,75));
		System.out.println("Tomas som är 180cm lång kastar upp en boll med massan 250 gram i luften så den får starthastigheten 60 km/h. Hur högt kommer bollen?");
		// 60km/h är 16.67 m/s och 180cm är 1.8 meter
		System.out.println(velocityToHeight(16.6) + 1.8 + "meter");
		System.out.println("En bil med massan 735kg accelererar med konstant acceleration från 0-100 på 4.8 sekunder. Hur stor effekt har bilens motor uppnått?");
		// 100km/h är 27,78 m/s
		// acceleration är 27,78 m/s / 4.8 = 5.7 m/s^2
		// Kraft m*a = 735kg*5.7m/s^2 = 4353,4 Newton (N)
		// Arbete är F*S (sträcka) = 580500 newtonmeter (Nm)
		System.out.println(power( 580500, 4.8) + "W");
		System.out.println("En studsboll som väger 1kg släpps från 12 meters höjd och varje gång den nuddar marken tappar den 1% av sin energi. Hur många gånger kommer bollen studsa i marken innan den inte studsar hörge än 0.5 meter?");
		System.out.println(numberOfBounces(12));
		System.out.println("En bil minskar farten med konstant acceleration från 25m/s till 15m/s på 3.2 sekunder. Bestäm accelerationen");
		// För att få accelerationen tar man delta V (hastigheten) delat med tiden
		System.out.println(acceleration(25,15,3.2));
		System.out.println("Ett föremål påverkas av två krafter, 8N riktad åt höger och 17N riktad åt vänster. Bestäm den resulterande kraften.");
		System.out.println(theResultForce(8.0,17.0) + "N");
		System.out.println("Beräkna ut rörelsemängden när en bil åker med 20m/s och har massa för 140kg. ");
		System.out.println(momentum(20,140));


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
	 * @param deep - En variabel som är höjden i meter
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
     * @param mass - En variabel som är massan i kilogram
     * @param height - En variabel som är höjden i meter
     * @return - potentialEnergy
     */
	public static double potentialEnergy(double mass, double height){
        double potentialEnergy = mass*G*height;
        return potentialEnergy;
}
    /**
     * En metod som räknar ut hur hög hastighet man kommer upp i som man släpper föremål från en viss höjd
     * @param height - En variabel som är höjden i meter
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
     * @param fluid - En variabel som är densitetet i kg/m^3
     * @param volume - En variabel som är volumen i m^3 (kubikmeter)
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
	 * @param volume - en variabel i kubikmeter
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
	 * @param volume - En variabel som är m^3 (kubikmeter)
	 * @return solidMass
	 */
	public static double volumeToMass(SolidTable solid, double volume){
		double solidMass = 0;
		solidMass = volume*solid.density;
		return solidMass;
	}

	/**
	 * En metod som räknar ut medelhastigheten med hjälp av sträcka och tid
	 * @param distance - En variabel som är distans för sträcka i meter
	 * @param time - En variabel som är tiden i sekunder
	 * @return - Velocity
	 */
	public static double svtVelocity(double distance, double time){
		double Velocity = 0;
		Velocity = distance/time;
		return Velocity;
	}

	/**
	 * En medtod som räknar ut sträcka med hjälp av hastighet och tid
	 * @param velocity - En variabel som är hastigheten i meter per sekund
	 * @param time - En variabel som är tid i sekunder
	 * @return - Distance
	 */
	public static double svtDistance(double velocity, double time){
		double Distance = 0;
		Distance = velocity*time;
		return Distance;
	}

	/**
	 * En metid som räknar ut tid med hjälp av sträcka och hastighet.
	 * @param distance - En variabel som är sträcka i meter
	 * @param velocity - En variabel som är hastigheten i meter per sekund
	 * @return - Time
	 */
	public static double svtTime(double distance, double velocity){
		double Time = 0;
		Time = distance/velocity;
		return Time;
	}

	/**
	 * En metod som räknar ut arbete med hjälp av kraft och sträcka
	 * @param force - En variabel som är kraft i Newton
	 * @param distance - En variabel som är sträcka i meter
	 * @return - work
	 */
	public static double work(double force, double distance){
		double work = 0;
		work = force*distance;
		return work;
	}

	/**
	 * En metod som räknar ut effekt med hjälp av arbete och tid
	 * @param work - En variabel som är arbete newton*meter
	 * @param time - En variabel som är tiden i sekunder
	 * @return - power
	 */
	public static double power(double work, double time){
		double power = 0;
		power = work/time;
		return power;
	}

	/**
	 * En metod som räknar ut hur mycket energi som krävs för att värma ett visst material ett angivet antal grader
	 * @param solid - Ett ämne
	 * @param mass - En variabel som är massa i kilogram
	 * @param deltaT - Delta
	 * @return - heat
	 */
	public static double heat(SolidTable solid, double mass, double deltaT){
		double heat = 0;
		heat = mass*deltaT*solid.heatCapacity;
		return heat;
	}

	/**
	 * En metod som räknar ut hur mycket energi som krävs för att värma en viss massa vätska ett angivet antal grader.
	 * @param fluid - Ett ämne
	 * @param mass -  En variabel som är massan
	 * @param deltaT - delta
	 * @return - heat
	 */
	public static double heat(FluidTable fluid, double mass, double deltaT){
		double heat = 0;
		heat = fluid.heatCapacity*mass*deltaT;
		return heat;
	}

	/**
	 * metod som räknar ut hur mycket energi som krävs för att värma en viss massa gas ett angivet antal grader.
	 * @param gas - Variabel som är gasen
	 * @param mass - En variabel som är massa i kilogram
	 * @param deltaT - Delta
	 * @return - heat
	 */
	public static double heat(GasTable gas, double mass,double deltaT){
		double heat = 0;
		heat = gas.heatCapacity*mass*deltaT;
		return heat;
	}

	/**
	 * En metod som räknar ut hur högt ett föremål med en viss hastighet uppåt kommer.
	 * @param velocity - En variabel som är hastigheten i meter per sekund
	 * @return - formen för height
	 */
	public static double velocityToHeight(double velocity){
		return Math.pow(velocity,2)/(2*9.82);
}

	/**
	 * En metod som räknar ut hur mpnga gånger en boll kommer studsa omd en förlorar 1% av sin energi efter varje studs, med hjälp av en while-loop
	 * @param height - En variabel som är höjden i meter
	 * @return - Returnar counterBounces alltså antal gånger bollen har studsat.
	 */
	public static double numberOfBounces(double height){
		double finalEnergy = height*9.82;
		int counterBounces = 0;
		double i = 12;
		while (i >=0.5){
			finalEnergy *=0.99;
			i = finalEnergy / 9.82;
			counterBounces++;
		}
		return counterBounces;
	}

	/**
	 * En metod som beräknar accelerationen med hjälp av delta hastigheten och tiden
	 * @param firstVelocity - Är starthastigheten
	 * @param lastVelocity - Är sluthastigheten
	 * @param time - tiden i sekunder
	 * @return - returnar formeln för accelerationen
	 */
	public static double acceleration(double firstVelocity, double lastVelocity,double time){
		return (firstVelocity-lastVelocity)/time;
	}

	/**
	 * En metod som räknar ut den resulterande kraften med hjälp av F1 och F2
	 * @param F1 - Första kraften i Newton
	 * @param F2 - Andra kraften i Newton
	 * @return - Returnar svaret på den resulterande kraften
	 */
	public static double theResultForce( double F1, double F2){
		return F1-F2;
	}

	/**
	 * En metod som räknar ut rörelsemängden i ett viss föremål
	 * @param mass- Massan i kilogram
	 * @param velocity - hastigheten inom meter per sekund
	 * @return - momentum
	 */
	public static double momentum( double mass, double velocity){
		double momentum = 0;
		momentum = mass*velocity;
		return momentum;
	}

	/**
	 * En metod som beräknar ut en volym för cylindern
	 * @param radie - En variabel som är radie i centimeter
	 * @return - volymecylinder
	 */
	public static double volymecylinder(double radie){
		double volymecylinder = 0;
		volymecylinder = (4*Math.PI*radie*radie*radie)/3;
		return volymecylinder;
	}

	/**
	 * En metod som beräknar en volym för kon
	 * @param radie - Radien för formeln
	 * @param height -  höjden för formeln i centimeter
	 * @return - volymecone
	 */
	public static  double volymecone(double radie, double height){
		double volymecone = 0;
		volymecone = (Math.PI*radie*radie*height)/3;
		return volymecone;
	}
}
