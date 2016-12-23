package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import BuilderGUI.BuilderApp;
import Common.Builder;

/**
 * Saves the levels to player
 */
public class FileManager implements ActionListener {
	/**
	 * Top level boundary class for builder. 
	 */
    public BuilderApp builderApp;
	/**
	 * Holds level information for builder 
	 */
    public Builder builder;
	
    /**
     * used for confirmation dialog 
     */
    int select;
    
    /**
	 * Constructor for FileManager
	 * @param builderApp	 Top level boundary class for builder
	 * @param builder   	 Contains a list of saved levels
	 */
	public FileManager(BuilderApp builderApp, Builder builder) {
		this.builder = builder;
		this.builderApp = builderApp;
	}

	public void actionPerformed(ActionEvent e) {
		select = JOptionPane.showConfirmDialog(null, "Add the levels in Puzzle?\n", 
				"Add",JOptionPane.YES_NO_OPTION);
		if (select==JOptionPane.YES_OPTION) {
			try {
				FileOutputStream file = new FileOutputStream("build.ser");
				ObjectOutputStream fl = new ObjectOutputStream(file);
				fl.writeObject(builder.getLevels());
				fl.close();
				file.close();
			}
			catch(IOException i) {
				i.printStackTrace();
			}
		}

	}
}
