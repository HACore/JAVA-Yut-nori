package YutnoriClient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.Socket;

public class GameClient {
	
	private GameThread gameThread;
	private Socket client;
	private BufferedReader reader;
	
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
					
					gameThread = new GameThread(client, Integer.valueOf(receive[1]));
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
		catch (InterruptedException e) { e.printStackTrace(); }
		
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
