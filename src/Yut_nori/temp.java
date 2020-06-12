import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class temp extends JFrame{

	ImageIcon imageM = new ImageIcon("../image/M.PNG");//이건 정상적인 명륜이
	ImageIcon imageY = new ImageIcon("../image/Y.PNG");//정상 율전이
	
	JButton m1 = new JButton(imageM); JButton m2 = new JButton(imageM);
	JButton m3 = new JButton(imageM); JButton m4 = new JButton(imageM);
	JButton y1 = new JButton(imageY); JButton y2 = new JButton(imageY);
	JButton y3 = new JButton(imageY); JButton y4 = new JButton(imageY);
	
	temp(){//전체 프레임 대체용임... 전체 프레임으로 옮길거야
		
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
		//이게 position 받아왔다는 전제 하에 그걸로 서영이 프레임에서 고정좌표를 얻어온걸로 친거야.
		//b[i].x, y 라고 생각하면 될듯. 문제는 x, y를 어디서 어케 가져오느냐...
		int positionx = 20;
		int positiony = 20;
		
		public void actionPerformed (ActionEvent e) {
			if(e.getSource() == m1) {
				m1.setLocation(positionx, positiony);
			}
			//이런식으로 쭉 m1~y4까지... 근데 너무 길어서 버튼 클래스를 따로 만들어서 클래스에 대한 걸로 퉁치고싶긴한데
			//버튼 클래스를 만드니까 생각보다 제약이 많아지더라고 근데 이것도 position 좌표 못받아오면 똑같을 것 같긴해
		}
	}
	//그리고 버튼클릭처럼 이벤트를 임의로 하나 만들어서 전체 게임에서 잡아먹히는 순간이 나오면 거기 조건문에
	//임의로 만든 이벤트를 바로 실행시켜서 말 위치를 초기값으로 되돌리고 싶은데 전체 게임에서 어떻게 돌아갈지 몰라서 일단 남겨뒀어
	
	public void setting () {//말 초기위치 설정.
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
