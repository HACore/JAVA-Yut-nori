package YutnoriServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.ObjectOutputStream;
import java.net.Socket;
import Yutnori.Game;

public class ClientManagerThread extends Thread {
	
	private Socket client;
	private int id;
	private BufferedReader reader;
	private PrintWriter writer;
	private ObjectOutputStream send;
	private Game game;
	
	public ClientManagerThread(Game game, Socket client, int id) {
		this.game = game;
		this.client = client;
		this.id = id;
	}
	
	@Override
	public void run() {
		
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream())); //연결된 클라이언트에게서 메세지 수신
			writer = new PrintWriter(client.getOutputStream(), true); //연결된 클라이언트로 메세지 송신
			send = new ObjectOutputStream(client.getOutputStream()); //연결된 클라이언트에게서 게임 객체 송신
			
			if(GameServer.clients.size() < 2) { //상대방이 들어올떄까지 대기
				while(GameServer.clients.size() < 2);
			}
			writer.println("Game start!~~~"+id);
			send.writeObject(game);
			send.flush();
			
			if(id == 1) {
				writer.println("[Your turn]");
			}
			
			String msg;
			int opponent_id = 1 - id;
			writer = new PrintWriter(GameServer.clients.get(opponent_id).getOutputStream(), true); //상대방 클라이언트로 메세지 송신
			
			while(true) //게임 시작
			{
				msg = reader.readLine();
				
				if(msg.startsWith("[Stop my turn]")) {
					writer.println("[Your turn]");
				}
				else if(msg.startsWith("[Win]")) {
					writer.println("[You lose]");
					System.out.println("***client"+id+" win the game***");
					break;
				}
				else if(msg.startsWith("[Lose]")) {
					System.out.println("***client"+id+" lose the game***");
					break;
				}
				
				
				
//				if(msg.startsWith("some")) {
//					break;
//				}
//				if(true/*이 클라이언트가 강제종료*/) {
//					for(int i = 0; i < GameServer.clients.size(); i++) {
//						if(GameServer.clients.get(i) == this.client)
//							continue;
//						new PrintWriter(GameServer.clients.get(i).getOutputStream(), true).println("The opponent has left the game.");
//					}
//					break;
//				}
				

			}
			GameServer.clients.remove(client);
			reader.close();
			writer.close();
			send.close();
			client.close();
			
		} catch(IOException e) { e.printStackTrace(); }
	}
	
}
