package BuilderControllers;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * SplashScreen2 is second splash screen that is needed for builder application
 * when you Build the game it takes you to SelectLevelType2
 * */
public class SplashScreen2 extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen2 frame = new SplashScreen2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen2() {
		setBounds(100, 100, 881, 426);
		getContentPane().setLayout(null);
		
		getContentPane().setBackground(Color.RED);
		
		JLabel lblRhodiumTeamCreated = new JLabel("Rhodium Team Created Letter Craze! ");
		lblRhodiumTeamCreated.setBounds(241, 38, 256, 16);
		getContentPane().add(lblRhodiumTeamCreated);
		
		JLabel lblNataVacheishvili = new JLabel("Nata Vacheishvili");
		lblNataVacheishvili.setBounds(31, 87, 137, 16);
		getContentPane().add(lblNataVacheishvili);
		
		JLabel lblMatthewSzupnar = new JLabel("Matthew Szupnar");
		lblMatthewSzupnar.setBounds(31, 152, 113, 16);
		getContentPane().add(lblMatthewSzupnar);
		
		JLabel lblChristopherStiles = new JLabel("Christopher Stiles");
		lblChristopherStiles.setBounds(466, 87, 151, 16);
		getContentPane().add(lblChristopherStiles);
		
		JLabel lblAmybeaWalder = new JLabel("AmyBea Walder");
		lblAmybeaWalder.setBounds(469, 152, 129, 16);
		getContentPane().add(lblAmybeaWalder);
		
		JLabel lblStephanieJeandell = new JLabel("Stephanie Jeandell");
		lblStephanieJeandell.setBounds(254, 122, 137, 16);
		getContentPane().add(lblStephanieJeandell);
		
		SplashScreen2 first=this;
		
		JButton btnPlayTheGame = new JButton("Build the Game!");
		btnPlayTheGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(new SelectLevelType2(first));
				revalidate();
			}
		});
		btnPlayTheGame.setBounds(241, 295, 117, 29);
		getContentPane().add(btnPlayTheGame);
		

	}

}
