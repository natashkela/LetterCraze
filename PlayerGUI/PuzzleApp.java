package PlayerGUI;

import javax.swing.JButton;

import Common.Puzzle;

public class PuzzleApp extends LevelFrame{
	
	//JavaDocs
	public PuzzleApp(Puzzle level) {
		super(level);
		title.setText("Puzzle");
		puzzleThemeLightning.setText("Moves Left: ");
		puzzleThemeLightningAttribute.setText(String.valueOf(level.getMovesMadeSize()));
	}
	
	//JavaDocs
	public JButton getGoBack() {
		return goBack;
	}
	
	//JavaDocs
	public JButton[][] getButtonList() {
		return tiles;
	}
}
