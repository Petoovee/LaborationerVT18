package stringTest;

public class StringTest {

	public static String test;
	public static long startTime, endTime;
	
	public static void main(String[] args) {
	startTime = System.nanoTime();
	int i = 0;
	boolean found = false;
	while(!found) {
		test = "i:" + i;
		i++;
		if(test.contains("250000000"))
			found = true;
	}
	endTime = System.nanoTime();
	long nanoTaken = endTime - startTime;
	double timeTaken = (double)nanoTaken;
	timeTaken = timeTaken/1000000000;
	System.out.println("Took " + timeTaken + " seconds");
}

//	public static void main(String[] args) {
//		startTime = System.nanoTime();
//		for (int i = 0; i < 250000000; i++) {
//			test = "i:" + i;
//		}
//		endTime = System.nanoTime();
//		long nanoTaken = endTime - startTime;
//		double timeTaken = (double)nanoTaken;
//		timeTaken = timeTaken/1000000000;
//		System.out.println("Took " + timeTaken + " seconds");
//	}
}