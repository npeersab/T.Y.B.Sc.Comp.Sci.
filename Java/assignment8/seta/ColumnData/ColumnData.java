import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ColumnData {
	public static void main(String[] args) {
		try {
			// load driver
			Class.forName("org.postgresql.Driver");
			
			// create connection
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost/studentdb", "postgres", "noor!xyz");
			
			// create statement
			Statement statement = connection.createStatement();
			
			// get resultset
			ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
			
			// get data of resultset
			ResultSetMetaData metaData = resultSet.getMetaData();
			
			// display column details
			int count = metaData.getColumnCount();
			System.out.println("No. of Columns: " + count);
			for (int i = 1; i <= count; i++) {
				System.out.println("\nColumn " + i + ": ");
				System.out.println("Label: " + metaData.getColumnLabel(i));
				System.out.println("Type: " + metaData.getColumnTypeName(i));
				System.out.println("Display Size: " + metaData.getColumnDisplaySize(i));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error while loading drivers");
		} catch (SQLException e) {
			System.out.println("Error while reading database");
		}
	}
}

