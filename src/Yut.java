//package Yutnori;

import java.util.Random;
import java.awt.*;
import java.io.Serializable;

//import java.awt.event.*;
import javax.swing.*;

public class Yut implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int move;
	//ButtonClickListener로 받아온 event 처리
	public int throwYut() {
		
		Random random = new Random();
		move = random.nextInt(6);
		
		if(move == 4 || move == 5) {
			
		}
		motion(move);
		
//		if(move == 0) move = -1;
		
		return move;
	}
	
	private void motion(int move) {
		
	}
	
//	public int getMove() {
//		return move;
//	}
	
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
//		yutImage = new JLabel(image);
//		add(yutImage);
	}
//	public void paintComponent(Graphics g) {
//		g.drawImage(image.getImage(),0,0,null);
//	}
}