package BuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * Allows user to see how it would look like approximately
 * and when pressing on cancel it goes to main menu where user can choose
 * what kind of level they want to build
 * */
public class AddLevelLightening extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	SplashScreen2 bla;
	/**
	 * Create the panel.
	 */
	public AddLevelLightening(SplashScreen2 first) {
		this.bla=first;
		setLayout(null);
		
		JLabel lblLevelBuilder = new JLabel("Level Builder For Lightening");
		lblLevelBuilder.setBounds(256, 5, 174, 16);
		add(lblLevelBuilder);
		
		JLabel lblChooseBoardSize = new JLabel("Choose Board Size: ");
		lblChooseBoardSize.setBounds(6, 41, 123, 16);
		add(lblChooseBoardSize);
		
		JRadioButton rdbtnx = new JRadioButton("3x3");
		rdbtnx.setBounds(6, 65, 56, 23);
		add(rdbtnx);
		
		JRadioButton radioButton = new JRadioButton("3x4");
		radioButton.setBounds(74, 65, 56, 23);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("3x5");
		radioButton_1.setBounds(6, 89, 56, 23);
		add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3x6");
		radioButton_2.setBounds(73, 89, 56, 23);
		add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("4x3");
		radioButton_3.setBounds(6, 113, 56, 23);
		add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("4x4");
		radioButton_4.setBounds(73, 113, 56, 23);
		add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("4x5");
		radioButton_5.setBounds(6, 138, 56, 23);
		add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("4x6");
		radioButton_6.setBounds(73, 138, 56, 23);
		add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("5x3");
		radioButton_7.setBounds(6, 166, 56, 23);
		add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("5x4");
		radioButton_8.setBounds(73, 166, 56, 23);
		add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("5x5");
		radioButton_9.setBounds(6, 191, 56, 23);
		add(radioButton_9);
		
		JRadioButton radioButton_10 = new JRadioButton("5x6");
		radioButton_10.setBounds(74, 191, 56, 23);
		add(radioButton_10);
		
		JRadioButton radioButton_11 = new JRadioButton("6x3");
		radioButton_11.setBounds(6, 215, 56, 23);
		add(radioButton_11);
		
		JRadioButton radioButton_12 = new JRadioButton("6x4");
		radioButton_12.setBounds(73, 215, 56, 23);
		add(radioButton_12);
		
		JRadioButton radioButton_13 = new JRadioButton("6x5");
		radioButton_13.setBounds(6, 240, 56, 23);
		add(radioButton_13);
		
		JRadioButton radioButton_14 = new JRadioButton("6x6");
		radioButton_14.setBounds(74, 240, 56, 23);
		add(radioButton_14);
		
		JLabel lblChooseStarThresholds = new JLabel("Choose Star Thresholds");
		lblChooseStarThresholds.setBounds(240, 41, 149, 16);
		add(lblChooseStarThresholds);
		
		JLabel lblFirstStar = new JLabel("First Star:");
		lblFirstStar.setBounds(240, 69, 61, 16);
		add(lblFirstStar);
		
		textField = new JTextField();
		textField.setBounds(328, 66, 61, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblSecondStar = new JLabel("Second Star: ");
		lblSecondStar.setBounds(240, 93, 81, 16);
		add(lblSecondStar);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(328, 88, 61, 21);
		add(textField_1);
		
		JLabel lblThirdStar = new JLabel("Third Star:");
		lblThirdStar.setBounds(240, 117, 65, 16);
		add(lblThirdStar);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(328, 112, 61, 21);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(256, 214, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAddLevel = new JButton("Add Level");
		btnAddLevel.setBounds(452, 349, 117, 29);
		add(btnAddLevel);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bla.setContentPane(new SelectLevelType2(bla));
				bla.revalidate();
			}
		});
		btnCancel.setBounds(18, 349, 117, 29);
		add(btnCancel);
		
		JLabel lblNumberOfSeconds = new JLabel("Number of Seconds Allowed");
		lblNumberOfSeconds.setBounds(240, 195, 177, 16);
		add(lblNumberOfSeconds);
		
			
	}

}
