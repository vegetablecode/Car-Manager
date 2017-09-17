package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.CarBase;
import View.AddNewCarWindow;
import View.Window;
import View.LoadDataWindow;

public class WindowController {
	
	// attributes
	private CarBase theModel;
	private Window theView;
	
	// anc
	private AddNewCarWindow ancWindow;
	private AddNewCarWindowController ancController;
	
	// load and save data
	private LoadDataWindow ldWindow;
	private LoadDataController ldController;
	
	// constructor
	public WindowController(CarBase theModel, Window theView) {
		this.theModel = theModel;
		this.theView = theView;
		
		theView.addANCListener(new ANCButtonListener());
		theView.addDCListener(new DCButtonListener());
		theView.addECListener(new ECButtonListener());
		theView.addSDListener(new SDButtonListener());
		theView.addLDListener(new LDButtonListener());
		
		theView.setVisible(true);
		
		// anc
		ancWindow = new AddNewCarWindow();
		ancController = new AddNewCarWindowController(theView, ancWindow, theModel);
		
		// load and save data
		ldWindow = new LoadDataWindow();
		ldController = new LoadDataController(theView, theModel, ldWindow);
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
			if(theView.getSelectedCarID()!=-1) {
				theModel.removeCar(theView.getSelectedCarID());
				theView.updateMainPanel(theModel);
			}
			else {
				theView.displayErrorMessage("You have to select the Car!");
			}
		}
		
	}
	
	// EC CLASS
	class ECButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			if(theView.getSelectedCarID()!=-1) {
				System.out.println("Editing tools");
			}
			else {
				theView.displayErrorMessage("You have to select the Car!");
			}
			
		}
		
	}
	
	// SD CLASS
	class SDButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("SD");
		}
		
	}
	
	// LD CLASS
	class LDButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			//ldWindow.setVisible(true);
			ldWindow.setVisible(true);
		}
		
	}
	
}
