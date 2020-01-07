package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.UIManager;

public class TopPanel extends JPanel {
	private JButton btnUser;
	private JButton btnCarrello;
	private JButton btnLogo;
	private JButton btnClose;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenu mnNewMenu_2;
	
	public TopPanel() {
		setToolTipText("UOMO");
		
		setSize(804, 133);
		setLayout(null);
		
		btnLogo = new JButton("");
		btnLogo.setOpaque(false);
		btnLogo.setContentAreaFilled(false);
		btnLogo.setBorderPainted(false);
		btnLogo.setBackground(new Color(240, 240, 240));
		btnLogo.setIcon(new ImageIcon(TopPanel.class.getResource("/IconMainFrame/logo.png")));
		btnLogo.setBounds(244, 11, 309, 62);
		add(btnLogo);
		
		btnUser = new JButton("");
		btnUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUser.setSize(45,53);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnUser.setSize(30,38);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("a");
			}
		});
		btnUser.setOpaque(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setBorderPainted(false);
		btnUser.setIcon(new ImageIcon(TopPanel.class.getResource("/IconMainFrame/userIcon.png")));
		btnUser.setBounds(691, 84, 30, 38);
		add(btnUser);
		
		btnCarrello = new JButton("");
		btnCarrello.setOpaque(false);
		btnCarrello.setContentAreaFilled(false);
		btnCarrello.setBorderPainted(false);
		btnCarrello.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCarrello.setSize(45,53);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCarrello.setSize(30,38);
			}
		});
		btnCarrello.setIcon(new ImageIcon(TopPanel.class.getResource("/IconMainFrame/icons8_shopping_cart_30px.png")));
		btnCarrello.setBounds(743, 84, 37, 38);
		add(btnCarrello);
		
		btnClose = new JButton("");
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnClose.setOpaque(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setIcon(new ImageIcon(TopPanel.class.getResource("/IconMainFrame/closeIcon.png")));
		btnClose.setBounds(757, 11, 37, 23);
		add(btnClose);
		
		panel = new JPanel();
		panel.setForeground(UIManager.getColor("Button.background"));
		panel.setBackground(UIManager.getColor("Button.background"));
		panel.setBounds(10, 94, 210, 39);
		add(panel);
		panel.setLayout(null);
		panel.setOpaque(false);
		menuBar = new JMenuBar();
		menuBar.setForeground(UIManager.getColor("Button.background"));
		menuBar.setBackground(UIManager.getColor("Button.background"));
		menuBar.setBounds(0, 0, 140, 39);
		panel.add(menuBar);
		
		mnNewMenu = new JMenu("UOMO");
		mnNewMenu.setOpaque(true);
		mnNewMenu.setForeground(new Color(46, 139, 87));
		mnNewMenu.setBackground(UIManager.getColor("Button.background"));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("T-SHIRTS");
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("FELPE");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("PANTALONI");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("GIACCHE");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_4 = new JMenuItem("SCARPE");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("ACCESSORI");
		mnNewMenu.add(mntmNewMenuItem_5);
		
		mnNewMenu_1 = new JMenu("DONNA");
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setIcon(new ImageIcon(TopPanel.class.getResource("/IconMainFrame/icons8-donna-in-piedi-30.png")));
		mnNewMenu_1.setOpaque(true);
		mnNewMenu_1.setBackground(UIManager.getColor("Button.background"));
		
		mnNewMenu_2 = new JMenu("");
		menuBar.add(mnNewMenu_2);
		
	}
}

