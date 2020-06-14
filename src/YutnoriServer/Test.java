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
				
				if(msg.startsWith("Wait")) { //������ ���Ë����� ���
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
//						if(msg == "The opponent has left the game.") { //������ ���� ��������
//							if(gameThread.isTerminated()) { //���� ����
//								gameThread.interrupt();
//								writer.println("some client left the game");
//								return;
//							}
//							else { //���ο� ���� ���
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
