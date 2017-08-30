package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CarBase;
import View.AddNewCarWindow;

public class AddNewCarWindowController {

	// attributes
	private AddNewCarWindow theView;
	private CarBase theModel;
	
	// constructor
	public AddNewCarWindowController(AddNewCarWindow theView, CarBase theModel) {
		this.theModel = theModel;
		
		theView.addOkButtonListener(new okButtonListener());
		theView.addCancelButtonListener(new cancelButtonListener());
		
	}
	
	// OK BUTTON CLASS
	class okButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			//System.out.print("OK! Button Clicked");
			System.out.println(theView.getName());
			//System.out.println(theView.getTopSpeed());
			//System.out.println(theView.getYear());
			//System.out.println(theView.getFuelConsumption());
			//theModel.addNewCar(theView.getName(), theView.getTopSpeed(), theView.getYear(), theView.getFuelConsumption());
		}
		
	}
	
	// CANCEL BUTTON CLASS
	class cancelButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Cancel button clicked!");
		}
		
	}
}
