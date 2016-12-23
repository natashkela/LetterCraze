package PlayerControllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Common.Coordinates;
import Common.Level;
import Common.Word;
import PlayerGUI.LevelFrame;


public class TileListener implements ActionListener {

	LevelFrame lFrame;
	Level level;
	int levelIndex;
	int column;
	int row;
	
	Coordinates[] selectedTiles;
	Coordinates lastSelected;
	int numSelectedTiles;
	JButton[][] tiles;
	
	public boolean valid(){
		int columns, rows;
		numSelectedTiles = 0;
		for (rows = 0; rows < 6; rows++) {
			for (columns = 0; columns < 6; columns++) {
				if (tiles[columns][rows].getBackground().equals(Color.CYAN)) {
					selectedTiles[numSelectedTiles] = new Coordinates(rows, columns);					
					numSelectedTiles++;
				} 
			}
		}
		if (numSelectedTiles == 0) { return true;}
		lastSelected = selectedTiles[numSelectedTiles-1];
		int lastRow = lastSelected.getRow();
		int lastColumn = lastSelected.getCol();
		int deltaRow = lastRow-row;
		int deltaColumn = lastColumn-column;
		if (java.lang.Math.abs(deltaRow) <= 1 && java.lang.Math.abs(deltaColumn) <= 1) {
			return true;
		}
		return false;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (level.getBoard().getTile(column, row).getIsActive() == true) {
			if (tiles[column][row].getBackground() == Color.WHITE) {
				if (valid() == true) {
					tiles[column][row].setBackground(Color.CYAN);
					if (level.getBoard().getWord().getTiles().isEmpty()) {
						level.getBoard().setWord(new Word(level.getBoard().getTile(column, row)));
					}
					else {
						level.getBoard().getWord().concatTile(level.getBoard().getTile(column, row));
					}
					numSelectedTiles++;
					System.out.println(level.getBoard().getWord());
					System.out.println(numSelectedTiles);
					lFrame.pushActive(tiles[column][row]);				
				}	
			}
			if (numSelectedTiles>0) {
				lastSelected = selectedTiles[numSelectedTiles-1];
				}
			if (level.getBoard().getTile(column, row).equals(level.getBoard().getTile(lastSelected))) {
				tiles[column][row].setBackground(Color.WHITE);
				lFrame.popActive();
				level.getBoard().getWord().remTile(level.getBoard().getTile(lastSelected));
				numSelectedTiles--;
			}
		}
		return;
	}

	public TileListener(LevelFrame levelframe, Level level, int levelNumber, int column, int row) {
		this.lFrame = levelframe;
		this.level = level;
		this.levelIndex = levelNumber;
		this.column = column;
		this.row = row;
		this.tiles = lFrame.getTiles();  
		this.selectedTiles = new Coordinates[36];
	}
}
