import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldFont extends JFrame implements ActionListener, ItemListener {
	
	private static final long serialVersionUID = 5195319646746975928L;
	private JComboBox<?> fontFamilyComboBox, sizeComboBox;
	private JLabel fontLabel, sizeLabel, styleLabel;
	private JCheckBox boldCheckBox, italicCheckBox, underlineCheckBox;
	private JTextField textField;
	private String fontName = "Arial";
	private int fontSize = 10, fontStyle = Font.PLAIN;
	private int underline = -1;
		
	public TextFieldFont() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 2, 0);
		
		fontLabel = new JLabel("Font");
		panel.add(fontLabel, gbc);
		
		String[] fontFamily = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontFamilyComboBox = new JComboBox<String>(fontFamily);
		fontFamilyComboBox.addActionListener(this);
		gbc.gridy++;
		panel.add(fontFamilyComboBox, gbc);
		
		sizeLabel = new JLabel("Size");
		gbc.gridy++;
		panel.add(sizeLabel, gbc);
		
		Integer size[] = new Integer[20];
		for(int i = 0; i < 20; i++)
			size[i] = i+10;
		sizeComboBox = new JComboBox<Integer>(size);
		sizeComboBox.addActionListener(this);
		gbc.gridy++;
		panel.add(sizeComboBox, gbc);
		
		textField = new JTextField();
		textField.setFont(new Font(fontName, fontStyle, fontSize));
		gbc.gridy++;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(20, 0, 2, 0);
		panel.add(textField, gbc);
		
		gbc.insets = new Insets(0, 40, 2, 0);
		gbc.gridx = 2;
		gbc.gridy = 0; 
	
		styleLabel = new JLabel("Style");
		panel.add(styleLabel, gbc);
		
		boldCheckBox = new JCheckBox("Bold");
		boldCheckBox.addItemListener(this);
		gbc.gridy++;
		panel.add(boldCheckBox, gbc);
		
		italicCheckBox = new JCheckBox("Italic");
		italicCheckBox.addItemListener(this);
		gbc.gridy++;
		panel.add(italicCheckBox, gbc);
	
		underlineCheckBox = new JCheckBox("Underline");
		underlineCheckBox.addItemListener(this);
		gbc.gridy++;
		panel.add(underlineCheckBox, gbc);
				
		setLayout(new BorderLayout());
		add(panel);
		setTitle("TextField");
		setSize(400, 400);
		setLocation(500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		
		new TextFieldFont();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
				
		Object obj = e.getSource();
		
		if(obj == fontFamilyComboBox) {
			
			fontName = fontFamilyComboBox.getSelectedItem().toString();
		}
		
		else if(obj == sizeComboBox) {
			
			fontSize = (Integer) sizeComboBox.getSelectedItem();
		}
		
		Font font = new Font(fontName, fontStyle, fontSize);
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, underline);
		textField.setFont(font.deriveFont(attributes));
		this.getContentPane().revalidate();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getItemSelectable();
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			if(obj == boldCheckBox)
				fontStyle += Font.BOLD;
			
			else if(obj == italicCheckBox) 
				fontStyle += Font.ITALIC;
			
			else if(obj == underlineCheckBox)
				underline = TextAttribute.UNDERLINE_ON;
		}
		
		else if(e.getStateChange() == ItemEvent.DESELECTED) {
			
			if(obj == boldCheckBox)
				fontStyle -= Font.BOLD;
			
			else if(obj == italicCheckBox) 
				fontStyle -= Font.ITALIC;
				
			else if(obj == underlineCheckBox)
				underline = -1;
		}
				
		if(underlineCheckBox.isSelected()) {
			
		}
		Font font = new Font(fontName, fontStyle, fontSize);
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, underline);
		textField.setFont(font.deriveFont(attributes));
	}
}

