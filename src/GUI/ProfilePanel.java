package GUI;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class ProfilePanel extends JPanel {
	private JTextField txtNome;
	private JTextField txtCognome;
	private JTextField txtEmail;
	private JTextField txtUsername;

	/**
	 * Create the panel.
	 */
	public ProfilePanel() {
		setBackground(new Color(220,255,192));
		setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblNome.setBounds(10, 213, 76, 36);
		add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblCognome.setBounds(271, 213, 101, 36);
		add(lblCognome);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblUsername.setBounds(271, 315, 118, 29);
		add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblEmail.setBounds(0, 311, 88, 36);
		add(lblEmail);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(84, 221, 132, 23);
		add(txtNome);
		
		txtCognome = new JTextField();
		txtCognome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCognome.setEditable(false);
		txtCognome.setColumns(10);
		txtCognome.setBounds(398, 219, 167, 23);
		add(txtCognome);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(84, 319, 176, 23);
		add(txtEmail);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setEditable(false);
		txtUsername.setColumns(10);
		txtUsername.setBounds(398, 317, 167, 23);
		add(txtUsername);
		
		JLabel lblFoto = new JLabel("Foto");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBounds(173, 22, 212, 143);
		add(lblFoto);

	}
}
