package main;

import javax.swing.JFrame;

public class viewframe extends JFrame {
	
	private static final long serialVersionUID = -9088606023866100460L;
	private static JFrame frame = new JFrame("ACAR");
	
	public viewframe(String level) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new viewpanel(level));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
	}
}