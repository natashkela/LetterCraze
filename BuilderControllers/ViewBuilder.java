package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BuilderGUI.BuilderApp;
import Common.Builder;

/**
 * Controller class for the top level boundary class in builder 
 */
public class ViewBuilder implements ActionListener{
	/**
	 * Contains info on saved levels for builder
	 */
	Builder builder;
	/**
	 *  Top level boundary class for builder 
	 */
    BuilderApp builderApp;

	
	/** 
	 * constructor for ViewBuilder.
	 * 
	 * @param builder		  Contains info on saved levels for builder
   	 * @param builderApp	  Top level boundary class for builder
	 */
	public ViewBuilder(BuilderApp builderApp, Builder builder) {
		this.builderApp = builderApp;
		this.builder = builder;
	}
	    

	@Override
	public void actionPerformed(ActionEvent e) {
		builderApp.setContentPane(builderApp.getStartBuilder());
	}
}
