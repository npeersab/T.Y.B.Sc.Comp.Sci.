package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDatabase {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	public static Scanner scanner;
		
	public StudentDatabase() {
		try {
			// load driver
			Class.forName("org.postgresql.Driver");
			
			// establish connection
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost/studentdb", "postgres", "noor!xyz");
			
			// create statement
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Unable to load driver");
			System.exit(1);
		} catch (SQLException e) {
			System.out.println("Unable to connect database");
			System.exit(1);
		}
		
		scanner = new Scanner(System.in);
	}
	
	public void insert() {
		// accept data of student
		System.out.print("Roll No: ");
		int rollNo = scanner.nextInt();
		System.out.print("Name: ");
		String name = scanner.next();
		System.out.print("Percentage: ");
		float percentage = scanner.nextFloat();
		int count = 0;
		
		try {
			// insert data into table
			count = statement.executeUpdate(
					"INSERT INTO student VALUES(" + rollNo + ", '" + name + "', " + percentage + ")");
		} catch (SQLException e) {
			System.out.println("Unable to insert data");
		}
		if (count != 0)
			System.out.println("added new record");
	}
	
	public void modify() {
		// accept roll no
		System.out.print("Enter roll no: ");
		int rollNo = scanner.nextInt();
		System.out.println("1. Modify name");
		System.out.println("2. Modify percentage");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();
		int count = 0;
		try {
			switch (choice) {
			case 1:
				System.out.println("Enter name: ");
				String name = scanner.next(); 
				count = statement.executeUpdate(
						"UPDATE student SET name = '" + name + "' WHERE rollNo = " + rollNo);
				break;
			case 2:
				System.out.println("Enter percentage: ");
				float percentage = scanner.nextFloat();
				count = statement.executeUpdate(
						"UPDATE student SET percentage = " + percentage + " WHERE rollNo = " + rollNo);
				break;
			}
		} catch (SQLException e) {
			System.out.println("Unable update databse");
		}
		
		// check if records are updated or not
		if (count == 0)
			System.out.println("record not found");
		else
			System.out.println("record updated successfully");
	}
	
	public void delete() {
		// accept roll no
		System.out.print("Enter roll no: ");
		int rollNo = scanner.nextInt();
		int count = 0;
		try {
			// delete data from database
			 count = statement.executeUpdate(
					"DELETE FROM student WHERE rollno = " + rollNo);
		} catch (SQLException e) {
			System.out.println("Unable to delete record from table");
		}
		if(count == 0)
			System.out.println("record not found");
		else 
			System.out.println("record deleted successfully");
	}
	
	public void search() {
		// accept roll no
		System.out.print("Enter roll no: ");
		int rollNo = scanner.nextInt();
		
		try {
			// get data from database
			resultSet = statement.executeQuery(
					"SELECT * FROM student WHERE rollno = " + rollNo);
			printData();
		} catch (SQLException e) {
			System.out.println("Unable to find record");
		}
	}
	
	public void viewAll() {
		try {
			// get data from database
			resultSet = statement.executeQuery("SELECT * FROM student");
			printData();
		} catch (SQLException e) {
			System.out.println("Unable to find record");
		}		
	}
	
	public void printData() {
		printline();
		System.out.printf("| %s | %10s | %s |\n", "Roll No", "Name", "Percentage");
		printline();
		try {
			while (resultSet.next()) {
				System.out.printf("| %7d | %10s | %10.2f |\n",
						resultSet.getInt(1), resultSet.getString(2), resultSet.getFloat(3));
				printline();
			}
		} catch (SQLException e) {
			System.out.println("Unable to records");
		}
	}
	
	public static void printline() {
		for (int i = 0; i < 37; i++)
			System.out.print("-");
		System.out.println();
	}
	
	public static void main(String args[]) {
		StudentDatabase studentDatabase = new StudentDatabase();
		int choice = 0;
		do {
			System.out.println("\n1. Insert");
			System.out.println("2. Modify");
			System.out.println("3. Delete");
			System.out.println("4. Search");
			System.out.println("5. View All");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				studentDatabase.insert();
				break;
				
			case 2:
				studentDatabase.modify();
				break;
				
			case 3:
				studentDatabase.delete();
				break;
				
			case 4:
				studentDatabase.search();
				break;
				
			case 5:
				studentDatabase.viewAll();
				break;
				
			case 6:
				System.exit(0);

			default:
				break;
			}
		} while (choice != 6);
	}
}
