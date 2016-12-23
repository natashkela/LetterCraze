package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;

import Common.*;

import BuilderGUI.BuilderApp;

/**
 * Controller for Removing Word
 */
public class RemoveWordListener implements ActionListener {
	/**
	 *  Top level boundary class for builder 
	 */
    public BuilderApp builderApp;
	/**
	 * Contains info on saved levels for builder
	 */
	public Builder builder;
	/**
	 * The level index. 
	 */        
    int levelIndex;
    /**
     * the input word field is empty
     */
    boolean emptyInput;
    /**
     * the word list contains the word in the textField
     */
    boolean containsWord;

    /**
	 * Constructor for RemoveWordListener.
	 * @param builderApp  Top level boundary class for builder
	 * @param builder	  Contains info on saved levels for builder
	 * @param levelIndex index of the level to be removed
	 */ 
   public RemoveWordListener(BuilderApp builderApp, Builder builder, int levelIndex) {
        this.builderApp = builderApp;
        this.builder = builder;
        this.levelIndex = levelIndex;
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField inputWord;
	    DefaultListModel<String> list;
	    //Make new if does not exist
	    
		if (levelIndex == -1){
			
			inputWord = builderApp.getMakeNewLevel().getWordInput();
			list = builderApp.getMakeNewLevel().getDefaultListModel();
			emptyInput = inputWord.getText().isEmpty();
			containsWord = list.contains(inputWord.getText().toUpperCase());
			
			if (!emptyInput && containsWord) {
				list.removeElement(inputWord.getText().toUpperCase());
				inputWord.setText("");
			}
		}
		//if its there edit
		else {
			inputWord = builderApp.getEditLevels().get(levelIndex).getInputWord();
			list = builderApp.getEditLevels().get(levelIndex).getDefaultListModel();
		
			if (!emptyInput && containsWord) {
				list.removeElement(inputWord.getText().toUpperCase());
				inputWord.setText("");
			}	
		}
	}
}
