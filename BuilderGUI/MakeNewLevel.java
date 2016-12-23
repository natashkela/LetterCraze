package BuilderGUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import BuilderControllers.SelectLevelTypeListener;
import Common.Builder;
import javax.swing.ImageIcon;

public class MakeNewLevel extends JPanel {
	
	//JavaDocs for all Attributes!
	Builder build;
	JPanel panels; 
	JButton btnGoBack;
	JButton btnSubmitWord;
	JButton btnRemoveWord;
	JButton btnSave;
	JButton btnPreview;
	JButton[][] Tiles;
	String levelType; 
	JComboBox selectLevelType; 
	JTextField[][] Letters;
	JSpinner star1ThresholdSpnr;
	JSpinner star2ThresholdSpnr;
	JSpinner star3ThresholdSpnr;
	JSpinner maxMovesSpnr;
	JSpinner maxTimeSpnr;
	DefaultListModel<String> dlm; 
	JList Words; 
	JTextField wordInput; 
	JTextField themeInput;
	JLabel lblLevelName; 
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	
	//JavaDocs!
	public MakeNewLevel (Builder b) {
		setBackground(Color.RED);
		this.levelType = "Puzzle";
		this.build = b;
		
		setLayout(null);
		setBounds(0, 0, 800, 600);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		btnGoBack.setBounds(10, 11, 102, 37);
		this.add(btnGoBack);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBounds(68, 100, 360, 360);
		this.add(boardPanel);
		boardPanel.setLayout(null);

		Tiles = new JButton[6][6];
		Letters = new JTextField[6][6];

		for (int x = 0; x < Tiles.length; x++) {
			for (int y = 0; y < Tiles[x].length; y++) {
				Tiles[x][y] = new JButton(" ");
				Tiles[x][y].setOpaque(true);
				Tiles[x][y].setBounds(60*x, 60*y, 60, 60);
				Tiles[x][y].setFocusable(false);
				boardPanel.add(Tiles[x][y]);

				Letters[x][y] = new JTextField();
			//	String[] list = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "QU", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			//	JComboBox jcb = new JComboBox(list);
			//	jcb.setEditable(true);
				Letters[x][y].setBounds(60*x, 60*y+30, 60, 30);
				Letters[x][y].setOpaque(true);
				Letters[x][y].setBackground(Color.WHITE);
				Letters[x][y].setVisible(false);
				boardPanel.add(Letters[x][y]);

			}
		}


		JPanel levelInfoPanel = new JPanel(); 
		levelInfoPanel.setBackground(Color.RED);
		levelInfoPanel.setBounds(529, 0, 271, 600);
		this.add(levelInfoPanel);
		levelInfoPanel.setLayout(null);

		panels = new JPanel(); 
		panels.setBackground(Color.RED);
		panels.setBounds(0, 157, 261, 421);
		levelInfoPanel.add(panels);
		panels.setLayout(new CardLayout(0, 0)); 

		JPanel puzzle = new JPanel();
		puzzle.setBackground(Color.RED);
		panels.add(puzzle, "Puzzle");
		puzzle.setLayout(null);

		JLabel lblMaxMoves = new JLabel("Maximum Moves Allowed: ");
		lblMaxMoves.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		lblMaxMoves.setBounds(6, 6, 195, 16);
		puzzle.add(lblMaxMoves);

		maxMovesSpnr = new JSpinner();
		maxMovesSpnr.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		maxMovesSpnr.setBounds(16, 33, 60, 28);
		maxMovesSpnr.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		puzzle.add(maxMovesSpnr);

		JPanel lightning = new JPanel();
		lightning.setBackground(Color.RED);
		panels.add(lightning, "Lightning");
		lightning.setLayout(null);

		JLabel lblMaxTime = new JLabel("Max Time Allowed (seconds):");
		lblMaxTime.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		lblMaxTime.setBounds(6, 6, 245, 16);
		lightning.add(lblMaxTime);

		maxTimeSpnr = new JSpinner();
		maxTimeSpnr.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		maxTimeSpnr.setBounds(16, 33, 60, 28);
		maxTimeSpnr.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		lightning.add(maxTimeSpnr);

		JPanel theme = new JPanel();
		theme.setBackground(Color.RED);
		panels.add(theme, "Theme");
		theme.setLayout(null);

		JLabel lblTheme = new JLabel("Theme: ");
		lblTheme.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		lblTheme.setBounds(6, 6, 188, 16);
		theme.add(lblTheme);

		themeInput = new JTextField(); 
		themeInput.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		themeInput.setBounds(6, 25, 245, 28);
		theme.add(themeInput);
		themeInput.setColumns(10);

		JLabel lblWords = new JLabel("Words: ");
		lblWords.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		lblWords.setBounds(6, 64, 188, 16);
		theme.add(lblWords);

		wordInput = new JTextField(); 
		wordInput.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		wordInput.setBounds(6, 85, 245, 28);
		theme.add(wordInput);
		wordInput.setColumns(10);
		
		btnSubmitWord = new JButton("Submit Word");
		btnSubmitWord.setFont(new Font("Chalkboard SE", Font.BOLD, 13));
		btnSubmitWord.setBounds(6, 121, 119, 29);
		theme.add(btnSubmitWord);

		btnRemoveWord = new JButton("Remove Word");
		btnRemoveWord.setFont(new Font("Chalkboard SE", Font.BOLD, 12));
		btnRemoveWord.setBounds(135, 121, 116, 29);
		theme.add(btnRemoveWord);

		dlm = new DefaultListModel<String>(); 
		Words = new JList(dlm); 
		Words.setFont(new Font("Chalkboard SE", Font.PLAIN, 12));
		Words.setBounds(6, 158, 245, 252);
		theme.add(Words);


		selectLevelType = new JComboBox(); 
		selectLevelType.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		selectLevelType.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Theme"}));
		selectLevelType.setMaximumRowCount(3);
		selectLevelType.setBounds(6, 34, 230, 27);
		//selectLevelType.addItemListener(new SelectLevelTypeListener(builderapp, build, levelNum));
		levelInfoPanel.add(selectLevelType); 

		JLabel lblLevelType = new JLabel("Level Type:"); 
		lblLevelType.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		lblLevelType.setBounds(6, 6, 188, 27);
		levelInfoPanel.add(lblLevelType);

		JLabel lblStar1Threshold = new JLabel("Star 1 Threshold:");
		lblStar1Threshold.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		lblStar1Threshold.setBounds(6, 73, 145, 16);
		levelInfoPanel.add(lblStar1Threshold);

		JLabel lblStar2Threshold = new JLabel("Star 2 Threshold:\r\n");
		lblStar2Threshold.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		lblStar2Threshold.setBounds(6, 101, 145, 16);
		levelInfoPanel.add(lblStar2Threshold);

		JLabel lblStar3Threshold = new JLabel("Star 3 Threshold:");
		lblStar3Threshold.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		lblStar3Threshold.setBounds(6, 129, 145, 16);
		levelInfoPanel.add(lblStar3Threshold);

		star1ThresholdSpnr = new JSpinner();
		star1ThresholdSpnr.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		star1ThresholdSpnr.setBounds(176, 67, 60, 28);
		star1ThresholdSpnr.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		levelInfoPanel.add(star1ThresholdSpnr);

		star2ThresholdSpnr = new JSpinner();
		star2ThresholdSpnr.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		star2ThresholdSpnr.setBounds(176, 95, 60, 28);
		star2ThresholdSpnr.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		levelInfoPanel.add(star2ThresholdSpnr);

		star3ThresholdSpnr = new JSpinner();
		star3ThresholdSpnr.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		star3ThresholdSpnr.setBounds(176, 123, 60, 28);
		star3ThresholdSpnr.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		levelInfoPanel.add(star3ThresholdSpnr);

		btnSave = new JButton("Save Level");
		btnSave.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		btnSave.setBounds(217, 481, 211, 37);
		add(btnSave);

		lblLevelName = new JLabel(""); 
		lblLevelName.setFont(new Font("Chalkboard SE", Font.BOLD, 18));
		lblLevelName.setBounds(133, 21, 360, 30);
		add(lblLevelName);
		
		btnPreview = new JButton("Preview");
		btnPreview.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
		btnPreview.setBounds(68, 481, 139, 37);
		add(btnPreview);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MakeNewLevel.class.getResource("/Common/starsmll.png")));
		lblNewLabel.setBounds(499, 68, 28, 26);
		add(lblNewLabel);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(MakeNewLevel.class.getResource("/Common/starsmll.png")));
		label.setBounds(499, 100, 28, 26);
		add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MakeNewLevel.class.getResource("/Common/starsmll.png")));
		label_1.setBounds(470, 100, 28, 26);
		add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(MakeNewLevel.class.getResource("/Common/starsmll.png")));
		label_2.setBounds(470, 129, 28, 26);
		add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(MakeNewLevel.class.getResource("/Common/starsmll.png")));
		label_3.setBounds(499, 129, 28, 26);
		add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(MakeNewLevel.class.getResource("/Common/starsmll.png")));
		label_4.setBounds(439, 129, 28, 26);
		add(label_4);
	}
	
	//JavaDocs!
	public JButton getGoBackButton() {
		return btnGoBack;
	}

	//JavaDocs!
	public JButton[][] getTiles() {
		return Tiles;
	}
	
	//JavaDocs!
	public JButton getSaveButton() {
		return btnSave;
	}
	
	//JavaDocs!
	public JButton getSubmitWordButton() {
		return btnSubmitWord;
	}
	
	//JavaDocs!
	public JButton getRemoveWordButton() {
		return btnRemoveWord;
	}
	
	//JavaDocs!
	public JButton getPreviewButton() {
		return btnPreview;
	}

	//JavaDocs!
	public JList getWords() {
		return Words;
	}
	
	//JavaDocs!
	public JSpinner getMaxTimeSpnr() {
		return maxTimeSpnr;
	}

	//JavaDocs!
	public JSpinner getMaxMovesSpnr() {
		return maxMovesSpnr;
	}

	//JavaDocs!
	public JTextField getThemeInput() { 
		return themeInput;
	}

	//JavaDocs!
	public JTextField getWordInput() { 
		return wordInput;
	}

	//JavaDocs!
	public DefaultListModel<String> getDefaultListModel() { 
		return dlm;
	}

	//JavaDocs!
	public JLabel getLevelNameLabel() {
		return lblLevelName;
	}

	//JavaDocs!
	public JPanel getPanels() {
		return panels;
	}

	//JavaDocs!
	public JComboBox getSelectLevelType() { 
		return selectLevelType;

	}
	
	//JavaDocs!
	public JTextField[][] getLetters() {
		return Letters;
	}

	//JavaDocs!
	public String getLevelType() {
		return levelType;
	}
	
	//JavaDocs!
	public void setLevelType(String lt) {
		this.levelType = lt;
	}

	//JavaDocs!
	public void resetLevelInfoPanel() { 
		lblLevelName.setText("Level Number " + (build.getLevels().size()+1));
		star1ThresholdSpnr.setValue(0);
		star2ThresholdSpnr.setValue(0);
		star3ThresholdSpnr.setValue(0);
		
		selectLevelType.setSelectedIndex(0);
		maxMovesSpnr.setValue(0);	
		maxTimeSpnr.setValue(0);
		
		themeInput.setText("");
		wordInput.setText("");
		dlm.clear();

		for (int col=0;col<6;col++) {
			for (int row=0; row<6;row++) {
				Tiles[col][row].setBackground(null);
				Tiles[col][row].setBounds(60*col, 60*row, 60, 60);
				Letters[col][row].setVisible(false);
				Letters[col][row].setText("");
			}
		}

	}
	
	//JavaDocs!
	public int[] getStarThresholds() {
		int[] starThresholds = new int[3];
		starThresholds[0] = (int)star1ThresholdSpnr.getValue();
		starThresholds[1] = (int)star2ThresholdSpnr.getValue();
		starThresholds[2] = (int)star3ThresholdSpnr.getValue();
		return starThresholds;
	}
	

}