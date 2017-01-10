package setA.que1;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Student extends JFrame {
	private static final long serialVersionUID = 1L;

	public Student(Object data[][]) {
		setLayout(new BorderLayout());

		// set column names
		String columnNames[] = {"Roll No.", "Name", "Percentage"};  		

		// create new JTable
		JTable table = new JTable(data, columnNames);
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);

		// set frame properties
		setTitle("Student Details");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(300, 300);
	}

	public static void main(String[] args) {
		Connection connection = null;

		try {
			// loading driver
			Class.forName("org.postgresql.Driver");

			// creating connection
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost/studentdb", "postgres", "noor!xyz");

			// create statement
			Statement statement = connection.createStatement();

			// execute query to get total no of rows
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM student");
			resultSet.next();
			int rowCount = resultSet.getInt(1);

			// execute query to get all student details
			resultSet = statement.executeQuery("SELECT * FROM student");

			// get the data from resultSet and store in 2D array to display as table
			// get no of rows in table
			Object data[][] = new Object[rowCount][3];
			int count = 0;
			while (resultSet.next()) {
				data[count][0] = resultSet.getInt(1);
				data[count][1] = resultSet.getString(2);
				data[count][2] = resultSet.getFloat(3);
				count++;
			}

			// pass data to frame constructor
			new Student(data);

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(
					null, "Unable to load driver", "Driver Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					null, "Unable to connect database", "Database Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			// close the connections
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(
						null, "Unable to close connections", "Database Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}

