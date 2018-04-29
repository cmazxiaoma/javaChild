import java.util.Random;

public class PushThread implements Runnable {
	private StackInterface s;

	public PushThread(StackInterface s) {
		this.s = s;
	}

	public void run() {
		while (true) {
			Random random = new Random();
			int i = random.nextInt(10);
			s.push(i);
			System.out.println("压栈成功，元素=" + i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
