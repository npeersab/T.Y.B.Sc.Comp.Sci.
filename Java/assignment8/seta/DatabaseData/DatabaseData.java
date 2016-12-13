import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseData {
	public static void main(String[] args) {
		try {
			// load driver
			Class.forName("org.postgresql.Driver");
			
			// create connection
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost/studentdb", "postgres", "noor!xyz");
			
			// get data about database
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			
			// display database details
			System.out.println("Database Product Name: " + databaseMetaData
					.getDatabaseProductName());
			System.out.println("Database Product Version: " + databaseMetaData.
					getDatabaseProductVersion());
			System.out.println("Database User Name: " + databaseMetaData.getUserName());
			System.out.println("Database URL: " + databaseMetaData.getURL());
			
			// get all tables from database
			ResultSet resultSet = databaseMetaData.getTables(
					connection.getCatalog(), connection.getSchema(), "%", null);
			// display all tables
			System.out.println("\nTables in Database:");
			while (resultSet.next()) {
				System.out.println(resultSet.getString(3));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error while loading drivers");
		} catch (SQLException e) {
			System.out.println("Error while reading database");
		}
	}
}
