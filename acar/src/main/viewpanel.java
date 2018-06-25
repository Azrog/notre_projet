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

	private int xmax = 9;
	private int ymax = 8;
	private int la = 133;
	private int ha = 94;
	private int oldx = 0;
	private int oldy = 0;
	
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
			setBackground(Color.white);
			setLayout(new GridLayout(ymax, xmax));

			for (int y = 0; y < ymax; y++) {
				for (int x = 0; x < xmax; x++) {
					char caracter = level.charAt(x + y * xmax);
					switch (caracter) {
					case 'A':
						JLabel a = new JLabel();
						a.setIcon(new ImageIcon(new ImageIcon("sprite/blanc.png").getImage().getScaledInstance(la, ha,
								Image.SCALE_DEFAULT)));
						// l.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(a);
						map[y][x] = caracter;
						break;
					case 'B':
						JLabel b = new JLabel();
						b.setIcon(new ImageIcon(new ImageIcon("sprite/i.png").getImage().getScaledInstance(la,
								ha, Image.SCALE_DEFAULT)));
						// f1.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(b);
						map[y][x] = caracter;
						break;
					case 'C':
						JLabel c = new JLabel();
						c.setIcon(new ImageIcon(new ImageIcon("sprite/id.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						// c.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(c);
						map[y][x] = caracter;
						break;
					case 'D':
						JLabel d = new JLabel();
						d.setIcon(new ImageIcon(new ImageIcon("sprite/iv.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						// gc.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(d);
						map[y][x] = caracter;
						break;
					case 'E':
						JLabel e = new JLabel();
						e.setIcon(new ImageIcon(new ImageIcon("sprite/lh.png").getImage().getScaledInstance(la,
								ha, Image.SCALE_DEFAULT)));
						// go.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(e);
						map[y][x] = caracter;
						break;
					case 'F':
						JLabel f = new JLabel();
						f.setIcon(new ImageIcon(new ImageIcon("sprite/lv.png").getImage().getScaledInstance(la, ha,
								Image.SCALE_DEFAULT)));
						// bo.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(f);
						map[y][x] = caracter;
						break;
					case 'G':
						JLabel g = new JLabel();
						g.setIcon(new ImageIcon(new ImageIcon("sprite/vd.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						// bh.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(g);
						map[y][x] = caracter;
						break;
					case 'H':
						JLabel h = new JLabel();
						h.setIcon(new ImageIcon(new ImageIcon("sprite/vg.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						// vb.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(h);
						map[y][x] = caracter;
						break;
					case 'I':
						JLabel i = new JLabel();
						i.setIcon(new ImageIcon(new ImageIcon("sprite/o.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						// vb.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(i);
						map[y][x] = caracter;
						break;
					case 'J':
						JLabel j = new JLabel();
						j.setIcon(new ImageIcon(new ImageIcon("sprite/id2.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						// c.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(j);
						map[y][x] = caracter;
						break;
					case 'K':
						JLabel k = new JLabel();
						k.setIcon(new ImageIcon(new ImageIcon("sprite/iv2.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						// gc.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(k);
						map[y][x] = caracter;
						break;
					case 'L':
						JLabel l = new JLabel();
						l.setIcon(new ImageIcon(new ImageIcon("sprite/vd2.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						// bh.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(l);
						map[y][x] = caracter;
						break;
					case 'M':
						JLabel m = new JLabel();
						m.setIcon(new ImageIcon(new ImageIcon("sprite/vg2.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						// bh.setBounds((i%20)*64, ((i-(i%20))/20)*42,
						// (i%20)*64+64, ((i-(i%20))/20)*42+64);
						add(m);
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

class setVehicule {
	public setVehicule(int x, int y) {
		JLabel v = new JLabel();
		v.setIcon(new ImageIcon(new ImageIcon("sprite/voiture.png").getImage().getScaledInstance(133, 94, Image.SCALE_DEFAULT)));
	}
}