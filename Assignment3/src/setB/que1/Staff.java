package setB.que1;

import java.util.Scanner;

public abstract class Staff {
	protected String name, address;
	public Staff() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Name : ");
		name = scanner.next();
		System.out.print("Address : ");
		address = scanner.next();
		scanner.close();
	}

	public String toString() {
		return "Name : " + name + "\nAddress : " + address;
	}

	public abstract void display();

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter limit for Staff : ");
		int n = scanner.nextInt();
		Staff staff[] = new Staff[n];

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter Staff " + (i + 1) + " Data :");
			System.out.print("1.Full Time Staff\n2.Part Time Staff\nEnter Staff Type : ");
			int stType = scanner.nextInt();
			switch(stType) {
			case 1 :
				staff[i] = new FullTimeStaff();
				break;
			default :
				staff[i] = new PartTimeStaff();
			}
		}

		System.out.println("\nFull Time Staff :");
		System.out.println("-----------------");
		for(int i = 0; i < n; i++)
			if(staff[i] instanceof FullTimeStaff)
				staff[i].display();

		System.out.println("\nPart Time Staff :");
		System.out.println("-----------------");
		for(int i = 0; i < n; i++)
			if(staff[i] instanceof PartTimeStaff)
				staff[i].display();

		scanner.close();
	}
}

class FullTimeStaff extends Staff {
	private String department;
	private int salary;

	public FullTimeStaff() {
		super();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Department : ");
		department = scanner.next();
		System.out.print("Salary : ");
		salary = scanner.nextInt();
		scanner.close();
	}

	public void display() {
		System.out.println(super.toString());
		System.out.println("Department : " + department + "\nSalary : " + salary + "\n");
	}
}

class PartTimeStaff extends Staff {
	private int noOfHours, ratePerHour;

	public PartTimeStaff() {
		super();
		Scanner scanner = new Scanner(System.in);	
		System.out.print("No of Hours : ");
		noOfHours = scanner.nextInt();
		System.out.print("Rate per hour : ");
		ratePerHour = scanner.nextInt();
		scanner.close();
	}

	public void display() {
		System.out.println(super.toString());
		System.out.println("No of Hours : " + noOfHours + "\nRate per Hour : " + ratePerHour + "\n");
	}
}
