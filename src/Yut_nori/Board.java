package Yutnori;

public class Board {
	
	Position[] pos = new Position[30];
	
	public Board() {
		
		for(int i=0; i<30; i++) {
			pos[i] = new Position();
		}
		
		// init Board position
		for(int i=0; i<6; i++) {
			pos[i].x = 700;
			pos[i].y = 700-100*i;
			pos[i+10].x = 100;
			pos[i+10].y = 100*i;
		}
		for(int i=0; i<4; i++) {
			pos[i+6].x = 500-100*i;
			pos[i+6].y = 100;
			pos[i+16].x = 200+100*i;
			pos[i+16].y = 600;
		}
		for(int i=0; i<5; i++) {
			pos[i+20].x = 600-83*(i+1);
			pos[i+20].y = 100+83*(i+1);
			pos[i+25].x = 100+83*(i+1);
			pos[i+25].y = 100+83*(i+1);
		}
	}
	
	public void setHorse(int idx, Horse horse) {
		pos[idx].player = horse;
	}
}

class Position {
	
	int x,y;
	// player num in that position
	Horse[] player = new Horse[4];
//	int player = 0;
	int cnt = 0;
}
