package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textEmail;
	private JTextField textUser;
	private JPasswordField passwordField;	
	private JPasswordField passwordField_r;
	private int mouseX;
	private int mouseY;
	
	private Controller controller;
	

	/**
	 * Create the frame.
	 */
	public RegisterFrame(Controller ctrl) {
		controller = ctrl;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 622);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 274, 622);
		contentPane.add(panel);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(67, 255, 143, 29);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Georgia", Font.BOLD, 25));
		panel.add(lblPassword);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(69, 25, 143, 39);
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Georgia", Font.BOLD, 33));
		panel.add(lblRegister);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setBounds(67, 106, 143, 29);
		lbl_username.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_username.setForeground(Color.BLACK);
		lbl_username.setFont(new Font("Georgia", Font.BOLD, 25));
		panel.add(lbl_username);
		
		JLabel lblRepeatPassword = new JLabel("<html>\r\n <center>Repeat\r\n<br/>password \r\n</center>\r\n </html>\r\n\r\n");
		lblRepeatPassword.setBounds(67, 319, 143, 59);
		lblRepeatPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepeatPassword.setForeground(Color.BLACK);
		lblRepeatPassword.setFont(new Font("Georgia", Font.BOLD, 25));
		panel.add(lblRepeatPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(67, 184, 143, 29);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Georgia", Font.BOLD, 25));
		panel.add(lblEmail);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita\r\n");
		lblDataDiNascita.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDiNascita.setForeground(Color.BLACK);
		lblDataDiNascita.setFont(new Font("Georgia", Font.BOLD, 25));
		lblDataDiNascita.setBounds(34, 414, 206, 29);
		panel.add(lblDataDiNascita);
		
		JLabel lblGoToLogin = new JLabel("Hai gi\u00E0 un account? Clicca Qui!\r\n");
		lblGoToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GoToLoginFrame();
			}
		});
		lblGoToLogin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblGoToLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		lblGoToLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoToLogin.setForeground(Color.WHITE);
		lblGoToLogin.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
		lblGoToLogin.setBounds(8, 608, 256, 14);
		panel.add(lblGoToLogin);
		
		JLabel Sfondo = new JLabel("");
		Sfondo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY = e.getY();
			}
		});
		Sfondo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
		});
		Sfondo.setIcon(new ImageIcon(RegisterFrame.class.getResource("/IconRegister/Artboard \u2013 1.png")));
		Sfondo.setBounds(0, 0, 274, 622);
		contentPane.add(Sfondo);
		

		textUser = new JTextField();
		textUser.setBounds(67, 146, 143, 20);
		textUser.setColumns(10);
		textUser.setBackground(new Color(191, 191, 191));
		panel.add(textUser);
		
		textEmail = new JTextField();
		textEmail.setBounds(67, 224, 143, 20);
		textEmail.setColumns(10);
		textEmail.setBackground(new Color(191, 191, 191));
		panel.add(textEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(67, 295, 143, 20);
		passwordField.setBackground(new Color(191, 191, 191));
		panel.add(passwordField);
		
		passwordField_r = new JPasswordField();
		passwordField_r.setBounds(67, 383, 143, 20);
		passwordField_r.setBackground(new Color(191, 191, 191));
		panel.add(passwordField_r);
		
		JButton btnlogin = new JButton("");
		btnlogin.setBounds(111, 511, 54, 48);
		btnlogin.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				VerifyFields();
			}
		});
		btnlogin.setIcon(new ImageIcon(RegisterFrame.class.getResource("/IconRegister/AddUserIcon.png")));
		btnlogin.setOpaque(false);
		btnlogin.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnlogin.setContentAreaFilled(false);
		btnlogin.setBorderPainted(false);
		btnlogin.setBackground(SystemColor.menu);
		panel.add(btnlogin);
		
		JButton btnclose = new JButton("");
		btnclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnclose.setBounds(245, 11, 19, 20);

		btnclose.setIcon(new ImageIcon(RegisterFrame.class.getResource("/IconLogin/LoginClose.png")));
		btnclose.setOpaque(false);
		btnclose.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnclose.setContentAreaFilled(false);
		btnclose.setBorderPainted(false);
		btnclose.setBackground(SystemColor.menu);
		panel.add(btnclose);
	}
	
	private boolean VerifyFields() {
		String username = textUser.getText();
		String email = textEmail.getText();
		String password = String.valueOf(passwordField.getPassword());
		String confirmpass = String.valueOf(passwordField_r.getPassword());
		
		if(username.trim().equals("") || email.trim().equals("") || password.trim().equals("") || confirmpass.trim().equals("") ) {
			JOptionPane.showMessageDialog(null, "Uno o più campi sono vuoti", "Campi vuoti",2);
			return false;
		}
		else if(!password.equals(confirmpass)) {
			JOptionPane.showMessageDialog(null, "Password non corrisponde", "Conferma Password", 2);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Account creato");
			return true;
		}
}
	

}
