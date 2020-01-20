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
		setLayout(null);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBorder(null);
//		add(scrollPane);
	
		ComponetArticolo ca = new ComponetArticolo();
		ca.setBounds(0, 0, 132, 163);
		add(ca);
		ComponetArticolo c2 = new ComponetArticolo();
		c2.setBounds(135, 0, 132, 163);
		add(c2);
	}
	
}
