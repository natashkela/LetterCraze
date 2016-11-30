package BuilderControllers;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/*
 * Puzzle builder allows user to add a puzzle level so far
 * when you press it it takes you to AddLevelPuzzle which allows user to see
 * how it looks so far 
 * */
public class PuzzleBuilder extends JPanel {
	SplashScreen2 bla;
	/**
	 * Create the panel.
	 */
	public PuzzleBuilder(SplashScreen2 first) {
		this.bla=first;
		setLayout(null);
		
		JLabel lblPuzzleLevelBuilder = new JLabel("Puzzle Level Builder");
		lblPuzzleLevelBuilder.setBounds(281, 17, 150, 16);
		add(lblPuzzleLevelBuilder);
		
		JLabel lblFirstLevel = new JLabel("First Level");
		lblFirstLevel.setBounds(50, 85, 64, 16);
		add(lblFirstLevel);
		
		JLabel lblSecondLevel = new JLabel("Second Level");
		lblSecondLevel.setBounds(303, 85, 93, 16);
		add(lblSecondLevel);
		
		JLabel lblThirdLevel = new JLabel("Third Level");
		lblThirdLevel.setBounds(539, 85, 69, 16);
		add(lblThirdLevel);
		
		JButton btnEdit = new JButton("Edit ");
		btnEdit.setBounds(21, 113, 117, 29);
		add(btnEdit);
		
		JButton button = new JButton("Edit ");
		button.setBounds(279, 113, 117, 29);
		add(button);
		
		JButton button_1 = new JButton("Edit ");
		button_1.setBounds(512, 113, 117, 29);
		add(button_1);
		
		JButton btnAddLevel = new JButton("Add Level");
		btnAddLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new AddLevelPuzzle(bla));
				bla.revalidate();
			}
		});
		btnAddLevel.setBounds(21, 332, 117, 29);
		add(btnAddLevel);
		
		JButton btnReorderLevels = new JButton("Reorder Levels");
		btnReorderLevels.setBounds(21, 299, 117, 29);
		add(btnReorderLevels);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(21, 144, 117, 29);
		add(btnDelete);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.setBounds(279, 144, 117, 29);
		add(btnDelete_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.setBounds(512, 144, 117, 29);
		add(button_2);

	}
}
