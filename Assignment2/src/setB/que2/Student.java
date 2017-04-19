package setB.que2;

import java.util.Scanner;
import setB.que2.SY.SyMarks;
import setB.que2.TY.TyMarks;

class Student {
	private int rollNo;
	private	String name;
	private	SyMarks syMarks;
	private	TyMarks tyMarks;

	// parameterized constructor
	Student(int rno, String nm) {
		rollNo = rno;
		name = nm;
	}

	// accept marks of SY from user
	void setSYMarks() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Computer    : ");
		int comp = scanner.nextInt();
		System.out.print("Maths       : ");
		int maths = scanner.nextInt();
		System.out.print("Electronics : ");
		int elec = scanner.nextInt();
		System.out.print("English     : ");
		int en = scanner.nextInt();

		syMarks = new SyMarks(comp, maths, elec, en);
		scanner.close();
	}

	// accept marks of TY from user
	void setTYMarks() {
		Scanner scanner = new Scanner(System.in);		

		System.out.print("PHP    : ");
		int php = scanner.nextInt();
		System.out.print("Java   : ");
		int java = scanner.nextInt();
		System.out.print("OOSE   : ");
		int oose = scanner.nextInt();
		System.out.print("CN     : ");
		int cn = scanner.nextInt();
		System.out.print("SYSPRO : ");
		int syspro = scanner.nextInt();
		System.out.print("TCS    : ");
		int tcs = scanner.nextInt();

		tyMarks = new TyMarks(php, java, oose, cn, syspro, tcs);
		scanner.close();
	}

	// display student details
	public static void display(Student student[]) {
		System.out.println("\nStudent Details :");
		printline(34);
		System.out.printf("| Roll No. | %10s |  Grade |\n", "Name");
		printline(34);
		for (int i = 0; i < student.length; i++)
			System.out.printf("| %8d | %10s | %6s |\n",
					student[i].rollNo, student[i].name, student[i].getGrade());
		printline(34);

	}

	// calculate student grades
	String getGrade() {
		int marks = (syMarks.getTotal() / 4 + tyMarks.getTotal() / 6) / 2;

		if (marks >= 70)
			return "A";
		else if (marks >= 60)
			return "B";
		else if (marks >= 50)
			return "C";
		else if (marks >= 40)
			return "Pass";
		else
			return "Fail";
	}

	// display dotted horizontal line
	public static void printline(int n) {
		for (int i = 0; i < n; i++)
			System.out.print('-');
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("How many students : ");
		int n = scanner.nextInt();

		Student student[] = new Student[n];
		int rno;
		String name;

		for (int i = 0; i < n; i++) {
			System.out.print("\nEnter roll No : ");
			rno = scanner.nextInt();
			System.out.print("Enter name : ");
			name = scanner.next();
			student[i] = new Student(rno, name);

			System.out.println("\nEnter SY Marks :");
			student[i].setSYMarks();
			System.out.println("\nEnter TY MArks :");
			student[i].setTYMarks();
		}
		Student.display(student);
		
		scanner.close();
	}
}		
