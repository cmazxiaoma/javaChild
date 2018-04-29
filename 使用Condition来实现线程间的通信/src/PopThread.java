
public class PopThread implements Runnable {
	private StackInterface s;

	public PopThread(StackInterface s) {
		this.s = s;
	}

	public void run() {
		while (true) {
			s.pop();
			System.out.println("出栈成功，下标=" + s.getPopArray()[1] + ",元素=" + s.getPopArray()[0]);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
