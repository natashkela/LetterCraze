package Builder;

import Player.Menu;

public class Model {
	Menu menu;
	
	public Model(){
		this.menu = new Menu();//create new menu for the model
	}
	
	public Menu getMenu(){
		return this.menu;
	}
	
	//set and return true if set, if not false
	public boolean setMenu(Menu input){
		this.menu = input;
		return true;
	}
}
