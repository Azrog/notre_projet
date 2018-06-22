package main;

import javax.swing.JFrame;

public class viewframe extends JFrame {
	/**
	 * the serialVersionUID.
	 */
	private static final long serialVersionUID = 9182866186936817112L;
	public static JFrame frame = new JFrame("ACAR");
	public viewframe() {
		super();
	}

	/**
	 * the method printWindow
	 *
	 * @param level.
	 * 				the level in the game.
	 */
	public static void printWindow(String level) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new viewpanel(level));
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

    /**
    * This class creates the map and sets all its settings
    * @author chris
    *
    */
	
}