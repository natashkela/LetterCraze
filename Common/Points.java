package Common;
import java.io.Serializable;

public class Points implements Serializable{
	//JavaDoc!
	 int points;
	//JavaDoc!
	 int stars;
   
	 //JavaDoc!
    public Points() {
        this.points=0;
        this.stars=0;
    }
    
    public void addPoints(int toAdd){
    	points=points+toAdd;
    }
    public void removePoints(int toRemove){
    	points=points-toRemove;
    }
    
    public int getPoints(){
    	return points;
    }
    
    public int getStars(){
    	return stars;
    }
    
    public void setPoints(int points){
    	this.points=points;
    }
    
    public void setStars(int stars){
    	this.stars=stars;
    }
    
    
}
