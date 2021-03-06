class MyQueue {

	// 队头和队尾的索引
	private int front = -1, rear = -1;
	// 定义一个数组模拟队列
	private String[] queue;

	// 构造器 参数maxElements为队列长度
	public MyQueue(int maxElements) {
		queue = new String[maxElements];
	}

	// 入列
	public void enqueue(String e) {
		queue[++rear] = e;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return front == rear;
	}

	// 判断队列是否已满
	public boolean isFull() {
		return rear == queue.length - 1;
	}

	// 出列
	public String dequeue() {
		return queue[++front];
	}
}
