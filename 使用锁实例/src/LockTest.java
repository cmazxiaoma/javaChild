import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
	public static void main(String[] args) {

		// 创建并发访问的信用卡账户
		CreditCardAccount myCard = new CreditCardAccount("6217-0028-7002-9811-211", 0);
		// 创建一个锁对象
		ReadWriteLock lock = new ReentrantReadWriteLock();
		// 创建一个线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		Operation o1 = new Operation("atm001", myCard, -4000, lock, 2);
		Operation o2 = new Operation("atm002", myCard, 6000, lock, 1);
		Operation o3 = new Operation("atm003", myCard, 800, lock, 1);
		Operation o4 = new Operation("atm003", myCard, 800, lock, 1);
		Operation o5 = new Operation("atm003", myCard, 0, lock, 3);
		pool.execute(new Thread(o1));
		pool.execute(new Thread(o2));
		pool.execute(new Thread(o3));
		pool.execute(new Thread(o4));
		pool.execute(new Thread(o5));
		// 关闭线程池
		pool.shutdown();

	}

}
