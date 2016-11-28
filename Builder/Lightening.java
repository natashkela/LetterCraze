package Builder;

public class Lightening extends Level{
	
	int time;//time needed to complete level
	Lightening(String title, int[] starThresh) {
		super(title, starThresh);
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
