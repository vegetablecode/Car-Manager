package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private JPanel settingsPanel;
	
	// attributes: panels: mainPanel <- LEFT HALF
	private Border mainBorder;
	private DefaultTableModel model;
	private JTable carList;
	private JScrollPane scrollPane;
	private String[] columnNames = {"ID", "Name", "Top Speed", "Year of Production", "Fuel Consumption"}; 
	Object[][] data;
	
	// attributes: panels: userPanel <- RIGHT HALF
	private JPanel userPanel;
	private JPanel uPTop, uPBottom;
	
	// attributes: panels: buttonPanel <- MAIN SETTINGS
	private Border buttonBorder;
	private JButton addNewCar;
	private JButton deleteCar;
	private JButton editCar;
	
	// attributes: panels: settingsPanel <- MAIN MENU
	private Border settingsBorder;
	private JButton saveData;
	private JButton loadData;
	
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
		//this.setLayout(new GridLayout(1,2));
		this.setLayout(new FlowLayout());
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		settingsPanel = new JPanel();
		userPanel = new JPanel();
		uPTop = new JPanel();
		uPBottom = new JPanel();
		
		// set components: mainPanel
		mainPanel.setPreferredSize(new Dimension(500, 370));
		mainPanel.setLayout(new GridLayout(1,1));
		
			// ----- JTable settings BEGIN
		
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
		
		carList.getColumnModel().getColumn(0).setPreferredWidth(30);
		carList.getColumnModel().getColumn(1).setPreferredWidth(110);
		carList.getColumnModel().getColumn(2).setPreferredWidth(100);
		carList.getColumnModel().getColumn(3).setPreferredWidth(110);
		carList.getColumnModel().getColumn(4).setPreferredWidth(110);
		
			// ----- JTable settings END
		
		mainBorder = BorderFactory.createTitledBorder("List Of Cars");
		mainPanel.setBorder(mainBorder);
		
		// ----- set components: buttonPanel BEGIN
		buttonPanel.setLayout(new GridLayout(3,1));
		buttonBorder = BorderFactory.createTitledBorder("Main menu:");
		
		addNewCar = new JButton("Add new car");
		deleteCar = new JButton("Delete car");
		editCar = new JButton("Edit car");
		
		buttonPanel.setBorder(buttonBorder);
		buttonPanel.add(addNewCar);
		buttonPanel.add(deleteCar);
		buttonPanel.add(editCar);
		// ----- set components: buttonPanel END
		
		// ----- set components: settingsPanel BEGIN
		settingsPanel.setLayout(new GridLayout(3,1));
		settingsBorder = BorderFactory.createTitledBorder("Main settings");
		
		loadData = new JButton("Load Data");
		saveData = new JButton("Save Data");
		
		settingsPanel.add(saveData);
		settingsPanel.add(loadData);
		settingsPanel.setBorder(settingsBorder);
		// ----- set components: settingsPanel END
		
		// set components: userPanel
		
		uPTop.add(buttonPanel);
		uPTop.add(settingsPanel);
		
		userPanel.setLayout(new GridLayout(2,1));
		//userPanel.setPreferredSize(new Dimension(100, 400));
		userPanel.add(uPTop);
		userPanel.add(uPBottom);
		
		// set the window
		this.add(mainPanel);
		this.add(userPanel);
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
	
	public void addSDListener(ActionListener listenerForSDButton) {
		saveData.addActionListener(listenerForSDButton);
	}
	
	public void addLDListener(ActionListener listenerForLDButton) {
		loadData.addActionListener(listenerForLDButton);
	}
	
	public void updateMainPanel(CarBase cars) {
		for(int i=model.getRowCount()-1; i>=0; i--) {
			model.removeRow(i);
		}
		for(int i=0; i<cars.getNumbOfCars(); i++) {
			model.addRow(new Object[] {i, cars.getCar(i).getName(), cars.getCar(i).getTopSpeed(), cars.getCar(i).getYear(), cars.getCar(i).getFuelConsumption()});
		}
	}
	
	public int getSelectedCarID() {
		return carList.getSelectedRow();
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
	
}
