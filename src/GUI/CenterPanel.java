package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CenterPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CenterPanel() {
		setBorder(null);
		setSize(906, 546);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
	}
}
