import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SafeStack implements StackInterface {

	private int[] values = new int[10];
	private int top = 0;;
	private boolean flag = false;
	private int[] pop = new int[2];
	// 创建一个锁
	private Lock myLock;
	// 创建一个Condition对象
	private Condition con;

	public SafeStack(Lock lock, Condition con) {
		this.myLock = lock;
		this.con = con;
	}

	public void push(int number) {
		myLock.lock();
		try {
			while (flag) {
				try {
					con.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			values[top] = number;
			top++;
			flag = true;
			con.signalAll();
			System.out.println("压栈");
		} finally {
			myLock.unlock();
		}
	}

	public void pop() {
		myLock.lock();
		try {
			while (!flag) {
				try {
					con.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			top--;
			pop[0] = values[top];
			pop[1] = top;
			flag = false;
			con.signalAll();
			System.out.println("出栈");

		} finally {
			myLock.unlock();
		}

	}

	public int[] getPopArray() {

		return pop;
	}

}
