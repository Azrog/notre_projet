package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class viewpanel extends JPanel {

	/**
    * the serialVersionUID.
    */
	private static final long serialVersionUID = 8681057499389021710L;

	private JLabel a = new JLabel();
	private JLabel b = new JLabel();
	private JLabel c = new JLabel();
	private JLabel d = new JLabel();
	private JLabel e = new JLabel();
	private JLabel f = new JLabel();
	private JLabel g = new JLabel();
	private JLabel h = new JLabel();
	private JLabel i = new JLabel();

	private int xmax = 9;
	private int ymax = 8;
	private char map[][] = {
			{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
			{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
			{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
			{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
			{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
			{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
			{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' },
			{ 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' } };

	/**
	 * constructor printMap
	 * @param level
	 */
	public viewpanel(String level) {
		if (level != "") {
			setBackground(Color.black);
			setLayout(new GridLayout(13, 20));

			for (int y = 0; y < ymax; y++) {
				for (int x = 0; x < xmax; x++) {
					char caracter = level.charAt(x + y * xmax);
					switch (caracter) {
					case 'A':
						a.setIcon(new ImageIcon(new ImageIcon("sprite/blanc.png").getImage().getScaledInstance(67, 47,
								Image.SCALE_DEFAULT)));
						// l.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(a);
						map[y][x] = caracter;
						break;
					case 'B':
						b.setIcon(new ImageIcon(new ImageIcon("sprite/i.png").getImage().getScaledInstance(67,
								47, Image.SCALE_DEFAULT)));
						// f1.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(b);
						map[y][x] = caracter;
						break;
					case 'C':
						c.setIcon(new ImageIcon(new ImageIcon("sprite/id.png").getImage()
								.getScaledInstance(67, 47, Image.SCALE_DEFAULT)));
						// c.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(c);
						map[y][x] = caracter;
						break;
					case 'D':
						d.setIcon(new ImageIcon(new ImageIcon("sprite/iv.png").getImage()
								.getScaledInstance(67, 47, Image.SCALE_DEFAULT)));
						// gc.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(d);
						map[y][x] = caracter;
						break;
					case 'E':
						e.setIcon(new ImageIcon(new ImageIcon("sprite/lh.png").getImage().getScaledInstance(67,
								47, Image.SCALE_DEFAULT)));
						// go.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(e);
						map[y][x] = caracter;
						break;
					case 'F':
						f.setIcon(new ImageIcon(new ImageIcon("sprite/lv.png").getImage().getScaledInstance(67, 47,
								Image.SCALE_DEFAULT)));
						// bo.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(f);
						map[y][x] = caracter;
						break;
					case 'G':
						g.setIcon(new ImageIcon(new ImageIcon("sprite/vd.png").getImage()
								.getScaledInstance(67, 47, Image.SCALE_DEFAULT)));
						// bh.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(g);
						map[y][x] = caracter;
						break;
					case 'H':
						h.setIcon(new ImageIcon(new ImageIcon("sprite/vg.png").getImage()
								.getScaledInstance(67, 47, Image.SCALE_DEFAULT)));
						// vb.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(h);
						map[y][x] = caracter;
						break;
					case 'I':
						i.setIcon(new ImageIcon(new ImageIcon("sprite/o.png").getImage()
								.getScaledInstance(67, 47, Image.SCALE_DEFAULT)));
						// vb.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(i);
						map[y][x] = caracter;
						break;
					}
				}
			}
			revalidate();
			repaint();
		}
	}
}