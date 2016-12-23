package PlayerGUI;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;

import Common.Level;
import Common.Lightning;
import Common.Tile;

public class LightningApp extends LevelFrame{
	
	Timer timer;
	int remainingTime;
	
	//JavaDocs!
	public LightningApp(Lightning lightning, Timer timer) {
		super(lightning);
		this.timer = timer;
		title.setText("Lightning");
		puzzleThemeLightning.setText("Remaining Time: ");
		puzzleThemeLightningAttribute.setText(String.valueOf(lightning.getTime()));
	}
	
	//JavaDocs!
	@Override
	public void replacePanel(Level level) {
		for (int i=0;i<6;i++) {
			for (int j=0;j<6;j++) {

				Tile tile = level.getBoard().getTile(i, j);
				if (tile.getIsActive()) {
					tiles[i][j].setVisible(true);
					if (tile.hasLetter()) {
						tiles[i][j].setText(tile.recentLetter().toUpperCaseLetter());
					}
				}
				else {
					tiles[i][j].setVisible(false);
				}
			}
		}
		
		points.setText(String.valueOf(level.getCurrent().getPoints()));
		
		if (level.getCurrent().getStars() == 0) {
			Image image = new ImageIcon("image/StarsEmpty.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			stars.setIcon(new ImageIcon(image));
		}

		else if (level.getCurrent().getStars() == 1) {
			Image image = new ImageIcon("image/StarsOne.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			stars.setIcon(new ImageIcon(image));
		}

		else if (level.getCurrent().getStars() == 2) {
			Image image = new ImageIcon("image/StarsTwo.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			stars.setIcon(new ImageIcon(image));
		}

		else {
			Image image = new ImageIcon("image/StarsThree.png").getImage();
			image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
			stars.setIcon(new ImageIcon(image));
		}
		
		for (int i=0; i<6;i++) {
			for (int j=0; j<6; j++) {
				tiles[i][j].setBackground(Color.WHITE);
			}
		}
		
	}
	
	//JavaDocs!
	public JButton[][] getTiles() {
		return tiles;
	}

		
	public JButton getBack() {
		return goBack;
	}
	
	//JavaDocs!
	public void startRemainingTime() {
		Lightning lvl = (Lightning) level;
		remainingTime = lvl.getTime();
	}
	
	//JavaDocs!
	public void RemainigTime() {
		remainingTime--;
	}
	
	//JavaDocs
	public int getRemainingTime() {
		return remainingTime;
	}
	
	//JavaDocs!
	public Timer getTimer() {
		return timer;
	}

}
