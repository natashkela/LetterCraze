package PlayerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Common.Level;
import Common.Move;
import PlayerGUI.LevelFrame;
import PlayerGUI.PlayerApp;

public class UndoListener implements ActionListener{
	//JavaDocs!
	PlayerApp playerApp;
	LevelFrame levelFrame;
	Level level;

	//JavaDocs!
	public UndoListener(PlayerApp playerApp, LevelFrame levelFrame, Level level) {
		this.playerApp = playerApp;
		this.level = level;
		this.levelFrame = levelFrame;
	}	

	public void actionPerformed(ActionEvent ae) {
		if (level.getMovesMadeSize()>0) {
			Move move = level.retMoves();
			boolean undo = move.undo();
			if (undo) {
				levelFrame.getList().removeElementAt(level.getFoundWords().size());
				if (level.getLevelType().equals("Lightning")) {
					levelFrame.replacePanel(level);
				}

				else if (levelFrame.getLevel().equals("Puzzle")) {
					levelFrame.increasePTLA();
					levelFrame.replacePanel(level);
				}
				
				else if (level.getLevelType().equals("Theme")) {
					levelFrame.increasePTLA();
					levelFrame.replacePanel(level);
				}
			}
		}
	}
}
