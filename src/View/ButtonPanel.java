package View;

import java.awt.*;
import javax.swing.*;

public class ButtonPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	// attributes
	private JLabel title;
	private JButton button1;
	private JButton button2;
	
	// constructor
	public ButtonPanel() {
		title = new JLabel("Button menu");
		button1 = new JButton("one");
		button2 = new JButton("two");
		
		setPreferredSize(new Dimension(600, 400));
		setLayout(new GridLayout(3,1));
		
		this.add(title);
		this.add(button1);
		this.add(button2);
	}

}
