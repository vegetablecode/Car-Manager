package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import Model.CarBase;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	
	// attributes: panels
	private JPanel mainPanel;
	private JPanel buttonPanel;
	
	// attributes: panels: mainPanel
	private Border mainBorder;
	private JTextArea listOfCars;
	private DefaultTableModel model;
	private JTable carList;
	private JScrollPane scrollPane;
	//private String[] columnNames = {"Name", "Top Speed", "Year of Production", "Fuel Consumption"}; 
	
	String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};
	Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	
	// attributes: panels: buttonPanel
	private Border buttonBorder;
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
		this.setLayout(new GridLayout(1,2));
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		
		// set components: mainPanel
		//mainPanel.setPreferredSize(new Dimension(400, 400));
		//mainPanel.setLayout(new GridLayout(1,1));
		
		// ----------TEMP--------------------------------
		
		model = new DefaultTableModel(data, columnNames);
		carList = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public Class<? extends Object> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		
		carList.setPreferredScrollableViewportSize(carList.getPreferredSize());
		carList.setFillsViewportHeight(true);
		carList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		scrollPane = new JScrollPane(carList);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mainPanel.add(scrollPane);
		
		//----------END----------------------------------
		
		mainBorder = BorderFactory.createTitledBorder("List Of Cars");
		
		listOfCars = new JTextArea(15,20);
		listOfCars.setLineWrap(true);
		listOfCars.setWrapStyleWord(true);
		
		mainPanel.setBorder(mainBorder);
		//mainPanel.add(listOfCars);
		
		// set components: buttonPanel
		buttonPanel.setPreferredSize(new Dimension(700, 400));
		buttonPanel.setLayout(new GridLayout(3,1));
		
		buttonBorder = BorderFactory.createTitledBorder("Main menu:");
		
		addNewCar = new JButton("Add new car");
		deleteCar = new JButton("Delete car");
		editCar = new JButton("Edit car");
		
		buttonPanel.setBorder(buttonBorder);
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
	
	public void updateMainPanel(CarBase cars) {
		for(int i=0; i<cars.getNumbOfCars(); i++) {
			listOfCars.append(cars.getCar(i).getName() + " | " + cars.getCar(i).getTopSpeed() + " | "  + cars.getCar(i).getYear() + " | " + cars.getCar(i).getFuelConsumption() + "\n");
		}
	}
	
}
