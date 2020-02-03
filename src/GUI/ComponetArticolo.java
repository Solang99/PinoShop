package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ComponetArticolo extends JPanel {


	public ComponetArticolo(Image foto , String nome,String id,float prezzo) {
		setLayout(null);
		
		this.setPreferredSize(new Dimension(125, 174));
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(21, 11, 89, 56);
		
	
		label.setIcon(new ImageIcon(foto.getScaledInstance(label.getWidth(), label.getHeight(),   java.awt.Image.SCALE_SMOOTH)));
		add(label);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(21, 140, 89, 23);
		add(btnAggiungi);
		
		JLabel lblNome = new JLabel("");
		lblNome.setText(nome);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(21, 74, 89, 23);
		add(lblNome);
		
		JLabel lblId = new JLabel("");
		lblId.setText(id);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(21, 96, 89, 23);
		add(lblId);
		
		JLabel lblPrezzo = new JLabel("");
		lblPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		Float p = prezzo;
		lblPrezzo.setText(p.toString());
		lblPrezzo.setBounds(21, 118, 89, 23);
		add(lblPrezzo);
		
		
		
		setVisible(true);

	}
}
