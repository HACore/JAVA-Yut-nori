package YutnoriClient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
//import javax.swing.JOptionPane;
import Yutnori.Game;

public class GameThread extends Thread {
	
	private Socket client;
	private int id;
	private BufferedReader reader;
	private PrintWriter writer;
	private Game game;
	
	public GameThread(Game game, Socket client, int id) {
		this.game = game;
		this.client = client;
		this.id = id;
	}
	
	@Override
	public void run() {
		
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);
			String msg;
			
			game.start(id);
			
			while(true)
			{
				msg = reader.readLine();
				
				if(msg.startsWith("[Your turn]")) {
					System.out.println("my turn");
					game.run(id);
					
					if(game.isWin(id)) {
						writer.println("[Win]");
						System.out.print("win the game!");
						break;
					}
				}
				else if(msg.startsWith("[You lose]")) {
					writer.println("[Lose]");
					System.out.print("lose the game...");
					break;
				}
				
				writer.println("[Stop my turn]");
			}
		}
		catch(IOException e) { e.printStackTrace(); }
		finally {
			try {
				if(reader != null) reader.close();
				if(writer != null) writer.close();
				if(client != null) client.close();
			}
			catch(IOException e) { e.printStackTrace(); }
		}
	}
	
//	public boolean isTerminated() {
//		int answer = JOptionPane.showConfirmDialog(null, "The opponent has left the game.\nWant to leave the game?", 
//												   "Game closed", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
//		
//		if(answer == JOptionPane.YES_OPTION)
//			return true;
//		else
//			return false;
//	}
	
}
