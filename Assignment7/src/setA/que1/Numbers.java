package setA.que1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Numbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many numbers?: ");
		int n = scanner.nextInt();
		
		TreeSet<Integer> integers = new TreeSet<Integer>();
		int buff = 0;
		System.out.println("Enter the numbers:");
		for (int i = 0; i < n; i++) {
			buff = scanner.nextInt();
			integers.add(buff);
		}
		
		System.out.println("Entered numbers:");
		Iterator<Integer> iterator = integers.iterator();
		while (iterator.hasNext())
			System.out.print(iterator.next() + " ");
		
		System.out.print("\nEnter number to be searched: ");
		buff = scanner.nextInt();
		if (integers.contains(buff))
			System.out.println("Number found");
		else
			System.out.println("Number not found");
		scanner.close();
	}
}
