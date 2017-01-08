package setB.que1;

public class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;
	MyDate date;

	public InvalidDateException(MyDate d) {
		date = d;
	}	

	void displayError() {
		System.out.println("Invalid Date : " + date);
	}
}

