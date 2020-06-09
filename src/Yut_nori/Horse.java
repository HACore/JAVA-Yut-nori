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
