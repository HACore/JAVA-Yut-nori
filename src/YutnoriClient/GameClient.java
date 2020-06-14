package YutnoriClient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import Yutnori.Game;

public class GameClient {
	
	private GameThread gameThread;
	private Socket client;
	private BufferedReader reader;
	private ObjectInputStream get;
	private Game game;
	
	public void connect() {
		
		try { //������ ����
			client = new Socket("localhost", 1398);
		} 
		catch(IOException e) {
			System.out.println("Server is not executing");
			e.printStackTrace();
			System.exit(1);
		}
		System.out.println("conneted to server!");
		
		try { //�������� ��ż���
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			get = new ObjectInputStream(client.getInputStream());
		}
		catch(IOException e) { e.printStackTrace(); }	
	}
	
	public void GameStart() {
				
		String msg;
		
		try {
			while(true)
			{
				msg = reader.readLine();

				if(msg.startsWith("Wait")) { //������ ���Ë����� ���
					System.out.println(msg);
					continue;
				}
				else if(msg.startsWith("Game")) {
					
					String[] receive = msg.split("~~~");
					System.out.println(receive[0]);
					
					game = (Game)get.readObject();
					
					gameThread = new GameThread(game, client, Integer.valueOf(receive[1]));
					gameThread.start();
					gameThread.join();
					
					break;
				}
			}
			
//			while(true)
//			{
//				msg = reader.readLine();
//
//				if(msg == "The opponent has left the game.") { //������ ���� ��������
//					if(gameThread.isTerminated()) { //���� ����
//						gameThread.interrupt();
//						writer.println("some client left the game");
//						return;
//					}
//					else { //���ο� ���� ���
//						gameThread.interrupt();
//						GameStart();
//					}
//				}
//			}
		}
		catch(IOException e) { e.printStackTrace(); }
		catch(InterruptedException e) { e.printStackTrace(); }
		catch(ClassNotFoundException e) { e.printStackTrace(); }
		
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
//				if(msg == "The opponent has left the game.") { //������ ���� ��������
//					if(gameThread.isTerminated()) { //���� ����
//						gameThread.interrupt();
//						writer.println("some client left the game");
//						return;
//					}
//					else { //���ο� ���� ���
//						gameThread.interrupt();
//						GameStart();
//					}
//				}
//			}
//		} catch(IOException e) { e.printStackTrace(); }
//	}
}
