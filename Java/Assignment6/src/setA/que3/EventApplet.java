package setA.que3;

import java.applet.Applet;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;

public class EventApplet extends Applet implements MouseListener, KeyListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	private JLabel keyClicked, keyPressed, mousePosition, keyReleased, mouseLocation, mouseDragged;

	public void init() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.gridx = gbc.gridy = 0;

		add(new JLabel("Key Clicked : "), gbc);

		gbc.gridy++;
		add(new JLabel("Key Pressed : "), gbc);

		gbc.gridy++;
		add(new JLabel("Key Released : "), gbc);

		gbc.gridy++;
		add(new JLabel("Mouse Position : "), gbc);

		gbc.gridy++;
		add(new JLabel("Mouse Location : "), gbc);

		gbc.gridy++;
		add(new JLabel("Mouse Dragged : "), gbc);

		gbc.gridy = 0;
		gbc.gridx++;

		keyClicked = new JLabel();
		add(keyClicked, gbc);

		keyPressed = new JLabel();
		gbc.gridy++;
		add(keyPressed, gbc);

		keyReleased = new JLabel();
		gbc.gridy++;
		add(keyReleased, gbc);

		mousePosition = new JLabel();
		gbc.gridy++;
		add(mousePosition, gbc);

		mouseLocation = new JLabel();
		gbc.gridy++;
		add(mouseLocation, gbc);

		mouseDragged = new JLabel();
		gbc.gridy++;
		add(mouseDragged, gbc);

		setFocusable(true);
		setSize(400, 400);
		addMouseListener(this);
		addKeyListener(this);
		addMouseMotionListener(this);
	}

	//@Override
	public void mouseClicked(MouseEvent e) {
		String labelText = null;

		if (e.getButton() == MouseEvent.BUTTON1)
			labelText = "Right Key";

		if (e.getButton() == MouseEvent.BUTTON2)
			labelText = "Middle Key";

		if (e.getButton() == MouseEvent.BUTTON3)
			labelText = "Left Key";

		keyClicked.setText(labelText);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String labelText = null;

		if (e.getButton() == MouseEvent.BUTTON1)
			labelText = "Right Key";

		if (e.getButton() == MouseEvent.BUTTON2)
			labelText = "Middle Key";

		if (e.getButton() == MouseEvent.BUTTON3)
			labelText = "Left Key";

		keyPressed.setText(labelText);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String labelText = null;

		if (e.getButton() == MouseEvent.BUTTON1)
			labelText = "Right Key";

		if (e.getButton() == MouseEvent.BUTTON2)
			labelText = "Middle Key";

		if (e.getButton() == MouseEvent.BUTTON3)
			labelText = "Left Key";

		keyReleased.setText(labelText);
		keyPressed.setText(null);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		mousePosition.setText("In window");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		mousePosition.setText("Out of window");		
	}

	@Override
	public void keyTyped(KeyEvent e) { }

	@Override
	public void keyPressed(KeyEvent e) {
		keyPressed.setText(KeyEvent.getKeyText(e.getKeyCode()));
		keyClicked.setText(KeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyReleased.setText(KeyEvent.getKeyText(e.getKeyCode()));
		keyPressed.setText(null);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseDragged.setText("Dragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseLocation.setText(e.getX() + ", " + e.getY());
		mouseDragged.setText("");
	}
}
