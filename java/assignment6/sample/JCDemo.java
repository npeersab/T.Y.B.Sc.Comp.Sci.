import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JCDemo extends JFrame implements ItemListener {

	JTextField jtf;
	JCheckBox jcb1, jcb2;

	public JCDemo() {

		setLayout(new FlowLayout());
		jcb1 = new JCheckBox("C Box1");
		jcb1.addItemListener(this);
		add(jcb1);
		jcb2 = new JCheckBox("C Box2");
		jcb2.addItemListener(this);
		add(jcb2);
		jtf = new JTextField(20);
		add(jtf);
		setSize(200, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

	public void itemStateChanged(ItemEvent e) {
		
		String text = null;
		if(jcb1.isSelected())
			text = jcb1.getText();
		if(jcb2.isSelected())
			text = jcb2.getText();
		jtf.setText(text);
	}

	public static void main(String args[]) {
		
		new JCDemo();
	}
}
