package setA.que3;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Student {
	public static void main(String[] args) {
		Hashtable<String, Float> students = new Hashtable<String, Float>();

		students.put("Ram", new Float(66.4));
		students.put("Akash", new Float(74.5));
		students.put("Amit", new Float(62.2));

		Set<String> names = students.keySet();
		Iterator<String> iterator = names.iterator();

		Float percentage = null;
		String name = null;

		printline();
		System.out.printf("| %5s | Percentage |\n", "Name");
		printline();
		while (iterator.hasNext()) {
			name = iterator.next();
			percentage = students.get(name);
			System.out.printf("| %5s | %10.2f |\n", name, percentage);
			printline();
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter student name to be searched: ");
		name = scanner.next();

		percentage = students.get(name);
		if (percentage == null)
			System.out.println("Student with name " + name + " not found");
		else
			System.out.println("Percentage of " + name + ": " + percentage);

		scanner.close();
	}

	public static void printline() {
		for (int i = 0; i < 22; i++)
			System.out.print("-");
		System.out.println();
	}
}
