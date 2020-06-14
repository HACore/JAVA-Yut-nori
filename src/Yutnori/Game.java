package Yutnori;

import javax.swing.JOptionPane;

public class Game {

	Player[] player;
	Frame frame;
	Board board;
	HorsePanel horsePanel;
	Horse[][] horse;
	Yut yut;
	
	boolean yut_status;
	int move;
	
	public Game() {
		player = new Player[2];
		board = new Board();
		horse = new Horse[2][4];
		yut = new Yut();
		yut_status = false;
	}
	
//	void a() {
//		horse[2].getPos(board);
//		board.setHorse(5, horse[2]);
//	}
	
	public void start() {
		frame = new Frame(this);
		horsePanel = new HorsePanel(this);
		
//		for(int i = 0; i < 2; i++) {
//			for(int j = 0; j < 4; j++) {
//				
//			}
//		}
		
	}
	
	public  void run(int id) {
		
		myturn();
		frame.enableButton(true);
		
		while(true) {
			if(yut_status) {
				
				horsePanel.enableButton(id, true);
				
				horse[id][0].changep(move);
				
				horsePanel.enableButton(id, false);
				break;
			}
		}

		frame.enableButton(false);
	}
	
	public boolean isWin(int id) {
		
		if(player[id].score == 4)
			return true;
		
		return false;
	}
	
	public void throwYut() {
		move = yut.throwYut();
		yut_status = true;
	}
	
	public Horse peakHorse(Object peak) {
		
		if(peak == horsePanel.m1)
			return horse[0][0];
		else if(peak == horsePanel.m2)
			return horse[0][1];
		else if(peak == horsePanel.m3)
			return horse[0][2];
		else if(peak == horsePanel.m4)
			return horse[0][3];
		else if(peak == horsePanel.y1)
			return horse[1][0];
		else if(peak == horsePanel.y2)
			return horse[1][1];
		else if(peak == horsePanel.y3)
			return horse[1][2];
		else if(peak == horsePanel.y4)
			return horse[1][3];
		
		return null;
	}
	
	public void changeHorsePos(Horse horse) {
		horse.changep(move);
	}
	
	public void myturn() {
		JOptionPane.showMessageDialog(null, "My turn!", "Message", JOptionPane.PLAIN_MESSAGE);
	}
}