package player;

import java.util.ArrayList;

import common.Letter;
import common.Tile;

public class Level {
	
	String title;//title of the level
	int[] starThresh;//scores needed to gain stars
	int highScore;//best score gained
	int highStar;//best stars gained
	int starNum;//how many stars
	int score;
	ArrayList<Word[]> wordsEntered;//what are the words entered
	Board board;//board is needed in every level
	boolean locked;//check if level is locked or not
	
	//This is a constructor for level. 
	//for level we need star-thresholds, information about best score, best stars, 
	//if its locked or not and what's the name of the level
	Level(String title,int[] starThresh, int highScore, int highStars, boolean locked){
		
		if(starThresh.length!=3){
			System.err.println ("Star threshold should have exactly three elements. Try again");
		}
		else{
			this.title = title;
			this.starThresh = starThresh;
			this.highScore = highScore;
			this.highStar = highStar;
			this.starNum = 0;//for starting the number of stars gained equals 0
			this.score = 0;//for starting the score equals to 0
			this.locked = locked;
			this.wordsEntered = new ArrayList<>();//words entered is empty arraylist for beginning
			if(this.initializeBoard()){//initialize the board
			}
			else{
				System.err.println ("Initialization returned false");
			}
		}
	}
	
	public boolean initializeBoard(){
		Tile[][] tileArray = new Tile[6][6];
		for(int row=0;row<6;row++){
			for(int col=0; col<6;col++){
				tileArray[row][col] = new Tile(row, col);
				tileArray[row][col].setLetter(new Letter());
			}
		}
		Board temp = new Board(tileArray);
		this.board = temp;
		return true;
	}
	
	String getTitle(){
		return this.title;
	}
	
	int[] getStarThresh(){
		return this.starThresh;
	}
	
	int getHighScore(){
		return this.highScore;
	}
	
	int getStarNum(){
		return this.starNum;
	}
	
	int getScore(){
		return this.score;
	}
	
	int getHighStars(){
		return this.highStar;
	}
	
	boolean getLocked(){
		return this.locked;
	}
	
	ArrayList<Word[]> getWordsEntered(){
		return this.wordsEntered;
	}
	
	Board getBoard(){
		return this.board;
	}
	
	boolean setTitle(String title){
		this.title = title;
		return true;
	}
	
	boolean setStarThresh(int[] starThresh){
		if (starThresh.length == 3){
			this.starThresh = starThresh;
			return true;
		}
		else{
			return false;
		}
	}
	
	boolean setHighScore(int highScore){
		this.highScore = highScore;
		return true;
	}
	
	boolean setHighStars(int highStar){
		this.highStar = highStar;
		return true;
	}
	
	boolean setStarNum(int starNum){
		this.starNum = starNum;
		return true;
	}
	
	boolean setScore(int score){
		this.score = score;
		return true;
	}
	

	boolean setLocked(boolean locked){
		this.locked = locked;
		return true;
	}
	
	boolean setWordsEntered(ArrayList<Word[]> wordsEntered){
		this.wordsEntered = wordsEntered;
		return true;
	}
	
	boolean setBoard(Board board){
		this.board = board;
		return true;
	}
	
}
