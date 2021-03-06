//package YutnoriClient;

import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.net.Socket;
//import Yutnori.Game;

public class GameClient {
	
	private GameThread gameThread;
	private Socket client;
//	private BufferedReader reader;
	private ObjectInputStream get;
//	private ObjectInputStream reader;
	private Game game;
	
	public void connect() {
		
		try { //서버와 연결
			client = new Socket("localhost", 6555);
		} 
		catch(IOException e) {
			System.out.println("Server is not executing");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("conneted to server!");
		
//		try { //서버와의 통신수단
////			InputStream in = client.getInputStream();
////			reader = new BufferedReader(new InputStreamReader(in));
//			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
////			get = new ObjectInputStream(in);
////			reader = new ObjectInputStream(client.getInputStream());
//		}
//		catch(IOException e) { e.printStackTrace(); }	
	}
	
	public void GameStart() {
				
//		String msg;
		
		
		try {
//			msg = reader.readLine();
//			
//			System.out.println(msg);
			System.out.println("Game start!");
			
			
			get = new ObjectInputStream(client.getInputStream());
			game = (Game)get.readObject();
//			get.close();
			
			gameThread = new GameThread(game, client, 1);
//			gameThread = new GameThread(game, client, Integer.valueOf(receive[1]));
			gameThread.start();
			gameThread.join();
			
			
			
			
		}
		catch(IOException e) { e.printStackTrace(); }
		catch(InterruptedException e) { e.printStackTrace(); }
		catch(ClassNotFoundException e) { e.printStackTrace(); }
		
		
		
		
		
		
		
		
		
		
//		
//		try {
//			while(true)
//			{
//				System.out.println("1****************************");
//				msg = reader.readLine();
//				System.out.println("2****************************");
//
//				if(msg.startsWith("Wait")) { //상대방이 들어올떄까지 대기
//					System.out.println(msg);
//					continue;
//				}
//				else if(msg.startsWith("Game")) {
//					
//					String[] receive = msg.split("~~~");
//					System.out.println(receive[0]);
//					
////					reader.close();
//					
//					get = new ObjectInputStream(client.getInputStream());
//					game = (Game)get.readObject();
//					get.close();
//					
//					gameThread = new GameThread(game, client, 1);
////					gameThread = new GameThread(game, client, Integer.valueOf(receive[1]));
//					gameThread.start();
//					gameThread.join();
//					
//					break;
//				}
//			}
//			
////			while(true)
////			{
////				msg = reader.readLine();
////
////				if(msg == "The opponent has left the game.") { //상대방이 게임 강제종료
////					if(gameThread.isTerminated()) { //게임 종료
////						gameThread.interrupt();
////						writer.println("some client left the game");
////						return;
////					}
////					else { //새로운 게임 대기
////						gameThread.interrupt();
////						GameStart();
////					}
////				}
////			}
//		}
//		catch(IOException e) { e.printStackTrace(); }
//		catch(InterruptedException e) { e.printStackTrace(); }
//		catch(ClassNotFoundException e) { e.printStackTrace(); }
//		
	}
	
	
}
	
//	private void checkStatus() {
//		
//		String msg;
//		
//		try {
//			while(true)
//			{
//				msg = reader.readLine();
//
//				if(msg == "The opponent has left the game.") { //상대방이 게임 강제종료
//					if(gameThread.isTerminated()) { //게임 종료
//						gameThread.interrupt();
//						writer.println("some client left the game");
//						return;
//					}
//					else { //새로운 게임 대기
//						gameThread.interrupt();
//						GameStart();
//					}
//				}
//			}
//		} catch(IOException e) { e.printStackTrace(); }
//	}
//}
