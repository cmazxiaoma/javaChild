
public class ThreadPoolTask implements Runnable {

	private String taskName;

	public ThreadPoolTask(String taskName) {
		this.taskName = taskName;
	}

	public void run() {
		System.out.println("执行任务:" + taskName);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
