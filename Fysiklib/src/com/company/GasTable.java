package com.company;

public enum GasTable{

	AIR(1.29, 1.01), 
	O2(1.43, 0.92), 
	OXYGEN(1.43, 0.92),
	ARGON(1.784, 0.52),
	CYAN(2.32, 1.71)
;

	double density;
	double heatCapacity;

	GasTable(double d, double hc) {
		density = d;
		heatCapacity = hc * 1E3; // 1E3 = 1*10^3
	}

}