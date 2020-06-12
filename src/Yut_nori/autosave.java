package javateam;

import java.io.*;

//thread.interrupt(); ���Ѽ� ���� ���� �� �����ϸ� ���� ������
class Mscore implements Runnable {
	Player p1;//�̰� �ٵ� �÷��̾� ���� ������ �÷��̾� �ִ� ����(?) ���� �־� �� �� ����... �ƴϸ� ���� ���� �ҷ��� �� �ֳ���
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