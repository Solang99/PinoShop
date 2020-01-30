package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ComponetArticolo extends JPanel {

	/**
	 * Create the panel.
	 */
	public ComponetArticolo(Image foto , String nome) {
		setLayout(null);
		
		this.setPreferredSize(new Dimension(125,172));
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(21, 11, 89, 56);
		ImageIcon iconIndumento=  new ImageIcon(CassaFrame.class.getResource("/IconRegister/notfound.png"));
		Image imageIndumentoScaled = iconIndumento.getImage().getScaledInstance(label.getWidth(), label.getHeight(),   java.awt.Image.SCALE_SMOOTH);

		label.setIcon(new ImageIcon(imageIndumentoScaled));
		add(label);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(21, 104, 89, 23);
		add(btnAggiungi);
		
		JButton btnEdit = new JButton("Edita");
		btnEdit.setBounds(21, 138, 89, 23);
		add(btnEdit);
		
		JLabel label_1 = new JLabel("");
		label_1.setText(nome);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(21, 74, 89, 23);
		add(label_1);
		
		setVisible(true);

	}
}
