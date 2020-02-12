
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
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TopPanel extends JPanel {
	private JButton btnUser;
	private JButton btnCarrello;
	private JButton btnLogo;
	private JButton btnClose;

	private Controller controller;
	private JButton button;
	
	public TopPanel( Controller ctrl,JFrame container) {
		controller = ctrl;
		setBorder(null);
		setToolTipText("");
		
		//setSize(902, 133);
		

		
		btnLogo = new JButton("");
		btnLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GoToMainFrame(container);
			}
		});
		btnLogo.setOpaque(false);
		btnLogo.setContentAreaFilled(false);
		btnLogo.setBorderPainted(false);
		btnLogo.setBackground(new Color(240, 240, 240));
		btnLogo.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/logo.png")));
		
		btnUser = new JButton("");
		btnUser.setBorderPainted(false);
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
				controller.GoToProfileFrame(container);
			}
		});
		btnUser.setOpaque(false);
		btnUser.setContentAreaFilled(false);
		btnUser.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/userIcon.png")));
		
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
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GoToCassaFrame(container);
			}
		});
		btnCarrello.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/icons8_shopping_cart_30px.png")));
		
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
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnAdd.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/IconAdd.png")));
		btnAdd.setOpaque(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setBorderPainted(false);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdd.setSize(45,53);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAdd.setSize(30,38);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.GoToAddArticolo();
			}
		});
		
		button = new JButton("O");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				container.setExtendedState(JFrame.MAXIMIZED_BOTH);
			}
		});
	
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(322)
					.addComponent(btnLogo, GroupLayout.PREFERRED_SIZE, 315, Short.MAX_VALUE)
					.addGap(160)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(779)
					.addComponent(btnUser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnCarrello, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogo, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(button)
						.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCarrello, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);
		
	}
}
