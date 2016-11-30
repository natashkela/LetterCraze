package PlayerControllers;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/*
 * Puzzle level that shows the table with letters
 * on a button press of Go Back it goes back to the main menu
 * where user is able to choose what kind of level they want to play
 * */
public class PuzzleLevel extends JPanel {
	private JTable table;
	SplashScreen1 bla;//just named it bla cause of not reason
	/**
	 * Create the panel.
	 */
	public PuzzleLevel(SplashScreen1 first) {
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
		lblTime.setBounds(6, 358, 67, 16);
		add(lblTime);
		
		JLabel lblLevelYouSelected = new JLabel("Puzzle");
		lblLevelYouSelected.setBounds(286, 50, 125, 16);
		add(lblLevelYouSelected);
		
		JLabel lblMovesRemaining = new JLabel("Moves Remaining: 12");
		lblMovesRemaining.setBounds(6, 330, 135, 16);
		add(lblMovesRemaining);
		
		JLabel lblWordsFound = new JLabel("Words Found:");
		lblWordsFound.setBounds(537, 28, 86, 16);
		add(lblWordsFound);
		
		JLabel lblNumberOfStars = new JLabel("Number of Stars: 0 out of 3");
		lblNumberOfStars.setBounds(6, 298, 172, 16);
		add(lblNumberOfStars);
	}
}
