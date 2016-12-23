package PlayerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Common.Level;
import Common.Puzzle;
import Common.Theme;
import PlayerGUI.LevelFrame;

public class ResetListener implements ActionListener {

	LevelFrame lFrame;
	Level level;

	public void actionPerformed(ActionEvent a) {

		level.getCurrent().setPoints(0);
		level.getCurrent().setStars(0);
		level.getBest().setPoints(level.getBest().getPoints());
		level.getBest().setStars(level.getBest().getStars());

		if (!level.getLevelType().equals("Theme")) {
			level.getBoard().resetBoard();
		} else {
			Theme themeLevel = (Theme)(level);
			level.getBoard().resetThemeBoard(themeLevel.getInitialBoard());
		}
		lFrame.clearList();
		level.getFoundWords().clear();
		level.getCurrent().setPoints(0);
		level.getCurrent().setStars(0);
		
		if (level.getLevelType().equals("Puzzle")) {
			Puzzle puzzle = (Puzzle)(level);
			lFrame.resetPTLA(puzzle.getMaxWord());
			lFrame.replacePanel(level);
		}
		else if (level.getLevelType().equals("Lightning")) {
			lFrame.replacePanel(level);
		}
		else if (level.getLevelType().equals("Theme")) {
			Theme theme = (Theme)(level);
			lFrame.resetPTLA(theme.getThemeWords().size()); 
			lFrame.replacePanel(level);

		}
	}

	public ResetListener(LevelFrame lf, Level l) {
		this.lFrame = lf;
		this.level = l;
	}
}