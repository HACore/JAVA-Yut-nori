
import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class HorsePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Game game;
	ImageIcon imageM = new ImageIcon("../image/M.PNG");//�̰� �������� �����
	ImageIcon imageY = new ImageIcon("../image/Y.PNG");//���� ������
	
	JLabel mLabel = new JLabel(imageM);
	JLabel yLabel = new JLabel(imageY);

	int mx, my, yx, yy;
	HorsePanel(Game game){
		this.game = game;
		
		setPreferredSize(new Dimension(1400,700));
		setOpaque(false);//JPanel�� ���� �⺻���� �����̶�� �Ҹ��� ���� �� ������ ���� �Ǹ� ����.
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
	public void setting () {//�� �ʱ���ġ ����. �ϴ� ���Ƿ� ���صаž�!
		mLabel.setSize(30,30); mLabel.setLocation(800, 35);
		yLabel.setSize(30,30); yLabel.setLocation(1000, 70);
	}

}