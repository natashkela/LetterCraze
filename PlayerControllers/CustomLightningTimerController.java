package PlayerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Common.Level;
import Common.Model;
import PlayerGUI.LightningApp;
import PlayerGUI.PlayerApp;

public class CustomLightningTimerController implements ActionListener {
	
	PlayerApp playerApp;
	Model model;
	int levelIndex;
	
	
	public CustomLightningTimerController(PlayerApp playerApp, Model model, int levelIndex) {
		this.playerApp = playerApp;
		this.model = model;
		this.levelIndex = levelIndex;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		LightningApp lightningApp = (LightningApp) playerApp.getCustomLevel().get(levelIndex);
		
		if(lightningApp.getRemainingTime() == 0)
        {
			lightningApp.getTimer().stop();
            if (playerApp.getContentPane().equals(lightningApp)) {
				JOptionPane.showConfirmDialog(null, 
						"Time is up!", "No More Time Left",
						JOptionPane.DEFAULT_OPTION);
				
				lightningApp.clearList();
				lightningApp.getLevel().updateBest();
                Level level = model.getCustomLevels().get(levelIndex);
                System.out.println("Score: " + level.getBest().getPoints());
				System.out.println("Stars: " + level.getBest().getStars());
                playerApp.getViewCustomLevels().replacePanel();
            	playerApp.setContentPane(playerApp.getViewCustomLevels());
            }
        }
        else{
           lightningApp.RemainigTime();
           lightningApp.resetPTLA(lightningApp.getRemainingTime());
        }
	}
	
}
