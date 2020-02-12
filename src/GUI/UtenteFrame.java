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


public class UtenteFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnRecenti;
	private JButton btnProfilo;
	private JButton btnLogOut;
	private Controller controller;
	private TopPanel topPanel;
	private JPanel panelCards;
	private JPanel profileCard;
	private JPanel sidePanel;
	private JLabel logoIcon;
	private JLabel lblNome;
	private int mouseX;
	private int mouseY;
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblFoto;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private CardLayout cardLayout;
	
	public UtenteFrame(Controller ctrl) {
		controller = ctrl;
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 648);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);

		topPanel = new TopPanel(controller,this);
		topPanel.setBounds(0, 0, 902, 133);
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
		topPanel.setSize(902, 133);
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
		JFrame frame = this;
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.GoToLoginFrame(frame);
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
	
		ImageIcon fotoProfilo = new ImageIcon(controller.commesso.getFoto());
		lblFoto.setIcon(new ImageIcon(fotoProfilo.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH)));
	
		profileCard.setLayout(null);
		profileCard.add(lblNome);
		profileCard.add(lblCognome);
		profileCard.add(lblFoto);
		profileCard.add(lblUsername);
		profileCard.add(lblEmail);
		
	    
		cardLayout = new CardLayout ();
		panelCards = new JPanel();
		panelCards.setLayout(cardLayout);
		panelCards.setBounds(253, 146, 637, 481);
		panelCards.setBackground(new Color (220,255,192));
		panelCards.add(profileCard,"profile");
		panelCards.add(recentiCard ,"recenti");
		cardLayout.show(panelCards, "profile");
		contentPane.add(panelCards);
	    

	}
	
	private void SetColor(JButton btn) {
		btn.setBackground(new Color(131,181,160));
	}
	private void ResetColor (JButton btn) {
		btn.setBackground(new Color(155, 220, 193));
	}
	

	
}
