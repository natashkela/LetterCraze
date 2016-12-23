package Common;

import javax.swing.Timer;

public class Lightning extends Level{

    //JavaDocs!
    int allowedTime;
    //JavaDocs!
    Timer timer;
    //JavaDocs!
    public Lightning(Board board, StarThresholds stars, int allowedTime) {
        super(board, stars, "Lightning");
        this.allowedTime=allowedTime;              
    }

    //JavaDoc!
    public int getTime() {
        return allowedTime;
    }
    
    //JavaDoc!
    public void setTime(int allowedTime){
    	this.allowedTime = allowedTime;
    }

}