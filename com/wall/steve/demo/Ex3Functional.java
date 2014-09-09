package com.wall.steve.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.wall.steve.wed.Car;

public class Ex3Functional {
	public static void main(String[] args) {
		List<Car> cars = Arrays.asList(
				new Car("VW", "Beetle", 2012),
				new Car("Toyota", "Corolla", 2008),
				new Car("Toyota", "Prius", 2014),
				new Car("Ford", "Mustang", 2012)
		);
		
		
		cars.stream()
			.filter(c -> c.getMake().equals("Toyota"))
			.forEach(car -> car.printCar());
		
		
		//findNewestCarImperative(cars);
		//findNewestCarFunctional(cars);
		
	}
	
	public static void findNewestCarImperative(List<Car> carList) {
		System.out.println("\nfindNewestCarImperative");
		Car newest = null;
		int newestYear = 1885;
		for (int i=0; i < carList.size(); i++) {
			Car current = carList.get(i);
			if (current.getYear() > newestYear) {
				newestYear = current.getYear();
				newest = current;
			}
		}
		newest.printCar();
	}

	private static void findNewestCarFunctional(List<Car> carList) {
		System.out.println("\nfindNewestCarFunctional");
		
		carList.stream()
			   .max(YEAR_TESTER)
			   .get()
			   .printCar();
		
	}

	static final Comparator<Car> YEAR_TESTER = (Car c1, Car c2) -> {
		return Integer.compare(c1.getYear(), c2.getYear());
	};

}
