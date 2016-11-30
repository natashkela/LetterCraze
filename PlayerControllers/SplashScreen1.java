package PlayerControllers;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/*
 * SplashScreen1 is a splash screen that appears when player opens the game
 * */
public class SplashScreen1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen1 frame = new SplashScreen1();
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
	public SplashScreen1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//List of Credentials
		JLabel lblTeamRhodium = new JLabel("Team Rhodium");
		lblTeamRhodium.setBounds(315, 24, 121, 26);
		contentPane.add(lblTeamRhodium);
		
		JLabel lblMatthewSzpunar = new JLabel("Matthew Szpunar");
		lblMatthewSzpunar.setBounds(315, 78, 136, 31);
		contentPane.add(lblMatthewSzpunar);
		
		JLabel lblNataVacheishvili = new JLabel("Nata Vacheishvili");
		lblNataVacheishvili.setBounds(315, 110, 136, 16);
		contentPane.add(lblNataVacheishvili);
		
		JLabel lblAmyBeaWalder = new JLabel("AmyBea Walder");
		lblAmyBeaWalder.setBounds(315, 141, 108, 16);
		contentPane.add(lblAmyBeaWalder);
		
		JLabel lblChristopherStiles = new JLabel("Christopher Stiles");
		lblChristopherStiles.setBounds(315, 169, 125, 16);
		contentPane.add(lblChristopherStiles);
		
		JLabel lblStephanieJeandell = new JLabel("Stephanie Jeandell");
		lblStephanieJeandell.setBounds(315, 197, 125, 16);
		contentPane.add(lblStephanieJeandell);
		//needed to move from JFrame to Jpanels
		SplashScreen1 first=this;
		
		JButton btnPlayLettercraze = new JButton("Play LetterCraze!");
		//on action move to Select Level Type 
		btnPlayLettercraze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(new SelectLevelType1(first));
				revalidate();
			}
		});
		btnPlayLettercraze.setBounds(288, 240, 159, 29);
		contentPane.add(btnPlayLettercraze);
		
	}
	
}
