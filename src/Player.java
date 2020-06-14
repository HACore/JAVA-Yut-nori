//package Yutnori;

import java.io.Serializable;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Horse[] horse = new Horse[4];
	int id;
	int score = 0;
	int outside = 0;//나가있는 말의 개수가 필요할 것 같았어 그 이미지 설정하려면
	Player(int id) {
		this.id = id;
	}
}
