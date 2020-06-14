package Yutnori;

public class Horse {
	private int position = -1;
	int posx, posy;
	int go;
	char s;
	Board b;
	public int id;
	public int num;
	
	void getBoardPos(Board board) {
		b = board;
		posx = b.pos[position].x;
		posy = b.pos[position].y;
	}
	
	void getYutMove(Yut yut) {
		go = yut.getMove();
	}
	
	void getDirection (Frame f) {
		s = f.ReturnC();
	}
	int getposition() {
		return this.position;
	}
	void gotoStart() {//이건 걍 잡아먹히면... Game에서 실행시켜주면 안될까...?
		this.position = -1;
	}
	int changep () {

		char left = 'l';
		char right = 'r';
		
		switch(position) {
		//position에 업데이트 해주는데 상대편 말 있는지 먼저 체크, 있으면 걔 위치 초기화하는 함수 부르고
		//아니면 그냥 그 말 개수 불러와서 Horse[num]에 Horse 업데이트 해주고 개수도++
		case 5:
			if(s == left) {
				this.position = 20+(go-1);
			}
			else {
				this.position = 6+(go-1);
			}

			break;
		case 10:
			if(s == right) {//밑으로 내려가는 경우
				this.position = 25+(go-1);
			}
			else {
				this.position = 11+(go-1);
			}
			break;
		case 15:
			this.position += go;
			break;
		case 22:
			if(go>2) {
				this.position = 15+(go-3);
			}
			else {
				this.position += go;
			}
			break;
		case 27:
			this.position += go;
		default:
			if(position>=20 && position<=24) {
				if(go>=(25-position)) {
					this.position = 15+(go-(25-position));
				}
				else {
					this.position += go;
				}
			}
			else {
				this.position += go;
			}
		}
		
		if(this.num<4&&b.pos[position].opponent_num>0 | this.num>=4&&b.pos[position].player_num>0) {
			return position;//잡아먹었을 때 그 자리 return. 그럼 그 자리에 있는 지금 턴이 아닌, 잡아먹혀야 할 말을 없애주는 거.
		}
		else {
			return -1;
		}

	}
}
