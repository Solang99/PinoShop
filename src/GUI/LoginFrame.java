package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
	
	
	
	private JPanel contentPane;
	private JPanel PanelOverWallpaper;
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblLogin;
	private JLabel lblRegistrati;
	private JButton btnLogin;
	private JButton btnClose;
	private int mouseX;
	private int mouseY;
	private Controller controller;


	public LoginFrame(Controller ctl) {
		controller = ctl;
		
		setUndecorated(true);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 396);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelOverWallpaper = new JPanel();
		PanelOverWallpaper.setBorder(null);
		PanelOverWallpaper.setBounds(0, 0, 276, 396);
		PanelOverWallpaper.setOpaque(false);

		btnLogin = new JButton("");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CheckLogin();
				
			}
		});
		btnLogin.setBounds(107, 281, 67, 59);
		btnLogin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(240, 240, 240));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnLogin.setIcon(new ImageIcon(LoginFrame.class.getResource("/IconLogin/LoginIcon.png")));
		
		btnClose = new JButton("");
		btnClose.setBounds(246, 11, 20, 20);
		btnClose.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnClose.setIcon(new ImageIcon(LoginFrame.class.getResource("/IconLogin/LoginClose.png")));
		btnClose.setOpaque(false);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setBackground(SystemColor.menu);
		
		textUsername = new JTextField();
		textUsername.setBounds(74, 141, 143, 20);
		textUsername.setColumns(10);
		textUsername.setBackground(new Color(191, 191, 191));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(74, 224, 143, 20);
		passwordField.setBackground(new Color(191, 191, 191));
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(74, 183, 143, 29);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Georgia", Font.BOLD, 25));
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(74, 21, 143, 39);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Georgia", Font.BOLD, 33));
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(74, 99, 143, 29);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Georgia", Font.BOLD, 25));
		
		lblRegistrati = new JLabel("Non hai un account ? Clicca qui!");
		lblRegistrati.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GoToRegisterFrame();
			}
		});
		lblRegistrati.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblRegistrati.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
	
		lblRegistrati.setBounds(10, 382, 256, 14);
		lblRegistrati.setForeground(Color.WHITE);
		lblRegistrati.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrati.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
		
		
		contentPane.add(PanelOverWallpaper);
		PanelOverWallpaper.setLayout(null);
		PanelOverWallpaper.add(lblPassword);
		PanelOverWallpaper.add(lblLogin);
		PanelOverWallpaper.add(lblUsername);
		PanelOverWallpaper.add(textUsername);
		PanelOverWallpaper.add(passwordField);
		PanelOverWallpaper.add(btnLogin);
		PanelOverWallpaper.add(btnClose);
		PanelOverWallpaper.add(lblRegistrati);
		
		JLabel Sfondo = new JLabel("New label");
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
				int x =e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
		});
		Sfondo.setBounds(0, 0, 276, 396);
		Sfondo.setIcon(new ImageIcon(LoginFrame.class.getResource("/IconLogin/LoginWallpaper.png")));
		Sfondo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(Sfondo);
	}
	
	private void CheckLogin() {
		try {
			boolean find = controller.LogIn(textUsername.getText(), passwordField.getPassword());
			if (find)
				controller.GoToMainFrame();
			else
				JOptionPane.showMessageDialog(null, "Coppia Username password non presente", "Errore", 2);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Contatta l'amministratore", "Errore", 2);
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
	}
}