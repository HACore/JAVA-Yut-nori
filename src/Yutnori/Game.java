package Yutnori;

import javax.swing.JOptionPane;

public class Game {
	
	Board board;
	
	public void start() {
		
		board = new Board();
	}
	
	public boolean isTerminated() {
		int answer = JOptionPane.showConfirmDialog(null, "상대방이 게임을 나갔습니다.\n게임을 나가시겠습니까?", "게임 종료", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
		
		if(answer == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}
}
