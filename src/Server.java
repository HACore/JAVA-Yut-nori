
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
//import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//import java.net.UnknownHostException;

public class Server {
	private ServerSocket server;
	private BufferedReader reader;
	private PrintWriter writer;
	private ObjectOutputStream send;
	private Game game;
	
	public void execute() {
		
		game = new Game();
		
		try {
			server = new ServerSocket(6555);
		} 
		catch(IOException e) { e.printStackTrace(); }
		System.out.println("server is ready");
		
//		try {
//			InetAddress ip = InetAddress.getLocalHost();
//			System.out.println(ip.getHostAddress());
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		}
//		
		
		try {
			Socket client = server.accept();
			System.out.println("some client is connected");
			
			reader = new BufferedReader(new InputStreamReader(client.getInputStream())); //연결된 클라이언트에게서 메세지 수신
			
			send = new ObjectOutputStream(client.getOutputStream());
			send.writeObject(game);
			send.flush();
//			send.close();
			
			writer = new PrintWriter(client.getOutputStream(), true);
//			writer.println("Game start!");
			System.out.println("Game start!");
			
			game.start(0);
			
			String msg;
			
			while(true) //게임 시작
			{
				msg = reader.readLine();
				
				if(msg.startsWith("[Your turn]")) {
					
					System.out.println("my turn");
					game.run(0);
					
					
					
					if(game.isWin(0)) {
						writer.println("[You lose]");
						System.out.println("***win the game***");
						break;
					}
					
					writer.println("[Your turn]");
				}
				else if(msg.startsWith("[Win]")) {
					System.out.println("***lose the game***");
					break;
				}
			
			}

			client.close();
		}
		catch(IOException e) { e.printStackTrace(); } 
		
//		while(true)
//		{
//
//				try {
//					Socket client = server.accept();
//					System.out.println("some client is connected");
//					
//
//					
//					ClientManagerThread c_thread = new ClientManagerThread(game, client);
//					c_thread.start();
////					c_thread.join();
//				}
//				catch(IOException e) { e.printStackTrace(); } 
////				catch (InterruptedException e) { e.printStackTrace(); }
//
//		}
		

	}
	

}
