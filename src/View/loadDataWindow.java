package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadDataWindow extends JFrame{
	private static final long serialVersionUID = 1L;

	// attributes
	private JPanel panel;
	private JButton loadFromDefaultDB;
	private JButton loadFromSelectedDB;
	
	// constructor
	public LoadDataWindow() {
		this.setSize(200,200);
		
		// gets dimensions of the screen 
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dimension = tk.getScreenSize();
		int xPos = (dimension.width/2) - (this.getWidth()/2);
		int yPos = (dimension.height/2) - (this.getHeight()/2);
		this.setLocation(xPos+50, yPos+50);
		
		// add panels and components
		panel = new JPanel();
		loadFromDefaultDB = new JButton("Load From Default DataBase");
		loadFromSelectedDB = new JButton("Load From Selected DataBase");
		
		panel.setLayout(new GridLayout(2,1));
		panel.add(loadFromSelectedDB);
		panel.add(loadFromDefaultDB);
		
		this.add(panel);
		this.setResizable(false);
		this.setTitle("Load Data");
	}
	
	// methods
	public void addLFDListener(ActionListener listenerForLFDButton) {
		loadFromDefaultDB.addActionListener(listenerForLFDButton);
	}
	
	public void addLFSListener(ActionListener listenerForLFSButton) {
		loadFromSelectedDB.addActionListener(listenerForLFSButton);
	}
	
}
