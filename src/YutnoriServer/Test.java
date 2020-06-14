package YutnoriServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//import YutnoriClient.GameThread;

public class Test {
//	private GameThread gameThread;
	private Socket client;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public void connect() {
		
		try { //서버와 연결
			client = new Socket("localhost", 1398);
		} 
		catch(IOException e) {
			System.out.println("Server is not executing");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("conneted to server!");
		
		try { //서버와의 통신수단
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);
		}
		catch(IOException e) { e.printStackTrace(); }
	}
	
	public void GameStart() {
				
		String msg = "";
		
		try {
			while(true)
			{
				System.out.println("1**********");
				msg = reader.readLine();
				System.out.println("2**********");
				
				if(msg.startsWith("Wait")) { //상대방이 들어올떄까지 대기
					System.out.println("3**********");
					System.out.println(msg);
					continue;
				}
				else {
//					gameThread = new GameThread(client);
//					gameThread.start();
					
//					while(true)
//					{
//						msg = reader.readLine();
//
//						if(msg == "The opponent has left the game.") { //상대방이 게임 강제종료
//							if(gameThread.isTerminated()) { //게임 종료
//								gameThread.interrupt();
//								writer.println("some client left the game");
//								return;
//							}
//							else { //새로운 게임 대기
//								gameThread.interrupt();
//								GameStart();
//							}
//						}
//					}
					
				}
			}
		} catch(IOException e) { e.printStackTrace(); }
		
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.connect();
		t.GameStart();
	}
}
