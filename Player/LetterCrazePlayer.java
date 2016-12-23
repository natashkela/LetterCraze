package Player;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import javax.swing.UIManager;

import Common.Level;
import Common.Model;
import PlayerControllers.BackMainMenuController;
import PlayerControllers.CustomLevelsListener;
import PlayerControllers.PlayCustomLevelListener;
import PlayerControllers.ResetListener;
import PlayerControllers.SubmitWordListener;
import PlayerControllers.TileListener;
import PlayerControllers.UndoListener;
import PlayerGUI.PlayerApp;

public class LetterCrazePlayer {
	public PlayerApp playerApp;
	public static Model model;

	/**
	 * Run the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LetterCrazePlayer window = new LetterCrazePlayer();
					window.playerApp.setVisible(true);
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Make the application.
	 */
	public LetterCrazePlayer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializeModel();
		initializeBoundary();
		initializeController();
	}

	/**
	 * Initialize the entity objects.
	 */
	private void initializeModel() {
		model = new Model();
		try {
			FileInputStream file = new FileInputStream("playersave.ser");
			ObjectInputStream fl = new ObjectInputStream(file);
			model = ((Model) fl.readObject());
			fl.close();
			file.close();
		}
		catch(IOException i) {
			//i.printStackTrace();
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		try {
			FileInputStream file1 = new FileInputStream("build.ser");
			ObjectInputStream fl1 = new ObjectInputStream(file1);
			model.importCustomLevels(((LinkedList<Level>) fl1.readObject()));
			fl1.close();
			file1.close();
		}
		catch(IOException i) {
			//i.printStackTrace();
			return;
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			return;
		}
	}


	/**
	 * Getter method for model.
	 */
	public Model getModel() {
		return model;
	}


	/**
	 * Initialize the boundary objects.
	 */
	private void initializeBoundary() {
		playerApp = new PlayerApp(model);
	}


	/**
	 * Getter method for application.
	 */
	public PlayerApp getApp() {
		return playerApp;
	}

	/**
	 * Initialize the controllers.
	 */
	private void initializeController() {
		
		// get from menu to custom levels
		playerApp.getStartPlayer().getPlayLevel().addActionListener(new CustomLevelsListener(playerApp, model));
				
		// get from custom levels to menu
		playerApp.getViewCustomLevels().getBackButton().addActionListener(new BackMainMenuController(playerApp, model));

		// get from Custom Level map to any unlocked level
		int numCustomLevels = model.getCustomLevels().size();
		for (int i = 0; i < numCustomLevels && i < 15; i++) {
			playerApp.getViewCustomLevels().getLevelButtons().get(i).addActionListener(new PlayCustomLevelListener(playerApp, model, i));
		}

		// exit from any custom level to Custom Level Map
		for (int i = 0; i < numCustomLevels; i++) {
			playerApp.getCustomLevel().get(i).getGoBack().addActionListener(new CustomLevelsListener(playerApp, model));
		}


		// set controllers for square buttons in customLevelApplications
		for (int i=0;i<numCustomLevels;i++) {
					for (int y = 0; y < 6; y++) {
						for (int x = 0; x < 6; x++) {
							playerApp.getCustomLevel().get(i).getTiles()[x][y].addActionListener(new TileListener(playerApp.getCustomLevel().get(i), model.getCustomLevels().get(i), i, x, y));
						}
					}
				}

		// set controllers for add word buttons in custom LevelApplications
		for (int i=0;i<numCustomLevels; i++) {
			playerApp.getCustomLevel().get(i).getSelect().addActionListener(new SubmitWordListener(playerApp, playerApp.getViewCustomLevels(), playerApp.getCustomLevel().get(i), model.getCustomLevels().get(i)));
		}

		// set controllers for reset buttons on custom levels
		for (int i=0;i<numCustomLevels;i++) {
			playerApp.getCustomLevel().get(i).getReset().addActionListener(new ResetListener(playerApp.getCustomLevel().get(i), model.getCustomLevels().get(i)));
		}

		// set controllers for undo buttons on custom levels
		for (int i=0;i<numCustomLevels; i++) {
			playerApp.getCustomLevel().get(i).getUndo().addActionListener(new UndoListener(playerApp, playerApp.getCustomLevel().get(i), model.getCustomLevels().get(i)));
		}
				
	}


}
