//package Yutnori;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame{

	Game game;
	
	JButton lb = new JButton("← LEFT");
	JButton rb = new JButton("RIGHT →");
	JButton tr = new JButton("THROW YUT");
	
	JPanel rpanel;
	
	Frame(Game game) {
		
		this.game = game;
		
		setTitle("Yut-nori");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 2,1 grid로 나눠 왼쪽은 판, 오른쪽은 말 윷 등등
		setLayout(new GridLayout(1,2));
		
		// 왼쪽 패널
		File file = new File(".");
		String path = file.getAbsolutePath();
		ImageIcon icon = new ImageIcon(path+"\\image\\board2.png");
		JPanel lpanel = new JPanel() {		
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),30,30,600,600,null);
			}
		};
		lpanel.setPreferredSize(new Dimension(700,700));
		
		// 오른쪽 패널
		rpanel = new JPanel();
		JPanel button2 = new JPanel();
		button2.setBackground(Color.white);
		button2.setPreferredSize(new Dimension(700,80));
		
		//윷 그림
		File file2 = new File(".");
		String path2 = file2.getAbsolutePath();
		ImageIcon icon2 = new ImageIcon(path2+"\\image\\5.png");
		JPanel ypanel = new JPanel(){		
			public void paintComponent(Graphics g) {
				g.drawImage(icon2.getImage(),0,0,null);
			}
		};
		ypanel.setPreferredSize(new Dimension(300,215));
		
		//Color sky = new Color(208,223,239);
		Color sky = new Color(153,217,234);
		
		// throw 버튼
		Throw trbutton = new Throw();
		tr.addActionListener(trbutton);
		tr.setPreferredSize(new Dimension(665,70));
		tr.setBackground(sky);
		tr.setBorderPainted(false);
		/* button enable & disable */
		tr.setEnabled(false);
		
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
		
		button2.add(tr);
		
		rpanel.add(horsepl);
		rpanel.add(ypanel);
		rpanel.add(button2,BorderLayout.SOUTH);
		
		add(lpanel);
		add(rpanel);
		
		rpanel.setBackground(Color.white);
		getContentPane().setBackground(Color.white);
		setSize(1400,700);
		setVisible(true);
	}
	
	void setYut(JPanel y) {
		y.setPreferredSize(new Dimension(300,215));
		rpanel.add(y);
	}
	
	void enableButton(boolean b) {
		lb.setEnabled(b);
		rb.setEnabled(b);
		tr.setEnabled(b);
	}
	
	int Throw() {
		
		Random random = new Random();
		return random.nextInt(6);
	}
	class Throw implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			game.throwYut();
//			TEnable(false);
		}
	}
}
