import java.util.concurrent.locks.Lock;

public class Operation1 implements Runnable {
	private String atm;
	private CreditCardAccount myCard;
	private int dwCash;
	// 执行操作所需要的锁对象，此处为读写锁
	private Lock myLock;
	// 操作类型:存款1/取款2/查询3
	private int operationType;

	public Operation1(String atm, CreditCardAccount myCard, int dwCash, Lock myLock, int operationType) {
		super();
		this.atm = atm;
		this.myCard = myCard;
		this.dwCash = dwCash;
		this.myLock = myLock;
		this.operationType = operationType;
	}

	public Operation1(String atm, CreditCardAccount myCard, int dwCash, Lock myLock) {
		super();
		this.atm = atm;
		this.myCard = myCard;
		this.dwCash = dwCash;
		this.myLock = myLock;
	}

	public int getOperationType() {
		return operationType;
	}

	public void setOperationType(int operationType) {
		this.operationType = operationType;
	}

	public void run() {
		if (operationType == 1) {
			// 获取 “写” 锁
			myLock.lock();
			try {

				System.out.println(atm + "正在往账户" + myCard + "存款，该账户当前余额为" + myCard.getMoney() + ",存款金额=" + dwCash);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				myCard.setMoney(dwCash + myCard.getMoney());

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(atm + "往账户" + myCard + "存款成功，该账户当前余额=" + myCard.getMoney());
			} finally {
				myLock.unlock();

			}
		} else if (operationType == 2) {
			myLock.lock();
			try {
				System.out.println(atm + "正在往账户" + myCard + "取款，该账户当前余额为" + myCard.getMoney() + ",取款金额=" + dwCash);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				myCard.setMoney(myCard.getMoney() + dwCash);

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(atm + "往账户" + myCard + "取款成功，该账户当前余额=" + myCard.getMoney());
			} finally {
				myLock.unlock();
			}
		} else {

			myLock.lock();
			try {

				System.out.println(atm + "正在查询账户" + myCard + ",当前余额=" + myCard.getMoney());

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				// 释放锁
				myLock.unlock();
			}
		}
	}

}
