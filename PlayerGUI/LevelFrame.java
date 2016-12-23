package PlayerGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import javax.swing.JScrollPane;

import Common.Level;
import Common.Tile;
import javax.swing.UIManager;


public abstract class LevelFrame extends JPanel{
	
	Stack<JButton> activebtn;
	JButton goBack;
	//JavaDocs!
	Level level;
	DefaultListModel<String> list; 
	JLabel points;
	JLabel puzzleThemeLightning;
	JLabel puzzleThemeLightningAttribute; 
	JButton reset;
	JScrollPane scrollPane;
	JButton select;
	JLabel stars;
	JButton[][] tiles;
	JLabel title;
	JButton undo;
	JList<String> wordsFound;
	
	
	//JavaDocs!
	public LevelFrame(Level level) {
		this.level=level;
		setBounds(0,0,800,600);
		this.setLayout(null);
		
		JPanel leftSide = new JPanel();
		leftSide.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		leftSide.setBounds(0, 0, 600, 600);
		leftSide.setLayout(null);
		add(leftSide);
		
		JPanel rightSide = new JPanel();
		rightSide.setBackground(UIManager.getColor("Button.light"));
		rightSide.setBounds(600, 0, 200, 600);
		rightSide.setLayout(null);
		
		title = new JLabel("");
		title.setFont(new Font("Chalkboard SE", Font.BOLD, 25));
		title.setBounds(6, 50, 588, 29);
		leftSide.add(title);
		
		// create 36 squareButtons
		tiles = new JButton[6][6];
		for (int row=0;row<6;row++) {
			for (int col=0; col<6; col++) {
				JButton btn = new JButton();
				btn.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
				btn.setBounds(120+(col*60), 120+(row*60), 60, 60);
				btn.setOpaque(true);
				btn.setBorderPainted(false);
				btn.setBackground(Color.WHITE);
				tiles[col][row] = btn;
				leftSide.add(btn);
			}
		}
		
		goBack = new JButton("Go Back");
		goBack.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		goBack.setBounds(6, 20, 91, 29);
		leftSide.add(goBack);
		
		stars=new JLabel();
		stars.setBounds(480, 537, 81, 27);
		Image image = new ImageIcon("image/StarsEmpty.png").getImage();
		image = image.getScaledInstance(80, 30, java.awt.Image.SCALE_SMOOTH);
		stars.setIcon(new ImageIcon(image));
		leftSide.add(stars);

		select = new JButton("Add word");
		select.setFont(new Font("Chalkboard SE", Font.PLAIN, 13));
		select.setBounds(484, 20, 110, 29);
		leftSide.add(select);
		
		add(rightSide);
		
		reset = new JButton("Reset");
		reset.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		reset.setBounds(124, 402, 70, 29);
		rightSide.add(reset);
		
		undo = new JButton("Undo");
		undo.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		undo.setBounds(0, 402, 70, 29);
		rightSide.add(undo);
		
		puzzleThemeLightning = new JLabel("");
		puzzleThemeLightning.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		puzzleThemeLightning.setBounds(6, 40, 188, 16);
		rightSide.add(puzzleThemeLightning);
		
		list = new DefaultListModel<String>();
		wordsFound = new JList<String>(list);
		wordsFound.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		
		JLabel lblwordsFound = new JLabel("Words Found: ");
		lblwordsFound.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		lblwordsFound.setBounds(6, 6, 170, 16);
		lblwordsFound.add(wordsFound);
		
		scrollPane = new JScrollPane(wordsFound);
		scrollPane.setViewportView(wordsFound);
		scrollPane.setBounds(7, 30, 170, 360);
		rightSide.add(scrollPane);
		
		puzzleThemeLightningAttribute = new JLabel("0");
		puzzleThemeLightningAttribute.setBounds(163, 479, 13, 29);
		puzzleThemeLightningAttribute.setFont(new Font("Chalkboard SE", Font.PLAIN, 25));
		rightSide.add(puzzleThemeLightningAttribute);
		
		points = new JLabel("0");
		points.setBounds(7, 485, 9, 21);
		points.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		rightSide.add(points);
		
		activebtn = new Stack<JButton>();
	}
	
	
	
	//JavaDocs!
	public void addToPTLA(int toAdd) {
		int points = Integer.parseInt(puzzleThemeLightningAttribute.getText());
		int newPoints = (points + toAdd);
		puzzleThemeLightningAttribute.setText(String.valueOf(newPoints));
	}
	
	//JavaDocs!
	public void clearList() {
		list.clear();
	}
	//JavaDocs!
	public Stack<JButton> getActiveButtons() {
		return activebtn;
	}
		
	//JavaDocs!
	public JButton getGoBack() {
		return goBack;
	}	
		
	//JavaDocs!
	public Level getLevel() {
		return level;
	}
		
	//JavaDocs!
	public DefaultListModel<String> getList() {
		return list;
		}
		
	//JavaDocs!
	public JLabel getPTL() {
		return puzzleThemeLightningAttribute;
	}
		
	
	//JavaDocs!
	public int getPTLA() {
		return Integer.parseInt(puzzleThemeLightningAttribute.getText());
	}
	
	//JavaDocs!
	public JButton getReset() {
		return reset;
	}
	
	//JavaDocs!
	public JButton getSelect() {
		return select;
	}
	
	//JavaDocs!
	public JButton[][] getTiles() {
		return tiles;
	}

	//JavaDocs!
	public JButton getUndo() {
		return undo;
	}
	
	//JavaDocs!
	public void increasePTLA() {
		puzzleThemeLightningAttribute.setText(String.valueOf(Integer.valueOf(puzzleThemeLightningAttribute.getText())+1));
	}
		
	//JavaDocs!
	public JButton peekActive() {
		return activebtn.peek();
	}
	
	//JavaDocs!
	public JButton popActive() {
		return activebtn.pop();
	}
	
	//JavaDocs!
	public void pushActive(JButton btn) {
		activebtn.push(btn);
	}

	//JavaDocs!
	public void replacePanel(Level level) {
		for (int row=0;row<6; row++) {
			for (int col=0; col<6; col++) {
				Tile tile = level.getBoard().getTile(col, row);
				
				if (!tile.getIsActive()) {
					tiles[col][row].setVisible(false);
				}
				else {
					tiles[col][row].setVisible(true);
					if (tile.hasLetter()) {
						tiles[col][row].setText(tile.recentLetter().toUpperCaseLetter());
					} else {
						tiles[col][row].setText("");
					}
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
		
		for (int col=0;col<6;col++) {
			for (int row= 0; row<6; row++) {
				tiles[col][row].setBackground(Color.WHITE);
			}
		}
	}

	//JavaDocs!
	public void resetPTLA(int reset) {
		puzzleThemeLightningAttribute.setText(String.valueOf(reset));
	}
	
	//JavaDocs!
	public void unselect() {
		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				tiles[i][j].setBackground(Color.WHITE);
			}
		}
	}
}
