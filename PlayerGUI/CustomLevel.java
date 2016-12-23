package PlayerGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Common.Level;
import Common.Model;
import javax.swing.UIManager;

public class CustomLevel extends JPanel{

	Model model;
	LinkedList<JLabel> points;
	LinkedList<JLabel> stars;
	LinkedList<JButton> btnLevel;
	JButton btnGoBack;


	/**
	 * Default constructor for CustomLevel
	 */

	public CustomLevel(Model model) {

		btnLevel = new LinkedList<JButton>();
		points = new LinkedList<JLabel>();
		
		
		setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		this.model = model;
		setBounds(0, 0, 800, 600);
		this.setLayout(null);

		JLabel lblCustomLevels = new JLabel("Custom Levels: ");
		lblCustomLevels.setFont(new Font("Chalkboard SE", Font.BOLD, 25));
		lblCustomLevels.setBounds(331, 17, 262, 24);
		this.add(lblCustomLevels);

		btnGoBack = new JButton("Go Back");
		btnGoBack.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
		btnGoBack.setBounds(54, 23, 87, 24);
		this.add(btnGoBack);


	
		for (int row=0;row<3;row++) {
			for (int col=0; col<5;col++) {
				JButton btn = new JButton();
				JLabel lev = new JLabel();
				JLabel star = new JLabel();
				
				btn.setForeground(Color.BLACK);
				btn.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
				btn.setBounds(50+(col*143), 125+(row*150), 125, 100);
				btnLevel.add(btn);
				this.add(btn);
				lev.setFont(new Font("Chalkboard SE", Font.BOLD, 15));
				lev.setBounds(50+(col*143), 110+(row*150), 125, 14);
				points.add(lev);
				this.add(lev);
				star.setBounds(70+(col*143), 225+(col*150), 81, 27);
				this.add(star);
			}
		}
		replacePanel();		
	}


	public void replacePanel() {
		int i=0;
		for (int row=0;row<3;row++) {
			for (int col=0; col<5; col++) {
				if(i < model.getCustomLevels().size()){
				Level lvl = model.getCustomLevels().get(i);
				
				
				if (lvl.getUnlocked()) {
					btnLevel.get(i).setText("Level " + (i+1)+ " " + lvl.getLevelType() + "!");
					points.get(i).setText(String.valueOf(lvl.getBest().getPoints()));
				}
				else {
					btnLevel.get(i).setText("Locked");
					}
				}
				i++;
			}
		}
	}

	//JavaDocs!
	public JButton getBackButton() {
		return btnGoBack;
	}

	//JavaDocs!
	public LinkedList<JButton> getLevelButtons() {
		return btnLevel;
	}

}
