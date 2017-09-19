package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SaveDataWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	// attributes
	private JPanel panel;
	private JButton saveToDefaultDB;
	private JButton saveToSelectedDB;
	private JTextField nameOfFile;
	private JLabel label;
	
	// constructor
	public SaveDataWindow() {
		this.setSize(200,200);
		
		// gets dimensions of the screen 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int xPos = (dimension.width/2) - (this.getWidth()/2);
		int yPos = (dimension.height/2) - (this.getHeight()/2);
		this.setLocation(xPos+50, yPos+50);
		
		// add panels and components
		panel = new JPanel();
		saveToDefaultDB = new JButton("Save to Default DataBase");
		saveToSelectedDB = new JButton("Save to Selected DataBase");
		nameOfFile = new JTextField();
		label = new JLabel("Enter the name of DB:");
		
		
		panel.setLayout(new GridLayout(4,1));
		panel.add(label);
		panel.add(nameOfFile);
		panel.add(saveToSelectedDB);
		panel.add(saveToDefaultDB);
		
		this.add(panel);
		this.setResizable(false);
		this.setTitle("Load Data");
	}
	
	// methods
	public void addSTDListener(ActionListener listenerForSTDButton) {
		saveToDefaultDB.addActionListener(listenerForSTDButton);
	}
	
	public void addSTSListener(ActionListener listenerForSTSButton) {
		saveToSelectedDB.addActionListener(listenerForSTSButton);
	}
	
	public String getNameOfFile() {
		return nameOfFile.getText();
	}
	
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}

}
