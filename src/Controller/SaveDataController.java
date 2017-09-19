package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CarBase;
import View.SaveDataWindow;
import View.Window;

public class SaveDataController {

	// attributes
	private Window theWindow;
	private CarBase model;
	private SaveDataWindow theView;
	
	// constructor
	public SaveDataController(Window theWindow, CarBase model, SaveDataWindow theView) {
		this.theWindow = theWindow;
		this.model = model;
		this.theView = theView;
			
		theView.addSTDListener(new SaveToDDBListener());
		theView.addSTSListener(new SaveToSDBListener());
	}
	
	// methods
	public void saveToFile(String name) {
		//
	}
	
	// SAVE TO SELECTED DB CLASS
	class SaveToSDBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String nameOfFile = theView.getNameOfFile();
			if(nameOfFile.isEmpty()!=true) {
				nameOfFile += ".txt";
				// next
			} else {
				System.out.println("No line typed!");
				theView.displayErrorMessage("Please type the name of file!");
			}
		}
		
	}
	
	// SAVE TO DEFAULT DB CLASS
	class SaveToDDBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("DEF");
			
		}
		
	}
	
}
