package Yutnori;

import javax.swing.JOptionPane;

public class Game {
	
	Board board;
	
	public void start() {
		
		board = new Board();
	}
	
	public boolean isTerminated() {
		int answer = JOptionPane.showConfirmDialog(null, "������ ������ �������ϴ�.\n������ �����ðڽ��ϱ�?", "���� ����", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
		
		if(answer == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}
}
