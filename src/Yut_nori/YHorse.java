package javateam;

import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YHorse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public JPanel getYPanel() {
		return new YPanel() {

			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imageY.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};
	}

}

class YPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	ImageIcon imageY;
	JLabel YImage;
	
	public YPanel() {
		setLayout(null);
		setBounds(0, 0, 1, 1);

		
		imageY = new ImageIcon("../image/M.PNG");
		YImage = new JLabel(imageY);
		add(YImage);
		setSize(30,30);
	}

}