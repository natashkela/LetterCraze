package BuilderControllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.Timer;

import BuilderGUI.BuilderApp;
import BuilderGUI.EditLevels;
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
import PlayerGUI.LightningApp;
import PlayerGUI.PuzzleApp;
import PlayerGUI.ThemeApp;

/**
 * Controller for Previewing Levels
 * @author macbookair
 *
 */

public class PreviewListener implements ActionListener {
	/** 
	 * The top level builder model 
	 * (top level entity class that can navigate to all stuff Builder)
	 */
	public Builder builder;
	/** 
	 * The top level builder application 
	 * (top level boundary class that can navigate to all stuff BuilderGUI)
	 */
	public BuilderApp builderApp;
	/**
	 *  The index of the level being acted upon 
	 */
	protected int levelIndex;
	
	/** 
	 * Adding functionality to the btnPreview in the MakeNewLevelGUI.
	 *   
	 * @param builderApp Top level builderApp for builderGUI (boundaries) 
	 * @param builder Top level builder for builder 
	 * @param levelIndex The number associated with a level
	 */
	public PreviewListener(BuilderApp builderApp, Builder builder, int levelIndex) {
		this.builderApp = builderApp;
		this.builder = builder;
		this.levelIndex = levelIndex;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (levelIndex==-1) {

			int i=0;
			MakeNewLevel level = builderApp.getMakeNewLevel();		
			Tile[] tiles = new Tile[36];
			
			int columns, rows;
			for (columns=0;columns<6;columns++) {
				for (rows=0;rows<6;rows++) {
					if (level.getTiles()[columns][rows].getBackground().equals(Color.WHITE)) {
						if(level.getLevelType().equals("Theme")){
							if(level.getLetters()[columns][rows].getText().length() == 0){
								tiles[i]= new Tile(new Coordinates(rows,columns), false, new Letter("A"));
							}
							else if(level.getLetters()[columns][rows].getText().substring(0, 1).toUpperCase().equals("Q")){
								tiles[i]= new Tile(new Coordinates(rows, columns), true, new Letter("QU"));
							}
							else{
								tiles[i]= new Tile(new Coordinates(rows, columns), true, new Letter(level.getLetters()[columns][rows].getText().substring(0, 1).toUpperCase()));
							
							}
						}
						else{
							tiles[i]= new Tile(new Coordinates(rows,columns), true, new Letter("A"));
						}
					}
					else {
						tiles[i]= new Tile(new Coordinates(rows,columns), false, new Letter("A"));
					}
					i++;
				}
			}
			
			StarThresholds starThreshold = new StarThresholds(level.getStarThresholds()[0], level.getStarThresholds()[1], level.getStarThresholds()[2]);
			Board board = new Board(tiles);
			
			//------------------------------PUZZLE--------------------------------
			if (level.getLevelType().equals("Puzzle")) {
				int maxMoves = (int)level.getMaxMovesSpnr().getValue();
				
				Puzzle puzzle = new Puzzle(board, starThreshold, maxMoves);
				puzzle.getBoard().resetBoard();
				
				PuzzleApp puzzApp = new PuzzleApp(puzzle);
				puzzApp.replacePanel(puzzle);
				puzzApp.getGoBack().addActionListener(new LeavePreviewListener(builderApp, builder, levelIndex));
				builderApp.setContentPane(puzzApp);
			}
			
			//-----------------------------Lightning-------------------------
			else if (level.getLevelType().equals("Lightning")) {
				int maxTime = (int)level.getMaxTimeSpnr().getValue();
				
				Lightning lightning = new Lightning(board, starThreshold, maxTime);
				lightning.getBoard().resetBoard();
				
				LightningApp lightningApp = new LightningApp(lightning, new Timer(0, null));
				lightningApp.replacePanel(lightning);
				lightningApp.getGoBack().addActionListener(new LeavePreviewListener(builderApp, builder, levelIndex));
				builderApp.setContentPane(lightningApp);
			}
			
			//------------------------------Theme------------------------------
			else if (level.getLevelType().equals("Theme")) {
				String theme = level.getThemeInput().getText();
				LinkedList<String> words = new LinkedList<String>();
				
				for (int t = 0; t < level.getWords().getModel().getSize(); t++) {
					words.add((String)level.getWords().getModel().getElementAt(t));
				}
				
				Theme theme1 = new Theme(board, starThreshold, theme, words);
				
				ThemeApp themeApp = new ThemeApp(theme1);
				themeApp.replacePanel(theme1);
				themeApp.restartPTL(theme1);
				themeApp.getGoBack().addActionListener(new LeavePreviewListener(builderApp, builder, levelIndex));
				builderApp.setContentPane(themeApp);
			}
		}
		
		else {
			int i=0;
			EditLevels level = builderApp.getEditLevels().get(levelIndex);
			Tile[] tiles = new Tile[36];
			
			for (int columns=0;columns<6;columns++) {
				for (int rows=0;rows<6;rows++) {
					if (level.getTileArray()[columns][rows].getBackground().equals(Color.WHITE)) {
						
						if(level.getLevelType().equals("Theme")){
						
							if(level.getLetters()[columns][rows].getText().length() == 0){
								tiles[i]= new Tile(new Coordinates(rows,columns), false, new Letter("A"));
							}
							else{
								tiles[i]= new Tile(new Coordinates(rows,columns), true, new Letter(level.getLetters()[columns][rows].getText().substring(0,1).toUpperCase()));
							}
						}
						else{
							tiles[i]= new Tile(new Coordinates(rows,columns), true, new Letter("A"));
						}
					}
					else {
						tiles[i]= new Tile(new Coordinates(rows,columns), false, new Letter("A"));
					}
					i++;
				}
			}
			Board board = new Board(tiles);
			StarThresholds starThreshold = new StarThresholds(level.getStarThreshsList()[0], level.getStarThreshsList()[1], level.getStarThreshsList()[2]);
			
			//-----------------------PUZZLE-----------------------
			if (level.getLevelType().equals("Puzzle")) {
				
				int maxMoves = (int)level.getMaxMoves().getValue();
				Puzzle puzzle = new Puzzle(board, starThreshold, maxMoves);
				
				puzzle.getBoard().resetBoard();
				
				PuzzleApp pApp = new PuzzleApp(puzzle);
				
				pApp.replacePanel(puzzle);
				pApp.getGoBack().addActionListener(new LeavePreviewListener(builderApp, builder, levelIndex));
				builderApp.setContentPane(pApp);
			}
			
			//---------------------------THEME-----------------------
			else if (level.getLevelType().equals("Theme")) {
				String theme = level.getTheme().getText();
				LinkedList<String> list = new LinkedList<String>();
				
				for (int j=0; j<level.getWords().getModel().getSize(); j++) {
					list.add((String)level.getWords().getModel().getElementAt(j));
				}
				Theme theme1 = new Theme(board, starThreshold, theme, list);
				
				ThemeApp tApp = new ThemeApp(theme1);
				
				tApp.replacePanel(theme1);
				tApp.restartPTL(theme1);
				tApp.getGoBack().addActionListener(new LeavePreviewListener(builderApp, builder, levelIndex));
				builderApp.setContentPane(tApp);
			}
			
			//------------------------LIGHTNING-------------------------
			else if (level.getLevelType().equals("Lightning")) {
				
				int time = (int)level.getTime().getValue();
				Lightning lightning = new Lightning(board, starThreshold, time);
				
				lightning.getBoard().resetBoard();
				
				LightningApp lApp = new LightningApp(lightning, new Timer(0, null));
				lApp.replacePanel(lightning);
				lApp.getGoBack().addActionListener(new LeavePreviewListener(builderApp, builder, levelIndex));
				builderApp.setContentPane(lApp);
				
			}
		}
	}
}