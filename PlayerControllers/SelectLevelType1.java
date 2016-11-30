package PlayerControllers;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * SelectLevelType1 Allows player to choose what kind of level
 * they want to play 
 * */
public class SelectLevelType1 extends JPanel {
	SplashScreen1 bla;//bla is just called bla because of no reason
	/**
	 * Create the panel.
	 */
	//constructor that takes in JFrame in order to know 
	//who is the parent of JPanel
	public SelectLevelType1(SplashScreen1 first) {
		setLayout(null);
		this.bla=first;//we set bla equal to whatever constructor takes in
		
		JLabel lblSelectLevelType = new JLabel("Select Level Type");
		lblSelectLevelType.setBounds(219, 32, 107, 16);
		add(lblSelectLevelType);
		
		JButton btnPuzzle = new JButton("Puzzle");
		btnPuzzle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new SelectLevelPuzzle(bla));
				bla.revalidate();
			}
		});
		btnPuzzle.setBounds(24, 171, 117, 29);
		add(btnPuzzle);
		
		JButton btnLightening = new JButton("Lightening");
		btnLightening.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new SelectLevelLightening(bla));
				bla.revalidate();
			}
		});
		btnLightening.setBounds(189, 171, 117, 29);
		add(btnLightening);
		
		JButton btnTheme = new JButton("Theme");
		btnTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new SelectLevelTheme(bla));
				bla.revalidate();
			}
		});
		btnTheme.setBounds(346, 171, 117, 29);
		add(btnTheme);
		
	}

}
