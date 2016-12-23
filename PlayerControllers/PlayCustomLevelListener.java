package PlayerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Common.Level;
import Common.Lightning;
import Common.Model;
import Common.Puzzle;
import Common.Theme;
import PlayerGUI.LightningApp;
import PlayerGUI.PlayerApp;
import PlayerGUI.ThemeApp;

public class PlayCustomLevelListener implements ActionListener {
	
	PlayerApp playerApp;
	Model model;
	int levelIndex;

	@Override
	public void actionPerformed(ActionEvent e) {
		Level level = model.getCustomLevels().get(levelIndex);
		if (level.getUnlocked()) {
			level.loadLevel();
			if (level.getLevelType().equals("Puzzle")) {
				playerApp.getCustomLevel().get(levelIndex).replacePanel((Puzzle)level);
				playerApp.setContentPane(playerApp.getCustomLevel().get(levelIndex));
			}
			else if (level.getLevelType().equals("Lightning")) {
				LightningApp lApp = (LightningApp)playerApp.getCustomLevel().get(levelIndex);
				lApp.replacePanel((Lightning)level);
				lApp.startRemainingTime();
				lApp.getTimer().start();
				playerApp.setContentPane(lApp);
			}
			else {
				playerApp.getCustomLevel().get(levelIndex).replacePanel((Theme)level);
				((ThemeApp) playerApp.getCustomLevel().get(levelIndex)).replacePanel((Theme)level);
				playerApp.setContentPane(playerApp.getCustomLevel().get(levelIndex));
			}
		}
	}

	
	public PlayCustomLevelListener(PlayerApp playerApp, Model model, int levelIndex) {
		this.playerApp = playerApp;
		this.model = model;
		this.levelIndex = levelIndex;
	}

}
