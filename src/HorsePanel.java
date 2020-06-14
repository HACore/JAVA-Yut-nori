
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class HorsePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Game game;
	ImageIcon imageM = new ImageIcon("../image/M.PNG");//이건 정상적인 명륜이
	ImageIcon imageY = new ImageIcon("../image/Y.PNG");//정상 율전이
	
	JLabel mLabel = new JLabel(imageM);
	JLabel yLabel = new JLabel(imageY);

	int mx, my, yx, yy;
	HorsePanel(Game game){
		this.game = game;
		
		setPreferredSize(new Dimension(1400,700));
		setOpaque(false);//JPanel이 원래 기본값이 투명이라는 소리를 들은 것 같은데 빼도 되면 빼고.
		setting();
		
		add(mLabel); add(yLabel);
		
		setVisible(true);
	}

	
	public void change(Horse h) {
		if(h.getposition() >= 30) {
			if(h.id == 0) {
				mLabel.setLocation(800, 35);
			}
			else {
				yLabel.setLocation(1000, 70);
			}
		}
		else {
			if(h.id == 0) {
				mLabel.setLocation(h.posx, h.posy);
			}
			else {
				yLabel.setLocation(h.posx, h.posy);
			}
		}
	}
	public void setting () {//말 초기위치 설정. 일단 임의로 정해둔거야!
		mLabel.setSize(30,30); mLabel.setLocation(800, 35);
		yLabel.setSize(30,30); yLabel.setLocation(1000, 70);
	}

}