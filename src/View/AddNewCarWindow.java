package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;

public class AddNewCarWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	// constructor
	public AddNewCarWindow() {
		this.setSize(400,250);
		
		// gets dimensions of the screen 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int xPos = (dimension.width/2) - (this.getWidth()/2);
		int yPos = (dimension.height/2) - (this.getHeight()/2);
		this.setLocation(xPos+50, yPos+50);
		
		// adds panels
		setLayout(new GridLayout(5,1));
		
		JTextField name = new JTextField();
		JTextField topSpeed = new JTextField();
		JTextField year = new JTextField();
		JTextField fuelConsumption = new JTextField();
		JButton okButton = new JButton("Add");
		JButton cancelButton = new JButton("Cancel");
		
		this.add(new JLabel("Name:"));
		this.add(name);
		this.add(new JLabel("Top speed:"));
		this.add(topSpeed);
		this.add(new JLabel("Year of production:"));
		this.add(year);
		this.add(new JLabel("Fuel Consumption:"));
		this.add(fuelConsumption);
		this.add(okButton);
		this.add(cancelButton);
		
		this.setResizable(false);
		this.setTitle("Add new car");
		this.setVisible(true);
	}
	
}
