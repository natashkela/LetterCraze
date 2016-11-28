package LevelBuilder;

public class Puzzle extends Level{
	
	int limit;//limit for the words
	Puzzle(String title, int[] starThresh) {
		super(title, starThresh);
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
