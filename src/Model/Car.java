package Model;

public class Car {
	
	// attributes
	private String name;
	private int topSpeed;
	private int year;
	private double fuelConsumption;
	
	// setters
	public void setName(String name){
		this.name = name;
	}
	
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}
	
	// getters
	public String getName() {
		return name;
	}
	
	public int getTopSpeed() {
		return topSpeed;
	}
	
	public int getYear() {
		return year;
	}
	
	public double getFuelConsumption() {
		return fuelConsumption;
	}
	
	// constructor
	public Car(String name, int topSpeed, int year, double fuelConsumption) {
		this.name = name;
		this.topSpeed = topSpeed;
		this.year = year;
		this.fuelConsumption = fuelConsumption;
	}
}
