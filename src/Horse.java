import java.io.Serializable;

//package Yutnori;

public class Horse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int position = -1;
	int posx, posy; //���� ��ǥ
	int go;
	char s;
	public int id;//�̰� Ȥ�� ������� �������� �ľ� �ʿ��ϸ� ������ �־�״µ� ������ �����Ⱦ����� �𸣰ھ�
	
	void getBoardPos(Board board) {
		Board b = board;
		posx = b.pos[position].x;
		posy = b.pos[position].y;
	}
	
//	void getYutMove(Yut yut) {
//		Yut y = yut;
//		go = yut.getMove();
//	}
	
	void getDirection (Frame f) {//� ����?���� ���� �޾ƿ��� ��
		s = f.ReturnC();
	}

	int getposition() {//�̰� Ȥ�� �� ��ġ �ٸ� ������ �� �� ������ �� �������� �Լ�
		return this.position;
	}
	
	void gotoStart() {//�̰� �� ��Ƹ����� �׷� ���?��... Game���� ��������ָ� �ȵɱ�...?
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
			if(s == right) {//������ �������� ���
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
