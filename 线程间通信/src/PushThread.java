
public class PushThread implements Runnable {
	private StackInterface s;
	private int i = 0;

	public PushThread(StackInterface s) {
		this.s = s;
	}

	public void run() {

		while (true) {
			i = 666;
			s.push(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
