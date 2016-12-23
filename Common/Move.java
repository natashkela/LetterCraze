package Common;
import java.io.Serializable;

import PlayerGUI.LevelFrame;

public class Move implements Serializable{
	//JavaDocs for all attributes!
	Letter[][] letters;
	Word word;
    Level level;
    LevelFrame levelFrame;		
    
    //JavaDocs!
    public Move(Word word, Level level) {
    	this.word=word;
        this.level=level;
        letters = new Letter[6][6];
        for (int row=0;row<6;row++) {
            for (int col=0;col<6;col++) {
                if (level.getBoard().getTile(col,row).hasLetter()&&
                	level.getBoard().getTile(col,row).getIsActive()) {
                    letters[col][row] = new Letter(level.getBoard().getTile(col,row).
                    		recentLetter().getLetter());
                }
            }
        }
    }
    
    //JavaDoc!
    public boolean isValid() {
       return word.isValid();
    }
    
        //JavaDocs
    public boolean doMove(){
        if (isValid()) {
        	
            level.getFoundWords().addElement(word.getLetters());
            if (!level.getLevelType().equals("Theme")) {
                int points=word.getPoints();
                level.getCurrent().addPoints(points);
            }
            
            else {
                level.getCurrent().addPoints(1);
            }
            
            if (level.getThresh().getThresh3()<=level.getCurrent().getPoints()){
                level.getCurrent().setStars(3);
            } 
        
            else if (level.getThresh().getThresh2()<=level.getCurrent().getPoints()){
                level.getCurrent().setStars(2);
            } 
            
            else if (level.getThresh().getThresh1()<=level.getCurrent().getPoints()){
                level.getCurrent().setStars(1);
            }
            
            level.updateBest();
            
            level.getBoard().clearValidWord(word);

            
            if (!level.getLevelType().equals("Theme")) {
                level.getBoard().floatUp();
            } 
            
            else {
                level.getBoard().themeFloatUp();
            }
            return true;
        }
        return false;
    }

  //JavaDoc!
    public boolean undo() {
        if (level.getFoundWords().isEmpty()) {
            return false;
        }
        
        int listLength = level.getFoundWords().size();
        level.getFoundWords().removeElementAt(listLength-1);
        
        if (level.getLevelType().equals("Theme")) {
        	level.getCurrent().removePoints(1);
            
        	if (level.getOldBest().getPoints()<level.getBest().getPoints()){
                level.getBest().removePoints(-1);
            }
        	
        }
        else {
        	int points=word.getPoints();
            level.getCurrent().removePoints(points);
            
            if (level.getOldBest().getPoints()<level.getBest().getPoints()) {
                level.getBest().removePoints(points);
            }
        }
        
        if (level.getThresh().getThresh1()>level.getCurrent().getPoints()) {
            level.getCurrent().setStars(0);
        } 

        else if (level.getThresh().getThresh2()>level.getCurrent().getPoints()) {
            level.getCurrent().setStars(1);
        } 

        else if (level.getThresh().getThresh3()>level.getCurrent().getPoints()) {
            level.getCurrent().setStars(2);
        }
        
        else {
            level.getCurrent().setStars(3);
        }
        
        if(level.getThresh().getThresh1()>level.getBest().getPoints()) {
            level.getBest().setStars(0);
        } 

        else if(level.getThresh().getThresh2()>level.getBest().getPoints()) {
            level.getBest().setStars(1);
        } 

        else if (level.getThresh().getThresh3()>level.getBest().getPoints()) {
            level.getBest().setStars(2);
        }
        
        else{
            level.getBest().setStars(3);
        }
        
        for (int row=0;row<6;row++) {
            for (int col=0;col<6;col++) {
                if (letters[col][row]!=null) {
                    level.getBoard().getTile(col,row).addLetter(letters[col][row]);
                }
            }
        }
        return true;
    }

}
