package Yut_nori;

public class Player {
	int id;
	Horse[] horse = new Horse[4];
	{
		for(int i = 0; i < 4; i++) {
			horse[i] = new Horse();
		}
	}
	Player(int k){
		this.id = k;
		for(int i = 0; i < 4; i++) {
			if(horse[i].id == 0) {
				horse[i].num = i;
			}
			else {
				horse[i].num = 3+i;
			}
		}
	}
	int score = 0;
	int throwing = 1;
}
