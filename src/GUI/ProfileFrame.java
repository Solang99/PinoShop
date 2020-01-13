package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JTextField;

public class ProfileFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnRecenti;
	private JButton btnProfilo;
	private JButton btnLogOut;
	private Controller controller;
	private TopPanel topPanel;
	private JPanel panelCards;
	private JPanel profileCard;
	private JPanel recentiCard;
	private CardLayout cardPanel;
	private JPanel sidePanel;
	private JLabel logoIcon;
	private JLabel lblCognome;
	private JLabel lblNome;
	private int mouseX;
	private int mouseY;
	
	public ProfileFrame(Controller ctrl) {
		controller = ctrl;
		cardPanel = new CardLayout();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 648);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);

		topPanel = new TopPanel(controller,this);
		topPanel.setBounds(0, 0, 897, 133);
		topPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY = e.getY();
			}
		});
		topPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x =e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
		});
		
		sidePanel = new JPanel();
		sidePanel.setBounds(0, 131, 243, 517);
		sidePanel.setBorder(null);
		sidePanel.setBackground(new Color(155, 220, 193));
		
		
		 btnRecenti = new JButton("RECENTI");
		 btnRecenti.setForeground(Color.BLACK);
		 btnRecenti.setBounds(0, 119, 242, 65);
		 btnRecenti.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		SetColor(btnRecenti);
		 		ResetColor(btnProfilo);
		 		ResetColor(btnLogOut);
		 	}
		 });
		btnRecenti.setBackground(new Color(155, 220, 193));
	
		btnRecenti.setBorderPainted(false);
		btnRecenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardPanel.show(panelCards, "2");
			}
		});
				btnRecenti.setPreferredSize(new Dimension(232, 40));
		btnRecenti.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRecenti.setFont(new Font("Segoe Print", Font.BOLD, 20));
		
		logoIcon = new JLabel("");
		logoIcon.setBounds(10, 278, 216, 228);
		logoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		logoIcon.setIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/PineIcon+.png")));
		logoIcon.setPreferredSize(new Dimension(232, 100));
		
		btnProfilo = new JButton("PROFILO");
		btnProfilo.setBounds(0, 69, 242, 65);
		btnProfilo.setForeground(Color.BLACK);
		btnProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetColor(btnProfilo);
				ResetColor(btnRecenti);
				ResetColor(btnLogOut);
				
			}
		});
		btnProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardPanel.show(panelCards, "1");
			}
			
		});
		btnProfilo.setPreferredSize(new Dimension(232, 40));
		btnProfilo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProfilo.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnProfilo.setBorderPainted(false);
		btnProfilo.setBackground(new Color(155, 220, 193));
		
		btnLogOut = new JButton("LOG OUT");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setBounds(0, 181, 242, 65);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetColor(btnLogOut);
				ResetColor(btnProfilo);
				ResetColor(btnRecenti);
			}
		});
		btnLogOut.setPreferredSize(new Dimension(232, 40));
		btnLogOut.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogOut.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBackground(new Color(155, 220, 193));
		contentPane.setLayout(null);
		contentPane.add(topPanel);
		contentPane.add(sidePanel);
		sidePanel.setLayout(null);
		sidePanel.add(btnProfilo);
		sidePanel.add(btnRecenti);
		sidePanel.add(btnLogOut);
		sidePanel.add(logoIcon);
		

		panelCards = new JPanel();
		panelCards.setBounds(286, 154, 575, 439);
		contentPane.add(panelCards);
		panelCards.setBackground(new Color (220,255,192));
		panelCards.setLayout(cardPanel);
		
		profileCard = new JPanel();
		profileCard.setBackground(new Color(220,255,192));
		panelCards.add(profileCard, "name_386263633130100");
		profileCard.setLayout(null);
		panelCards.add(profileCard, "1");
		
		lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblNome.setBounds(244, 31, 72, 22);
		profileCard.add(lblNome);
		
		lblCognome = new JLabel("COGNOME");
		lblCognome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblCognome.setBounds(231, 132, 111, 22);
		profileCard.add(lblCognome);
		
		recentiCard = new JPanel();
		recentiCard.setBackground(new Color(220,255,192));
		panelCards.add(recentiCard, "2");



	}
	
	private void SetColor(JButton btn) {
		btn.setBackground(new Color(131,181,160));
	}
	private void ResetColor (JButton btn) {
		btn.setBackground(new Color(155, 220, 193));
	}
}
