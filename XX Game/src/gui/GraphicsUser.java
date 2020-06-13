package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GraphicsUser extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1277299519491668317L;
	public GraphicsUser() {
		super();
		repaint();
	}
	public void paintComponent(Graphics g) {
		setBackground(Color.gray);
		super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g.create();
	    try {
			stickMan(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void stickMan(Graphics g) throws IOException {
	    Graphics2D g2d = (Graphics2D) g.create();
	    URL img = getClass().getResource("assets/stickman.png");
	    BufferedImage stickman = ImageIO.read(img);
	    g2d.drawImage(stickman, 0, 25, null);
	}
}
