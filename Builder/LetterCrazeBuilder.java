package Builder;
import java.awt.EventQueue;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import BuilderControllers.EditLevelListener;
import BuilderControllers.FileManager;
import BuilderControllers.LevelListener;
import BuilderControllers.ViewNewLevelListener;
import BuilderControllers.ViewSavedLevels;
import BuilderControllers.PreviewListener;
import BuilderControllers.RemoveLevelListener;
import BuilderControllers.RemoveWordListener;
import BuilderControllers.SaveListener;
import BuilderControllers.SelectLevelTypeListener;
import BuilderControllers.SubmitWordListener;
import BuilderControllers.ViewBuilder;
import BuilderControllers.ViewEditLevelListener;
import BuilderGUI.BuilderApp;
import Common.Builder;
import Common.Level;

/**
 * 
 * LetterCrazeBuilder is an application for adding,editing and deleting levels
 * which are used it LetterCrazePlayer
 *
 */
public class LetterCrazeBuilder {
	private static Builder builder;
	/**
	 * Builder Main Method
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LetterCrazeBuilder window = new LetterCrazeBuilder();
					window.builderApp.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private BuilderApp builderApp;

	/**
	 * Initializing Builder
	 * 
	 */
	public LetterCrazeBuilder() {
		initialize();
	}

	/**
	 * 
	 * Initializing EBCs
	 */

	private void initialize() {
		initializeModel();
		initializeBoundary();
		initializeController();
	}

	/**
	 * 
	 * Initializing Boundaries
	 */
	private void initializeBoundary() {
		this.builderApp = new BuilderApp(builder);
	}

	/**
	 * Initializing Controllers.
	 */
	private void initializeController() {
		builderApp.getSavedLevels().getBack().addActionListener(new ViewBuilder(builderApp, builder));
		builderApp.getStartBuilder().getNewLevel().addActionListener(new ViewNewLevelListener(builderApp, builder));
		builderApp.getMakeNewLevel().getSaveButton().addActionListener(new SaveListener(builderApp, builder, -1 , builderApp.getMakeNewLevel()));
		builderApp.getMakeNewLevel().getGoBackButton().addActionListener(new ViewBuilder(builderApp, builder));
		builderApp.getSavedLevels().getSave().addActionListener(new FileManager(builderApp, builder));
		builderApp.getStartBuilder().getEdit().addActionListener(new ViewSavedLevels(builderApp, builder));
		
		for (int i=0; i<15; i++) {
			builderApp.getEditLevels().get(i).getGoBack().addActionListener(new ViewSavedLevels(builderApp, builder));
		}
		
		for (int i=0;i<15;i++) {
			builderApp.getSavedLevels().getLevel().get(i).addActionListener(new ViewEditLevelListener(builderApp, builder, i));
		}
		
		for (int i=0; i<15; i++) {
			builderApp.getEditLevels().get(i).getSaveLevel().addActionListener(new EditLevelListener(builderApp, builder, builderApp.getEditLevels().get(i), i));
		}
		
		for (int i=0;i<15;i++) {
			builderApp.getEditLevels().get(i).getSelectLevelType().addItemListener((ItemListener) new SelectLevelTypeListener(builderApp, builder, i));
		}
		builderApp.getMakeNewLevel().getSelectLevelType().addItemListener((ItemListener) new SelectLevelTypeListener(builderApp, builder, -1));

		for (int i=0;i<15;i++) {
			builderApp.getSavedLevels().getDelete().get(i).addActionListener(new RemoveLevelListener(builderApp, builder, i));
		}
		
		for (int i=0; i<15; i++) {
			builderApp.getEditLevels().get(i).getAddWord().addActionListener(new SubmitWordListener(builderApp, builder, i));
		}
		builderApp.getMakeNewLevel().getSubmitWordButton().addActionListener(new SubmitWordListener(builderApp, builder, -1));
		
		for (int i=0; i<15; i++) {
			builderApp.getEditLevels().get(i).getDeleteWord().addActionListener(new RemoveWordListener(builderApp, builder, i));
		}
		builderApp.getMakeNewLevel().getRemoveWordButton().addActionListener(new RemoveWordListener(builderApp, builder, -1));
		
		for (int i=0;i<15;i++) {
			builderApp.getEditLevels().get(i).getPreview().addActionListener(new PreviewListener(builderApp, builder, i));
		}
		builderApp.getMakeNewLevel().getPreviewButton().addActionListener(new PreviewListener(builderApp, builder, -1));

		
		for (int row=0;row<6;row++) {
			for (int col=0; col<6; col++) {
				JButton button = builderApp.getMakeNewLevel().getTiles()[col][row];
				JTextField text = builderApp.getMakeNewLevel().getLetters()[col][row];
				button.addActionListener(new LevelListener(builderApp, builder, button, text, -1));
			}
		}
		
		for (int i=0; i<15;i++) {
			for (int  row=0;row<6; row++) {
					for (int col=0;col<6;col++) {
						JButton button = builderApp.getEditLevels().get(i).getTileArray()[col][row];
						JTextField text = builderApp.getEditLevels().get(i).getLetters()[col][row];
						button.addActionListener(new LevelListener(builderApp, builder, button, text, i));
				}
			}
		}

	}

	/**
	 * Initialize Entities
	 * 
	 */
	private void initializeModel() {
		builder = new Builder();
		try {
			FileInputStream file = new FileInputStream("build.ser");
			ObjectInputStream fl = new ObjectInputStream(file);
			LinkedList<Level> levelList = (LinkedList<Level>) (fl.readObject());
			builder.setLevels(levelList);
			fl.close();
			file.close();
		}
		catch(IOException io) {
			return;
		}
		catch(ClassNotFoundException cnfe) {
			return;
		}
	}

}
