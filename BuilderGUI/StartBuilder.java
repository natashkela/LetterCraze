package BuilderGUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Common.Builder;
import java.awt.Color;

public class StartBuilder extends JPanel{
	
	//JavaDocs!
	Builder builder;
	JButton newLevel;
	JButton edit;

	public StartBuilder(Builder build) {
		setBackground(Color.RED);

		this.builder = build;
		setBounds(0, 0, 800, 600);
		this.setLayout(null);

		JLabel title = new JLabel("LetterCraze Builder");
		title.setFont(new Font("Chalkboard SE", Font.BOLD, 25));
		title.setBounds(277, 76, 239, 37);
		this.add(title);

		newLevel = new JButton("New Level");
		newLevel.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		newLevel.setBounds(325, 209, 115, 30);
		this.add(newLevel);

		edit = new JButton("Edit");
		edit.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		edit.setBounds(325, 251, 115, 30);
		this.add(edit);
		
	}

	//JavaDocs!
	public JButton getNewLevel() {
		return newLevel;
	}

	//JavaDocs!
	public JButton getEdit() {
		return edit;
	}

}
