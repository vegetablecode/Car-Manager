package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class loadDataWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	// attributes
	private JPanel panel;
	
	// constructor
	public loadDataWindow() {
		this.setSize(400,250);
		
		// gets dimensions of the screen 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int xPos = (dimension.width/2) - (this.getWidth()/2);
		int yPos = (dimension.height/2) - (this.getHeight()/2);
		this.setLocation(xPos+50, yPos+50);
		
		// add panels
		panel = new JPanel();
	}
	
}
