package setA.que3;

public class PrintText_Thread implements Runnable {
	private Thread thread;
	private int n;
	private String message;
	
	public PrintText_Thread(String message, int n) {
		this.message = message;
		this.n = n;
		
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (n > 0) {
			System.out.println(message);
			n--;
		}
	}
	
	public static void main(String[] args) {
		new PrintText_Thread("I am in FY", 10);
		new PrintText_Thread("I am in SY", 20);
		new PrintText_Thread("I am in TY", 30);
	}
}
