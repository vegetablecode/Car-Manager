package Controller;

import java.awt.Window;

import Model.CarBase;

public class WindowController {
	
	// attributes
	private CarBase theModel;
	private Window theView;
	
	// constructor
	public WindowController(CarBase theModel, Window theView) {
		this.theModel = theModel;
		this.theView = theView;
		
		
		
		theView.setVisible(true);
	}

}
