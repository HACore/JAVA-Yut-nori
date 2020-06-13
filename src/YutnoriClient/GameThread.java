package YutnoriClient;

import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

//import Yutnori.Game;

public class GameThread extends Thread {
	
	private Socket client;
	private PrintWriter writer;
	
	public GameThread(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		
		try {
			writer = new PrintWriter(client.getOutputStream(), true);
			
			
			
			
			
			
		}
		catch(IOException e) { e.printStackTrace(); }
		finally {
			try {
				writer.close();
				client.close();
			}
			catch(IOException e) { e.printStackTrace(); }
		}
	}
	
	public boolean isTerminated() {
		int answer = JOptionPane.showConfirmDialog(null, "상대방이 게임을 나갔습니다.\n게임을 나가시겠습니까?", "게임 종료", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
		
		if(answer == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}
}
