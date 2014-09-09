package com.wall.steve.demo;

public interface Vehicle {
	String getType();
	
	static void printVehicles(Vehicle... vehicles) {
		for (Vehicle v : vehicles) {
			System.out.println(v.getType() + "  " + v.getNumberOfWheels());
		}
	}
	
	default int getNumberOfWheels() {
		return 4;
	}
}
