package player;

import common.Tile;

public class Board {
	
	Tile[][] tiles;//2D array for tiles
		
		public Board(Tile[][] tiles){
			if((tiles.length==6) && (tiles[0].length==6)){ //Check if its greater than 36 tiles
				this.tiles = tiles;
			}
			else{
				System.err.println ("The number of tiles is greater than 36. Please change it.");
			}
		}
		
		Tile[][] getTile(){//get the tiles
			return this.tiles;
		}
		
		boolean setTile(Tile[][] tile){//boolean for setting tiles. if set return true, else return false
			if((tile.length == 6)&&(tile[0].length == 6)){
				this.tiles = tile;
				return true;
			}
			else{ 
				return false;
			}
		}

}
