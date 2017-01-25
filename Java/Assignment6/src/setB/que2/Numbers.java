package setB.que2;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

public class Numbers extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu file, compute, operations;
	private final String computeString[] =  {"Sum", "Average", "Maximum", "Minimum", "Median"},
			fileString[] = {"Load", "Save", "Exit"},
			operationString[] = {"Search", "Sort"},
			sortString[] = {"Ascending", "Descending"};
	private JTextArea textArea;
	private int[] numbers;
	private final int maxSize = 50;

	public Numbers() {
		// Create new Menu bar
		menuBar = new JMenuBar();

		// create File menu
		file =  new JMenu("File");
		JMenuItem item = new JMenuItem(fileString[0]);
		item.addActionListener(this);
		file.add(item);
		item = new JMenuItem(fileString[1]);
		item.addActionListener(this);
		file.add(item);
		file.addSeparator();
		item = new JMenuItem(fileString[2]);
		item.addActionListener(this);
		file.add(item);
		menuBar.add(file);

		// create Compute menu
		compute = new JMenu("Compute");
		for (String string : computeString) {
			item = new JMenuItem(string);
			compute.add(item).addActionListener(this);
		}
		menuBar.add(compute);

		// create Operations menu
		operations = new JMenu("Operations");
		item = new JMenuItem(operationString[0]);
		item.addActionListener(this);
		operations.add(item);

		// create menu for sort
		JMenu menu = new JMenu(operationString[1]);
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButtonMenuItem ascending = new JRadioButtonMenuItem(sortString[0]);
		ascending.addActionListener(this);
		buttonGroup.add(ascending);
		menu.add(ascending);
		JRadioButtonMenuItem descending = new JRadioButtonMenuItem(sortString[1]);
		buttonGroup.add(descending);
		descending.addActionListener(this);
		menu.add(descending);			
		operations.add(menu);
		menuBar.add(operations);

		// set Layout to GridbagLayout
		setLayout(new GridBagLayout());
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.fill = GridBagConstraints.BOTH;
		bagConstraints.gridx = bagConstraints.gridy = 0;
		bagConstraints.insets = new Insets(0, 10, 10, 10);
		bagConstraints.weightx = 1;

		// create numbers label
		add(new JLabel("Numbers : "), bagConstraints);

		// create text area to display numbers
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setMargin(new Insets(10, 10, 10, 10));
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));
		bagConstraints.gridy++;
		add(textArea, bagConstraints);

		// set constraints of Frame
		setJMenuBar(menuBar);		
		setSize(500, 300);
		setLocation(400, 200);
		setTitle("Numbers");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		new Numbers();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		String menuString = null;

		if (object instanceof JMenuItem)
			menuString = ((JMenuItem) object).getText();
		else if (object instanceof JRadioButtonMenuItem)
			menuString = ((JRadioButtonMenuItem) object).getText();

		switch (menuString) {
		case "Load":
			load();
			break;

		case "Save":
			break;

		case "Exit":
			System.exit(NORMAL);
			break;

		case "Sum":
			sum();
			break;

		case "Average":
			average();
			break;

		case "Maximum":
			maximun();
			break;

		case "Minimum":
			minimum();
			break;

		case "Median":
			median();
			break;

		case "Search":
			search();
			break;

		case "Ascending":
			ascending();
			break;

		case "Descending":
			descending();
			break;
		}
	}

	// generate random numbers and display in textarea 
	public void load() {
		numbers = new int[50];
		
		// generate random numbers
		Random random = new Random();
		for (int i = 0; i < maxSize; i++) {
			numbers[i] = Math.abs(random.nextInt()) % 90 + 10;
		}
		textArea.setText(toString());
	}

	// display sum of all numbers
	public void sum() {
		JOptionPane.showInternalMessageDialog(
				this.getContentPane(), computeString[0] + " is " + getSum(), computeString[0], JOptionPane.INFORMATION_MESSAGE);
	}

	// display  average of numbers
	public void average() {
		displayMessage(computeString[1] + " is " + ((float) getSum()) / maxSize, computeString[1]);
	}

	// display maximum number
	public void maximun() {
		int max = 0;
		for (int n : numbers)
			max = Integer.max(max, n);

		displayMessage(computeString[2] + " number is " + max, 
				computeString[2]);
	}

	// display  minimum number
	public void minimum() {
		int min = numbers[0];
		for (int n : numbers)
			min = Integer.min(min, n);

		displayMessage(computeString[3] + " number is " + min,
				computeString[3]);
	}

	// display median
	public void median() {
		displayMessage(computeString[4] + " is " + getSortedAscending()[maxSize / 2],
				"Average");
	}

	// search for a number
	public void search() {
		int num = 0;

		// if user give input other than integer
		try {
			String buff = 
					JOptionPane
					.showInputDialog("Enter number to be searched :");

			// if user close the input window
			if (buff == null)
				return;

			num = Integer.parseInt(buff);

		} catch (NumberFormatException e) {
			displayMessage("Invalid input !!! ", "Error");
			return;
		}

		boolean flag = false;
		StringBuffer buffer = new StringBuffer();
		int i = 0;
		for (i = 0; i < maxSize; i++)
			if (numbers[i] == num) {
				buffer.append((i + 1) + " ");
				flag = true;
			}

		if (flag)
			displayMessage(num + " found at position " + buffer.toString(), "Found");	
		else 
			displayMessage(num + " not found", "Not found");
	}

	// set numbers in ascending order
	private void ascending() {
		if (numbers != null) {
			numbers = getSortedAscending();
			textArea.setText(toString());
		}
	}

	// set numbers in descending order
	private void descending() {
		if (numbers != null) {
			numbers = getSortedDescending();
			textArea.setText(toString());
		}
	}

	// return numbers in string format
	public String toString() {
		if (numbers == null)
			return " ";
		
		StringBuffer buffer = new StringBuffer();
		
		for(int n : numbers)
			buffer.append(n + " ");

		// add newline after 10 numbers
		for (int i = 0, coeff = 30; i < 4; i++, coeff += 30) {
			buffer.insert(coeff + i, '\n');
		}

		return buffer.toString();
	}

	// return sorted numbers in ascending order
	public int[] getSortedAscending() {
		// copy numbers in temporary array
		int num[] = new int[maxSize], k = 0;
		for (int n : numbers)
			num[k++] = n;

		// sort the array
		for (int i = 0; i < maxSize; i++)
			for (int j = 0; j < maxSize - i - 1; j++)
				if (num[j] > num[j + 1]) {
					num[j] = num[j] + num[j + 1];
					num[j + 1] = num[j] - num[j + 1];
					num[j] = num[j] - num[j + 1];
				}
		return num;
	}

	// return sorted numbers in descending order
	public int[] getSortedDescending() {
		// copy numbers in temporary array
		int num[] = new int[maxSize], k = 0;
		for (int n : numbers)
			num[k++] = n;

		// sort the array
		for (int i = 0; i < maxSize; i++)
			for (int j = 0; j < maxSize - i - 1; j++)
				if (num[j] < num[j + 1]) {
					num[j] = num[j] + num[j + 1];
					num[j + 1] = num[j] - num[j + 1];
					num[j] = num[j] - num[j + 1];
				}

		return num;
	}

	// return sum of all numbers
	public int getSum() {
		int sum = 0;
		for (int n : numbers) {
			sum += n;
		}
		return sum;
	}

	// display message
	public void displayMessage(String message, String title) {
		JOptionPane.showInternalMessageDialog(
				this.getContentPane(),
				message,
				title,
				JOptionPane.INFORMATION_MESSAGE);
	}
}

