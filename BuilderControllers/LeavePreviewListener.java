package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BuilderGUI.BuilderApp;
import Common.Builder;

/**
 * Controller for Going Back from Preview
 */

public class LeavePreviewListener implements ActionListener {
	/**
	 * Top level boundary class for builder
	 */
    public BuilderApp builderApp;
	/**
	 * Contains info on saved levels for builder
	 */
	public Builder builder;
	/**
	 * The level index. 
	 */        
    int levelIndex;
    
    /**
   	 * Constructor for LeavePreviewListener.
   	 * @param builderApp  Top level boundary class for builder
   	 * @param builder	  Contains info on saved levels for builder
   	 * @param levelIndex index of the level to be removed
   	 */ 
	
	public LeavePreviewListener(BuilderApp builderApp, Builder builder, int levelIndex) {
		this.builderApp = builderApp;
		this.builder = builder;
		this.levelIndex = levelIndex;
	}

	
	public void actionPerformed(ActionEvent e) {
		if (levelIndex==-1) {
			builderApp.setContentPane(builderApp.getMakeNewLevel());
		}
		else {
			builderApp.setContentPane(builderApp.getEditLevels().get(levelIndex));
		}	
	}

}
