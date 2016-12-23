package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BuilderGUI.BuilderApp;
import Common.Builder;

/**
 * Controller class for viewing the MakeNewLevel boundary class 
 */
public class ViewNewLevelListener implements ActionListener{
	/**
	 * Contains info on saved levels for builder
	 */
	Builder builder;
	/**
	 *  Top level boundary class for builder 
	 */
    BuilderApp builderApp;
	
	/** 
	 * Constructor for MakeNewLevelController.
	 * @param builder		  Contains info on saved levels for builder
   	 * @param builderApp	  Top level boundary class for builder
	 */
	public ViewNewLevelListener(BuilderApp builderApp, Builder builder) {
		this.builderApp =builderApp;
		this.builder = builder;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		builderApp.getMakeNewLevel().resetLevelInfoPanel();
		builderApp.setContentPane(builderApp.getMakeNewLevel());
	}
}
