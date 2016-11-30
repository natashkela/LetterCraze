package PlayerControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * This shows the user available levels in Lightening
 * if they are unlocked or locked
 * the number of stars out of 3 for each level that user gained
 * 
 * */
public class SelectLevelLightening extends JPanel {

	SplashScreen1 bla;//just named it bla because of no reason
	/**
	 * Create the panel.
	 */
	public SelectLevelLightening(SplashScreen1 first) {
		this.bla=first;//needed this in constructor to know who the parent of JPanel is
		setLayout(null);
		
		JButton btnUnlocked = new JButton("Unlocked");
		btnUnlocked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new LighteningLevel(bla));
				bla.revalidate();
			}
		});
		btnUnlocked.setBounds(68, 148, 117, 29);
		add(btnUnlocked);
		
		JButton btnLocked = new JButton("Locked");
		btnLocked.setBounds(162, 264, 117, 29);
		add(btnLocked);
		
		JButton btnLocked_1 = new JButton("Locked");
		btnLocked_1.setBounds(294, 148, 117, 29);
		add(btnLocked_1);
		
		JButton btnLocked_2 = new JButton("Locked");
		btnLocked_2.setBounds(397, 264, 117, 29);
		add(btnLocked_2);
		
		JButton btnLocked_3 = new JButton("Locked");
		btnLocked_3.setBounds(536, 148, 117, 29);
		add(btnLocked_3);
		
		JLabel lblChooseALevel = new JLabel("Choose A Level");
		lblChooseALevel.setBounds(314, 35, 144, 16);
		add(lblChooseALevel);
		
		JLabel label = new JLabel("0 out of 3 Stars");
		label.setBounds(78, 189, 97, 16);
		add(label);
		
		JLabel label_1 = new JLabel("0 out of 3 Stars");
		label_1.setBounds(172, 305, 97, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("0 out of 3 Stars");
		label_2.setBounds(304, 189, 97, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("0 out of 3 Stars");
		label_3.setBounds(407, 305, 97, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("0 out of 3 Stars");
		label_4.setBounds(546, 189, 97, 16);
		add(label_4);

	}

}
