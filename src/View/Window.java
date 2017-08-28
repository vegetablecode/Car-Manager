package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// constructor
	public Window() {
		this.setSize(800,400);
		
		// gets dimensions of the screen 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int xPos = (dimension.width/2) - (this.getWidth()/2);
		int yPos = (dimension.height/2) - (this.getHeight()/2);
		this.setLocation(xPos, yPos);
		
		// adds panels
		setLayout(new GridLayout(1,2));
		this.add(new MainPanel());
		this.add(new ButtonPanel());
		
		// sets the window
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("CarManager");
		
		//new AddNewCarWindow();
	}
	
}
