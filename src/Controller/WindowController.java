package Controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CarBase;

public class WindowController {
	
	// attributes
	private CarBase theModel;
	private Window theView;
	
	// constructor
	public WindowController(CarBase theModel, Window theView) {
		this.theModel = theModel;
		this.theView = theView;
		
		//theView.kek();
		
		//theView.addANCListener(new ANCButtonListener());
		//theView.addDCListener(new DCButtonListener());
		//theView.addECListener(new ECButtonListener());
		
		theView.setVisible(true);
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
