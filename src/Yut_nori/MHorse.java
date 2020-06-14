package javateam;

import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MHorse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public JPanel getMPanel() {
		return new MPanel() {

			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(imageM.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};
	}

}

class MPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	ImageIcon imageM;
	JLabel MImage;
	
	public MPanel() {
		setLayout(null);
		setBounds(0, 0, 1, 1);
		
		imageM = new ImageIcon("../image/M.PNG");
		MImage = new JLabel(imageM);
		add(MImage);
	}

}
