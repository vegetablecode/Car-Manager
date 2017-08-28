package Model;

import java.util.ArrayList;
import java.util.List;

public class CarBase {

	// attributes
	private List <Car> cars = new ArrayList <Car>();
	
	// methods
	public void addNewCar(String name, int topSpeed, int year, double fuelConsumption) {
		cars.add(new Car(name, topSpeed, year, fuelConsumption));
	}
	
	public int getNumbOfCars() {
		return cars.size();
	}
	
	public void removeCar(int id) {
		cars.remove(id);
	}
	
	public Car getCar(int id) {
		return cars.get(id);
	}
}
