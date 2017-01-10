package setA.que3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ColumnData {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			// load driver
			Class.forName("org.postgresql.Driver");

			// create connection
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost/studentdb", "postgres", "noor!xyz");

			// create statement
			Statement statement = connection.createStatement();

			// get resultSet
			ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

			// get data of resultSet
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
		} finally {
			// close the connections
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(
						null, "Unable to close connection", "Database Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

