package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CarBase;
import View.LoadDataWindow;
import View.Window;

public class LoadDataController {

	// attributes
	private Window theWindow;
	private CarBase model;
	private LoadDataWindow theView;
	
	// constructor
	public LoadDataController(Window theWindow, CarBase model, LoadDataWindow theView) {
		this.theWindow = theWindow;
		this.model = model;
		this.theView = theView;
		
		theView.addLFDListener(new LoadFromDDBListener());
		theView.addLFSListener(new LoadFromSDBListener());
	}
	
	// LOAD FROM SELECTED DB CLASS
	class LoadFromSDBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("SEL");
		}
		
	}
	
	// LOAD FROM DEFAULT DB CLASS
	class LoadFromDDBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("DEF");
		}
		
	}
	
}
