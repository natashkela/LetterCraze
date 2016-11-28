package LevelBuilder;


public class Tile {
	Letter letter;//letter in the tile
	int row;
	int col;
	
	public Tile(int row, int col){
		this.row = row;
		this.col = col;
	}
	

	int getRow(){
		return this.row;
	}
	
	int getCol(){
		return this.col;
	}
	
	Letter getLetter(){
		return this.getLetter();
	}
	
	boolean setRow (int input){
		this.row = input;
		return true;
	}
	
	boolean setCol (int input){
		this.row = input;
		return true;
	}
	
	boolean setLetter(Letter input){
		this.letter = input;
		return true;
	}
	
	
	//remove the letter in the tile, if there's nothing return false, if there is something, return 
	//true 
	public boolean removeLetter(){
		if (this.letter != null){
			this.letter = null;
			return true;
		}
		else{
			return false;
		}
	}
	
	/*Maybe needed for undo*/
	//replace letter and return the one that was there before
		//if there was nothing return null
		public Letter replace(Letter input){
			if (this.letter != null){
				Letter let = this.letter;
				this.letter = input;//change with new
				return let;//return old
			}
			else{
				return null;
			}
		}
	
}
