package Common;

import java.io.Serializable;

public class StarThresholds implements Serializable {
	//JavaDocs for all attirbutes!
	int thresh1;
    int thresh2;
    int thresh3;

  //JavaDoc!
    public StarThresholds(int thresh1, int thresh2, int thresh3) {
        this.thresh1 = thresh1;
        this.thresh2 = thresh2;
        this.thresh3 = thresh3;
    }
    
  //JavaDoc!
    public int getThresh1() {
        return thresh1;
    }

  //JavaDoc!
    public int getThresh2() {
        return thresh2;
    }
    
  //JavaDoc!
    public int getThresh3() {
        return thresh3;
    }
    
  //JavaDoc!
    void setThresh1(int points) {
        thresh1 = points;
    }
    
  //JavaDoc!
    void setThresh2(int points) {
        thresh2 = points;
    }

  //JavaDoc!
    void setThresh3(int points) {
        thresh3 = points;
    }

}
