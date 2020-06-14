//package Yutnori;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HorsePanel extends JPanel {

	Game game;
	ImageIcon imageM = new ImageIcon("../image/M.PNG");//�̰� �������� �����
	ImageIcon imageY = new ImageIcon("../image/Y.PNG");//���� ������
	
	JButton m1 = new JButton(imageM); JButton m2 = new JButton(imageM);
	JButton m3 = new JButton(imageM); JButton m4 = new JButton(imageM);
	JButton y1 = new JButton(imageY); JButton y2 = new JButton(imageY);
	JButton y3 = new JButton(imageY); JButton y4 = new JButton(imageY);
	int m1x, m1y, m2x, m2y, m3x, m3y, m4x, m4y;
	int y1x, y1y, y2x, y2y, y3x, y3y, y4x, y4y;
	Horse tempH;
	HorsePanel(Game game){
		this.game = game;
		
		setPreferredSize(new Dimension(1400,700));
		setOpaque(false);//JPanel�� ���� �⺻���� �����̶�� �Ҹ��� ���� �� ������ ���� �Ǹ� ����.
		transparent();
		setting();
		
		m1.addActionListener(new ButtonClickListener());
		m1.setEnabled(false);
		m2.addActionListener(new ButtonClickListener());
		m2.setEnabled(false);
		m3.addActionListener(new ButtonClickListener());
		m3.setEnabled(false);
		m4.addActionListener(new ButtonClickListener());
		m4.setEnabled(false);
		y1.addActionListener(new ButtonClickListener());
		y1.setEnabled(false);
		y2.addActionListener(new ButtonClickListener());
		y2.setEnabled(false);
		y3.addActionListener(new ButtonClickListener());
		y3.setEnabled(false);
		y4.addActionListener(new ButtonClickListener());
		y4.setEnabled(false);
		
		add(m1); add(m2); add(m3); add(m4);
		add(y1); add(y2); add(y3); add(y4);
		
		setVisible(true);
	}
//	void getHorse(Horse h) {
//		//�ʿ��� Horse �����ͼ� ����Ϸ���. Game���� �Ź� ���������� �ҵ�..? �� ���������� ��ư ���� �����̱� ����
//		tempH = h;
//	}
	

	public void setting () {//�� �ʱ���ġ ����. �ϴ� ���Ƿ� ���صаž�!
		m1.setSize(30,30); m1.setLocation(800, 35);
		m2.setSize(30,30); m2.setLocation(850, 35);
		m3.setSize(30,30); m3.setLocation(900, 35);
		m4.setSize(30,30); m4.setLocation(950, 35);
		y1.setSize(30,30); y1.setLocation(1000, 70);
		y2.setSize(30,30); y2.setLocation(1050, 70);
		y3.setSize(30,30); y3.setLocation(1100, 70);
		y4.setSize(30,30); y4.setLocation(1150, 70);
		
	}

	public void transparent() {//�����ϰ� ���ִ� ��
		m1.setOpaque(false); m2.setOpaque(false);
		m3.setOpaque(false); m4.setOpaque(false);
		y1.setOpaque(false); y2.setOpaque(false);
		y3.setOpaque(false); y4.setOpaque(false);
		
		m1.setBorderPainted(false); m2.setBorderPainted(false);
		m3.setBorderPainted(false); m4.setBorderPainted(false);
		y1.setBorderPainted(false); y2.setBorderPainted(false);
		y3.setBorderPainted(false); y4.setBorderPainted(false);
	}
	
	void enableButton(int id, boolean b) {
		if(id == 0) {
			m1.setEnabled(b);
			m2.setEnabled(b);
			m3.setEnabled(b);
			m4.setEnabled(b);
		}
		else if(id == 1) {
			y1.setEnabled(b);
			y2.setEnabled(b);
			y3.setEnabled(b);
			y4.setEnabled(b);
		}
	}
	
	//�ٽ� ó������ ���ư��� �ϸ�(��Ƹ����ų�, ���� �°ų�) ���Ƿ� �̺�Ʈ �ű⼭ �߻����Ѿ� �� ��...?
	class ButtonClickListener implements ActionListener {

		public void actionPerformed (ActionEvent e) {
			
			tempH = game.peakHorse(e.getSource());
			game.changeHorsePos(tempH);
			
			int p = tempH.getposition();
			
			if(e.getSource() == m1) {
				if(p == -1 | p >= 30) {//����Ʈ�� �� ���� ��ġ�� ���ư��� ��
					m1.setLocation(800, 35);
				}
				else {//�̰� ���� Ư�� ��Ȳ�� �ƴ� �� ������ġ �ٲ㼭 �������ִ� ��
					m1x = tempH.posx;
					m1y = tempH.posy;
					m1.setLocation(m1x, m1y);
				}
			}
			if(e.getSource() == m2) {
				if(p == -1 | p >= 30) {
					m2.setLocation(850, 35);
				}
				else {
					m2x = tempH.posx;
					m2y = tempH.posy;
					m2.setLocation(m2x, m2y);
				}
			}
			if(e.getSource() == m3) {
				if(p == -1 | p >= 30) {
					m3.setLocation(900, 35);
				}
				else {
					m3x = tempH.posx;
					m3y = tempH.posy;
					m3.setLocation(m3x, m3y);
				}
				
			}
			if(e.getSource() == m4) {
				if(p == -1 | p >= 30) {
					m4.setLocation(950, 35);
				}
				else {
					m4x = tempH.posx;
					m4y = tempH.posy;
					m4.setLocation(m4x, m4y);
				}
				
			}
			if(e.getSource() == y1) {
				if(p == -1 | p >= 30) {
					y1.setLocation(1000, 70);
				}
				else {
					y1x = tempH.posx;
					y1y = tempH.posy;
					y1.setLocation(y1x, y1y);
				}
				
			}
			if(e.getSource() == y2) {
				if(p == -1 | p >= 30) {
					y2.setLocation(1050, 70);
				}
				else {
					y2x = tempH.posx;
					y2y = tempH.posy;
					y2.setLocation(y2x, y2y);
				}
				
			}
			if(e.getSource() == y3) {
				if(p == -1 | p >= 30) {
					y3.setLocation(1100, 70);
				}
				else {
					y3x = tempH.posx;
					y3y = tempH.posy;
					y3.setLocation(y3x, y3y);
				}
				
			}
			if(e.getSource() == y4) {
				if(p == -1 | p >= 30) {
					y4.setLocation(1150, 70);
				}
				else {
					y4x = tempH.posx;
					y4y = tempH.posy;
					y4.setLocation(y4x, y4y);
				}
				
			}
			game.horse_status = true;
		}
	}

}
