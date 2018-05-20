package arrayTest;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayTest {

	public static void main(String[] args) {
		ArrayTest2 arrayTest2 = new ArrayTest2();
	}
}

class ArrayTest2 {
	private static LinkedList<Integer> linkedList = new LinkedList<>();
	private static ArrayList<Integer> arrayList = new ArrayList<>();
	private static long startTime, arrayTime, linkedTime;

	public ArrayTest2() {
		test();
	}

	public void test() {
		System.out.println("Adding 100,000,000 values to ArrayList");
		startTime = System.nanoTime();
		for (int i = 0; i < 100000000; i++) {
			arrayList.add(i);
		}
		arrayTime = System.nanoTime();
		System.out.println("Took " + (arrayTime - startTime) + " nanoseconds");
		System.out.println("Adding 100,000,000 values to LinkedList");
		startTime = System.nanoTime();
		for (int i = 0; i < 100000000; i++) {
			linkedList.add(i);
		}
		linkedTime = System.nanoTime();
		System.out.println("Took " + (linkedTime - startTime) + " nanoseconds");
	}
}
