package BuilderControllers;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import BuilderGUI.BuilderApp;
import Common.Builder;

/**
 * 
 * Controller for selecting which type of level
 * @author macbookair
 *
 */
public class SelectLevelTypeListener implements ItemListener{
	/**
	 *  The top level builder application 
	 *  (top level boundary class that can navigate to all stuff BuilderGUI)
	 */
    public BuilderApp builderApp;
	/**
	 * The top level builder model 
	 * (top level entity class that can navigate to all stuff Builder)
	 */
	public Builder builder;
	/**
	 * The index of the selected level 
	 */    
    protected int levelIndex;
    
	/**
	 * Adding functionality to the selectLevelType JComboBox in the MakeNewLevelGUI.
	 * @param builderApp 	 Top level application for builderGUI (boundaries) 
	 * @param builder		 Top level model for builder   
	 * @param levelIndex 	 The number associated with a level
	 */
    public SelectLevelTypeListener(BuilderApp builderApp, Builder builder, int levelIndex) {
        this.builderApp = builderApp;
        this.builder = builder;
        this.levelIndex = levelIndex;
    }
	
	public void itemStateChanged(ItemEvent e) {
		CardLayout cardLayout;
		String level;
		int rows, columns;
		//if not made yet, make it
		if (levelIndex==-1) {
			cardLayout = (CardLayout) (builderApp.getMakeNewLevel().getPanels().getLayout());
			cardLayout.show(builderApp.getMakeNewLevel().getPanels(), (String)e.getItem());
			level = (String) e.getItem();
			builderApp.getMakeNewLevel().setLevelType(level);
			//if its lightning or puzzle
			
	        if (level.equals("Lightning")||level.equals("Puzzle")) {
				for (rows=0;rows<6;rows++) {
					for (columns=0;columns<6;columns++) {
						builderApp.getMakeNewLevel().getTiles()[columns][rows].setBounds(60*columns, 60*rows, 60, 60);
						builderApp.getMakeNewLevel().getLetters()[columns][rows].setVisible(false);
					}
				}
			}
	        //if its theme
			else {
				for (rows=0;rows<6;rows++) {
					for (columns=0;columns<6;columns++) {
						builderApp.getMakeNewLevel().getTiles()[columns][rows].setBounds(60*columns, 60*rows, 60, 60);
						if (builderApp.getMakeNewLevel().getTiles()[columns][rows].getBackground().equals(Color.WHITE)) {
							
							builderApp.getMakeNewLevel().getTiles()[columns][rows].setBounds(60*columns, 60*rows, 60, 30);
							builderApp.getMakeNewLevel().getLetters()[columns][rows].setVisible(true);
						}
					}
				}
			}
		}
		
		//If it exists, edit
		else {
			
			cardLayout = (CardLayout) (builderApp.getEditLevels().get(levelIndex).getPanels().getLayout());
			cardLayout.show(builderApp.getEditLevels().get(levelIndex).getPanels(), (String)e.getItem());
			level = (String) e.getItem();
			builderApp.getEditLevels().get(levelIndex).setLevelType(level);
			//if its lightning or puzzle
			
	        if (level.equals("Lightning")||level.equals("Puzzle")) {
				for (rows=0;rows<6;rows++) {
					for (columns=0;columns<6;columns++) {
						
						builderApp.getEditLevels().get(levelIndex).getTileArray()[columns][rows].setBounds(60*columns, 60*rows, 60, 60);
						builderApp.getEditLevels().get(levelIndex).getLetters()[columns][rows].setVisible(false);
					}
				}
			}
	        //if its theme
	        
			else {
				for (rows=0;rows<6;rows++) {
					for (columns=0;columns<6;columns++) {
						builderApp.getEditLevels().get(levelIndex).getTileArray()[columns][rows].setBounds(60*columns, 60*rows, 60, 60);
						
						if (builderApp.getEditLevels().get(levelIndex).getTileArray()[columns][rows].getBackground().equals(Color.WHITE)) {
							
							builderApp.getEditLevels().get(levelIndex).getTileArray()[columns][rows].setBounds(60*columns, 60*rows, 60, 30);
							builderApp.getEditLevels().get(levelIndex).getLetters()[columns][rows].setVisible(true);
						}
					}
				}
			}
		}	
	}
}