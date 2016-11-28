package Builder;

public class Level {
	String title;
	int[] starThresh;
	Board board;
	
	Level(String title, int[] starThresh){
		if(starThresh.length!=3){
			System.err.println ("Star threshold should have exactly three elements. Try again");
		}
		else{
			this.title = title;
			this.starThresh = starThresh;
			if(this.initializeBoard()){
			}
			else{
				System.err.println ("Initialization returned false");
			}
			
		}
	}
	
	String getTitle(){
		return this.title;
	}
	
	
	int[] getStarThresh(){
		return this.starThresh;
	}
	
	Board getBoard(){
		return this.board;
	}
	
	boolean setTitle(String title){
		this.title = title;
		return true;
	}
	
	boolean setStarThresholds(int[] starThresholds){
		if (starThresholds.length!=3){
			return false;
		}
		else{
			this.starThresh = starThresh;
			return true;
		}
	}
	
	boolean setBoard(Board board){
		this.board = board;
		return true;
	}
	
	//Empty Board
	public boolean initializeBoard(){
		Tile[][] tileArray = new Tile[6][6];
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				tileArray[row][col] = new Tile(row, col);
				tileArray[row][col] = null;
			}
		}
		Board temp = new Board(tileArray);
		this.board = temp;
		return true;
	}
	
	public boolean initializeBoardWithLetters(){
		Tile[][] tileArray = new Tile[6][6];
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				tileArray[row][col] = new Tile(row, col);
				tileArray[row][col].setLetter(new Letter());
			}
		}
		Board temp = new Board(tileArray);
		this.board = temp;
		return true;
	}
}
