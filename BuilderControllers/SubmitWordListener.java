package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

import Common.*;
import BuilderGUI.BuilderApp;

/**
 * Controller class for the submit word button and how to handle actions upon it
 */
public class SubmitWordListener implements ActionListener {

	/**
	 * Holds level information for builder 
	 */
    public Builder builder;
	/**
	 * Top level boundary class for builder. 
	 */
    public BuilderApp builderApp;
	/**
	 * The index of the level to be edited. 
	 */
    int levelIndex;
    /**
     *  True if listModel contains the input word 
     */
    boolean containsWord;
    
    

	/**
	 * Constructor for functionality for submit word button
	 * @param builderApp	 Top level boundary class for builder
	 * @param builder   	 Contains a list of saved levels
	 * @param levelIndex	 The index number of level
	 */
    
    public SubmitWordListener(BuilderApp builderApp, Builder builder, int levelIndex) {
        this.builder = builder;
        this.builderApp = builderApp;
        this.levelIndex = levelIndex;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
	    DefaultListModel<String> list;
	    JTextField inputWord;
	    
	    /*
	     * Level is not made yet. Create it  
	     */
		if (levelIndex == -1) {
			
			list = builderApp.getMakeNewLevel().getDefaultListModel();
			inputWord = builderApp.getMakeNewLevel().getWordInput();
			containsWord = list.contains(inputWord.getText().toUpperCase());
			
			if (inputWord.getText().length()>2&&!containsWord) {
				
				list.addElement(inputWord.getText().toUpperCase());
				inputWord.setText("");
			}
		}
		/*
		 * Edit Level 
		 */
		else {
			
			list = builderApp.getEditLevels().get(levelIndex).getDefaultListModel();
			inputWord = builderApp.getEditLevels().get(levelIndex).getInputWord();
			containsWord = list.contains(inputWord.getText().toUpperCase());
			
			if (inputWord.getText().length()>2&&!containsWord) {
				
				list.addElement(inputWord.getText().toUpperCase());
				inputWord.setText("");
			}
		}
		
	}
}

	