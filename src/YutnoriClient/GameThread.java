package YutnoriClient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;
import Yutnori.Game;

public class GameThread extends Thread {
	
	private Socket client;
	private int id;
	private PrintWriter writer;
	private BufferedReader reader;
	private Game game;
	
	public GameThread(Socket client, int id) {
		this.client = client;
		this.id = id;
	}
	
	@Override
	public void run() {
		
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);
			
			String msg = reader.readLine();
			
			game = new Game();
			game.run();
			
			
			
			
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
		int answer = JOptionPane.showConfirmDialog(null, "The opponent has left the game.\nWant to leave the game?", 
												   "Game closed", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
		
		if(answer == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}
}
