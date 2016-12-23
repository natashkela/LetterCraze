package PlayerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Common.Level;
import Common.Move;
import Common.Puzzle;
import Common.Theme;
import Common.Word;
import PlayerGUI.CustomLevel;
import PlayerGUI.LevelFrame;
import PlayerGUI.PlayerApp;

public class SubmitWordListener implements ActionListener {
	PlayerApp playerApp;
	LevelFrame lFrame;
	public Level level;
	public JPanel exitView; //2dname

	
	public void actionPerformed(ActionEvent e) {
		Word potentialWord = level.getBoard().getWord();
		if (potentialWord.isValid()) {
			Move move = new Move(potentialWord, level);
			move.doMove();
			level.MovePush(move);
			level.getFoundWords().addElement(potentialWord.toString());
			if (level.getLevelType().equals("Puzzle")) {
				lFrame.addToPTLA(-1);
				int currentPTLA = lFrame.getPTLA();
				if (currentPTLA == 0) {
					JOptionPane.showConfirmDialog(null, "No More moves Left!", "No More Moves", JOptionPane.DEFAULT_OPTION);
					level.resetLevel();
					Puzzle playingLevel = (Puzzle)(level);
					playingLevel.resetValidWords();
					lFrame.resetPTLA(playingLevel.getMaxWord());
					lFrame.clearList();
					((CustomLevel)exitView).replacePanel();
					playerApp.setContentPane(exitView);
				}
			}

			if (level.getLevelType().equals("Theme")) {
				lFrame.addToPTLA(-1);
				int currentPTLA = lFrame.getPTLA();
				if (currentPTLA == 0) {
					JOptionPane.showConfirmDialog(null, "Good Job! You guessed all the words", "Perfect", JOptionPane.DEFAULT_OPTION);
					level.resetLevel();
					Theme playingLevel = (Theme)level;
					lFrame.resetPTLA(playingLevel.getThemeWords().size());
					lFrame.clearList();
					((CustomLevel)exitView).replacePanel();
					playerApp.setContentPane(exitView);
				}
			}

		}

		lFrame.replacePanel(level);
	}

	public SubmitWordListener(PlayerApp playerApp, JPanel nextView, LevelFrame levelframe, Level level) {
		this.playerApp = playerApp;
		this.exitView = nextView;
		this.lFrame = levelframe;
		this.level = level;
	}

}
