import java.util.Scanner;

class Employee {

	private String id, name, dept;
	private float salary;

	Employee() {

	}

	Employee(String i, String nm, String dp, float sal) {

		id = i;
		name = nm;
		dept = dp;
		salary = sal;
	}
	
	public void acceptEmployee() {

		Scanner ip = new Scanner(System.in);

		System.out.print("\nEnter id : ");
		id = ip.next();
		System.out.print("Enter name : ");
		name = ip.next();
		System.out.print("Enter Department : ");
		dept = ip.next();
		System.out.print("Enter salary : ");
		salary = ip.nextFloat();
	}
	
	public void displayEmployee() {

		System.out.println("ID : "  + id);
		System.out.println("Name : " + name);
		System.out.println("Department : " + dept);
		System.out.println("Salary : " + salary);
	}

	public float getSalary() {

		return salary;
	}

}

class Manager extends Employee {

	private float bonus;

	Manager() {

	}

	Manager(String i, String n, String dp, float sal, float bon) {

		super(i, n, dp, sal);
		bonus = bon;
	}

	public void acceptManager() {
	
		Scanner ip = new Scanner(System.in);

		acceptEmployee();
		System.out.print("Enter bonus : ");
		bonus = ip.nextFloat();
		
	}

	public void displayManager() {
		
		displayEmployee();
		System.out.println("Bonus : " + bonus);
	}
	
	public float getTotalSalary() {
		
		return bonus + getSalary();
	}

	public static int getMaxSalMan(Manager manager[]) {

		int max = 0;;
		for(int i = 1; i < manager.length; i++)
			if(manager[i].getTotalSalary() > manager[max].getTotalSalary())
				max = i;
		return max;
	}

	public static void main(String argsp[]) {
	
		
		System.out.print("How many managers : ");
		Scanner ip = new Scanner(System.in);
		int n = ip.nextInt();

		Manager manager[] = new Manager[n];
		for(int i = 0; i < n; i++) {
			manager[i] = new Manager();
			manager[i].acceptManager();
		}

		System.out.println("\nManager with maximun Salary :");
		manager[Manager.getMaxSalMan(manager)].displayManager();

				
	}
}

