package PlayerGUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Common.Model;
import javax.swing.UIManager;

public class StartPlayer extends JPanel{
	
	//JavaDocs!
	Model model;
	JButton playLevels;
	
	
	//JavaDocs!
	public StartPlayer(Model m) {
		setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		setBounds(0, 0, 800, 600);
		this.setLayout(null);
		model = m;
		
		JLabel title = new JLabel("LetterCraze");
		title.setFont(new Font("Chalkboard SE", Font.BOLD, 30));
		title.setBounds(311, 74, 172, 43);
		this.add(title); 
		
		playLevels = new JButton("Play Levels!");
		playLevels.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		playLevels.setBounds(307, 183, 176, 30);
		this.add(playLevels);
		
	}

	//JavaDocs!
	public JButton getPlayLevel() {
		return playLevels;
	}
}
