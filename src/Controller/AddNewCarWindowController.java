package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CarBase;
import View.AddNewCarWindow;
import View.Window;

public class AddNewCarWindowController {

	// attributes
	private Window theWindow;
	private AddNewCarWindow theView;
	private CarBase theModel;
	
	// constructor
	public AddNewCarWindowController(Window theWindow, AddNewCarWindow theView, CarBase theModel) {
		this.theWindow = theWindow;
		this.theModel = theModel;
		this.theView = theView;
		
		theView.addOkButtonListener(new okButtonListener());
		theView.addCancelButtonListener(new cancelButtonListener());
		
	}
	
	// OK BUTTON CLASS
	class okButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			String name;
			int topSpeed;
			int year;
			double fuelConsumption;
			
			try {
				name = theView.getName();
				topSpeed = theView.getTopSpeed();
				year = theView.getYear();
				fuelConsumption = theView.getFuelConsumption();
				
				theModel.addNewCar(name, topSpeed, year, fuelConsumption);
				theWindow.updateMainPanel(theModel);
				theView.setVisible(false);
				
				theView.cleanFields();
			}
			catch(NumberFormatException ex) {
				System.out.println(ex);
				theView.displayErrorMessage("You need to enter all details!");
			}
		}
		
	}
	
	// CANCEL BUTTON CLASS
	class cancelButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Cancel button clicked!");
			theWindow.updateMainPanel(theModel);
		}
		
	}
}
