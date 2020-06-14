//package YutnoriServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServer {
	
	static ArrayList<Socket> clients;
	private ServerSocket server;
	private PrintWriter writer;
	private Game game;
	
	public void execute() {
		
		clients = new ArrayList<Socket>();
		game = new Game();
		
		try {
			server = new ServerSocket(1398);
		} 
		catch(IOException e) { e.printStackTrace(); }
		System.out.println("server is ready");
		
		while(true)
		{
			while(clients.size() < 2)
			{
				try {
					Socket client = server.accept();
					System.out.println("some client is connected");
					
					clients.add(client);
					
					writer = new PrintWriter(client.getOutputStream(), true);
					if(GameServer.clients.size() < 2) {
						writer.println("Wait for an opponent to enter...");
					}
					
					ClientManagerThread c_thread = new ClientManagerThread(game, client, clients.indexOf(client));
					c_thread.start();
					c_thread.join();
				}
				catch(IOException e) { e.printStackTrace(); } 
				catch (InterruptedException e) { e.printStackTrace(); }
			}
		}
		
//		while(true) {
//			if(clients.isEmpty()) {
//				try {
//					server.close();
//				}
//				catch(IOException e) { e.printStackTrace(); }
//				System.out.println("server is closed");
//			}
//		}
	}
	
}
