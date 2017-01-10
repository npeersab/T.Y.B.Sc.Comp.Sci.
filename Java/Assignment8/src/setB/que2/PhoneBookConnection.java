package setB.que2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PhoneBookConnection {
	private final String URL = "jdbc:postgresql://localhost/phonebook",
			USER = "postgres", PASSWORD = "noor!xyz", DRIVER = "org.postgresql.Driver";
	private Connection connection;

	// constructor
	public PhoneBookConnection() {
		try {
			// load database driver
			Class.forName(DRIVER);

			// establish connection
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(
					null, "Unable to load drivers...", "No Drivers Found", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null, "Unable to connect database...", "Connection Failed", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	// return connection
	public Connection getConnection() {
		return connection;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (connection != null)
			connection.close();
	}
}