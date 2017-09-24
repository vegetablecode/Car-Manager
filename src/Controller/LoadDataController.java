package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.CarBase;
import Utils.FileOpener;
import View.LoadDataWindow;
import View.Window;

public class LoadDataController {

	// attributes
	private Window theWindow;
	private CarBase model;
	private LoadDataWindow theView;
	private FileOpener fileOpener;
	
	// constructor
	public LoadDataController(Window theWindow, CarBase model, LoadDataWindow theView) {
		this.theWindow = theWindow;
		this.model = model;
		this.theView = theView;
		
		fileOpener = new FileOpener(model);
		
		theView.addLFDListener(new LoadFromDDBListener());
		theView.addLFSListener(new LoadFromSDBListener());
	}
	
	// LOAD FROM SELECTED DB CLASS
	class LoadFromSDBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooseFile = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text DB Files (*.csv)", "csv");
			
			chooseFile.setFileFilter(filter);
			chooseFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooseFile.setCurrentDirectory(new java.io.File("./database"));
			chooseFile.setAcceptAllFileFilterUsed(false);
			chooseFile.setDialogTitle("Pick the DataBase");
			
			int returnVal = chooseFile.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    		String nameOfFile = "./database/";
		    	    nameOfFile += chooseFile.getSelectedFile().getName();
		    	    fileOpener.loadDatabase(nameOfFile);
		    }
			theWindow.updateMainPanel(model);
		}
		
	}
	
	// LOAD FROM DEFAULT DB CLASS
	class LoadFromDDBListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("DEF");
		}
		
	}
	
}
