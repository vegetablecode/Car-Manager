package Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Model.Car;
import Model.CarBase;

public class FileOpener {
	
	// attributes
	private CarBase theModel;
	
	// constructor
	public FileOpener(CarBase theModel) {
		this.theModel = theModel;
	}
	
	// methods
	public void loadDatabase(String nameOfFile) {
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(nameOfFile));
			while ((line = br.readLine()) != null) {
				String[] data = line.split(csvSplitBy);
				theModel.addNewCar(data[0].replaceAll("\"", ""), Integer.parseInt(data[1].replaceAll("\"", "")), Integer.parseInt(data[2].replaceAll("\"", "")), Double.parseDouble(data[3].replaceAll("\"", "")));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
