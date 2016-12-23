package Common;

public class Puzzle extends Level{
	/**
	 * maximum number of words that player is able to guess in the level
	 */
    int maxWord; 
    /**
     * amount of valid words
     */
    int numWordValid; 

	
    /**
      * Constructor for puzzle level
      *@param board 
      *@param starThreshold 	star thresholds
      *@param maxWord 			number of words allowed
      */
    
    public Puzzle(Board board, StarThresholds starThreshold, int maxWord) {
    	super(board, starThreshold, "Puzzle");
    	numWordValid=0;
    	this.maxWord = maxWord;
    	
    }
    
    //JavaDoc!
    public int getNumWordValid() {
    	return numWordValid;
    }
    
    //JavaDoc!
    public void resetValidWords() {
    	numWordValid = 0;
    }
    
    //JavaDoc!
    public int getMaxWord() {
        return maxWord;
    }
}
