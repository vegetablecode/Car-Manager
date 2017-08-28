package App;

import Controller.WindowController;
import Model.CarBase;
import View.Window;

public class Main {

	public static void main(String args[]) {
		CarBase theModel = new CarBase();
		Window theView = new Window();
		WindowController theController = new WindowController(theModel, theView);
		
		
		//AddNewCarWindow ancWindow = new AddNewCarWindow();
		//AddNewCarWindowController ancController = new AddNewCarWindowController(ancWindow);
	}
	
}
