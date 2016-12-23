package Common;
import java.io.Serializable;

public class Tile implements Serializable{
	/**
	 * to know the coordinates of tiles
	 */
	Coordinates coordinates;
	/**
	 * letter for tile
	 */
	Letter letter; 
	/**
	 *check if its active
	 */
	boolean isActive; 

	/**
	 * Tile Constructor
	 * @param coordinates   for coordinates of the tiles
	 * @param isActive		isActive to check if the tile is active or not
	 * @param letter		to add the letter to the tile
	 */
	public Tile(Coordinates coordinates, boolean isActive, Letter letter){
		this.coordinates=coordinates;
		this.isActive=isActive;
		this.letter=letter;
	}
	
	/**
	 * Constructor for Tile
	 * @param coordinates   coordinates of the tile
	 * @param isActive		to know if the tile is active or not
	 */
	public Tile(Coordinates coordinates, boolean isActive){
		this.coordinates=coordinates;
		this.isActive = isActive;
		this.letter = null;
	}

	//JavaDocs!
	public boolean hasLetter(){
		return letter!=null;
	}

	//JavaDocs!
	void addLetter (Letter letter){
		this.letter=letter;
	}

	//JavaDocs!
	public Letter recentLetter(){
		return letter;
	}

	/**
	 * returns the letter and removes it
	 * @return Letter 	removed Letter
	 */
	Letter remLetter(){
		Letter let = letter;
		removeLetter();
		return let;
	}

	/**
	 * removes the letter
	 */
	void removeLetter(){
		letter=null;
	}
		
	//JavaDocs! //Based on excel sheet!
	void randTile(){
		int[] frequency = {12700,9060,8170,7510,6970,6750,6333,6090,5999,4250,
					4030,2780,2760,2410,2360,2230,2020,1970,1930,1490,980,770,150,
					150,100,70};
		String[] letters = {"E","T","A","O","I","N","S","H","R","D",
					"L","C","U","M","W","F","G","Y","P","B","V","K","J",
					"X","QU","Z"};
		int[] points  = {1,1,2,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4,4,5,5,7,7,8,8,};
		int totalFreq = 100032;
		int rand=(int)(Math.floor(totalFreq*Math.random()));
		int sum=0;
		Letter letter = new Letter("");
		for (int i=0; i<frequency.length;i++) {
				sum=sum+frequency[i];
				if(rand<sum){
					 letter = new Letter(letters[i]);
					 break;
				}
			}
			this.letter=letter;
		}
	
	//JavaDocs!
	Coordinates getCoordinates(){
		return coordinates;
	}

	//JavaDocs!
	public Letter getLetter() {
		return letter;
	}
	
	//JavaDocs!
	public boolean getIsActive(){
		return isActive;
	}

	

}
