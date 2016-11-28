package Builder;

import java.util.ArrayList;


public class Theme extends Level{

	String theme;//theme name
	ArrayList<String> words;//words used in theme
	Board board;//needs its own board cause we create the themes
	Theme(String title, int[] starThresh) {
		super(title, starThresh);
		this.theme = theme;
		this.words=words;
		this.board=board;
	}
	
	
	ArrayList<String> getWords(){
		return this.words;
	}
	
	Board getBoard(){
		return this.board;
	}
	
	boolean setWords(ArrayList<String> input){
		this.words = input;
		return true;
	}
	
	boolean setBoard(Board input){
		this.board = input;
		return true;
	}
	
	boolean addWord(String input){
		return words.add(input);
	}
	
	boolean removeWord(String input){
		return words.remove(input);
	}
	
	//initialize the board
	public boolean initializeBoard(){
		this.board = this.board;
		return true;
	}
}
