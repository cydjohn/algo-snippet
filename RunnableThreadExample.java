public class RunnableThreadExample implements Runnable {
	public int count = 0;

	public void run() {
		try {
			while (count < 5) {
				Thread.sleep(500);
				System.out.println("run function sleep at " + count);
				count++;
			}
		} catch (InterruptedException exc) {
			System.out.println("RunnableThread interrupted.");
		}
		System.out.println("RunnableThread terminating.");
	}

	public static void main(String[] args) {
		RunnableThreadExample instance = new RunnableThreadExample();
		Thread thread = new Thread(instance);
		thread.start();

		while (instance.count != 5) {
			try {
				Thread.sleep(250);
				System.out.println("main function sleep at " + instance.count);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}
}