
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Frame extends JFrame{
	public static void main(String[] args) {
		
		Frame frame = new Frame();
		// 종료 event
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	int p = 0;
	int o = 0;
	
	Frame() {
		
		setTitle("Yut-nori");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		
		ImageIcon b = new ImageIcon(".\\image\\yut.png");
		JLabel b2 = new JLabel(b);
		b2.setBounds(10,10,700,700);
		
		
		
		setSize(1400,700);
		setVisible(true);
	}
	
	class Left implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
