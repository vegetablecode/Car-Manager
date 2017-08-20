package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	// attributes
	private JLabel testLabel;
	
	// constructor
	public MainPanel() {
		testLabel = new JLabel("Main Panel goes here");
		
		setPreferredSize(new Dimension(400, 400));
		
		setLayout(new GridLayout(3,1));
		this.add(testLabel);
	}
	
}
