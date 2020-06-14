package javateam;

import javax.swing.JOptionPane;

public class Game {

	Player[] player;
	Frame frame;
	Board board;
	HorsePanel horsePanel;
	Horse[] horse;
	Yut yut;
	int id;
	
	boolean yut_status;
	boolean horse_status;
	int move;
	
	public Game() {
		player = new Player[2];
		for(int i = 0; i < 2; i++) {
			player[i] = new Player(i);
		}
		board = new Board();
		horse = new Horse[2];
		for(int i = 0; i < 2; i++) {
			horse[i] = new Horse();
			horse[i].id = i;
		}
		yut = new Yut();
		yut_status = false;

	}
	
	public void start(int id) {
		frame = new Frame(this);
		horsePanel = new HorsePanel(this);
		this.id = id;
	}
	
	public void run(int id) {
		
		myturn();
		frame.enableButton(true);
		
		while(true) {
			if(yut_status) {
				
				frame.setYut(yut.getYutPanel(move));

				break;
			}
		}
		changeHorsePos(horse[id]);
		horsePanel.change(horse[id]);
		

		frame.enableButton(false);
	}
	
	public boolean isWin(int id) {
		
		if(player[id].score == 4)
			return true;
		
		return false;
	}
	
	public void throwYut() {
		move = yut.Throw();
		yut_status = true;
	}
	
	public void changeHorsePos(Horse horse) {
		horse.changep(board, move);
	}
	
	public void myturn() {
		JOptionPane.showMessageDialog(null, "My turn!", "Message", JOptionPane.PLAIN_MESSAGE);
	}
}
