package setB.que2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PhoneBook extends JFrame {
	private static final long serialVersionUID = 1L;
	// components
	private JTextField nameField, addressField, phoneField, emailField;
	private JButton preButton, deleteButton, updateButton, nextButton, exitButton;

	// result
	private ResultSet resultSet;

	// constructor
	public PhoneBook(Connection connection) {

		try {
			// create statement
			Statement statement = connection.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			// execute query
			resultSet = statement.executeQuery("SELECT * FROM PeopleDetails");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Connection faild", 
					"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

		// set layout to grid bag layout and create GridBagConstraints
		setLayout(new GridBagLayout());
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 2;
		bagConstraints.insets = new Insets(10, 10, 10, 10);

		// add labels
		add(new JLabel("Name: "), bagConstraints);
		bagConstraints.gridy++;
		add(new JLabel("Address: "), bagConstraints);
		bagConstraints.gridy++;
		add(new JLabel("Phone: "), bagConstraints);
		bagConstraints.gridy++;
		add(new JLabel("E-mail: "), bagConstraints);
		bagConstraints.gridy++;

		// add text fields
		nameField = new JTextField(15);
		bagConstraints.gridy = 0;
		bagConstraints.gridx += 2;
		add(nameField, bagConstraints);	

		addressField = new JTextField(15);
		bagConstraints.gridy++;
		add(addressField, bagConstraints);

		phoneField = new JTextField(15);
		bagConstraints.gridy++;
		add(phoneField, bagConstraints);

		emailField = new JTextField(15);
		bagConstraints.gridy++;
		add(emailField, bagConstraints);

		// add all buttons
		preButton = new JButton("<<");
		preButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prevRecord();
			}
		});
		bagConstraints.gridwidth = 1;
		bagConstraints.gridy++;
		bagConstraints.gridx = 0;
		add(preButton, bagConstraints);

		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteRecord();
			}
		});
		bagConstraints.gridx++;
		add(deleteButton, bagConstraints);

		updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateRecord();
			}
		});
		bagConstraints.gridx++;
		add(updateButton, bagConstraints);

		nextButton = new JButton(">>");
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nextRecord();
			}
		});
		bagConstraints.gridx++;
		add(nextButton, bagConstraints);

		exitButton = new JButton("Exit");
		exitButton.addActionListener(e -> dispose());
		bagConstraints.gridx++;
		add(exitButton, bagConstraints);

		// set frame properties
		setTitle("Phone Book");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		if(!nextRecord()) {
			JOptionPane.showMessageDialog(
					this, "No Details Found...", "No Data", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	// display next record
	private boolean nextRecord() {
		try {
			if(resultSet.next()) {
				nameField.setText(resultSet.getString(2));
				addressField.setText(resultSet.getString(3));
				phoneField.setText(resultSet.getString(4));
				emailField.setText(resultSet.getString(5));
				return true;
			}
			else 
				resultSet.previous();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					this, "Unable to read Database...", "Connection Failed", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	// display previous record
	private boolean prevRecord() {
		try {
			if(resultSet.previous()) {
				nameField.setText(resultSet.getString(2));
				addressField.setText(resultSet.getString(3));
				phoneField.setText(resultSet.getString(4));
				emailField.setText(resultSet.getString(5));
				return true;
			}
			else
				resultSet.next();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					this, "Unable to read Database...", "Connection Failed", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	// update record
	public void updateRecord() {
		if (isValidRecords()) {
			try {
				resultSet.updateString(2, nameField.getText());
				resultSet.updateString(3, addressField.getText());
				resultSet.updateString(4, phoneField.getText());
				resultSet.updateString(5, emailField.getText());
				resultSet.updateRow();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(
						this, "Unable to connect Database...", "Connection Failed", JOptionPane.ERROR_MESSAGE);
			}
			JOptionPane.showMessageDialog(
					this, "Details Updated...", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// delete record
	public void deleteRecord() {
		try {
			resultSet.deleteRow();
			if (resultSet.next()) {
				resultSet.previous();
				nextRecord();
			}
			else if (resultSet.previous()){
				resultSet.next();
				prevRecord();
			}
			else {
				JOptionPane.showMessageDialog(
						this, "No more records...", "Error", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					this, "Unable to delete record...", "Connection Failed", JOptionPane.ERROR_MESSAGE);
		}
	}

	// check whether record is valid or not
	public boolean isValidRecords() {
		// check all field filled or not
		String name = nameField.getText();
		String address = addressField.getText();
		String phone = phoneField.getText();
		String email = emailField.getText();

		if (name.length() == 0 || address.length() == 0
				|| phone.length() == 0 || email.length() == 0) {
			JOptionPane.showMessageDialog(this, "Please fill all the fields", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		// check whether phone number is valid or not
		long num = 0;
		try {
			num = Long.parseLong(phone);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Phone number can contain only digits", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (phone.length() < 10) {
			JOptionPane.showMessageDialog(this, "Phone number should contain at least 10 digits", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (num < 0) {
			JOptionPane.showMessageDialog(this, "Phone number cannot be negative", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		// check whether email id is invalid or not
		if (email.indexOf('@') == -1 || email.indexOf('.') == -1) {
			JOptionPane.showMessageDialog(this, "Invalid Email address", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public static void main(String args[]) {
		PhoneBookConnection phoneBookConnection = new PhoneBookConnection();
		Connection connection = phoneBookConnection.getConnection();
		new PhoneBook(connection);
	}
}
