import java.math.BigInteger;

public class HelloWorld {

	private int classSize;

	public HelloWorld() {
		classSize = 0;
	}

	public HelloWorld(int size) {
		this.classSize = size;
	}

	public int getClassSize() {
		return classSize;
	}

	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to 1150");

		System.out.println(factorial(15));

		System.out.println(euler1());
		System.out.println(euler2());

		HelloWorld test = new HelloWorld(13);
		HelloWorld test2 = new HelloWorld();

		System.out.println(test.getClassSize());
		System.out.println(test2.getClassSize());
	}

	public static BigInteger factorial(int param) {
		BigInteger total = new BigInteger("1");
		for (int i = 1; i <= param; i++) {
			total = total.multiply(new BigInteger("" + i));
		}
		return total;
	}

	public static int euler1() {
		int total = 0;

		for (int i = 1; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				total += i;
			}
		}

		return total;
	}

	public static long euler2() {
		long valueA = 1;
		long valueB = 1;
		long swapValue = 0;

		long total = 2;

		for (int i = 0; i < 50; i++) {
			// System.out.println("A:" + valueA + " B:" + valueB + " T:" +
			// total);
			swapValue = valueA + valueB;
			// 3 = 2 + 1
			total += swapValue;

			valueB = valueA; // 2
			valueA = swapValue; // 3
		}
		return total;
	}

	public static void fizzbizz() {
		for (int i = 1; i < 1000; i++) {
			String text = "";

			if (i % 3 == 0 && i % 5 == 0) {
				text = "fizzbuzz";

			} else if (i % 3 == 0) {
				text = "fizz";

			} else if (i % 5 == 0) {
				text = "buzz";

			}

			System.out.println(text);
		}
	}
}
