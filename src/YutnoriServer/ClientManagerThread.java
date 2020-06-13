package YutnoriServer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientManagerThread extends Thread {
	
	private Socket client;
	private int id;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public ClientManagerThread(Socket client, int id) {
		this.id = id;
		this.client = client;
	}
	
	@Override
	public void run() {
		//각각 클라이언트가 클릭한 버튼이벤트를 받아와 서버에 전송하고 결과값을 모든 클라이언트에게 뿌린다
		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);
			
			if(GameServer.clients.size() < 2) { //상대방이 들어올떄까지 대기
				writer.println("Wait for an opponent to enter...");
				while(GameServer.clients.size() < 2);
			}
			writer.println("Game start!");
			
			String msg;
			
			while(true) //게임 시작
			{
				msg = reader.readLine();
				
				
				
//				if(GameServer.clients.size() < 2) {
//					System.out.println("some client left the game");
//					writer.println("The opponent has left the game.");
//					
//					
//					
//				}
				
				if(msg == "some client left the game") {
					break;
				}
				if(true/*이 클라이언트가 강제종료*/) {
					for(int i = 0; i < GameServer.clients.size(); i++) {
						if(GameServer.clients.get(i) == this.client)
							continue;
						new PrintWriter(GameServer.clients.get(i).getOutputStream(), true).println("The opponent has left the game.");
					}
					break;
				}
			}
			GameServer.clients.remove(client);
			client.close();
			
		} catch(IOException e) { e.printStackTrace(); }
	}
	
}
