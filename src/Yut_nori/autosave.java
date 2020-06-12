import java.io.*;


//thread.interrupt(); 시켜서 게임 끝날 때 종료하면 될듯

public class autosave {

	public static void main(String[] args) {
		
		Player player1 = new Player();
		Player player2 = new Player();

		Mscore p1 = new Mscore(player1);
		Yscore p2 = new Yscore(player2);
		
		new Thread(p1).start();
		new Thread(p2).start();
	}

}
class Mscore implements Runnable {
	Player p1;
	Mscore(Player p){
		this.p1 = p;
	}
	public void run() {
			try {
				File file = new File("../result.txt");
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
				pw.print("Player1: ");
				pw.println(p1.score);
				pw.close();
				Thread.sleep(120000);
			} catch(IOException e) {
				e.printStackTrace();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}

	}
}

class Yscore implements Runnable {
	Player p2;
	Yscore(Player p){
		this.p2 = p;
	}
	public void run() {
			try {
				File file = new File("../result.txt");
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
				pw.print("Player2: ");
				pw.println(p2.score);
				pw.close();
				Thread.sleep(120000);
			} catch(IOException e) {
				e.printStackTrace();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}

	}
}
