package Yut_nori;

import java.util.Random;
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class Yut {
	private int move;
	
	//ButtonClickListener
	public int Throw() {
		
		Random random = new Random();
		move = random.nextInt(6);
		return move;
	}
	
	public int getMove() {
		return move;
	}
	public JPanel getYutPanel(int move) {
		return new YutPanel(move) {
			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(),0,0,null);
			}
		};
	}

}

class YutMotionPanel extends JPanel{
	
	Image image;
	
	YutMotionPanel() {
		image = Toolkit.getDefaultToolkit().createImage("../image/yut_motion.gif");  
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, this);
		}
	}
}

class YutPanel extends JPanel{
	
	ImageIcon image;
	JLabel yutImage;
	
	public YutPanel(int move) {
		setLayout(null);
		setBounds(0, 0, 1, 1);
		
		image = new ImageIcon("../image/" + move + ".PNG");
		yutImage = new JLabel(image);
		add(yutImage);
	}
}
