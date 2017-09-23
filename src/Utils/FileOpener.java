package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Model.CarBase;

public class FileOpener {
	
	// attributes
	private CarBase theModel;
	
	// constructor
	public FileOpener(CarBase theModel) {
		this.theModel = theModel;
	}
	
	// methods
	public void readFile(String nameOfFile) throws IOException {
		File listOfCars = new File(nameOfFile);
		
		try {
			BufferedReader getInfo = new BufferedReader(new FileReader(listOfCars));
			String carInfo = getInfo.readLine();
			
			// zabawa z tekstem
			
			System.out.println("GOOD");
		}
		catch(FileNotFoundException e) {
			System.out.println("Can't find the file");
		}
	}

}
