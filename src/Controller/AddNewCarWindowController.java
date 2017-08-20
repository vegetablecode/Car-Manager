package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.AddNewCarWindow;

public class AddNewCarWindowController {

	// attributes
	private AddNewCarWindow theView;
	
	// constructor
	public AddNewCarWindowController(AddNewCarWindow theView) {
		this.theView = theView;
		
		this.theView.addOkButtonListener(new okButtonListener());
	}
	
	class okButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			System.out.print("Button Clicked");
		}
		
	}
}
