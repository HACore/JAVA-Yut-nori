
import java.io.Serializable;
import javax.swing.JOptionPane;

public class Game implements Serializable {

	private static final long serialVersionUID = 1L;
	
	Player[] player;
	Frame frame;
	Board board;
	HorsePanel horsePanel;
	Horse[] horse;
	Yut yut;
	int id;
	
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

	}
	
	public void start(int id) {
		frame = new Frame(this);
		horsePanel = new HorsePanel(this);
		this.id = id;
	}
	
	public void run(int id) {
		
		myturn();
		
		int y = frame.Throw();
		frame.enableButton(true);
		
		player[id].horse.changep(board, y);
		
		frame.setYut(yut.getYutPanel(y));

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
	}
	
	public void changeHorsePos(Horse horse) {
		horse.changep(board, move);
	}
	
	public void myturn() {
		JOptionPane.showMessageDialog(null, "My turn!", "Message", JOptionPane.PLAIN_MESSAGE);
	}
}
