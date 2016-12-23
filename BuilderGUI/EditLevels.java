package BuilderGUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Common.Builder;
import Common.Model;
import Common.Lightning;
import Common.Level;
import Common.Coordinates;
import Common.Puzzle;
import Common.Tile;
import Common.Theme;
import Common.Letter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * The containing Frame for editing a saved level.
 */

public class EditLevels extends JPanel {
	//JavaDocs for every attribute!
	Builder builder;
	JPanel panels;
	JButton goBack;
	JButton addWord; //why is this used? Where is are the level type panels being used
	JButton deleteWord;
	JButton saveLevel;
	JButton[][] tileArray;
	JButton preview;
	JTextField[][] letters;
	JComboBox selectLevelType;
	JSpinner time;
	JSpinner maxMoves;
	JSpinner starThresh1;
	JSpinner starThresh2;
	JSpinner starThresh3;
	JTextField inputWord;
	JTextField theme;
	JLabel levelNameLabel;
	JList words;
	DefaultListModel<String> listModel;
	String levelType;
	int level;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

	public EditLevels(Builder build, int level) {
		setBackground(Color.RED);

		this.builder = build;
		this.level = level;

		setLayout(null);
		setBounds(0, 0, 800, 600);

		tileArray = new JButton[6][6];
		letters = new JTextField[6][6];
		
		levelType = "Puzzle";
		goBack = new JButton("Go Back");
		goBack.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		goBack.setBounds(34, 79, 91, 29);

		JPanel boardTiles = new JPanel();
		boardTiles.setBounds(137, 127, 360, 360);
		this.add(boardTiles);
		boardTiles.setLayout(null);

		for (int c=0; c<tileArray.length; c++) {
			for (int r=0; r<tileArray[c].length; r++) {
				tileArray[c][r] = new JButton(" ");
				tileArray[c][r].setOpaque(true);
				tileArray[c][r].setBounds(60*c, 60*r, 60, 60);
				boardTiles.add(tileArray[c][r]);
				letters[c][r] = new JTextField();
				
				//MAYBE WE DO NOT NEED THIS!!!! (Nata)
				
				
				
			//	letters[c][r].setModel(new DefaultComboBoxModel(new String[] 
			//			{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
			//					"L", "M", "N", "O", "P", "QU", "R", "S", "T", "U", 
			//					"V", "W", "X", "Y", "Z"}));
			//	letters[c][r].setMaximumRowCount(10);
				letters[c][r].setBounds(60*c, 60*r+30, 60, 30);
				letters[c][r].setOpaque(true);
				letters[c][r].setBackground(Color.WHITE);
				letters[c][r].setVisible(false);
				boardTiles.add(letters[c][r]);
			}
		}
		
		this.add(goBack);
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 0, 0));
		panel1.setBounds(600, 0, 200, 600);
		this.add(panel1);
		panel1.setLayout(null);

		panels = new JPanel();
		panels.setBounds(0, 157, 200, 421);
		panel1.add(panels);
		panels.setLayout(new CardLayout(0, 0));

		JPanel puzzlepan = new JPanel();
		puzzlepan.setBackground(new Color(255, 0, 0));
		panels.add(puzzlepan, "Puzzle");
		puzzlepan.setLayout(null);

		JLabel maxMovesLabel = new JLabel("Moves Allowed:");
		maxMovesLabel.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		maxMovesLabel.setBounds(0, 36, 104, 22);
		puzzlepan.add(maxMovesLabel);

		maxMoves = new JSpinner();
		maxMoves.setFont(new Font("Chalkboard ES", Font.PLAIN, 15));
		maxMoves.setBounds(140, 33, 60, 28);
		maxMoves.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		puzzlepan.add(maxMoves);

		JPanel lightningpan = new JPanel();
		panels.add(lightningpan, "Lightning");
		lightningpan.setBackground(Color.RED);
		lightningpan.setLayout(null);

		JLabel timelbl = new JLabel("Time in Seconds:");
		timelbl.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		timelbl.setBounds(6, 6, 188, 16);
		lightningpan.add(timelbl);

		time = new JSpinner();
		time.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		time.setBounds(134, 34, 60, 28);
		time.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		lightningpan.add(time);

		JPanel themepan = new JPanel();
		panels.add(themepan, "Theme");
		themepan.setBackground(Color.RED);
		themepan.setLayout(null);

		JLabel themeLabel = new JLabel("Theme: ");
		themeLabel.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		themeLabel.setBounds(6, 6, 188, 16);
		themepan.add(themeLabel);

		theme = new JTextField();
		theme.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		theme.setBounds(6, 34, 188, 28);
		themepan.add(theme);
		theme.setColumns(10);

		JLabel lblWords = new JLabel("Words: ");
		lblWords.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		lblWords.setBounds(6, 75, 188, 16);
		themepan.add(lblWords);

		inputWord = new JTextField();
		inputWord.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		inputWord.setBounds(6, 103, 188, 28);
		themepan.add(inputWord);
		inputWord.setColumns(10);

		addWord = new JButton("Add");
		addWord.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		addWord.setBounds(6, 135, 90, 29);
		themepan.add(addWord);

		deleteWord = new JButton("Delete");
		deleteWord.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		deleteWord.setBounds(108, 135, 86, 29);
		themepan.add(deleteWord);

		listModel = new DefaultListModel();
		words = new JList(listModel);
		words.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		words.setBorder(new LineBorder(Color.LIGHT_GRAY));
		words.setBounds(6, 172, 188, 218);
		themepan.add(words);

		selectLevelType = new JComboBox();
		selectLevelType.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		selectLevelType.setModel(new DefaultComboBoxModel(new String[] 
				{"Puzzle", "Lightning", "Theme"}));
		selectLevelType.setBounds(0, 24, 188, 27);
		selectLevelType.setMaximumRowCount(3);
		panel1.add(selectLevelType);

		JLabel gameType = new JLabel("Select Your Game Type!");
		gameType.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		gameType.setBounds(0, 0, 188, 27);
		panel1.add(gameType);
		
		JLabel starThresh1Label = new JLabel("First Threshold");
		starThresh1Label.setBounds(0, 72, 112, 16);
		panel1.add(starThresh1Label);
		starThresh1Label.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		

		starThresh1 = new JSpinner();
		starThresh1.setBounds(133, 66, 60, 28);
		panel1.add(starThresh1);
		starThresh1.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		starThresh1.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		
		JLabel starThresh2Label = new JLabel("Second Threshold");
		starThresh2Label.setBounds(0, 99, 119, 22);
		panel1.add(starThresh2Label);
		starThresh2Label.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		
		JLabel starThresh3Label = new JLabel("Third Threshold");
		starThresh3Label.setBounds(0, 132, 112, 16);
		panel1.add(starThresh3Label);
		starThresh3Label.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		
		starThresh2 = new JSpinner();
		starThresh2.setBounds(133, 93, 60, 28);
		panel1.add(starThresh2);
		starThresh2.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		starThresh2.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		
		starThresh3 = new JSpinner();
		starThresh3.setBounds(133, 119, 60, 29);
		panel1.add(starThresh3);
		starThresh3.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		starThresh3.setModel(new SpinnerNumberModel(0, 0, 10000, 1));									

		saveLevel = new JButton("Save Level");
		
		/* I DO NOT THINK WE NEED THIS IF ERROR UNCOMMMENT AND SEE!
		saveLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		*/
		saveLevel.setFont(new Font("Dialog", Font.PLAIN, 14));
		saveLevel.setBounds(427, 519, 111, 29);
		add(saveLevel);

		levelNameLabel = new JLabel("");
		levelNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		levelNameLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		levelNameLabel.setBounds(259, 20, 147, 49);
		add(levelNameLabel);

		JLabel lblLevelYouAre = new JLabel("Choose Board Layout!");
		lblLevelYouAre.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		lblLevelYouAre.setBounds(245, 90, 200, 16);
		add(lblLevelYouAre);

		preview = new JButton("Preview");
		preview.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		preview.setBounds(50, 522, 105, 26);
		add(preview);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EditLevels.class.getResource("/Common/starsmll.png")));
		lblNewLabel.setBounds(564, 67, 35, 26);
		add(lblNewLabel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(EditLevels.class.getResource("/Common/starsmll.png")));
		label.setBounds(531, 100, 35, 26);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(EditLevels.class.getResource("/Common/starsmll.png")));
		label_1.setBounds(564, 100, 35, 26);
		add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(EditLevels.class.getResource("/Common/starsmll.png")));
		label_2.setBounds(499, 127, 30, 26);
		add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(EditLevels.class.getResource("/Common/starsmll.png")));
		label_3.setBounds(531, 127, 30, 26);
		add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(EditLevels.class.getResource("/Common/starsmll.png")));
		label_4.setBounds(564, 127, 35, 26);
		add(label_4);

	}
	
	//JavaDocs!
	public JPanel getPanels() {
		return panels;
	}

	//JavaDocs!
	public JButton getGoBack() {
		return goBack;
	}
	
	//JavaDocs!
	public JButton getAddWord() {
		return addWord;
	}

	//JavaDocs!
	public JButton getDeleteWord() {
		return deleteWord;
	}
	
	//JavaDocs!
	public JButton[][] getTileArray() {
		return tileArray;
	}

	//JavaDocs!
	public JButton getSaveLevel() {
		return saveLevel;
	}
	
	//JavaDocs!
	public JButton getPreview() {
		return preview;
	}
	
	//JavaDocs!
	public JTextField[][] getLetters() {
		return letters;
	}

	//JavaDocs!
	public JComboBox getSelectLevelType() {
		return selectLevelType;
	}

	//JavaDocs!
	public JSpinner getTime() {
		return time;
	}

	//JavaDocs!
	public JSpinner getMaxMoves() {
		return maxMoves;
	}
	
	//JavaDocs!
	public void setLevelType(String type) {
		this.levelType = type;
	}

	//JavaDocs!
	public JTextField getTheme() {
		return theme;
	}

	//JavaDocs!
	public JTextField getInputWord() {
		return inputWord;
	}

	//JavaDocs!
	public JList getWords() {
		return words;
	}

	//JavaDocs!
	public JLabel getLevelNameLabel() {
		return levelNameLabel;	
	}
	
	//JavaDocs!
	public String getLevelType() {
		return levelType;
	}
	
	//JavaDocs!
	public DefaultListModel<String> getDefaultListModel() {
		return listModel;
	}
	
	//JavaDocs!
	public int[] getStarThreshsList() {
		int[] starThresh = new int[3];
		starThresh[0] = (int)starThresh1.getValue();
		starThresh[1] = (int)starThresh2.getValue();
		starThresh[2] = (int)starThresh3.getValue();
		return starThresh;
	}
	
	//JavaDocs!
	public void resetPanel() {
		Level lev = builder.getLevels().get(level);

		levelNameLabel.setText("Level " + String.valueOf(level+1));
		
		starThresh1.setValue(lev.getThresh().getThresh1());
		starThresh2.setValue(lev.getThresh().getThresh2());
		starThresh3.setValue(lev.getThresh().getThresh3());
		
		listModel.clear();

		if (lev.getLevelType().equals("Puzzle")) {
			selectLevelType.setSelectedIndex(0);
			maxMoves.setValue(((Puzzle)lev).getMaxWord());
		}
		
		else if (lev.getLevelType().equals("Lightning")) {
			selectLevelType.setSelectedIndex(1);
			time.setValue(((Lightning)lev).getTime());
		}
		
		else if (lev.getLevelType().equals("Theme")) {
			selectLevelType.setSelectedIndex(2);
			theme.setText(((Theme)lev).getTheme());
			LinkedList<String> wordList = ((Theme)lev).getThemeWords();
			for(int i=0;i<wordList.size();i++){
				listModel.addElement(wordList.get(i));
			}
		}
		
		for (int c=0; c<6; c++) {
			for (int r=0; r<6; r++) {
				if (lev.getBoard().getTile(c, r).getIsActive()) {
					tileArray[c][r].setBackground(Color.WHITE);
					tileArray[c][r].setBounds(60*c, 60*r, 60, 60);
					if (lev.getLevelType().equals("Theme")) {
						tileArray[c][r].setBounds(60*c, 60*r, 60, 30);
						letters[c][r].setVisible(true);
						letters[c][r].setText(lev.getBoard().getTile(c,r).recentLetter().getLetter().toUpperCase());
					}

				}
				else {
					tileArray[c][r].setBounds(60*c, 60*r, 60, 60);
					tileArray[c][r].setBackground(null);
					letters[c][r].setVisible(false);
					letters[c][r].setText("");
					if (lev.getLevelType().equals("Theme")) {
						letters[c][r].setText(lev.getBoard().getTile(c,r).recentLetter().getLetter().toUpperCase());
					}
				}
			}
		}
	}
}
