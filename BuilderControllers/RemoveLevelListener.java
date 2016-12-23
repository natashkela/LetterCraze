package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BuilderGUI.BuilderApp;
import Common.Builder;


/**
 * 
 * Controller For Removing Level
 * @author macbookair
 *
 */
public class RemoveLevelListener implements ActionListener {
	/**
	 * Top level boundary class for builder 
	 */
    public BuilderApp builderApp;
	/**
	 * Contains info on saved levels for builder
	 */
	public Builder builder;
	/**
	 *  The level index. 
	 */        
    int levelIndex;

	/**
	 * Constructor for RemoveLevelListener.
	 * @param builder	  Contains info on saved levels for builder
	 * @param builderApp  Top level boundary class for builder
	 * @param levelIndex  Index of the level to be removed
	 */ 
    public RemoveLevelListener(BuilderApp builderApp, Builder builder, int levelIndex) {
        this.builderApp = builderApp;
        this.builder = builder;
        this.levelIndex = levelIndex;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		builder.getLevels().remove(levelIndex);
		builderApp.getSavedLevels().replacePanel();
	}

}