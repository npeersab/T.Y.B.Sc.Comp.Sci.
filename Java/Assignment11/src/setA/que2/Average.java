package setA.que2;

public class Average implements Runnable {
	Thread thread;
	private int sum;

	public Average() {
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++)
			sum += Math.random() * 100;
	}

	public float getAverage() {
		return (float) sum / 100;
	}

	public static void main(String[] args) {
		Average average[] = new Average[10];
		

		for (int i = 0; i < 10; i++)
			average[i] = new Average();

		float sum = 0;
		try {
			for (int i = 0; i < 10; i++) {
				average[i].thread.join();
				sum += average[i].getAverage();
			}
		} catch (InterruptedException e) {
			System.out.println("Thread Interrupted");
		}
		
		System.out.println("Average of 1000 integers is: " + sum / 10);
	}
}

