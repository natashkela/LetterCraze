package Common;
import java.io.Serializable;

/** 
 * Letter class that has an associated String and points depends on String
 */
public class Letter implements Serializable{
    String letter;//javadoc
    int points;//javadoc
    
    /**
     * constructor
     * @param letter Letter that should be in the tile
     */
    public Letter(String letter) {
        this.letter = letter.toUpperCase();
        this.points= LetterScoreHolder.getScores(letter);
    }

    /** 
     * gets points
     */
    public int getPoints() {
        return points;
    }
    
    /** 
     * gets letter
     */
    public String getLetter() {
        return letter;
    }
    
    /** 
     * returns upper case format of letter
     */
    public String toUpperCaseLetter(){
        return letter.toUpperCase();
    }

    /** 
     * checks validity concerning if the right letter has the right points associated with it and if it follows the default uppercase format
     */
    public boolean isValid() {
        if ((LetterScoreHolder.getScores(letter)==points)&&
        		letter.equals(letter.toUpperCase())){ 
        				return true; 
        	}
        else{
        	return false;
        }

    }

}
