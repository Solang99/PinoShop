package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;

public class ProfilePanel extends JPanel {

	private static final String Image = null;
	
	private JButton btnRecenti;
	private JButton btnProfilo;
	private JButton btnLogOut;
	private Controller controller;
	
	private JPanel panelCards;
	private JPanel profileCard;
	private JPanel sidePanel;
	private JLabel logoIcon;
	private JLabel lblNome;

	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblFoto;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private CardLayout cardLayout;
	
	public ProfilePanel(Controller ctrl) {
		controller = ctrl;

		setBorder(null);
		setSize(514, 298);
		setBounds(0, 144, 906, 541);
		


		sidePanel = new JPanel();
		sidePanel.setBounds(0, 0, 243, 552);
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
		 		cardLayout.show(panelCards, "recenti");
		 	}
		 });
		btnRecenti.setBackground(new Color(155, 220, 193));
	
		btnRecenti.setBorderPainted(false);
	
		btnRecenti.setPreferredSize(new Dimension(232, 40));
		btnRecenti.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRecenti.setFont(new Font("Segoe Print", Font.BOLD, 20));
		
		logoIcon = new JLabel("");
		logoIcon.setBounds(10, 278, 216, 228);
		logoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		logoIcon.setIcon(new ImageIcon(ProfilePanel.class.getResource("/IconProfile/PineIcon+.png")));
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
				cardLayout.show(panelCards, "profile");
				
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
		setLayout(null);
		
		sidePanel.setLayout(null);
		sidePanel.add(btnProfilo);
		sidePanel.add(btnRecenti);
		sidePanel.add(btnLogOut);
		sidePanel.add(logoIcon);
		add(sidePanel);
		
		
		


		
		JPanel recentiCard = new JPanel();
		

		
		model = controller.FillTableRecentiModel();
	    table = new JTable(){

			@Override
	        public boolean isCellEditable(int row, int column) {
	           return false;
	        }
	    };
	    table.setFillsViewportHeight(true);
	    

	    
	    table.setModel(model);
		
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    table.setDefaultRenderer(String.class, centerRenderer);
	    
	    scroll = new JScrollPane(table);
	    scroll.setBounds(328, 10, 200, 531);
	    recentiCard.add(scroll);

	    
	    profileCard = new JPanel();
		profileCard.setBackground(new Color(220,255,192));

	
		
		
		
		
		
		lblNome = new JLabel("Nome: " + controller.commesso.getNome());
		lblNome.setBounds(40, 188, 201, 84);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		JLabel lblCognome = new JLabel("Cognome: " + controller.commesso.getCognome() );
		lblCognome.setBounds(350, 188, 201, 72);
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		lblUsername = new JLabel("Username: " + controller.commesso.getUsername());
		lblUsername.setBounds(40, 293, 201, 72);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		lblEmail = new JLabel("Email: " + controller.commesso.getMail());
		lblEmail.setBounds(350, 293, 201, 72);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(192, 61, 201, 134);
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
	
		Image fotoProfilo = (controller.commesso.getFoto());
		lblFoto.setIcon(new ImageIcon(fotoProfilo));
	
		profileCard.setLayout(null);
		profileCard.add(lblNome);
		profileCard.add(lblCognome);
		profileCard.add(lblFoto);
		profileCard.add(lblUsername);
		profileCard.add(lblEmail);
		
	    
		cardLayout = new CardLayout ();
		panelCards = new JPanel();
		panelCards.setLayout(cardLayout);
		panelCards.setBounds(253, 40, 637, 441);
		
		panelCards.add(profileCard,"profile");
		panelCards.add(recentiCard ,"recenti");
		cardLayout.show(panelCards, "profile");
		add(panelCards);
	    

	}
	
	private void SetColor(JButton btn) {
		btn.setBackground(new Color(131,181,160));
	}
	private void ResetColor (JButton btn) {
		btn.setBackground(new Color(155, 220, 193));
	}
	
	

}
