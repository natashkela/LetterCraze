package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * SelectLevelType2 allows user to choose which level they want to build
 * */
public class SelectLevelType2 extends JPanel {
	SplashScreen2 bla;//just named it bla cause of no reason
	/**
	 * Create the panel.
	 */
	public SelectLevelType2(SplashScreen2 first) {
		setLayout(null);
		this.bla=first;//needed the to know who the parent of JPanel is
		
		JLabel lblSelectLevelType = new JLabel("Which Level Would you like To Build?");
		lblSelectLevelType.setBounds(219, 32, 231, 16);
		add(lblSelectLevelType);
		
		JButton btnPuzzle = new JButton("Puzzle");
		btnPuzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new PuzzleBuilder(bla));
				bla.revalidate();
			}
		});
		btnPuzzle.setBounds(24, 171, 117, 29);
		add(btnPuzzle);
		
		JButton btnLightening = new JButton("Lightening");
		btnLightening.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new LighteningBuilder(bla));
				bla.revalidate();
			}
		});
		btnLightening.setBounds(189, 171, 117, 29);
		add(btnLightening);
		
		JButton btnTheme = new JButton("Theme");
		btnTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new ThemeBuilder(bla));
				bla.revalidate();
			}
		});
		btnTheme.setBounds(346, 171, 117, 29);
		add(btnTheme);
		
	}

}
