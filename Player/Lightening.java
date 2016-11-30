package player;

public class Lightening extends Level{

	int time;//time needed to complete level
	
	Lightening(String title, int[] starThresh, int highScore, int highStars, boolean locked,int time) {
		super(title, starThresh, highScore, highStars, locked);
		this.time=time;
	}
	
	int getTime(){
		return this.time;
	}
	
	boolean setTime(int time){
		this.time = time;
		return true;
	}
}
