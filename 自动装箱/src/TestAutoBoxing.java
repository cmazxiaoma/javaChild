
public class TestAutoBoxing {
	public static void main(String[] args) {
		Integer t1 = new Integer(127);
		Integer t2 = new Integer(127);
		System.out.println("t1==t2 ? " + (t1 == t2));
		Integer t3 = 127;
		Integer t4 = 127;
		System.out.println("t3==t4 ? " + (t3 == t4));
		System.out.println("t1==t4 ? " + (t1 == t4));
		Integer t5 = 128;
		Integer t6 = 128;
		System.out.println("t5==t6 ? " + (t5 == t6));

	}

}
