package YutnoriServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class GameServer {
	
	static ArrayList<Socket> clients;
	private ServerSocket server;
	
	public void execute() {
		
		clients = new ArrayList<Socket>();
		
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
					
					ClientManagerThread c_thread = new ClientManagerThread(client, clients.indexOf(client));
					c_thread.start();
				}
				catch(IOException e) { e.printStackTrace(); }
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
