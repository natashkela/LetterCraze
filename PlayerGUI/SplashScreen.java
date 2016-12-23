package PlayerGUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Common.Model;
import javax.swing.UIManager;

public class SplashScreen extends JPanel{
	/** Model of PlayerApplication. */
	Model model;
	
	/** All Team, members, and type of application text for Splash Screen. */
	JLabel Rhodium;
	JLabel Matt;
	JLabel AmyBea;
	JLabel Stephanie;
	JLabel Nata;


	/**
	 * Default constructor for Splash Screen View.
	 */
	
    public SplashScreen(Model model) {
		setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));

    	this.model = model;
        setBounds(0, 0, 800, 600);
        this.setLayout(null);
        
        Rhodium = new JLabel("Rhodium");
        Rhodium.setBounds(343, 241, 111, 37);
        Rhodium.setFont(new Font("Dialog", Font.BOLD, 24));
        this.add(Rhodium);
        
        Matt = new JLabel("Matthew Szpunar");
        Matt.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
        Matt.setBounds(34, 101, 123, 22);
        this.add(Matt);
        
        AmyBea = new JLabel("AmyBea Walder");
        AmyBea.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
        AmyBea.setBounds(657, 101, 111, 22);
        this.add(AmyBea);
        
        Stephanie = new JLabel("Stephanie Jeandell");
        Stephanie.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
        Stephanie.setBounds(34, 426, 132, 22);
        this.add(Stephanie);
        
        Nata = new JLabel("Nata Vacheishvili");
        Nata.setFont(new Font("Chalkboard SE", Font.PLAIN, 15));
        Nata.setBounds(650, 426, 118, 22);
        this.add(Nata);
        
    }
}
