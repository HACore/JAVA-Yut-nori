package Yutnori;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	public static void main(String[] args) {
		
		Frame frame = new Frame();
		// ���� event. �� ���� ���ų� �ٸ� ���� �̱�� �̷��� �ϸ� �� ��
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	int p = 0;
	int o = 0;
	char c = 'r';
	Yut yut = new Yut();
	
	Frame() {
		
		setTitle("Yut-nori");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 2,1 grid�� ���� ������ ��, �������� �� �� ���
		setLayout(new GridLayout(1,2));
		
		// ���� �г�
		File file = new File(".");
		String path = file.getAbsolutePath();
		ImageIcon icon = new ImageIcon(path+"\\image\\board2.png");
		JPanel lpanel = new JPanel() {		
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),30,30,600,600,null);
			}
		};
		lpanel.setPreferredSize(new Dimension(700,700));
		
		// ������ �г�
		JPanel rpanel = new JPanel();
		JPanel button1 = new JPanel();
		JPanel button2 = new JPanel();
		button1.setBackground(Color.white);
		button2.setBackground(Color.white);
		button1.setPreferredSize(new Dimension(700,80));
		button2.setPreferredSize(new Dimension(700,80));
		
		//Color sky = new Color(208,223,239);
		Color sky = new Color(153,217,234);
		
		// left ��ư
		JButton lb = new JButton("�� LEFT");
		Left lbutton = new Left();
		lb.addActionListener(lbutton);
		lb.setPreferredSize(new Dimension(330,70));
		lb.setBackground(sky);
		lb.setBorderPainted(false);
		/* button enable & disable */
		// lb.setEnabled(true);
		// lb.setEnabled(true);
		
		// right ��ư
		JButton rb = new JButton("RIGHT ��");
		Right rbutton = new Right();
		rb.addActionListener(rbutton);
		rb.setPreferredSize(new Dimension(330,70));
		rb.setBackground(sky);
		rb.setBorderPainted(false);
		/* button enable & disable */
		// rb.setEnabled(true);
		// rb.setEnabled(true);
		
		// throw ��ư
		JButton tr = new JButton("THROW YUT");
		Right trbutton = new Right();
		tr.addActionListener(trbutton);
		tr.setPreferredSize(new Dimension(665,70));
		tr.setBackground(sky);
		tr.setBorderPainted(false);
		//tr.setOpaque(true);
	    //tr.setBackground(Color.white);
		/* button enable & disable */
		// tr.setEnabled(true);
		// tr.setEnabled(true);
		
		JPanel horsepl = new JPanel();
	    horsepl.setLayout(new GridLayout(2,1));
	    horsepl.setPreferredSize(new Dimension(660, 240));
	      
	    JLabel labelP1 = new JLabel();
	    labelP1.setText("Player1");
	    labelP1.setHorizontalAlignment(SwingConstants.LEFT);
	    labelP1.setPreferredSize(new Dimension(320,120));
	    labelP1.setOpaque(true);
	    labelP1.setBackground(Color.white);
	    
	    JLabel labelP2 = new JLabel();
	    labelP2.setText("Player2");
	    labelP2.setHorizontalAlignment(SwingConstants.LEFT);
	    labelP2.setPreferredSize(new Dimension(320,120));
	    labelP2.setOpaque(true);
	    labelP2.setBackground(Color.white);
	      
	    horsepl.add(labelP1);
	    horsepl.add(labelP2);
		
		button1.add(lb);
		button1.add(rb);
		button2.add(tr);
		
		rpanel.add(horsepl);
		rpanel.add(button1);
		rpanel.add(button2);
		
		add(lpanel);
		add(rpanel);
		
		rpanel.setBackground(Color.white);
		getContentPane().setBackground(Color.white);
		setSize(1400,700);
		setVisible(true);
	}
	
	class Left implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			c = 'l';
		}
	}
	class Right implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			c = 'r';
		}
	}
	class Throw implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			yut.Throw();
		}
	}
}