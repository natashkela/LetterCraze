package BuilderControllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import BuilderGUI.BuilderApp;
import BuilderGUI.MakeNewLevel;
import Common.Board;
import Common.Builder;
import Common.Coordinates;
import Common.Letter;
import Common.Lightning;
import Common.Puzzle;
import Common.StarThresholds;
import Common.Theme;
import Common.Tile;

/**
 * Controller for Saving
 * @author macbookair
 *
 */
public class SaveListener implements ActionListener{

	/**
	 * Frame of BuilderApp
	 */
	public BuilderApp builderApp;
	
	/**
	 * Builder for info  
	 */
	public Builder builder;
	
	/**
	 * MakeNewLevel for making new level
	 */
	public MakeNewLevel level;
	
	/**
	 * Which level it should be
	 * equals -1 if we are making the level
	 * */
	int levelIndex;


	/**
	 * Constructor for SaveListener
	 * @param builderApp	Frame of BuilderApp
	 * @param builder    	Info for Builder
	 * @param order			Order of the level
	 * @param level			Frame of making new level
	 */
	public SaveListener(BuilderApp builderApp, Builder builder, int levelIndex, MakeNewLevel level) {
		this.builderApp = builderApp;
		this.builder = builder;
		this.levelIndex = levelIndex;
		this.level = level;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i=0;
		Tile[] tiles = new Tile[36];
		for (int row=0; row<6; row++) {
			for (int col=0; col<6; col++) {
				/*
				 * make tile active
				 */
				if (level.getTiles()[col][row].getBackground().equals(Color.WHITE)) {
					if(level.getLevelType().equals("Theme")){
						if(level.getLetters()[col][row].getText().length() != 0){
							if(level.getLetters()[col][row].getText().substring(0, 1).toUpperCase().equals("Q")){
								tiles[i] = new Tile(new Coordinates(row,col), true, 
										new Letter("QU"));
							}
							else {
								tiles[i] = new Tile(new Coordinates(row,col), true, 
										new Letter(level.getLetters()[col][row].getText().substring(0, 1).toUpperCase()));
							}
						}
						else if(level.getLetters()[col][row].getText().length() == 0){
							tiles[i] = new Tile(new Coordinates(row,col), false, 
									new Letter("A"));
						}
					}
					else{
						tiles[i] = new Tile(new Coordinates(row,col), true, 
								new Letter("A"));
					}
				}
				else {
					tiles[i] = new Tile(new Coordinates(row, col), false, 
										new Letter("A"));
				}
				i++;
			}
		}
		
		StarThresholds starThresh = new StarThresholds(level.getStarThresholds()[0], 
														level.getStarThresholds()[1], 
														level.getStarThresholds()[2]);
		
		Board board = new Board(tiles);
		
		//--------------------------------PUZZLE-----------------------------------
		if (level.getLevelType().equals("Puzzle")) {
			
			int maxMoves = (int)level.getMaxMovesSpnr().getValue();
			Puzzle puzzle = new Puzzle(board, starThresh, maxMoves);
			
			if (builder.getLevels().size()<15&&levelIndex==-1) {
				builder.getLevels().add(puzzle);
				
				JOptionPane.showConfirmDialog(null, "Level is put at " + 
				builder.getLevels().size() + ".", "You Got It!", JOptionPane.DEFAULT_OPTION);
			}
			
			/*
			 * Is it editing? Overwrite! 
			 */
			else if (levelIndex>=0&&levelIndex<= 15) {
				
				builder.getLevels().remove(levelIndex);
				builder.getLevels().add(levelIndex, puzzle);
				
				JOptionPane.showConfirmDialog(null, "Your Level Numbered " + levelIndex + 
						"has been changed.", "You Got It!", JOptionPane.DEFAULT_OPTION);
			}
			/*
			 * No more then 15!
			 * */
			else {
				JOptionPane.showConfirmDialog(null, "Sorry but level is not saved.\n"
								+ "You are allowed to have only 15 levels", "Nahhh", 
								JOptionPane.DEFAULT_OPTION);
			}
		}
		
		//------------------------------THEME---------------------------------------
		else if (level.getLevelType().equals("Theme")) {
			
			LinkedList<String> wordList = new LinkedList<String>();
			String theme = level.getThemeInput().getText();
			
			for (int j=0;j<level.getWords().getModel().getSize();j++) {
				wordList.add((String) level.getWords().getModel().getElementAt(j));
			}
			
			//need new theme
			Theme themelev = new Theme(board, starThresh, theme, wordList);
			
			/*
			 * Making new level, add to next available place in levels
			 */
			if (builder.getLevels().size()<15&&levelIndex==-1){
				builder.getLevels().add(themelev);
				
				JOptionPane.showConfirmDialog(null, "Level is put at " + 
				builder.getLevels().size() + ".", "You Got It!", JOptionPane.DEFAULT_OPTION);

			}
			
			/*
			 * Is it editing? Overwrite! 
			 */
			
			else if (levelIndex>=0&&levelIndex<=15) {
				builder.getLevels().remove(levelIndex);
				builder.getLevels().add(levelIndex, themelev);
				
				JOptionPane.showConfirmDialog(null, "Your Level Numbered " + levelIndex + 
						" has been changed.", "You Got It!", JOptionPane.DEFAULT_OPTION);
			}
			else {
				/*
				 * No more then 15!
				 * */
				JOptionPane.showConfirmDialog(null, "Sorry but level is not saved.\n"
						+ "You are allowed to have only 15 levels", "Nahhh", 
						JOptionPane.DEFAULT_OPTION);
			}
		}
		
		//------------------------------Lightning--------------------------------
		else if (level.getLevelType().equals("Lightning")) {
			
			int time = (int)level.getMaxTimeSpnr().getValue();
			Lightning lightning = new Lightning(board, starThresh, time);
			
			/*
			 * Making new level, add to next available place in levels
			 */
			if (levelIndex == -1 && builder.getLevels().size()<15) {
				builder.getLevels().add(lightning);
				
				JOptionPane.showConfirmDialog(null, "Level is put at " + 
						builder.getLevels().size() + ".", "You Got It!", JOptionPane.DEFAULT_OPTION);

			}
			/*
			 * Is it editing? Overwrite! 
			 */
			else if (levelIndex>=0&&levelIndex<=15) {
				builder.getLevels().remove(levelIndex);
				builder.getLevels().add(levelIndex, lightning);
				JOptionPane.showConfirmDialog(null, "Your Level Numbered " + levelIndex + 
						" has been changed.", "You Got It!", JOptionPane.DEFAULT_OPTION);
			}
			
			else {
				/*
				 * No more then 15!
				 */
				JOptionPane.showConfirmDialog(null, "Sorry but level is not saved.\n"
						+ "You are allowed to have only 15 levels", "Nahhh", 
						JOptionPane.DEFAULT_OPTION);
			}
		}
		
		//Refreshing the panel
		builderApp.getMakeNewLevel().resetLevelInfoPanel();
	}

}
