package Player;

public class Puzzle extends Level{
	int limit;//limit for the words
	Puzzle(String title, int[] starThresh, int highScore, int highStars, boolean locked,int limit) {
		super(title, starThresh, highScore, highStars, locked);
		this.limit=limit;
	}
	
	int getLimit(){
		return this.limit;
	}
	
	boolean setLimit(int input){
		this.limit = input;
		return true;
	}

}
