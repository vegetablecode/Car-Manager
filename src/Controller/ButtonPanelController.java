package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CarBase;
import View.ButtonPanel;

public class ButtonPanelController {
	
	// attributes
	private CarBase theModel;
	private ButtonPanel theView;
	
	// constructor
	public ButtonPanelController(CarBase theModel, ButtonPanel theView) {
		this.theModel = theModel;
		this.theView = theView;
		
		theView.addANCListener(new ANCButtonListener());
		theView.addDCListener(new DCButtonListener());
		theView.addECListener(new ECButtonListener());
	}
	
	// ANC CLASS
	class ANCButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			System.out.println("ANC Button Clicked");
			
		}
		
	}
	
	// DC CLASS
	class DCButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			System.out.println("DC Button Clicked");
			
		}
		
	}
	
	// EC CLASS
	class ECButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			System.out.println("ANC Button Clicked");
			
		}
		
	}

}
