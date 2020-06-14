import java.io.Serializable;

public class Horse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int position = 0;
	int posx, posy;
	int go;
	Board b;
	public int id;
	
	void getBoardPos(Board board) {
		b = board;
		posx = b.pos[position].x;
		posy = b.pos[position].y;
	}

	
	int getposition() {
		return this.position;
	}

	void changep (Board board, int d) {
		go = d;
		switch(position) {

		case 5:
			this.position = 20+(go-1);
			break;
		case 10:
			this.position = 25+(go-1);
			break;
		case 15:
			this.position += go;
			break;
		case 22:
			this.position = 27 + go;
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
		
		getBoardPos(board);

	}
}
