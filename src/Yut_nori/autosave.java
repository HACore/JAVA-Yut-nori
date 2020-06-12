package javateam;

import java.io.*;

//thread.interrupt(); 시켜서 게임 끝날 때 종료하면 되지 않을까
class Mscore implements Runnable {
	Player p1;//이거 근데 플레이어 정보 쓰려면 플레이어 있는 곳에(?) 같이 둬야 할 것 같어... 아니면 따로 정보 불러올 수 있나ㅜ
	public void run() {
			try {
				File file = new File("../result.txt");
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
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
	public void run() {
			try {
				File file = new File("../result.txt");
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
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