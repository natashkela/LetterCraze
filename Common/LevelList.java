package Common;

import java.io.Serializable;
import java.util.LinkedList;

public class LevelList implements Serializable {

    //JavaDoc!
    LinkedList<Level> levelList;
    //JavaDoc!
    int unlockedNum; // probably should keep track of how many levels are locked/unlocked

    //JavaDoc!
    public LevelList(LinkedList<Level> levels) {
        this.levelList = levelList;
    }

    //JavaDoc!
    public LevelList() {
        levelList = new LinkedList<Level>();
    }

    //JavaDoc!
    public boolean unlockNext() {
        for (int i=0;i<levelList.size()-1;i++) {
            if (levelList.get(i).getBest().getStars()>=1&&!levelList.get(i+1).unlocked) {
                levelList.get(i+1).unlock();
                return true;
            }
        }
        return false;
    }
    
  //JavaDoc!
    public void addLevel(Level level) {
        levelList.add(level);
    }

   //JavaDoc!
    public void removeLevel(int level) {
        levelList.remove(level);
    }

    //JavaDoc!
    public LinkedList<Level> getLevels() {
        return levelList;
    }

}