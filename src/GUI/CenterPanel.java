package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class CenterPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CenterPanel() {
		setBorder(null);
		setSize(906, 546);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		add(scrollPane);
	}
}
