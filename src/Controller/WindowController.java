package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CarBase;
import View.AddNewCarWindow;
import View.Window;

public class WindowController {
	
	// attributes
	private CarBase theModel;
	private Window theView;
	
	// anc
	private AddNewCarWindow ancWindow;
	private AddNewCarWindowController ancController;
	
	// constructor
	public WindowController(CarBase theModel, Window theView) {
		this.theModel = theModel;
		this.theView = theView;
		
		theView.addANCListener(new ANCButtonListener());
		theView.addDCListener(new DCButtonListener());
		theView.addECListener(new ECButtonListener());
		
		theView.setVisible(true);
		
		// anc
		ancWindow = new AddNewCarWindow();
		ancController = new AddNewCarWindowController(theView, ancWindow, theModel);
	}
	
	// ANC CLASS
	class ANCButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			ancWindow.setVisible(true);
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
