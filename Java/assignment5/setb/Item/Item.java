import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Item {

	private String id, name;
	private float price;
	private int qty;
	private static RandomAccessFile file;

	// parameterized constructor
	public Item(String[] itemData) {

		this.id = itemData[0];
		this.name = itemData[1];
		this.price = Float.parseFloat(itemData[2]);
		this.qty = Integer.parseInt(itemData[3]);
	}

	// function to read a single item from file
	public static String[] readData() {

		try {
			String line = file.readLine();
			if(line != null) {
				return line.split(" ");
			}
		}
		catch(IOException e) {
			System.out.println("Error while reading file");
		}

		return null;
	}

	// function to search item by name
	public static void searchItem(String name) {

		openFile();
		String[] itemData = null;
		boolean flag = false;

		while((itemData = readData()) != null) {
			if(name.equals(itemData[1])) {
				if(!flag)
					displayHead();
				new Item(itemData).display();
				flag = true;
			}
		}
		if(!flag)
			System.out.println("\n" + name + " not found...");
	}

	// function to display item having maximum cost
	public static void displayCostiestItem() {

		openFile();
		float maxPrice = 0;
		String[] itemData  = null;
		Item maxItem = null;
		
		while((itemData = readData()) != null) {
		
			if(Float.parseFloat(itemData[2]) > maxPrice) {
				maxItem = new Item(itemData);
				maxPrice = maxItem.price;
			}
		}

		System.out.print("\nCostiest item :");
		displayHead();
		maxItem.display();
	}

	//function to display all items
	public static void displayAllItems() {

		openFile();
		displayHead();
		String[] itemData = null;

		while((itemData = readData()) != null) {

			new Item(itemData).display();
		}
	}

	//functions to display an item
	public static void displayHead() {

		System.out.println();
		printLine();
		System.out.printf("| %4s | %10s |  Price | Qty |\n", "id", "Name");
		printLine();
	}

	public void display() {

		System.out.printf("| %4s | %10s | %6.2f | %3d |\n", id, name, price, qty);
		printLine();
	}

	public static void printLine() {

		for(int i = 0; i < 36; i++)
			System.out.print("-");
		System.out.println();
	}

	// function to open randomaccess file in read mode
	public static void openFile() {

		try {
			file = new RandomAccessFile("item.dat", "r");
		}
		catch(FileNotFoundException e) {
			
			System.out.println("Error : File not found");
			System.exit(1);
		}
	}

	public static void main(String args[]) {

		do {
			System.out.println("\n1. Search for a specific item by name");
			System.out.println("2. Find costiest item");
			System.out.println("3. Display all items and total cost");
			System.out.println("4. Exit");
			System.out.print("Enter choice : ");

			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();

			switch(choice) {
				case 1 :
					System.out.print("\nEnter item name : ");
					String name = sc.next();
					searchItem(name);
					break;

				case 2 :
					displayCostiestItem();
					break;

				case 3 :
					displayAllItems();
					break;

				case 4 :
					System.exit(0);

				default :
					System.out.println("Invalid choice");

			}

		} while(true);
	}
}
