package Yutnori;

import java.util.Random;
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class Yut {
	
	//ButtonClickListener로 받아온 event 처리
	public int Throw() {
		
		Random random = new Random();
		int move = random.nextInt(6);
		
		if(move == 4 || move == 5) {
			
		}
		motion(move);
		
//		if(move == 0) move = -1;
		
		return move;
	}
	
	private void motion(int move) {
		
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