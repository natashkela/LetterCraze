package BuilderGUI;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import BuilderControllers.SplashTimer;
import Common.Builder;
import java.awt.Color;

public class BuilderApp extends JFrame{
	
	//JavaDocs for all attributes!
	Builder build;
	SplashScreen splash;
	StartBuilder startBuilder;
	MakeNewLevel makeNewLevel;
	SavedLevels savedLevels;
	LinkedList<EditLevels> editLevels;
	/**
	 * for how many seconds should we show splashscreen
	 */
	int timeforsplash;
	Timer timer;
	
	public BuilderApp(Builder build) {
		getContentPane().setBackground(Color.RED);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				int select=JOptionPane.showConfirmDialog(null, "Are you sure you want to exit Builder?\n","", JOptionPane.YES_NO_OPTION);
				if (select==JOptionPane.YES_OPTION) {
					try {
						FileOutputStream file = new FileOutputStream("build.ser");
						ObjectOutputStream fl = new ObjectOutputStream(file);
						fl.writeObject(build.getLevels());
						fl.close();
						file.close();
					}
					catch(IOException io) {
						io.printStackTrace();
					}
					dispose();
					System.exit(0);
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setTitle("BuilderApp");
		this.build = build;
		
		// initialize views
		splash = new SplashScreen(build);
		startBuilder = new StartBuilder(build);
		makeNewLevel = new MakeNewLevel(build);
		savedLevels = new SavedLevels(build);
		editLevels = new LinkedList<EditLevels>();
		
		for (int i=0;i<15;i++) {
			editLevels.add(new EditLevels(build, i));
		}
		
		timeforsplash = 3;  
        timer=new Timer(1350, new SplashTimer(this, this.build));
        timer.start();
		this.setContentPane(splash);
		
	}
	//JavaDocs!
	public int getTimeForSplash() {
		return timeforsplash;
	}
	//JavaDocs!
	public Timer getTimer() {
		return timer;
	}
	//JavaDocs!
	public void TimeForSplash() {
		timeforsplash--;
	}
	//JavaDocs!
	public StartBuilder getStartBuilder() {
		return startBuilder;
	}
	//JavaDocs!
	public MakeNewLevel getMakeNewLevel() {
		return makeNewLevel;
	}
	//JavaDocs!
	public SavedLevels getSavedLevels() {
		return savedLevels;
	}
	//JavaDocs!
	public LinkedList<EditLevels> getEditLevels() {
		return editLevels;
	}
	public SplashScreen getSplash(){
		return splash;
	}

}
