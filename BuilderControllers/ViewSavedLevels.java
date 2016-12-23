package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BuilderGUI.BuilderApp;
import Common.Builder;

/**
 * Controller class for actions upon saved levels 
 */

public class ViewSavedLevels implements ActionListener{
	/**
	 * Contains info on saved levels for builder
	 */
	Builder builder;
    /**
	 *  Top level boundary class for builder 
	 */
    BuilderApp builderApp;



	/** 
	 * constructor for ViewSavedLevels.
	 * 
	 * @param builder		  Contains info on saved levels for builder
   	 * @param builderApp	  Top level boundary class for builder
	 */
	public ViewSavedLevels(BuilderApp builderApp, Builder builder) {
		this.builderApp = builderApp;
		this.builder = builder;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		builderApp.getSavedLevels().replacePanel();
		builderApp.setContentPane(builderApp.getSavedLevels());
	}
	
}
