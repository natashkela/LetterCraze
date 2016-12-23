package BuilderGUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Common.Builder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SplashScreen extends JPanel{
	
	//JavaDocs for all Attributes!
	Builder builder;
	JLabel teamName;
	JLabel Matt;
	JLabel AmyBea;
	JLabel Stephanie;
	JLabel Nata;
	JLabel lblNewLabel_2;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;

    public SplashScreen(Builder build) {
    	builder=build;
    	setBackground(Color.RED);
        setBounds(0, 0, 800, 600);
        this.setLayout(null);
        
        teamName = new JLabel("Rhodium");
        teamName.setBounds(324, 111, 111, 37);
        teamName.setFont(new Font("Chalkboard SE", Font.BOLD, 25));
        this.add(teamName);
        
        Matt = new JLabel("Matthew Szpunar");
        Matt.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
        Matt.setBounds(324, 175, 123, 22);
        this.add(Matt);
        
        AmyBea = new JLabel("AmyBea \"Refuses to make small labels\" Walder");
        AmyBea.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
        AmyBea.setBounds(222, 218, 312, 22);
        this.add(AmyBea);
        
        Stephanie = new JLabel("Stephanie Jeandell");
        Stephanie.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
        Stephanie.setBounds(324, 261, 132, 22);
        this.add(Stephanie);
        
        Nata = new JLabel("Nata Vacheishvili");
        Nata.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
        Nata.setBounds(329, 304, 118, 22);
        this.add(Nata);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/Common/starsmll.png")));
        lblNewLabel.setBounds(291, 169, 30, 30);
        add(lblNewLabel);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon(SplashScreen.class.getResource("/Common/starsmll.png")));
        label.setBounds(439, 169, 30, 30);
        add(label);
        
        label_1 = new JLabel("");
        label_1.setIcon(new ImageIcon(SplashScreen.class.getResource("/Common/starsmll.png")));
        label_1.setBounds(541, 214, 30, 30);
        add(label_1);
        
        label_2 = new JLabel("");
        label_2.setIcon(new ImageIcon(SplashScreen.class.getResource("/Common/starsmll.png")));
        label_2.setBounds(183, 214, 30, 30);
        add(label_2);
        
        label_3 = new JLabel("");
        label_3.setIcon(new ImageIcon(SplashScreen.class.getResource("/Common/starsmll.png")));
        label_3.setBounds(450, 257, 30, 30);
        add(label_3);
        
        label_4 = new JLabel("");
        label_4.setIcon(new ImageIcon(SplashScreen.class.getResource("/Common/starsmll.png")));
        label_4.setBounds(291, 257, 30, 30);
        add(label_4);
        
        label_5 = new JLabel("");
        label_5.setIcon(new ImageIcon(SplashScreen.class.getResource("/Common/starsmll.png")));
        label_5.setBounds(291, 300, 30, 30);
        add(label_5);
        
        label_6 = new JLabel("");
        label_6.setIcon(new ImageIcon(SplashScreen.class.getResource("/Common/starsmll.png")));
        label_6.setBounds(439, 300, 30, 30);
        add(label_6);
    }
}
