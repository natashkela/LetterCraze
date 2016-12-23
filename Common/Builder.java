package Common;

import java.io.Serializable;
import java.util.LinkedList;

/** 
 * Associated levels saved to Builder
 */
public class Builder implements Serializable {

	/**
	 * SavedLevels
	 */
    LinkedList<Level> levelList;

    /** 
     * Constructor for Builder
     */	
    public Builder() {
        levelList = new LinkedList<Level>();
    }

    /** 
     * Get saved levels.
     */	
    public LinkedList<Level> getLevels() {
        return levelList;
    }

    /** 
     * sets saved levels
     * @param levelList    LinkedList of levels that need to be used by Builder
     */
    public void setLevels(LinkedList<Level> levelList) {
        this.levelList = levelList;
    }

}