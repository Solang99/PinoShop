package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ComponetArticolo extends JPanel {

	/**
	 * Create the panel.
	 */
	public ComponetArticolo() {
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ComponetArticolo.class.getResource("/IconRegister/AddUserIcon.png")));
		label.setBounds(45, 11, 48, 55);
		add(label);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(21, 89, 89, 23);
		add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(21, 123, 89, 23);
		add(button);

	}
}
