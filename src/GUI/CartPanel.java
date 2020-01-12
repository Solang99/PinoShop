package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;

public class CartPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CartPanel() {
		setBackground(Color.YELLOW);
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);

	}

}
