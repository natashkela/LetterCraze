package PlayerGUI;

import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Common.Level;
import Common.Lightning;
import Common.Model;
import Common.Puzzle;
import Common.Theme;
import PlayerControllers.CustomLightningTimerController;
import PlayerControllers.SplashTimer;

public class PlayerApp extends JFrame{

	CustomLevel custom;
	LinkedList<LevelFrame> customLevel;
	Timer lightningTimer;
	Model model;
	SplashScreen splash;
	Timer splashScreenTimer;
	int splashtime;
	StartPlayer startPlayer;


	public PlayerApp(Model model) {
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int select = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
				if (select == JOptionPane.YES_OPTION) {
					try {
						FileOutputStream file =
								new FileOutputStream("play.ser");
						ObjectOutputStream fl = new ObjectOutputStream(file);
						fl.writeObject(model);
						fl.close();
						file.close();
						FileOutputStream file1 = new FileOutputStream("build.ser");
						ObjectOutputStream fl1 = new ObjectOutputStream(file1);
						fl1.writeObject(model.getCustomLevels());
						fl1.close();
						file1.close();
						
					}
					catch(IOException i) {
						i.printStackTrace();
					}
					dispose();
					System.exit(0);
				}
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("LetterCraze Player");

		this.model = model;

		splash = new SplashScreen(model);
		startPlayer = new StartPlayer(model);
		custom = new CustomLevel(model);
		customLevel = new LinkedList<LevelFrame>();

		splashtime=2;
		splashScreenTimer = new Timer(1000, new SplashTimer(this, this.model));
		splashScreenTimer.start();
		this.setContentPane(splash);

		int numCustomLevels = model.getCustomLevels().size();
		for (int i = 0; i < numCustomLevels; i++) {
			Level level = model.getCustomLevels().get(i);
			if (level.getLevelType().equals("Puzzle")) {
				PuzzleApp puzzle = new PuzzleApp((Puzzle) level);
				puzzle.setName("customlevel" + (i+1));
				customLevel.add(puzzle);
			}
			else if (level.getLevelType().equals("Lightning")) {
				lightningTimer = new Timer(1000, new CustomLightningTimerController(this, this.model, i));
				LightningApp lightning = new LightningApp((Lightning) level, lightningTimer);
				lightning.setName("customlevel" + (i+1));
				customLevel.add(lightning);
			}
			else {
				ThemeApp theme = new ThemeApp((Theme) level);
				theme.setName("customlevel " + (i+1));
				customLevel.add(theme);
			}
		}
	}

	
	
	public Model getModel() {
		return model;
	}

	public Timer getSplashScreenTimer() {
		return splashScreenTimer;
	}

	public int getSplashTime() {
		return splashtime;
	}

	public StartPlayer getStartPlayer() {
		return startPlayer;
	}


	public CustomLevel getViewCustomLevels() {
		return custom;
	}
	
	public void decrementSplashTime() {
		splashtime--;
	}

	public LinkedList<LevelFrame> getCustomLevel() {
		return customLevel;
	}
}
