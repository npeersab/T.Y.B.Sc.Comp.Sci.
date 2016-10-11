import java.awt.ComponentOrientation;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Calculator extends JFrame implements ActionListener {
	
	private JButton zero, one, two, three, four, five, six, seven, eight, nine, add, mul, sub, div, equal, dot;
	private JTextField field;
	private String result;
	
	public Calculator() {
		
			setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = gbc.gridy = 0;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weighty = gbc.weightx = 1;
			
			field = new JTextField();
			field.setHorizontalAlignment(SwingConstants.RIGHT);
			field.setFont(new Font("Arial", Font.PLAIN, 30));
			field.setFocusable(false);
			field.setText(result = "0");
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.insets = new Insets(10, 10, 10, 10);
			add(field,gbc);
			
			gbc.gridwidth = GridBagConstraints.BOTH;
			gbc.insets = new Insets(2, 10, 2, 2);
			gbc.gridy++;
			
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
			gbc.gridy = 1;
						
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
			gbc.gridy = 1;
								
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
			
			add = new JButton("+");
			add.addActionListener(this);
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
		
		switch (button.getText()) {
		
		case "+":
	
			break;
			
		case "-":
			
			break;
			
		case "*":
			
			break;

		case "/":
			
			break;
			
		case "=":
			
			break;
			
		default:
			result += button.getText();
		}
		
		field.setText(result);
		field.updateUI();
	}
}

