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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final DateChooserDialog dateChooserDialog = new DateChooserDialog();
	private CenterPanel centralPanel;
	private TopPanel topPanel;
	private Controller controller;
	private int mouseX,mouseY;
	
	public MainFrame(Controller ctrl, ArrayList<Image> foto , ArrayList<String> nomi) {
		controller = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 906, 685);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		
		topPanel = new TopPanel(this.getWidth(),controller,this);
		topPanel.setBounds(0, 0, 926, 133);
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
		
		centralPanel = new CenterPanel(foto, nomi);

		centralPanel.setBounds(0, 144, 906, 541);
		contentPane.setLayout(null);
		contentPane.add(topPanel);
		contentPane.add(centralPanel);

	}
	

}

