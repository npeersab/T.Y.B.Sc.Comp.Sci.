package setA.que2;

public class InsufficientFundsException extends Exception {
	private static final long serialVersionUID = 1L;
	String message;

	public InsufficientFundsException(String msg) {
		System.out.println("Insufficient Funds :");
		message = msg;
	}

	public void displayMessage() {
		System.out.println(message);
	}
}