package GUI;



import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;


public class UtenteFrame extends JFrame {

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
	private JLabel lblNome;
	private int mouseX;
	private int mouseY;
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblFoto;
	
	public UtenteFrame(Controller ctrl) {
		controller = ctrl;
		cardPanel = new CardLayout();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 648);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);

		topPanel = new TopPanel(907,controller,this);
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
		logoIcon.setIcon(new ImageIcon(UtenteFrame.class.getResource("/IconProfile/PineIcon+.png")));
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
		panelCards.setBounds(286, 180, 575, 397);
		contentPane.add(panelCards);
		panelCards.setBackground(new Color (220,255,192));
		panelCards.setLayout(cardPanel);
		
		profileCard = new JPanel();
		profileCard.setBackground(new Color(220,255,192));
		panelCards.add(profileCard, "name_386263633130100");
		panelCards.add(profileCard, "1");
		
		lblNome = new JLabel("Nome: " + controller.commesso.getNome());
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		JLabel lblCognome = new JLabel("Cognome: " + controller.commesso.getCognome() );
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		lblUsername = new JLabel("Username: " + controller.commesso.getUsername());
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		lblEmail = new JLabel("Email: " + controller.commesso.getMail());
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		lblFoto = new JLabel("");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon fotoProfilo = new ImageIcon(new ImageIcon(controller.commesso.getFoto()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		lblFoto.setIcon(fotoProfilo);
		GroupLayout gl_profileCard = new GroupLayout(profileCard);
		gl_profileCard.setHorizontalGroup(
			gl_profileCard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_profileCard.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_profileCard.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_profileCard.createSequentialGroup()
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addGap(109)
							.addComponent(lblCognome, GroupLayout.PREFERRED_SIZE, 201, Short.MAX_VALUE))
						.addGroup(gl_profileCard.createSequentialGroup()
							.addGap(152)
							.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_profileCard.createSequentialGroup()
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 201, Short.MAX_VALUE)
							.addGap(109)
							.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
					.addGap(24))
		);
		gl_profileCard.setVerticalGroup(
			gl_profileCard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_profileCard.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_profileCard.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_profileCard.createSequentialGroup()
							.addGap(127)
							.addComponent(lblNome, GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
						.addGroup(gl_profileCard.createSequentialGroup()
							.addGap(127)
							.addComponent(lblCognome, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_profileCard.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		profileCard.setLayout(gl_profileCard);
		
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
