package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BuilderGUI.BuilderApp;
import Common.Builder;

/**
 * Controller class for any level in edit mode 
 */
public class ViewEditLevelListener implements ActionListener{
	/**
	 * Contains info on saved levels for builder
	 */
	Builder builder;
	/**
	 *  Top level boundary class for builder 
	 */
    BuilderApp builderApp;
	/**
	 * Index of selected level 
	 */        
    int levelIndex;


	/** 
	 * Constructor for ViewEditLevelListener.
	 * 
	 * @param builder		  Contains info on saved levels for builder
   	 * @param builderApp	  Top level boundary class for builder
   	 * @param levelIndex	  Index of the selected level
	 */
	public ViewEditLevelListener(BuilderApp builderApp, Builder builder, int levelIndex) {
		this.builderApp = builderApp;
		this.builder = builder;
		this.levelIndex = levelIndex;
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if (levelIndex<builder.getLevels().size()) {
			builderApp.getEditLevels().get(levelIndex).resetPanel();
			builderApp.setContentPane(builderApp.getEditLevels().get(levelIndex));
		}
	}
}
