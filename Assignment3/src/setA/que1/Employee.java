package setA.que1;

import java.util.Scanner;

class Employee {
	private String id, name, dept;
	private float salary;

	// default useless constructor
	Employee() {
	}

	// parameterized constructor
	Employee(String id, String name, String dept, float salary) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}

	// accept employee details
	public void acceptEmployee() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("\nEnter id : ");
		id = scanner.next();
		System.out.print("Enter name : ");
		name = scanner.next();
		System.out.print("Enter Department : ");
		dept = scanner.next();
		System.out.print("Enter salary : ");
		salary = scanner.nextFloat();
		scanner.close();
	}

	// display employee details
	public void displayEmployee() {
		System.out.println("ID : "  + id);
		System.out.println("Name : " + name);
		System.out.println("Department : " + dept);
		System.out.println("Salary : " + salary);
	}

	// return salary
	public float getSalary() {
		return salary;
	}
}

class Manager extends Employee {
	private float bonus;

	// default useless constructor
	Manager() {
	}

	// parameterized constructor
	Manager(String i, String n, String dp, float sal, float bon) {
		super(i, n, dp, sal);
		bonus = bon;
	}

	// accept manager details
	public void acceptManager() {
		Scanner scanner = new Scanner(System.in);

		acceptEmployee();
		System.out.print("Enter bonus : ");
		bonus = scanner.nextFloat();
		scanner.close();
	}

	// display manager details
	public void displayManager() {
		displayEmployee();
		System.out.println("Bonus : " + bonus);
	}

	// return total salary
	public float getTotalSalary() {
		return bonus + getSalary();
	}

	// return index of manager with maximum salary
	public static int getMaxSalMan(Manager manager[]) {
		int max = 0;
		for (int i = 1; i < manager.length; i++)
			if(manager[i].getTotalSalary() > manager[max].getTotalSalary())
				max = i;
		return max;
	}

	public static void main(String argsp[]) {
		System.out.print("How many managers : ");
		Scanner ip = new Scanner(System.in);
		int n = ip.nextInt();

		Manager manager[] = new Manager[n];
		for (int i = 0; i < n; i++) {
			manager[i] = new Manager();
			manager[i].acceptManager();
		}

		System.out.println("\nManager with maximun Salary :");
		manager[Manager.getMaxSalMan(manager)].displayManager();
		ip.close();
	}
}


