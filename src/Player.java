//package Yutnori;

import java.io.Serializable;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Horse[] horse = new Horse[4];
	int id;
	int score = 0;
	int outside = 0;//�����ִ� ���� ������ �ʿ��� �� ���Ҿ� �� �̹��� �����Ϸ���
	Player(int id) {
		this.id = id;
	}
}
