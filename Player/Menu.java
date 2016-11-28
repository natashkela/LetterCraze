package Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu {

	ArrayList<ArrayList<Level>> levels;//creates list of levels which is going to hold levels
	//in that category, theme along with 5 theme levels...
	
	public Menu(){
		this.levels = new ArrayList<ArrayList<Level>>(3);//three types of level
		//puzzle,lightening, theme which holds array list of levels inside them
	}
	
	public ArrayList<ArrayList<Level>> getLevels(){
		return this.levels;
	}

	public boolean setLevels(ArrayList<ArrayList<Level>> input){
		this.levels = input;
		return true;
	}
	
	//adds the level to the menu, if its not compatible then return false
	public boolean addLevel(Level input){
		if (input == null){
			return false;
		}
		else{
			if (input instanceof Lightening){//if its lightening then create Arraylist of levels
				ArrayList<Level> LighteningLevels = this.levels.get(0);
				LighteningLevels.add(input);
				return true;
			}
			else if (input instanceof Theme){
				ArrayList<Level> ThemeLevels = this.levels.get(1);
				ThemeLevels.add(input);
				return true;
			}
			else if (input instanceof Puzzle){
				ArrayList<Level> puzzleLevels = this.levels.get(2);
				puzzleLevels.add(input);
				return true;
			}
			else{	
				return false;
			}
		}
	}
	
	//how to remove level??? 
}