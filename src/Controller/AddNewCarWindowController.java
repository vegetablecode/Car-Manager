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
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addOkButtonListener(new okButtonListener());
		this.theView.addCancelButtonListener(new cancelButtonListener());
	}
	
	// OK BUTTON CLASS
	class okButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			System.out.print("OK! Button Clicked");
		}
		
	}
	
	// CANCEL BUTTON CLASS
	class cancelButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Cancel button clicked!");
		}
		
	}
}
