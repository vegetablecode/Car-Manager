package Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Model.Car;
import Model.CarBase;

public class FileSaver {
	
	// attributes
	private CarBase theModel;
	
	// constructor
	public FileSaver(CarBase theModel) {
		this.theModel = theModel;
		
	}
	
	// methods
	public void saveToFile(String name) {
		PrintWriter carOutput = createFile(name);
		
		for(int i = 0; i<theModel.getNumbOfCars(); i++) {
			writeToFile(theModel.getCar(i), carOutput);
		
		carOutput.close();
		}
	}
	
	private PrintWriter createFile(String fileName) {
		try {
			File listOfCars = new File(fileName);
			PrintWriter infoToWrite = new PrintWriter(new BufferedWriter(new FileWriter(listOfCars)));
			return infoToWrite;
		}
		catch(IOException e) {
			System.out.println("Can't create the file");
		}
		return null;
		
	}
	
	private void writeToFile(Car car, PrintWriter carOutput) {
		String carInfo = car.getName() + ";" + Integer.toString(car.getTopSpeed()) + ";" + Integer.toString(car.getYear()) + ";" + Double.toString(car.getFuelConsumption());
		carOutput.println(carInfo);
	}

}
