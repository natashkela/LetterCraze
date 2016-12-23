package Common;

import java.io.Serializable;

/** 
 * Holder for all the active Tile representations
 */
public class Board implements Serializable {
	Tile[][] tiles = new Tile[6][6];
	Word word;
	int column, row;
	/** 
	 * Constructs board made up of tiles
	 * @param tiles    36 valid tiles for all level boards
	 */
	public Board (Tile[] tiles) {
		for (int i = 0; i < tiles.length; i++) {
			this.tiles[tiles[i].getCoordinates().getCol()][tiles[i].getCoordinates().getRow()] = tiles[i];
		}
	}
	
	/** 
	 * Resets the board's active tiles randomly
	 */
	public void resetBoard() {
		for (row = 0; row < 6; row++) {
			for (column = 0; column < 6; column++) {
				if (tiles[column][row].isActive) {
					tiles[column][row].randTile();	
				}
			}
		}
	}
	
	/** 
	 * Resets the board's active tiles randomly
	 * @param board the Board being/will be being played on
	 */
	public void resetThemeBoard(Board board) {
				for (row = 0; row < 6; row++) {
					for (column = 0; column < 6; column++) {
						if (tiles[column][row].isActive) {
							tiles[column][row].addLetter(board.getTile(column,row).getLetter());
						}
					}
				}
	}

	/**
	 * Creates tile at given coordinates.
	 * @param col    column the tile goes in
	 * @param row    row the column goes in
	 */
	public Tile makeTile (int col, int row) {
		return makeTile (new Coordinates(col, row));
	}

	/**
	 * Makes a tile using Coordinates instead of col and row
	 * @param coord    	tile coordinates
	 */
	public Tile makeTile (Coordinates coord) {
		return new Tile(coord, true);
	}

	/**
	 * Finds a tile based on given column and row.
	 * 
	 * @param col    column of tile
	 * @param row    row of tile
	 */
	public Tile getTile (int col, int row) {
		return tiles[col][row];
	}
	
	/**
	 * same as the other getTile but with coord instead of col and row
	 * @param coord    get coordinates of the tile
	 */

	public Tile getTile (Coordinates coord) {
		return getTile(coord.getCol(), coord.getRow());
	}
	
    /**
     * Returns the current word
     * @return formed word
     */

    public Word getWord() {
        return word;
    }

    /**
     * Sets the current word
     * @param word  current word
     */

    public void setWord(Word word) {
        this.word = word;
    }

    /**
     * Clears the current word
     * @param word  current word
     */
	public void clearValidWord (Word word) {
		for (int i=0;i<word.getTiles().size();i++) {
			removeLetter(word.getTiles().get(i));
		}
	}

    /**
     * Clears the letter associated with param tile
     * @param tile  tile that will have it's letter removed
     */
	public Letter removeLetter (Tile tile) {
		return tile.remLetter();
	}

	/** 
	 * Floats up the tiles and will be called when words are found
	 */
	public void floatUp () {
			for (row=0;row<5;row++) {
				for (column = 0; column < 6; column++) {
					if (tiles[column][row].isActive&&!tiles[column][row].hasLetter()) {
						for (int nRow=row+1;nRow<6;nRow++) {
							if(tiles[column][nRow].isActive && tiles[column][nRow].hasLetter()) {
								Letter letter = tiles[column][nRow].remLetter();
								tiles[column][row].addLetter(letter);
								break;
							}
						}
					}
				}
			}
			for (row = 0; row < 6; row++) {
				for (column=0; column<6; column++) {
					if (tiles[column][row].isActive&&!tiles[column][row].hasLetter()) {
						tiles[column][row].randTile();
					}
				}
			}
		}
	
	/** 
	 * Floats up the tiles and will be called when words are found specifically when on a theme level type
	 */
	public void themeFloatUp() {
		for (row=0;row<5;row++) {
			for (column = 0; column < 6; column++) {
			if (tiles[column][row].isActive&&!tiles[column][row].hasLetter()) {
					for (int nRow=row+1;nRow<6;nRow++) {
						if(tiles[column][nRow].isActive&&tiles[column][nRow].hasLetter()) {
							Letter letter = tiles[column][nRow].remLetter();
							tiles[column][row].addLetter(letter);
							break;
						}
					}
				}
			}
		}
	}
	
}
