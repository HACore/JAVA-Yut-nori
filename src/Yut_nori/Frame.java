
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	public static void main(String[] args) {
		
		Frame frame = new Frame();
		// 종료 event. 한 쪽이 지거나 다른 쪽이 이기면 이렇게 하면 될 듯
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	int p = 0;
	int o = 0;
	char c = 'r';
	
	Frame() {
		
		setTitle("Yut-nori");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 2,1 grid로 나눠 왼쪽은 판, 오른쪽은 말 윷 등등
		setLayout(new GridLayout(1,2));
		
		// 왼쪽 패널
		File file = new File(".");
		String path = file.getAbsolutePath();
		ImageIcon icon = new ImageIcon(path+"\\image\\board.png");
		JPanel lpanel = new JPanel() {		
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,650,650,null);
			}
		};
		lpanel.setPreferredSize(new Dimension(700,700));
		
		// 오른쪽 패널
		JPanel rpanel = new JPanel();
		JPanel button1 = new JPanel();
		JPanel button2 = new JPanel();
		button1.setPreferredSize(new Dimension(700,100));
		button2.setPreferredSize(new Dimension(700,100));
		
		// left 버튼
		JButton lb = new JButton("LEFT");
		Left lbutton = new Left();
		lb.addActionListener(lbutton);
		lb.setPreferredSize(new Dimension(330,80));
		/* button enable & disable */
		// lb.setEnabled(true);
		// lb.setEnabled(true);
		
		// right 버튼
		JButton rb = new JButton("RIGHT");
		Right rbutton = new Right();
		rb.addActionListener(rbutton);
		rb.setPreferredSize(new Dimension(330,80));
		/* button enable & disable */
		// rb.setEnabled(true);
		// rb.setEnabled(true);
		
		// throw 버튼
		JButton tr = new JButton("THROW YUT");
		Right trbutton = new Right();
		tr.addActionListener(trbutton);
		tr.setPreferredSize(new Dimension(665,80));
		/* button enable & disable */
		// tr.setEnabled(true);
		// tr.setEnabled(true);
		
		button1.add(lb);
		button1.add(rb);
		button2.add(tr);
		
		rpanel.add(button1);
		rpanel.add(button2);
		
		add(lpanel);
		add(rpanel);
		
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
			// 윷 던지기 코드 삽입 바람
		}
	}
}
