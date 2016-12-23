package BuilderControllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Common.Builder;
import Common.Model;
import BuilderGUI.BuilderApp;
import BuilderGUI.SplashScreen;

/**
 * Controller for Splash Timer
 * @author macbookair
 *
 */
public class SplashTimer implements ActionListener {

	/**
	 *  Top level boundary class for builder 
	 */
	BuilderApp builderApp;
	/**
	 * Contains info on saved levels for builder
	 */
	Builder builder;

	/**
	 * Constructor for SplashTimer 
	 * @param builderApp  Top level boundary class for builder
	 * @param builder	  Contains info on saved levels for builder
	 */	
	public SplashTimer(BuilderApp builderApp, Builder builder) {
		this.builderApp = builderApp;
		this.builder = builder;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(builderApp.getTimeForSplash()==0){
			builderApp.getTimer().stop();
			builderApp.setContentPane(builderApp.getStartBuilder());
        }
        else{
        	builderApp.TimeForSplash();
        }
	}
}