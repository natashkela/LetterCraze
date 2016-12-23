package BuilderControllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import BuilderGUI.BuilderApp;
import BuilderGUI.EditLevels;
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
 * 
 * Controller for Edit Levels
 * @author macbookair
 *
 */

public class EditLevelListener implements ActionListener{

	/**
	 * Holds level information for builder 
	 */
    public Builder builder;
    
	/**
	 * Top level boundary class for builder
	 */
    public BuilderApp builderApp;
    
    /** 
     * Frame for EditLevels
     */
    public EditLevels level;
    
   /**
    * Level order number
    */
    int levelIndex;


	/** 
	 * Constructor for EditLevelController.
	 * @param builderApp	Top level boundary class for builder
	 * @param builder   	Contains a list of saved levels
	 * @param level			Frame for EditLevels
	 * @param levelindex	Level order number
	 */
   public EditLevelListener(BuilderApp builderApp, Builder builder, EditLevels level, int levelIndex) {
    	this.builderApp = builderApp;
    	this.builder = builder;
    	this.level = level;
    	this.levelIndex = levelIndex;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	int i=0;
    	Tile[] tiles = new Tile[36];
    	
    	for (int row=0; row<6; row++) {
    		for (int col=0; col<6; col++) {
    			
    			if (level.getTileArray()[col][row].getBackground().equals(Color.WHITE)) {
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
    	
    	StarThresholds stars = new StarThresholds(level.getStarThreshsList()[0], level.getStarThreshsList()[1], level.getStarThreshsList()[2]);
    	Board board = new Board(tiles);
    	
    	//----------------------------------PUZZLE----------------------------------
    	
    	if (level.getLevelType().equals("Puzzle")) {
    		int maxMove = (int)level.getMaxMoves().getValue();
    		Puzzle puzzle = new Puzzle(board, stars, maxMove);
    		
    		//add
    		if (builder.getLevels().size()<15&&levelIndex==-1) {
    			builder.getLevels().add(puzzle);
    		}
    		
    		//edit
    		else if (levelIndex >= 0 && levelIndex <= 15) {
    			builder.getLevels().remove(levelIndex);
    			builder.getLevels().add(levelIndex, puzzle);
				JOptionPane.showConfirmDialog(null, "Level Number " + (levelIndex+1) + " is changed.", "You Got It!", JOptionPane.DEFAULT_OPTION);
    		}
    	}
    	
    	//-----------------------------THEME-------------------------------------
    	else if (level.getLevelType().equals("Theme")) {
    		LinkedList<String> list = new LinkedList<String>();
    		String theme = level.getTheme().getText();
    		
    		for (int j=0; j<level.getWords().getModel().getSize();j++) {
    			list.add((String)level.getWords().getModel().getElementAt(j));
    		}
    		
    		Theme theme1 = new Theme(board, stars, theme, list);
    		
    		//add
    		if (builder.getLevels().size()<15&&levelIndex==-1) {
    			builder.getLevels().add(theme1);
    		}
    		
    		//edit
    		else if (levelIndex>=0&&levelIndex<= 15) {
    			builder.getLevels().remove(levelIndex);
    			builder.getLevels().add(levelIndex, theme1);
				JOptionPane.showConfirmDialog(null, "Level Number" + (levelIndex+1) + " is changed.", "You Got It!", JOptionPane.DEFAULT_OPTION);

    		}
    	}
    	
    	//----------------------------LIGHTNING--------------------------------
    	else if (level.getLevelType().equals("Lightning")) {
    		
    		int time = (int)level.getTime().getValue();
    		
    		Lightning lightning = new Lightning(board, stars, time);
    		
    		//add
    		if (builder.getLevels().size()<15&&levelIndex==-1) {
    			builder.getLevels().add(lightning);
    		}
    		
    		//edit
    		else if (levelIndex>=0&&levelIndex<=15) {
    			builder.getLevels().remove(levelIndex);
    			builder.getLevels().add(levelIndex, lightning);
				JOptionPane.showConfirmDialog(null, "Level Number " + (levelIndex+1) + " is changed.", "You Got It!", JOptionPane.DEFAULT_OPTION);
    		}
    	}
    }
}
