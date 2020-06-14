//package Yutnori;

import java.io.Serializable;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	int id;
	Horse horse = new Horse();

	Player(int k){
		this.id = k;
	}
	int score = 0;
}
