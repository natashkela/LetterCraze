package Builder;

public class Lightning extends Level{
	
	int time;//time needed to complete level
	Lightning(String title, int[] starThresh, int time) {
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
