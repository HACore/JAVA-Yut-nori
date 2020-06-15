import java.io.Serializable;

//package Yutnori;

//import java.io.Serializable;

public class Board implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Position[] pos = new Position[30];
	
	{
		for(int i = 0; i < 30; i++) {
			pos[i] = new Position();
		}
	}
	
	public Board() {
		// init Board position
		for(int i=0; i<6; i++) {
			pos[i].x = 530;
			pos[i].y = 530-104*i;
			pos[i+10].x = 10;
			pos[i+10].y = 20+104*i;
		}
		for(int i=0; i<4; i++) {
			pos[i+6].x = 530-104*(i+1);
			pos[i+6].y = 20;
			pos[i+16].x = 10+100*(i+1);
			pos[i+16].y = 530;
		}
		for(int i=0; i<5; i++) {
			pos[i+20].x = 530-87*(i+1);
			pos[i+20].y = 20+85*(i+1);
			pos[i+25].x = 10+87*(i+1);
			pos[i+25].y = 20+85*(i+1);
		}
	}
}

class Position implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	int x,y;
}
