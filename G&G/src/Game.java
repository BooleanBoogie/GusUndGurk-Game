
// Java program Program to add a menubar
// and add menuitems, submenu items and also add 
// ActionListener to menu items 
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
public class Game extends JFrame implements ActionListener { 
	// menubar 
	static JMenuBar mb; 

	// JMenu 
	static JMenu x, x1; 

	// Menu items 
	static JMenuItem m1, m2, m3, s1, s2; 

	// create a frame 
	static JFrame f; 

	// a label 
	static JLabel l1; 
	static JLabel l2;

	// main class 
	public static void main(String[] args) 
	{ 
		// create an object of the class 
		Game Game = new Game(); 

		// create a frame 
		f = new JFrame("G & G"); 

		// create a label 
		l1 = new JLabel("*----------------------- RPG ARENA SIM V1.0 -----------------------*");
		l2 = new JLabel("                   Code written by Andrew McCracken            "); 

		// create a menubar 
		mb = new JMenuBar(); 

		// create a menu 
		x = new JMenu("Menu"); 
		//x1 = new JMenu("submenu"); 

		// create menuitems 
		m1 = new JMenuItem("Main Menu"); 
		m2 = new JMenuItem("Character Encyclopedia"); 
		m3 = new JMenuItem("Character Select");

		// add ActionListener to menuItems 
		m1.addActionListener(Game); 
		m2.addActionListener(Game); 
		m3.addActionListener(Game); 

		// add menu items to menu 
		x.add(m1); 
		x.add(m2); 
		x.add(m3); 

		// add submenu 
		//x.add(x1); 

		// add menu to menu bar 
		mb.add(x); 

		// add menubar to frame 
		f.setJMenuBar(mb); 

		// add label 
		f.add(l1, BorderLayout.NORTH); 
		f.add(l2, BorderLayout.LINE_START);

		// set the size of the frame 
		f.setSize(500, 500); 
		f.setVisible(true); 
	} 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 

		// set the label to the menuItem that is selected 
		l1.setText(s); 
		if (s.equals("Character Select"))
			l2 .setText("Knight, Cleric, Berserker, Drunk Wizard, High Elf");
		else if (s.equals("Character Encyclopedia"))
			l2.setText("               Welcome to the Character Encyclopedia! ");
		else if (s.equals("Main Menu")) {
			l1.setText("*----------------------- RPG ARENA SIM V1.0 -----------------------*");
			l2.setText("                   Code written by Andrew McCracken            ");
		}
	} 
} 