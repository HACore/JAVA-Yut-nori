import java.io.Serializable;

//package Yutnori;

public class Horse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int position = -1;
	int posx, posy; //말의 좌표
	int go;
	char s;
	public int id;//이건 혹시 명륜인지 율전인지 파악 필요하면 쓰려고 넣어뒀는데 솔직히 쓸지안쓸지는 모르겠어
	
	void getBoardPos(Board board) {
		Board b = board;
		posx = b.pos[position].x;
		posy = b.pos[position].y;
	}
	
//	void getYutMove(Yut yut) {
//		Yut y = yut;
//		go = yut.getMove();
//	}
	
	void getDirection (Frame f) {//어떤 방향?으로 갈지 받아오는 거
		s = f.ReturnC();
	}

	int getposition() {//이건 혹시 말 위치 다른 곳에서 쓸 일 있으면 값 리턴해줄 함수
		return this.position;
	}
	
	void gotoStart() {//이건 걍 잡아먹히는 그런 경우?에... Game에서 실행시켜주면 안될까...?
		this.position = -1;
	}
	
	void changep (int move) {
		
		go = move;
		
		char left = 'l';
		char right = 'r';
		
		switch(position) {
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
	}
}
