public class TestBoxing {
	public void test(Object o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		TestBoxing tb = new TestBoxing();
		// 自动装箱
		tb.test(666);
	}

}
