//package YutnoriClient;

public class ClientMain {

	public static void main(String[] args) {
		
		GameClient client = new GameClient();
		client.connect();
		
		client.GameStart();
		
		System.exit(0);
	}

}
