package BuilderControllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Common.*;
import BuilderGUI.BuilderApp;

/**
 * 
 * Controller for all mouse actions in saved levels
 * @author macbookair
 *
 */

public class LevelListener implements ActionListener {
	/**
	 *  Top level boundary class for builder 
	 */
    BuilderApp builderApp;
	/**
	 * Contains info on saved levels for builder
	 */
	Builder builder;
	
	/**
	 * Button in saved levels 
	 */    
    JButton button;
	/**
	 * combo box containing level type options 
	 */    
    JTextField levelTypes;
	/**
	 * Index of selected level 
	 */        
    int levelIndex;
    /**
     * Checks to see if user is making theme level 
     */
    boolean isMakingTheme;
    /**
     * Checks to see if user is editing theme level 
     */
    boolean isEditingTheme;

	/**
	 * Constructs functionality for Level button.
	 * @param builderApp	  Top level boundary class for builder
	 * @param builder		  Contains info on saved levels for builder
   	 * @param levelIndex	  Index of the selected level
	 * @param levelTypes	  Combo box containing level type options
	 * @param JButton button  Button in saved levels	 	
	 */
    public LevelListener(BuilderApp builderApp, Builder builder, JButton button, JTextField levelTypes, int levelIndex) {
        this.builderApp = builderApp;
    	this.builder = builder;
        this.button = button;
        this.levelTypes = levelTypes;
        this.levelIndex = levelIndex;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (button.getBackground().equals(Color.WHITE)) {
			button.setBackground(null);
			levelTypes.setVisible(false);
			button.setSize(60, 60);
		}
		
		else {
			if(levelIndex==-1){
				isMakingTheme = builderApp.getMakeNewLevel().getLevelType().equals("Theme");
			}
			else{
				isEditingTheme = builderApp.getEditLevels().get(levelIndex).getLevelType().equals("Theme");
			}
			
			button.setBackground(Color.WHITE);
			
			if (isMakingTheme) {
				button.setSize(60, 30);
				levelTypes.setVisible(true);
			}
			else if (isEditingTheme) {
				button.setSize(60, 30);
				levelTypes.setVisible(true);
			}
			else {
				button.setSize(60, 60);
			}
		}
	}

}
