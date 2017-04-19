package setB.que1;

public class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;
	MyDate date;

	public InvalidDateException(MyDate date) {
		this.date = date;
	}	

	void displayError() {
		System.out.println("Invalid Date : " + date);
	}
}

