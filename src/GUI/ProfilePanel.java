package GUI;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class ProfilePanel extends JPanel {


	
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



		sidePanel = new JPanel();
		sidePanel.setBorder(null);
		sidePanel.setBackground(new Color(155, 220, 193));
		
		
		 btnRecenti = new JButton("RECENTI");
		
	
		 btnRecenti.setForeground(Color.BLACK);
		 btnRecenti.setBounds(0, 119, 286, 65);
		 btnRecenti.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		setColor(btnRecenti);
		 		resetColor(btnProfilo);
		 		resetColor(btnLogOut);
		 		cardLayout.show(panelCards, "recenti");
		 	}
		 });
		btnRecenti.setBackground(new Color(155, 220, 193));
	
		btnRecenti.setBorderPainted(false);
	
		btnRecenti.setPreferredSize(new Dimension(232, 40));
		btnRecenti.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRecenti.setFont(new Font("Segoe Print", Font.BOLD, 20));
		
		logoIcon = new JLabel("");
		logoIcon.setBounds(39, 282, 216, 228);
		logoIcon.setHorizontalAlignment(SwingConstants.CENTER);
		logoIcon.setIcon(new ImageIcon(ProfilePanel.class.getResource("/IconProfile/PineIcon+.png")));
		logoIcon.setPreferredSize(new Dimension(232, 100));
		
		btnProfilo = new JButton("PROFILO");
	
		btnProfilo.setBounds(0, 69, 286, 65);
		btnProfilo.setForeground(Color.BLACK);
		btnProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(btnProfilo);
				resetColor(btnRecenti);
				resetColor(btnLogOut);
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
		btnLogOut.setBounds(0, 181, 286, 65);
		
		
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(btnLogOut);
				resetColor(btnProfilo);
				resetColor(btnRecenti);
				int dialogResult =JOptionPane.showConfirmDialog (null, "Sicuro di voler effettuare il LogOut? La cassa verra svuotata","Warning",JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					controller.fromMainToLoginFrame();
				}
			
			}
		});
		btnLogOut.setPreferredSize(new Dimension(232, 40));
		btnLogOut.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogOut.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBackground(new Color(155, 220, 193));
		
		sidePanel.setLayout(null);
		sidePanel.add(btnProfilo);
		sidePanel.add(btnRecenti);
		sidePanel.add(btnLogOut);
		sidePanel.add(logoIcon);
		
		
		


		
		JPanel recentiCard = new JPanel();
		

		
		model = controller.fillTableRecentiModel();
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
	
		Image fotoProfilo = (controller.commesso.getFoto().getScaledInstance(120, 120, Image.SCALE_AREA_AVERAGING));
		
	    
		cardLayout = new CardLayout ();
		panelCards = new JPanel();
		panelCards.setLayout(cardLayout);
		
			    
		profileCard = new JPanel();
		profileCard.setBackground(new Color(220,255,192));
			    
	    lblFoto = new JLabel("");
	    lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
	    lblFoto.setIcon(new ImageIcon(fotoProfilo));
	    
	    panelCards.add(profileCard,"profile");
	    JPanel panelDati = new JPanel();
			    
	    JLabel lblCognome = new JLabel("Cognome: " + controller.commesso.getCognome() );
	    lblCognome.setHorizontalAlignment(SwingConstants.LEFT);
	    lblCognome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
			    
			    	
			    		
			    		
			    		
			    		
			    		
		lblNome = new JLabel("Nome: " + controller.commesso.getNome());
			    		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
			    		lblNome.setFont(new Font("Segoe Print", Font.PLAIN, 20));
			    		
			    		lblUsername = new JLabel("Username: " + controller.commesso.getUsername());
			    		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
			    		lblUsername.setFont(new Font("Segoe Print", Font.PLAIN, 20));
			    		
			    		lblEmail = new JLabel("Email: " + controller.commesso.getMail());
			    		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			    		lblEmail.setFont(new Font("Segoe Print", Font.PLAIN, 20));
			    		
		GroupLayout gl_profileCard = new GroupLayout(profileCard);
			    		gl_profileCard.setHorizontalGroup(
			    			gl_profileCard.createParallelGroup(Alignment.TRAILING)
			    				.addGroup(gl_profileCard.createSequentialGroup()
			    					.addGap(208)
			    					.addComponent(lblFoto, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
			    					.addGap(191))
			    				.addGroup(gl_profileCard.createSequentialGroup()
			    					.addContainerGap()
			    					.addComponent(panelDati, GroupLayout.PREFERRED_SIZE, 585, Short.MAX_VALUE)
			    					.addContainerGap())
			    		);
			    		gl_profileCard.setVerticalGroup(
			    			gl_profileCard.createParallelGroup(Alignment.LEADING)
			    				.addGroup(gl_profileCard.createSequentialGroup()
			    					.addGap(27)
			    					.addComponent(lblFoto, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
			    					.addGap(18)
			    					.addComponent(panelDati, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
			    					.addGap(81))
			    		);
			    		panelDati.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 40));
			    		panelDati.add(lblCognome);
			    		panelDati.add(lblNome);
			    		panelDati.add(lblUsername);
			    		panelDati.add(lblEmail);
	    profileCard.setLayout(gl_profileCard);
	    
		panelCards.add(recentiCard ,"recenti");
		
		GroupLayout gl_recentiCard = new GroupLayout(recentiCard);
		gl_recentiCard.setHorizontalGroup(
			gl_recentiCard.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_recentiCard.createSequentialGroup()
					.addGap(40)
					.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
					.addGap(42))
		);
		gl_recentiCard.setVerticalGroup(
			gl_recentiCard.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_recentiCard.createSequentialGroup()
					.addGap(5)
					.addComponent(scroll)
					.addGap(39))
		);
		recentiCard.setLayout(gl_recentiCard);
		cardLayout.show(panelCards, "profile");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(sidePanel, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelCards, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addComponent(panelCards, GroupLayout.PREFERRED_SIZE, 446, Short.MAX_VALUE)
					.addGap(49))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(sidePanel, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
					.addGap(31))
		);
		setLayout(groupLayout);
	    

	}
	
	private void setColor(JButton btn) {
		btn.setBackground(new Color(131,181,160));
	}
	private void resetColor (JButton btn) {
		btn.setBackground(new Color(155, 220, 193));
	}
}
