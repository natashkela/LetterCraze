package PlayerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Common.Model;
import PlayerGUI.PlayerApp;

/**
 * Controls length of time Splash screen appears on screen
 * when running the application.
 */

public class SplashTimer implements ActionListener {
	
	PlayerApp playerApp;
	Model model;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(playerApp.getSplashTime() == 0) {
            playerApp.getSplashScreenTimer().stop();
            playerApp.setContentPane(playerApp.getStartPlayer());
        }
        else
        {
            playerApp.decrementSplashTime();
        }
	}

	
	public SplashTimer(PlayerApp playerApp, Model model) {
		this.playerApp = playerApp;
		this.model = model;
	}

}
