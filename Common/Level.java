package Common;

import java.io.IOException;
import java.io.Serializable;
import java.util.Stack;

import javax.swing.DefaultListModel;

public abstract class Level implements Serializable {

    //JavaDoc!
    Board board;
    //JavaDoc!
    Points best;
    //JavaDoc!
    Points current;
    //JavaDoc!
    Points oldBest;
    //JavaDoc!
    StarThresholds starThresh;
    //JavaDoc!
    //JavaDoc!
    boolean unlocked;
    //JavaDoc!
    String levelType;
  //JavaDoc!
    DefaultListModel<String> foundWords;
    Stack<Move> moves;
    
   
    

    //JavaDoc!
    Level(Board board, StarThresholds stars, String levelType) {
        this.board = board;
        this.starThresh = stars;
        this.levelType = levelType;
        best = new Points();
        current = new Points();
        oldBest = new Points();
        unlocked = false;
        moves = new Stack<Move>();
        foundWords = new DefaultListModel<String>();  
    }

    //JavaDoc!
    public void loadLevel() {
        loadDictionary();
        oldBest.setPoints(best.getPoints());
        oldBest.setStars(best.getStars());
        resetLevel();
    }
    
    //JavaDoc!
    void loadDictionary() {
        try {
            WordTable.loadWordTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        //JavaDoc!
    public void MovePush(Move move) {
        moves.push(move);
    }

    //JavaDoc!  
    public Move retMoves() {
        return moves.pop();
    }

   //JavaDoc!
    public void updateBest() {
        if (best.getPoints()<current.getPoints()) {
            best.setPoints(current.getPoints());
            best.setStars(current.getStars());
        }
    }
    
   
    //JavaDoc!
    public void resetLevel() {
        board.resetBoard(); 
        current = new Points();
        foundWords.clear();
        moves.clear();
    }
    
    //JavaDoc!
    public DefaultListModel<String> getFoundWords() {
        return foundWords;
    }

    //JavaDoc!   
    public void unlock() {
        unlocked = true;
    }

  //JavaDoc!
    public String getLevelType() {
        return levelType;
    }

    //JavaDoc!
    public Points getBest() {
        return best;
    }
    
  //JavaDoc!  
    public Points getOldBest() {
        return oldBest;
    }

    //JavaDoc!
    public Points getCurrent() {
        return current;
    }
    
  //JavaDoc!
    public StarThresholds getThresh() {
        return starThresh;
    }
    
    //JavaDoc!
    public int getMovesMadeSize() {
        return moves.size();
    }
    
    //JavaDoc!
    public Board getBoard() {
        return board;
    }

  //JavaDoc!  
    public boolean getUnlocked() {
        return unlocked;
    }


    

    

}