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
	private JPanel menuPanel;
	private JPanel buttonPanel;
	private JPanel settingsPanel;
	
	// attributes: panels: mainPanel
	private Border mainBorder;
	private DefaultTableModel model;
	private JTable carList;
	private JScrollPane scrollPane;
	private String[] columnNames = {"ID", "Name", "Top Speed", "Year of Production", "Fuel Consumption"}; 
	
	Object[][] data;
	
	// attributes: panels: buttonPanel
	private Border buttonBorder;
	private JButton addNewCar;
	private JButton deleteCar;
	private JButton editCar;
	
	// attributes: panels: settingsPanel
	private Border settingsBorder;
	private JButton saveData;
	private JButton loadData;
	
	// constructor
	public Window() {
		this.setSize(850,400);
		
		// get dimensions of the screen 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int xPos = (dimension.width/2) - (this.getWidth()/2);
		int yPos = (dimension.height/2) - (this.getHeight()/2);
		this.setLocation(xPos, yPos);
		
		// add panels
		this.setLayout(new GridLayout(1,2));
		mainPanel = new JPanel();
		menuPanel = new JPanel();
		buttonPanel = new JPanel();
		settingsPanel = new JPanel();
		
		// set components: mainPanel
		mainPanel.setPreferredSize(new Dimension(450, 400));
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
		carList.getColumnModel().getColumn(1).setPreferredWidth(75);
		carList.getColumnModel().getColumn(2).setPreferredWidth(70);
		carList.getColumnModel().getColumn(3).setPreferredWidth(110);
		carList.getColumnModel().getColumn(4).setPreferredWidth(110);
		
			// ----- JTable settings END
		
		mainBorder = BorderFactory.createTitledBorder("List Of Cars");
		mainPanel.setBorder(mainBorder);
		
		// set components: menuPanel
		menuPanel.setPreferredSize(new Dimension(700, 400));
		menuPanel.setLayout(new GridLayout(2,1));
		
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
		menuPanel.add(buttonPanel);
		// ----- set components: buttonPanel END
		
		// ----- set components: settingsPanel BEGIN
		settingsPanel.setLayout(new GridLayout(3,1));
		settingsBorder = BorderFactory.createTitledBorder("Main settings");
		
		loadData = new JButton("Load Data");
		saveData = new JButton("Save Data");
		
		settingsPanel.add(saveData);
		settingsPanel.add(loadData);
		settingsPanel.setBorder(settingsBorder);
		menuPanel.add(settingsPanel);
		// ----- set components: settingsPanel END
		
		// set the window
		this.add(mainPanel);
		this.add(menuPanel);
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
