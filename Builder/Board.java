package Builder;

import common.Tile;

public class Board {
	
	Tile[][] tiles;//tiles on the board
	Board(Tile[][] tiles){
		if((tiles.length == 6) && (tiles[0].length == 6)){
			this.tiles = tiles;
		}
		else{
			System.err.println ("The number of tiles is greater than 36. Please change it");
		}
		
	}
	
	Tile[][] getTile(){
		return this.tiles;
	}
	
	boolean setSquares(Tile[][] tiles){
		if((tiles.length == 6)&&(tiles[0].length == 6)){
			this.tiles = tiles;
			return true;
		}
		else{ 
			return false;
		}
	}
}
