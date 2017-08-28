package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// attributes: panels
	private JPanel mainPanel;
	private JPanel buttonPanel;
	
	// attributes: panels: mainPanel
	private JLabel testLabel;
	
	// attributes: panels: buttonPanel
	private JLabel title;
	private JButton addNewCar;
	private JButton deleteCar;
	private JButton editCar;
	
	// constructor
	public Window() {
		this.setSize(800,400);
		
		// get dimensions of the screen 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int xPos = (dimension.width/2) - (this.getWidth()/2);
		int yPos = (dimension.height/2) - (this.getHeight()/2);
		this.setLocation(xPos, yPos);
		
		// add panels
		setLayout(new GridLayout(1,2));
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		
		// set components: mainPanel
		mainPanel.setPreferredSize(new Dimension(400, 400));
		mainPanel.setLayout(new GridLayout(3,1));
		
		testLabel = new JLabel("Main Panel goes here");
		
		mainPanel.add(testLabel);
		
		// set components: buttonPanel
		buttonPanel.setPreferredSize(new Dimension(700, 400));
		buttonPanel.setLayout(new GridLayout(4,1));
		
		title = new JLabel("Button menu");
		addNewCar = new JButton("Add new car");
		deleteCar = new JButton("Delete car");
		editCar = new JButton("Edit car");
		
		buttonPanel.add(title);
		buttonPanel.add(addNewCar);
		buttonPanel.add(deleteCar);
		buttonPanel.add(editCar);
		
		// set the window
		this.add(mainPanel);
		this.add(buttonPanel);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("CarManager");

	}
	
	// methods
	public void addANCListener(ActionListener listenerForANCButton) {
		addNewCar.addActionListener(listenerForANCButton);
	}
	
	public void addDCListener(ActionListener listenerForDCButton) {
		deleteCar.addActionListener(listenerForDCButton);
	}
	
	public void addECListener(ActionListener listenerForECBButton) {
		editCar.addActionListener(listenerForECBButton);
	}
	
	public void kek() {
		System.out.println("SIEMSON");
	}
	
}
