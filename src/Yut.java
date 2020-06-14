
import java.util.Random;
import java.awt.*;
import java.io.Serializable;

//import java.awt.event.*;
import javax.swing.*;

public class Yut implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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

			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(image.getImage(),0,0,null);
			}
		};
	}

}


class YutPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
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