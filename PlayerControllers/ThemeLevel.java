package PlayerControllers;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * Theme level that shows the table with letters
 * on a button press of Go Back it goes back to the main menu
 * where user is able to choose what kind of level they want to play
 * */
public class ThemeLevel extends JPanel {
	SplashScreen1 bla;//just named it bla
	/**
	 * Create the panel.
	 */
	public ThemeLevel(SplashScreen1 first) {
		this.bla=first;//needed to know who the parent of JPanel is
		setLayout(null);
		String[] column = {"A","Qu","B","D","E","F"};
		String[][] rows = {{"A","B","C","H","O","P"},
							{"B","C","A","E","U","A"},
							{"E","F","C","D","Qu","A"},
							{"B","C","A","E","U","A"},
							{"E","F","C","D","Qu","A"},
							{"A","B","C","H","O","P"}
							};
		JTable table = new JTable(rows,column);
		table.setBounds(195, 244, 312, 102);
		add(table);
		table.setEnabled(false);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new SelectLevelType1(bla));
				bla.revalidate();
			}
		});
		btnGoBack.setBounds(22, 45, 117, 29);
		add(btnGoBack);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.setBounds(22, 86, 117, 29);
		add(btnRestart);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.setBounds(22, 127, 117, 29);
		add(btnUndo);
		
		JLabel lblTime = new JLabel("Score: 0");
		lblTime.setBounds(11, 344, 67, 16);
		add(lblTime);
		
		JLabel lblLevelYouSelected = new JLabel("Theme");
		lblLevelYouSelected.setBounds(286, 50, 125, 16);
		add(lblLevelYouSelected);
		
		JLabel lblMovesRemaining = new JLabel("Moves Remaining: 5");
		lblMovesRemaining.setBounds(11, 316, 135, 16);
		add(lblMovesRemaining);
		
		JLabel lblColors = new JLabel("Colors!!!");
		lblColors.setBounds(274, 91, 75, 16);
		add(lblColors);
		
		JLabel lblWordsFound = new JLabel("Words Found:");
		lblWordsFound.setBounds(565, 50, 86, 16);
		add(lblWordsFound);
		
		JLabel lblNumberOfStars = new JLabel("Number of Stars: 0 out of 3");
		lblNumberOfStars.setBounds(11, 287, 172, 16);
		add(lblNumberOfStars);
	}

}
