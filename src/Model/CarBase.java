package Model;

import java.util.ArrayList;
import java.util.List;

public class CarBase {

	// attributes
	private static List <Car> cars = new ArrayList <Car>();
	
	// methods
	public static void addNewCar(String name, int topSpeed, int year, double fuelConsumption) {
		cars.add(new Car(name, topSpeed, year, fuelConsumption));
	}
	
	public static int getNumbOfCars() {
		return cars.size();
	}
	
	public static void removeCar(int id) {
		cars.remove(id);
	}
	
	public static Car getCar(int id) {
		return cars.get(id);
	}
}
