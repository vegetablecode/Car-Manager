package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;

public class AddNewCarWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// attributes
	private JPanel panel;
	private JTextField name;
	private JTextField topSpeed;
	private JTextField year;
	private JTextField fuelConsumption;
	private JButton okButton;
	private JButton cancelButton;

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
		panel = new JPanel();
		name = new JTextField();
		topSpeed = new JTextField();
		year = new JTextField();
		fuelConsumption = new JTextField();
		okButton = new JButton("Add");
		cancelButton = new JButton("Cancel");
		
		panel.setLayout(new GridLayout(5,1));
		panel.add(new JLabel("Name:"));
		panel.add(name);
		panel.add(new JLabel("Top speed:"));
		panel.add(topSpeed);
		panel.add(new JLabel("Year of production:"));
		panel.add(year);
		panel.add(new JLabel("Fuel Consumption:"));
		panel.add(fuelConsumption);
		panel.add(okButton);
		panel.add(cancelButton);
		
		this.add(panel);
		
		this.setResizable(false);
		this.setTitle("Add new car");
		this.setVisible(true);
	}
	
}
