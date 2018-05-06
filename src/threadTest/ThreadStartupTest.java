package threadTest;

public class ThreadStartupTest {
	int counter = 0;
	long startTime = System.nanoTime();

	public static void main(String[] args) {
		ThreadStartupTest h = new ThreadStartupTest();
		ThreadStartupTest.TestThread newThread = h.new TestThread();
		newThread.start();
	}

	public class TestThread extends Thread {

		public void run() {
			counter++;
			if (counter == 100000) {
				System.out.println(
						"" + (double) (((System.nanoTime() - startTime)) / counter) + " nanoseconds per thread");
			} else {
				TestThread newThread = new TestThread();
				newThread.start();
			}
		}
	}
}
