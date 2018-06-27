package main;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class viewpanel extends JPanel {

	/**
    * the serialVersionUID.
    */
	private static final long serialVersionUID = 8681057499389021710L;

	Lock lock = new ReentrantLock();
	private int xmax = 9;
	private int ymax = 8;
	private int la = 133;
	private int ha = 94;
	protected char map[][] = {
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
		if (level != "" || level.length() != xmax*ymax) {
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
						add(a);
						map[y][x] = caracter;
						break;
					case 'B':
						JLabel b = new JLabel();
						b.setIcon(new ImageIcon(new ImageIcon("sprite/i.png").getImage().getScaledInstance(la,
								ha, Image.SCALE_DEFAULT)));
						add(b);
						map[y][x] = caracter;
						break;
					case 'C':
						JLabel c = new JLabel();
						c.setIcon(new ImageIcon(new ImageIcon("sprite/id.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						add(c);
						map[y][x] = caracter;
						break;
					case 'D':
						JLabel d = new JLabel();
						d.setIcon(new ImageIcon(new ImageIcon("sprite/iv.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						add(d);
						map[y][x] = caracter;
						break;
					case 'E':
						JLabel e = new JLabel();
						e.setIcon(new ImageIcon(new ImageIcon("sprite/lh.png").getImage().getScaledInstance(la,
								ha, Image.SCALE_DEFAULT)));
						add(e);
						map[y][x] = caracter;
						break;
					case 'F':
						JLabel f = new JLabel();
						f.setIcon(new ImageIcon(new ImageIcon("sprite/lv.png").getImage().getScaledInstance(la, ha,
								Image.SCALE_DEFAULT)));
						add(f);
						map[y][x] = caracter;
						break;
					case 'G':
						JLabel g = new JLabel();
						g.setIcon(new ImageIcon(new ImageIcon("sprite/vd.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						add(g);
						map[y][x] = caracter;
						break;
					case 'H':
						JLabel h = new JLabel();
						h.setIcon(new ImageIcon(new ImageIcon("sprite/vg.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						add(h);
						map[y][x] = caracter;
						break;
					case 'I':
						JLabel i = new JLabel();
						i.setIcon(new ImageIcon(new ImageIcon("sprite/o.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						add(i);
						map[y][x] = caracter;
						break;
					case 'J':
						JLabel j = new JLabel();
						j.setIcon(new ImageIcon(new ImageIcon("sprite/id2.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						add(j);
						map[y][x] = caracter;
						break;
					case 'K':
						JLabel k = new JLabel();
						k.setIcon(new ImageIcon(new ImageIcon("sprite/iv2.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						add(k);
						map[y][x] = caracter;
						break;
					case 'L':
						JLabel l = new JLabel();
						l.setIcon(new ImageIcon(new ImageIcon("sprite/vd2.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						add(l);
						map[y][x] = caracter;
						break;
					case 'M':
						JLabel m = new JLabel();
						m.setIcon(new ImageIcon(new ImageIcon("sprite/vg2.png").getImage()
								.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
						add(m);
						map[y][x] = caracter;
						break;
					}
				}
			}
			Thread t = new Thread(new vehicule (6, 5));
			t.start();
			Thread t2 = new Thread(new vehicule (7, 2));
			t2.start();
		}
	}
	
	public class vehicule implements Runnable {
		private JLabel v = new JLabel();
		private int oldx;
		private int oldy;
		
		public vehicule(int x, int y) {
			oldx = x;
			oldy = y;
			v.setIcon(new ImageIcon(new ImageIcon("sprite/voiture.png").getImage().getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
			lock.lock();
			try {
				remove(x+y*xmax);
				add(v, x+y*xmax);
			} finally {
				lock.unlock();
			}
			revalidate();
			repaint();
		}
		
		public void run() {
			String oui = null;
		    SerialTest main = new SerialTest();
		    main.initialize();
		    Thread t=new Thread() {
		        public void run() {
		    //the following line will keep this app alive for 1000 seconds,
		    //waiting for events to occur and responding to them (printing incoming messages to console).
		            try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
		        }
		    };
		    t.start();
		    System.out.println(" Started ");

		    while (true)
		    {
		        try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		        oui = SerialTest.getOut();
		        SerialTest.cadenas.lock();
		        int vx = 0;
		        int vy = 0;
		        try {
		            switch (oui) {
		            	case "L" :
		            		if (vx == 0 && vy == 0) {
		            			vx = -1;
		            		}
		            		if (vx == 1 && vy == 0) {
		            			vx = 0;
		            			vy = 1; 
		            		}
		            		if (vx == -1 && vy == 0) {
		            			vx = 0;
		            			vy = -1;
		            		}
		            		if (vx == 0 && vy == 1) {
		            			vx = -1;
		            			vy = 0;
		            		}
		            		if (vx == 0 && vy == -1) {
		            			vx = 1;
		            			vy = 0;
		            		}
		            		
		            		setVehicule(oldx+vx, oldy+vy);
		            	break;
		            	case "R" :

		            		if (vx == 0 && vy == 0) {
		            			vx = 1;
		            		}
		            		if (vx == 1 && vy == 0) {
		            			vx = 0;
		            			vy = -1; 
		            		}
		            		if (vx == -1 && vy == 0) {
		            			vx = 0;
		            			vy = 1;
		            		}
		            		if (vx == 0 && vy == 1) {
		            			vx = 1;
		            			vy = 0;
		            		}
		            		if (vx == 0 && vy == -1) {
		            			vx = -1;
		            			vy = 0;
		            		}
		            		setVehicule(oldx+vx, oldy+vy);
		            	break;
		            	case "T" :
		            		setVehicule(oldx+vx, oldy+vy);
			            break;
			            default :
			            	//place libre
			            break;
		            }
		        } finally {
		        	SerialTest.cadenas.unlock();
		        }
		    }
		}
		
		public void setVehicule(int x, int y) {
			switch (map[oldy][oldx]) {
			case 'A':
				JLabel a = new JLabel();
				a.setIcon(new ImageIcon(new ImageIcon("sprite/blanc.png").getImage().getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(a, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'B':
				JLabel b = new JLabel();
				b.setIcon(new ImageIcon(new ImageIcon("sprite/i.png").getImage().getScaledInstance(la,
						ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(b, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'C':
				JLabel c = new JLabel();
				c.setIcon(new ImageIcon(new ImageIcon("sprite/id.png").getImage()
						.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(c, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'D':
				JLabel d = new JLabel();
				d.setIcon(new ImageIcon(new ImageIcon("sprite/iv.png").getImage()
						.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(d, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'E':
				JLabel e = new JLabel();
				e.setIcon(new ImageIcon(new ImageIcon("sprite/lh.png").getImage().getScaledInstance(la,
						ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(e, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'F':
				JLabel f = new JLabel();
				f.setIcon(new ImageIcon(new ImageIcon("sprite/lv.png").getImage().getScaledInstance(la, ha,
						Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(f, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'G':
				JLabel g = new JLabel();
				g.setIcon(new ImageIcon(new ImageIcon("sprite/vd.png").getImage()
						.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(g, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'H':
				JLabel h = new JLabel();
				h.setIcon(new ImageIcon(new ImageIcon("sprite/vg.png").getImage()
						.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(h, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'I':
				JLabel i = new JLabel();
				i.setIcon(new ImageIcon(new ImageIcon("sprite/o.png").getImage()
						.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(i, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'J':
				JLabel j = new JLabel();
				j.setIcon(new ImageIcon(new ImageIcon("sprite/id2.png").getImage()
						.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(j, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'K':
				JLabel k = new JLabel();
				k.setIcon(new ImageIcon(new ImageIcon("sprite/iv2.png").getImage()
						.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(k, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'L':
				JLabel l = new JLabel();
				l.setIcon(new ImageIcon(new ImageIcon("sprite/vd2.png").getImage()
						.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(l, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			case 'M':
				JLabel m = new JLabel();
				m.setIcon(new ImageIcon(new ImageIcon("sprite/vg2.png").getImage()
						.getScaledInstance(la, ha, Image.SCALE_DEFAULT)));
				lock.lock();
				try {
					remove(oldx+oldy*xmax);
					add(m, oldx+oldy*xmax);
				} finally {
					lock.unlock();
				}
				break;
			}
			lock.lock();
			try {
				remove(x+y*xmax);
				add(v, x+y*xmax);
			} finally {
				lock.unlock();
			}
			oldx = x;
			oldy = y;
			revalidate();
			repaint();
		}
	}
}