package Common;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Word implements Serializable{
	/**
	 * word with letters
	 */
	private String letters; 
	/**
	 * points gained for the word
	 */
	private int points;
	/**
	 * tiles that make up the work
	 */
	private LinkedList<Tile> tiles;
  

	//JavaDocs!
    public Word(Tile tile) {
        letters = "";
        if (tile.getLetter()!=null) {
            concatTile(tile);
        }
        points=tile.recentLetter().getPoints();
        tiles=new LinkedList<Tile>();
    }
    
    //JavaDocs!
    public boolean isValid(){
        if (WordTable.isWord(letters)) {
            if (letters.length()>=3) { 
            	return true; 
            	}
        }
        return false;
    }
    
  //JavaDocs!
    public void concatTile (Tile tile) {
        tiles.add(tile);
        letters=letters+(tile.recentLetter().toUpperCaseLetter());
        points=0;
        for (int i=0;i<tiles.size();i++) {
            points=points+tiles.get(i).recentLetter().getPoints();
        }
        points=points*(letters.length()-2);
    }
    
  //JavaDocs!
    public void remTile(Tile tile) {
    	letters="";
        points=0;
    	tiles.remove(tile);
        for (int i=0;i<tiles.size();i++) {
            letters=letters+tiles.get(i).recentLetter().letter;
            points=points+tiles.get(i).recentLetter().getPoints();
        }
        points=(letters.length()-2)*points;
    }
    
    //JavaDocs!
    public LinkedList<Tile> getTiles() {
        return tiles;
    }

    //JavaDocs!
    public int getPoints() {
        return points;
    }

    //JavaDocs!
    public String getLetters(){
        return letters;
    }

}
