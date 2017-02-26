package setA.que1;

public class Message implements Runnable {
	private String message;
	private Thread thread;
	
	public Message(String message) {
		this.message = message;
		
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println("\n" + message + " is running\n");
		}
	}
	
	public static void main(String[] args) {
		new Message("Thread 1");
		new Message("Thread 2");
	}
}
