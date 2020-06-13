package Yutnori;

public class Board {

	// position
	int x,y;
	// player num in that position
	int player = 0;
	int opponent = 0;
	
	Board[] pos = new Board[30];
	
	public Board() {
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
}