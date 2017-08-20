package View;

import Controller.AddNewCarWindowController;

public class Test {
	
	public static void main(String args[]) {
		new Window();
		AddNewCarWindow ancWindow = new AddNewCarWindow();
		AddNewCarWindowController ancController = new AddNewCarWindowController(ancWindow);
	}
	
}
