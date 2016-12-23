package PlayerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Common.Level;
import Common.Lightning;
import Common.Model;
import Common.Puzzle;
import Common.Theme;
import PlayerGUI.LevelFrame;
import PlayerGUI.PlayerApp;

public class CustomLevelsListener implements ActionListener {

	PlayerApp playerApp;
	Model model;
	
	public CustomLevelsListener(PlayerApp playerApp, Model model) {
		this.playerApp = playerApp;
		this.model = model;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < model.getCustomLevels().size(); i++) {
			LevelFrame levelFrame = playerApp.getCustomLevel().get(i);
			Level level = levelFrame.getLevel();
			level.resetLevel();
			if (level.getLevelType().equals("Puzzle")) {
				Puzzle puzzle = (Puzzle)level;
				levelFrame.resetPTLA(puzzle.getMaxWord());
			}
			else if (level.getLevelType().equals("Lightning")) {
				levelFrame.resetPTLA(((Lightning)level).getTime());
			}
			else if (level.getLevelType().equals("Theme")) {
				Theme theme = (Theme)level;
				levelFrame.resetPTLA(theme.getThemeWords().size());
			}
		}

		playerApp.getViewCustomLevels().replacePanel();	
		playerApp.setContentPane(playerApp.getViewCustomLevels());  
		
		LevelFrame customLevel;
		for (int i = 0; i < playerApp.getCustomLevel().size(); i++) {
			customLevel = playerApp.getCustomLevel().get(i);
			customLevel.unselect();
			customLevel.clearList();
		}
	}
	
	

}
