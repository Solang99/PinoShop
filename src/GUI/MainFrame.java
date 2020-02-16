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
	private HomePanel homePanel;
	private CassaPanel cassaPanel;
	private Controller controller;
	private ProfilePanel profilePanel;
	
	private CardLayout cardLayout;
	private JPanel panelCards;
	private TopPanel topPanel;
	
	public MainFrame(Controller ctrl ) {
		controller = ctrl;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		//setSize(906, 685);
		setBounds(100, 100, 906, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 1, 1, 0));
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		
		
		topPanel  = new TopPanel(controller, this);
		contentPane.add(topPanel);
		
		
		cardLayout = new CardLayout ();
		panelCards = new JPanel();
		panelCards.setLayout(cardLayout);
		
		homePanel = new HomePanel(controller);
		cassaPanel = new CassaPanel(controller);
		profilePanel = new ProfilePanel(controller);
		
		
		panelCards.add(homePanel,"homePanel");
		panelCards.add(profilePanel,"profilePanel");
		panelCards.add(cassaPanel,"cassaPanel");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(topPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addComponent(panelCards, GroupLayout.PREFERRED_SIZE, 902, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelCards, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
					.addGap(0))
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
		cardLayout.show(panelCards, "homePanel");
	}
	
	public void aggiornaHome() {
		homePanel.aggiornaHome();

		
	}
	
	public void aggiornaCassa() {
		
		
		cassaPanel.aggiornaCassa();
	

	}
	
	public void aggiornaSizeCassa(boolean isMax,int min,int max) {

		cassaPanel.setComponetPerLine(isMax,min,max);
	
		
	}
	public void aggiornaSizeHome(boolean isMax,int min,int max) {
		homePanel.setComponetPerLine(isMax,min,max);
	
		
	}
	
	
	
}

