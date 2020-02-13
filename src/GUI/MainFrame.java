package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import datechooser.beans.DateChooserCombo;
import datechooser.beans.DateChooserDialog;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final DateChooserDialog dateChooserDialog = new DateChooserDialog();
	private CenterPanel centralPanel;
	private ProfilePanel profilePanel;
	private CassaPanel cassaPanel;
	private TopPanel topPanel;
	private Controller controller;
	private int mouseX,mouseY;
	private CardLayout cardLayout;
	private JPanel panelCards;
	
	
	public MainFrame(Controller ctrl ) {
		controller = ctrl;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setSize(906, 685);
		setBounds(100, 100, 906, 685);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
	
		topPanel = new TopPanel(controller, this);
//		topPanel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				mouseX= e.getX();
//				mouseY = e.getY();
//			}
//		});
//		topPanel.addMouseMotionListener(new MouseMotionAdapter() {
//			@Override
//			public void mouseDragged(MouseEvent e) {
//				int x =e.getXOnScreen();
//				int y = e.getYOnScreen();
//				setLocation(x-mouseX,y-mouseY);
//			}
//		});
		
		
		
		
		centralPanel = new CenterPanel(controller);
		profilePanel = new ProfilePanel(controller);
		cassaPanel = new CassaPanel(controller);
		
		
		cardLayout = new CardLayout ();
		panelCards = new JPanel();
		panelCards.setLayout(cardLayout);
		
		panelCards.add(centralPanel,"centerPanel");
		panelCards.add(profilePanel,"profilePanel");
		panelCards.add(cassaPanel,"cassaPanel");
		cardLayout.show(panelCards, "centerPanel");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelCards, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 902, Short.MAX_VALUE)
						.addComponent(topPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(2))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panelCards, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);

	}
	
	
	public void showProfile(){
		cardLayout.show(panelCards, "profilePanel");
	}
	
	public void showCassa(){
		cardLayout.show(panelCards, "cassaPanel");
	}
	
	public void showHome(){
		cardLayout.show(panelCards, "centerPanel");
	}
	
	public void AggiornaHome() {
		centralPanel.AggiornaHome();
		topPanel.revalidate();
		topPanel.getIgnoreRepaint();
		
	}
	
	public void AggiornaCassa() {
		
		
		cassaPanel.AggiornaCassa();
	
		cassaPanel.revalidate();
		cassaPanel.repaint();

	}
	
	
	
}

