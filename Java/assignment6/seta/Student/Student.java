import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Student extends JFrame implements ActionListener, ItemListener, DocumentListener{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private ButtonGroup buttonGroup;
	private JRadioButton fy, sy, ty;
	private JTextField nameTextField;
	JTextArea textArea;
	private JCheckBox music, dance, sports;
	private String studName = "---", studClass = "---", studHobbies = "---"; 

	public Student() {

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = gbc.gridy = 0;
		gbc.insets = new Insets(0, 20, 10, 0);

		JLabel label = new JLabel("Your Name : ");
		panel.add(label, gbc);

		gbc.insets = new Insets(0, 20, 0, 0);

		label = new JLabel("Your Class : ");
		gbc.gridy++;
		panel.add(label, gbc);

		fy = new JRadioButton("FY");
		fy.addActionListener(this);
		gbc.gridy++;
		panel.add(fy, gbc);

		sy = new JRadioButton("SY");
		sy.addActionListener(this);
		gbc.gridy++;
		panel.add(sy, gbc);

		ty = new JRadioButton("TY");
		ty.addActionListener(this);
		gbc.gridy++;
		panel.add(ty, gbc);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(fy);
		buttonGroup.add(sy);
		buttonGroup.add(ty);

		gbc.insets = new Insets(20, 20, 0, 0);

		textArea = new JTextArea("Name : " + studName + "\nClass : " + studClass + "\nHobbies : " + studHobbies);
		textArea.setEditable(false);
		gbc.gridy++;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panel.add(textArea, gbc);

		gbc.insets = new Insets(0, 20, 10, 0);
		gbc.gridx++;

		nameTextField = new JTextField();
		nameTextField.getDocument().addDocumentListener(this);
		gbc.gridy = 0;
		panel.add(nameTextField, gbc);

		gbc.insets = new Insets(0, 20, 0, 0);

		label = new JLabel("Your Hobbies : ");
		gbc.gridy++;
		panel.add(label, gbc);

		music = new JCheckBox("Music");
		music.addItemListener(this);
		gbc.gridy++;
		panel.add(music, gbc);

		dance = new JCheckBox("Dance");
		dance.addItemListener(this);
		gbc.gridy++;
		panel.add(dance, gbc);

		sports = new JCheckBox("Sports");
		sports.addItemListener(this);
		gbc.gridy++;
		panel.add(sports, gbc);

		add(panel);
		setTitle("Student");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(500, 200);
		setSize(400, 400);
		setVisible(true);
	}

	@Override
		public void itemStateChanged(ItemEvent e) {

			JCheckBox obj = (JCheckBox) e.getSource();

			if(e.getStateChange() == ItemEvent.SELECTED) {

				addtHobbies(obj.getLabel());
			}

			if(e.getStateChange() == ItemEvent.DESELECTED) {
				removeHobbies(obj.getLabel());
			}
		}

	@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {

			Object obj = e.getSource();

			if(obj instanceof JRadioButton) {
				JRadioButton jRadioButton = (JRadioButton) obj;
				studClass = jRadioButton.getLabel();
			}
			updateText();
		}

	@Override
		public void insertUpdate(DocumentEvent e) {

			setName(nameTextField.getText());
		}

	@Override
		public void removeUpdate(DocumentEvent e) {

			setName(nameTextField.getText());
		}

	@Override
		public void changedUpdate(DocumentEvent e) {

			setName(nameTextField.getText());
		}

	public void updateText() {

		textArea.setText("Name : " + studName + "\nClass : " + studClass + "\nHobbies : " + studHobbies);
	}

	public void setName(String studName) {

		this.studName = studName;
		updateText();
	}

	public void setClass(String studClass) {

		this.studClass = studClass;
		updateText();
	}

	public void addtHobbies(String studHobbies) {

		this.studHobbies = this.studHobbies.replace("---", "");
		this.studHobbies += " " + studHobbies;
		this.studHobbies = this.studHobbies.trim();
		updateText();
	}

	public void removeHobbies(String studHobbies) {

		this.studHobbies = this.studHobbies.replace(studHobbies, "");
		this.studHobbies = this.studHobbies.trim();
		if(this.studHobbies.length() == 0) {
			this.studHobbies = "---";
		}
		updateText();
	}

	public static void main(String[] args) {

		new Student();
	}
}
