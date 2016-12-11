package builderController;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileCreatorPuzzle {
	
	private static boolean[][] activeTiles;
	public static int maxNumOfWords;
	private static String title;
	private static int[] starThreshold;
	private static int order;
    private static int maxStars;
    private static int highScore;
    private static boolean locked;
    
	FileCreatorPuzzle(boolean[][] activeTiles,int maxNumOfWords,String title, int[] starThreshold, int order,
						int maxStars, int highScore, boolean locked){
		this.activeTiles = activeTiles;
		this.maxNumOfWords=maxNumOfWords;
		this.title=title;
		this.starThreshold=starThreshold;
		this.order=order;
		this.maxStars=maxStars;
		this.highScore=highScore;
		this.locked=locked;
	}
	
	public static void writeToFile(String fileName) throws IOException {
		PrintWriter fw = new PrintWriter(fileName+".txt");
		for (int i=0; i<activeTiles.length; i++) {
			for(int j=0;j<activeTiles[0].length;j++){
				if(activeTiles[i][j]){
					fw.write(Integer.toString(i)+Integer.toString(j)+"1");//first number is row
					//second number is column
					//third number shows if its active or not
					//if its one its active
					//if its zero its not active
				}
				else{
					fw.write(Integer.toString(i)+Integer.toString(j)+"0");//first number is row
					//second number is column
					//third number shows if its active or not
					//if its one its active
					//if its zero its not active
				}
			}
		}
		
		fw.write("222");//code for ending one attribute in this case Active Tiles
		//if you see line equal to 000 it means that next line would be the next attribute
		fw.write(maxNumOfWords);
		fw.write("222");//end of max numofWords
		fw.write(title);
		fw.write("222");//end of title
		for(int i=0;i<starThreshold.length;i++){
			fw.write(starThreshold[i]);//writes in star thresholds line by line
		}
		fw.write("222");//end of star thresholds
		fw.write(order);
		fw.write("222");//end of order
		fw.write(maxStars);
		fw.write("222");//end of maxStars
		fw.write(highScore);
		fw.write("222");//end of highScore
		if(locked){
			fw.write("0");//locked
		}
		else{
			fw.write("1");//unlocked
		}
		fw.write("222");//end of locked
		fw.close();
	}
}
