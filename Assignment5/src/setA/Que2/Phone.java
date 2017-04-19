package setA.Que2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Phone {
	public static void searchContact(String name_key) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("Phone.txt")));
			String line = null;
			boolean flag = false;

			while ((line = br.readLine()) != null) {
				if (line.length() != 0) {
					String name = line.substring(0, line.indexOf(' '));
					String number = line.substring(line.indexOf(' ') + 1, line.length());

					if (name.equals(name_key)) {
						System.out.println("\nName : " + name);
						System.out.println("Number : " + number);
						flag = true;
					}
				}
			}

			br.close();
			if (!flag) {
				System.out.println("\n" + name_key + "Not Found...");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println("Unable to read data");
		}
	}

	public static void addContact(String name, String number) {
		try {
			FileWriter fileWriter = new FileWriter("Phone.txt", true);		
			fileWriter.write("\n" + name + " " + number);
			fileWriter.close();
			System.out.println(name + " added to Contacts");
		}
		catch (IOException e) {
			System.out.println("Unable to write data to file");
		}
	}

	public static void main(String args[]) {
		do {
			System.out.println("\n1. Search name and display phone number");
			System.out.println("2. Add a new name-number pair");
			System.out.println("3. Exit");
			System.out.print("Enter choice : ");

			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			switch (choice) {
			case 1 :
				System.out.print("\nEnter name : ");
				searchContact(scanner.next());
				break;

			case 2 :
				System.out.print("\nEnter name : ");
				String name = scanner.next();
				System.out.print("Enter number : ");
				String number = scanner.next();
				addContact(name, number);
				break;

			case 3 :
				System.exit(0);

			default :
				System.out.println("Invalid Input");
				scanner.close();
			}
		} while (true);
	}
}
