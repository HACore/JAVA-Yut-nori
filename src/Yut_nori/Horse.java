package Yut_nori;

public class Horse {
	private int position = -1;
	
	int getposition() {
		return this.position;
	}
	void changep (int d, String s) {
		/*String s는 직진할지 꺾을지 입력받는 건데 어떻게 입력받을지 모르겠어서 임의로 string으로 설정*/
		switch(position) {
		case 5:
			if(s.equals("go")) {
				this.position = 6+(d-1);
			}
			else {
				this.position = 20+(d-1);
			}
			break;
		case 10:
			if(s.equals("go")) {//밑으로 내려가는 경우
				this.position = 11+(d-1);
			}
			else {
				this.position = 25+(d-1);
			}
			break;
		case 15://이건 위로 올라가는 case를 따져야할지 모르겠어서 일단 보류
			this.position += d;
			break;
		case 22:
			if(d>2) {
				this.position = 15+(d-3);
			}
			else {
				this.position += d;
			}
			break;
		case 27:
			this.position += d;
		default:
			if(position>=20 && position<=24) {
				if(d>=(25-position)) {
					this.position = 15+(d-(25-position));
				}
				else {
					this.position += d;
				}
			}
			else {
				this.position += d;
			}
		}
	}
}

class HorsePanel extends JPanel{
	
	ImageIcon imageM;
	ImageIcon imageY;
	JPanel Horses1 = new JPanel();
	JPanel Horses2 = new JPanel();
	JLabel p1 = new JLabel("Player1");
	JLabel p2 = new JLabel("Player2");
	JLabel image1 = new JLabel();
	JLabel image2 = new JLabel();
	
	public HorsePanel() {
		setLayout(null);
		setBounds(0, 0, 1, 1);
		
		Horses1.setLayout(new GridLayout(1,5));
		Horses2.setLayout(new GridLayout(1,5));
		
		imageM = new ImageIcon("../image/M.PNG");
		imageY = new ImageIcon("../image/Y.PNG");
		
		image1 = new JLabel(imageM);
		image2 = new JLabel(imageY);
		
		Horses1.add(p1);
		Horses1.add(image1);
		Horses1.add(image1);
		Horses1.add(image1);
		Horses1.add(image1);
		
		Horses2.add(p2);
		Horses2.add(image2);
		Horses2.add(image2);
		Horses2.add(image2);
		Horses2.add(image2);
		
		
		this.add(Horses1);
		this.add(Horses2);
	}
}
