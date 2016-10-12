import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
	
	private JButton zero, one, two, three, four, five, six, seven, eight, nine, add, mul, sub, div, equal, dot, clear;
	private JTextField field;
	private StringBuffer buff, displayText;
	private String op1, op2;
	private char opr;
	
	public Calculator() {
		
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weighty = gbc.weightx = 1;
			
			field = new JTextField();
			 
			field.setFont(new Font("Arial", Font.PLAIN, 20));
			field.setFocusable(false);
			field.setHorizontalAlignment(JTextField.RIGHT);
			field.setText((displayText = new StringBuffer("0")).toString());
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.insets = new Insets(10, 10, 10, 10);
			add(field,gbc);
			
			gbc.gridwidth = GridBagConstraints.BOTH;
			gbc.insets = new Insets(2, 10, 2, 2);
			gbc.gridy+=2;
			
			one = new JButton("1");
			one.addActionListener(this);
			add(one, gbc);
			
			four = new JButton("4");
			four.addActionListener(this);
			gbc.gridy++;
			add(four, gbc);
			
			seven = new JButton("7");
			seven.addActionListener(this);
			gbc.gridy++;
			add(seven, gbc);
			
			zero = new JButton("0");
			zero.addActionListener(this);
			gbc.gridy++;
			add(zero, gbc);
			
			gbc.gridx++;
			gbc.insets = new Insets(2, 2, 2, 2);
			gbc.gridy = 2;
						
			two = new JButton("2");
			two.addActionListener(this);
			add(two, gbc);
			
			five = new JButton("5");
			five.addActionListener(this);
			gbc.gridy++;
			add(five, gbc);
			
			eight = new JButton("8");
			eight.addActionListener(this);
			gbc.gridy++;
			add(eight, gbc);
			
			dot = new JButton(".");
			dot.addActionListener(this);
			gbc.gridy++;
			add(dot, gbc);
			
			gbc.gridx++;
			gbc.gridy = 2;
								
			three = new JButton("3");
			three.addActionListener(this);
			add(three, gbc);
			
			six = new JButton("6");
			six.addActionListener(this);
			gbc.gridy++;
			add(six, gbc);
			
			nine = new JButton("9");
			nine.addActionListener(this);
			gbc.gridy++;
			add(nine, gbc);
			
			equal = new JButton("=");
			equal.addActionListener(this);
			gbc.gridy++;
			add(equal, gbc);
			
			gbc.gridy = 1;
			gbc.gridx++;
			gbc.insets = new Insets(2, 2, 2,10);
			
			clear = new JButton("C");
			clear.addActionListener(this);
			add(clear, gbc);
			
			add = new JButton("+");
			add.addActionListener(this);
			gbc.gridy++;
			add(add, gbc);
			
			sub = new JButton("-");
			sub.addActionListener(this);
			gbc.gridy++;
			add(sub, gbc);
			
			mul = new JButton("*");
			mul.addActionListener(this);
			gbc.gridy++;
			add(mul, gbc);
			
			div = new JButton("/");
			div.addActionListener(this);
			gbc.gridy++;
			add(div, gbc);
			
			buff = new StringBuffer();
			
			setSize(240, 320);
			setLocation(400, 200);
			setTitle("Calculator");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
	}

	public static void main(String[] args) {

		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton button = (JButton) e.getSource();
		String input = button.getText();
		
		switch (input) {
		
		case "+":
			op1 = buff.toString();
			buff.delete(0, buff.length());
			opr = '+';
			break;
			
		case "-":
			op1 = buff.toString();
			buff.delete(0, buff.length());
			opr = '-';
			break;
			
		case "*":
			op1 = buff.toString();
			buff.delete(0, buff.length());
			opr = '*';
			break;

		case "/":
			op1 = buff.toString();
			buff.delete(0, buff.length());
			opr = '/';
			break;
			
		case "=":
			op2 = buff.toString();
			buff = new StringBuffer(execute(op1, op2, opr));
			displayText.delete(0, displayText.length());
			input = buff.toString();
			break;
			
		case "C":
			buff.delete(0, buff.length());
			displayText.delete(0, displayText.length());
			input = "";
			break;
			
		default:
			buff.append(input);
		}
		
		displayText.append(input);
		field.setText(displayText.toString());
		
	}
	
	private String execute(String op1, String op2, char opr) {
		
		double d1 = Double.parseDouble(op1), d2 = Double.parseDouble(op2);
		String result = null;
				
		switch(opr) {
			
			case '+':
				result = String.valueOf(d1 + d2);
				break;
				
			case '-':
				result = String.valueOf(d1 - d2);
				break;
				
			case '*':
				result = String.valueOf(d1 * d2);
				break;
				
			case '/':
				result = String.valueOf(d1 / d2);
				break;
		}
		
		return result;
	}
}

