package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/IconRegister/Artboard \u2013 1.png")));
		lblNewLabel.setBounds(0, 0, 274, 622);
		contentPane.add(lblNewLabel);
	}

}
