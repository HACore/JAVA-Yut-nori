package Yut_nori;

public class Game {

		Board[] b = new Board[29];

		Game(){
    
    		// init Board location
    		for(int i=0; i<6; i++) {
					b[i].x = 700;
					b[i].y = 700-100*i;
					b[i+10].x = 100;
					b[i+10].y = 100*i;
				}
				for(int i=0; i<4; i++) {
					b[i+6].x = 500-100*i;
					b[i+6].y = 100;
					b[i+16].x = 200+100*i;
					b[i+16].y = 600;
				}
				for(int i=0; i<5; i++) {
					b[i+20].x = 600-83*(i+1);
					b[i+20].y = 100+83*(i+1);
				}
				for(int i=0; i<2; i++) {
					b[i+25].x = 100+83*(i+1);
					b[i+25].y = 100+83*(i+1);
					b[i+27].x = 100+83*(i+4);
					b[i+27].y = 100+83*(i+4);
				}
    }
}
