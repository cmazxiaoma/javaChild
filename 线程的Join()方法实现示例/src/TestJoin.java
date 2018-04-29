
public class TestJoin {
	static int[] a = new int[20];

	public static void main(String[] args) {
		JoinThread r = new JoinThread();
		Thread thread = new Thread(r);
		thread.start();
		try {
			thread.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println("Printing array[" + i + "]:" + a[i]);
		}
	}

	static class JoinThread implements Runnable {
		public void run() {
			for (int i = 0; i < a.length; i++) {
				System.out.println("Initializing array a[" + i + "]:" + (i - 50));
				a[i] = i - 50;
			}
		}
	}
}
