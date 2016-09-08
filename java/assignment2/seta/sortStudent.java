import java.util.Scanner;

class Student {

	private int rollNo;
	private String name;
	private float per;
	static int count;

	Student() {

		incCount();
	}

	Student(int rn, String nm, float pr) {

		rollNo = rn;
		name = nm;
		per = pr;
	
		incCount();
	}

	static void incCount() {

		count++;
		System.out.println(count + " objects created...");
	}

	public String toString() {
		
		return "Roll No : " + rollNo + "\nName : " + name + "\nPercentage : " + per;
	}

	static void sortStudent(Student student[]) {
	
		for(int i = 0; i < Student.count; i++)
			for(int j = 0; j < Student.count - i - 1; j++)
				if(student[j].per > student[j + 1].per) {
					Student temp = student[j];
					student[j] = student[j + 1];
					student[j + 1] = temp;
				}
	}
	
	public static void main(String args[]) {

		boolean flag = true;
		Scanner ip = new Scanner(System.in);
		Student student[] = new Student[50];

		while(flag) {
			System.out.print("\n1.Add new Student\n2.View all students\n3.Sort Student By Percentage\n4.Exit\nEnter option : ");
			int choice = ip.nextInt();
		
			switch(choice) {
				case 1 :
					System.out.print("\nEnter roll No : ");
					int r = ip.nextInt();
					System.out.print("Enter name : ");
					String n = ip.next();
					System.out.print("Enter percentage : ");
					float f = ip.nextFloat();
					
					student[Student.count] = new Student(r, n, f);
					break;
	
				case 2 :
					System.out.println("\nStudent Details");
					for(int i = 0; i < Student.count; i++)
						System.out.println(student[i]);
					break;

				case 3 :
					Student.sortStudent(student);
					System.out.println("\nStudent data Sorted");
					break;
				
				case 4 :
					flag = false;
			}
		}
	}
}
