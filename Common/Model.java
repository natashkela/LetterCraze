package Common;

import java.io.Serializable;
import java.util.LinkedList;


public class Model implements Serializable {

	
	//JavaDoc
	LinkedList<Level> customLevels; 
	
	/** Creates default levels and organizes them into a Map. */
	public Model() {		
		customLevels = new LinkedList<Level>();
	}

	/** Looks for custom level files, creates Level objects, adds them to list 
	 * 
	 * @param linkedList       ArrayList of LevelModels to be imported
	 */
	public void importCustomLevels(LinkedList<Level> linkedList) {

		customLevels = linkedList;
		int numCustomLevels = customLevels.size();
		for (int i = 0; i < numCustomLevels; i++) {
			customLevels.get(i).unlocked = true;
		}
	}

	/** Gets all Custom Levels for Custom Map.  */
	public LinkedList<Level> getCustomLevels() {
		return customLevels;
	}

}

