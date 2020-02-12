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
	private TopPanel topPanel;
	private Controller controller;
	private int mouseX,mouseY;
	private CardLayout cardLayout;
	private JPanel panelCards;
	
	
	public MainFrame(Controller ctrl ) {
		controller = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 906, 685);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
	
		topPanel = new TopPanel(controller, this);
		
		
		
		
		centralPanel = new CenterPanel(controller);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(centralPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
						.addComponent(topPanel, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(centralPanel, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
		cardLayout = new CardLayout ();
		panelCards = new JPanel();
		panelCards.setLayout(cardLayout);
		panelCards.setBounds(253, 146, 637, 481);

	}
}

