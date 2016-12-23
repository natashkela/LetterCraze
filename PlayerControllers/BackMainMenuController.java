package PlayerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Common.Model;
import PlayerGUI.PlayerApp;

public class BackMainMenuController implements ActionListener{
	
	PlayerApp playerApp;
	/** Player Level information. */
	Model model;
	
	/**
	 * Switch to the custom level views
	 * 
	 * @param e ActionEvent
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		playerApp.setContentPane(playerApp.getViewCustomLevels());
	}
	
	/**
	 * Sets parameters for BackMainMenuController.
	 * 
	 * @param playerApp Application
	 * @param m model
	 */
	
	public BackMainMenuController(PlayerApp playerApp, Model m) {
		this.playerApp = playerApp;
		this.model = m;
	}
}
