package Player;

import java.util.ArrayList;

public class Word {
	ArrayList<Tile> lettersSelected;
	public Word(ArrayList<Tile> lettersSelected){
		this.lettersSelected=lettersSelected;
	}
	
	ArrayList<Tile> getLettersSelected(){
		return lettersSelected;
	}
	
	boolean setLettersSelected(ArrayList<Tile> input){
		this.lettersSelected = input;
		return true;
	}
}
