import java.util.Scanner;

public class MyDate {

	int day, month, year;

	public MyDate() {
	
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter date :");
		System.out.print("Day (dd) : ");
		day = ip.nextInt();
		System.out.print("Month (mm) : ");
		month = ip.nextInt();
		System.out.print("Year (yyyy) : ");
		year = ip.nextInt();

	}

	public String toString() {

		return day + "/" + month + "/" + year + "\n";
	}

	public void isValid() throws InvalidDateException {

		switch(month) {

			case 1 :
			case 3 :
			case 5 :
			case 7 :
			case 8 :
			case 10 :
			case 12 :
				if(day > 31 || day < 1)
					throw new InvalidDateException(this);
				break;
			case 4 :
			case 6 :
			case 9 :
			case 11 :
				if(day > 30 || day < 1)
					throw new InvalidDateException(this);
				break;
			case 2 :
				if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
					if(day < 1 || day > 29)
						throw new InvalidDateException(this);
					else
						if(day < 1 || day > 28)
							throw new InvalidDateException(this);
				break;
			default :
				throw new InvalidDateException(this);
		}	

	}
	
	public static void main(String args[]) {

		MyDate date = new MyDate();
		try {
			date.isValid();
			System.out.println("Date is valid");			
		}

		catch(InvalidDateException ide) {

			ide.displayError();
		}

	}	
}

class InvalidDateException extends Exception {

	MyDate date;

	public InvalidDateException(MyDate d) {

		date = d;
	}	

	void displayError() {

		System.out.println("Invalid Date : " + date);
	}
}
