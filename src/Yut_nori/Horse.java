package Yut_nori;

public class Horse {
  int position = -1;
	
	int getposition() {
		return this.position;
	}
	void changep (int now, String s) {
		/*String s는 직진할지 꺾을지 입력받는 건데 어떻게 입력받을지 모르겠어서 임의로 string으로 설정*/
		switch(now) {
		case 5:
			if(s.equals("go")) {
				this.position = 6;
			}
			else {
				this.position = 20;
			}
			break;
		case 10:
			if(s.equals("go")) {//밑으로 내려가는 경우
				this.position = 11;
			}
			else {
				this.position = 25;
			}
			break;
		case 15://이건 위로 올라가는 case를 따져야할지 모르겠어서 일단 보류
			this.position++;
			break;
		case 22:
			if(s.equals("go")) {
				this.position = 23; //왼쪽 길로 내려갈 때
			}
			else {
				this.position = 27;
			}
			break;
		default:
			this.position++;
		}
	}
}
