package javateam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class temp extends JFrame{

	ImageIcon imageM = new ImageIcon("../image/M.PNG");//�̰� �������� �����
	ImageIcon imageY = new ImageIcon("../image/Y.PNG");//���� ������
	
	JButton m1 = new JButton(imageM); JButton m2 = new JButton(imageM);
	JButton m3 = new JButton(imageM); JButton m4 = new JButton(imageM);
	JButton y1 = new JButton(imageY); JButton y2 = new JButton(imageY);
	JButton y3 = new JButton(imageY); JButton y4 = new JButton(imageY);
	
	temp(){//��ü ������ ��ü����... ��ü ���������� �ű�ž�
		
		m1.setOpaque(false); m2.setOpaque(false);
		m3.setOpaque(false); m4.setOpaque(false);
		y1.setOpaque(false); y2.setOpaque(false);
		y3.setOpaque(false); y4.setOpaque(false);
		
		m1.setBorderPainted(false); m2.setBorderPainted(false);
		m3.setBorderPainted(false); m4.setBorderPainted(false);
		y1.setBorderPainted(false); y2.setBorderPainted(false);
		y3.setBorderPainted(false); y4.setBorderPainted(false);
		
		setting();
		
		m1.addActionListener(new ButtonClickListener());

	}
	
	class ButtonClickListener implements ActionListener {
		//�̰� position �޾ƿԴٴ� ���� �Ͽ� �װɷ� ������ �����ӿ��� ������ǥ�� ���°ɷ� ģ�ž�.
		//b[i].x, y ��� �����ϸ� �ɵ�. ������ x, y�� ��� ���� ����������...
		int positionx = 20;
		int positiony = 20;
		
		public void actionPerformed (ActionEvent e) {
			if(e.getSource() == m1) {
				m1.setLocation(positionx, positiony);
			}
			//�̷������� �� m1~y4����... �ٵ� �ʹ� �� ��ư Ŭ������ ���� ���� Ŭ������ ���� �ɷ� ��ġ��ͱ��ѵ�
			//��ư Ŭ������ ����ϱ� �������� ������ ����������� �ٵ� �̰͵� position ��ǥ ���޾ƿ��� �Ȱ��� �� ������
		}
	}
	//�׸��� ��ưŬ��ó�� �̺�Ʈ�� ���Ƿ� �ϳ� ���� ��ü ���ӿ��� ��Ƹ����� ������ ������ �ű� ���ǹ���
	//���Ƿ� ���� �̺�Ʈ�� �ٷ� ������Ѽ� �� ��ġ�� �ʱⰪ���� �ǵ����� ������ ��ü ���ӿ��� ��� ���ư��� ���� �ϴ� ���ܵ׾�
	
	public void setting () {//�� �ʱ���ġ ����.
		m1.setSize(30,30); m1.setLocation(100, 0);
		m2.setSize(30,30); m2.setLocation(100, 0);
		m3.setSize(30,30); m3.setLocation(100, 0);
		m4.setSize(30,30); m4.setLocation(100, 0);
		y1.setSize(30,30); y1.setLocation(100, 0);
		y2.setSize(30,30); y2.setLocation(100, 0);
		y3.setSize(30,30); y3.setLocation(100, 0);
		y4.setSize(30,30); y4.setLocation(100, 0);
	}

}
