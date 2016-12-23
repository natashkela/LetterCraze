package BuilderGUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Common.Builder;

public class SavedLevels extends JPanel{

	//JavaDocs for all attributes!
	Builder builder;
	JButton save;
	JButton back;
	LinkedList<JButton> btnlvl;
	LinkedList<JButton> btndelete;
	int theme = 0, puzzle = 0, lightning = 0;
	int tempValue;

	//JavaDocs!
	public SavedLevels(Builder build) {
		builder = build;
		setBackground(Color.RED);
		setBounds(0, 0, 892, 600);
		this.setLayout(null);

		JLabel lblLevels = new JLabel("Levels!");
		lblLevels.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblLevels.setBounds(392, 52, 93, 24);
		this.add(lblLevels);

		back=new JButton("Back");
		back.setFont(new Font("Chalkboard SE", Font.PLAIN, 12));
		back.setBounds(28, 47, 75, 29);
		this.add(back);
		
		save = new JButton("Add Levels to Player");
		save.setFont(new Font("Chalkboard SE", Font.PLAIN, 12));
		save.setBounds(713, 47, 158, 29);
		add(save);
		
		btnlvl = new LinkedList<JButton>();
		btndelete = new LinkedList<JButton>();
		for (int row=0;row<3;row++) {
			for (int col=0;col<5;col++) {
				JButton button = new JButton();
				button.setForeground(Color.BLACK);
				button.setFont(new Font("Chalkboard SE", Font.PLAIN, 12));
				button.setBounds(50+(col*143), 125+(row*150), 125, 100);
				JButton delete = new JButton("remove level");
				delete.setFont(new Font("Chalkboard SE", Font.PLAIN, 14));
				delete.setOpaque(true);
				delete.setBackground(Color.GRAY); 
				delete.setBounds(50+(col*143), 75+((row+1)*150), 125, 40);
				btnlvl.add(button);
				btndelete.add(delete);
				this.add(button);
				this.add(delete);
			}
		}
		replacePanel();		
	}

	
	//JavaDocs!
	public void replacePanel() {
		int level=0;
		for (int row=0; row<3;row++) {
			for (int col=0; col<5;col++) {
				if (level<builder.getLevels().size()) {
					String whichLevel=builder.getLevels().get(level).getLevelType();
					btnlvl.get(level).setText( "Level type: \n" + whichLevel );
					btndelete.get(level).setVisible(true);
				}
				else {
					btnlvl.get(level).setText("Empty");
					btndelete.get(level).setVisible(false);
				}
				level++;
			}

		}
	}

	public JButton getSave() {
		return save;
	}
	
	public JButton getBack(){
		return back;
	}

	public LinkedList<JButton> getLevel() {
		return btnlvl;
	}
	
	public LinkedList<JButton> getDelete() {
		return btndelete;
	}
	
}
