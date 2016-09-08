import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JButtonDemo extends JFrame implements ActionListener {

	JTextField jtf;
	JButton jb;
	
	JButtonDemo() {

		setLayout(new FlowLayout());
		jtf = new JTextField(15);
		add(jtf);
		jtf.setText("Not Clicked");
		jb = new JButton("Click me");
		jb.addActionListener(this);
		add(jb);
		setSize(240, 340);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		jtf.setText("Clicked");
	}

	public static void main(String args[]) {

		new JButtonDemo();
	}
}
