
package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.border.MatteBorder;

public class TopPanel extends JPanel {
	private JButton btnUser;
	private JButton btnCarrello;
	private JButton btnLogo;
	private JButton btnClose;

	private Controller controller;
	private JButton btnMaximize;
	private JButton btnNormalSize;
	private JLabel IconCommesso;
	private JLabel lblDate;
	private JPanel panel;
	private int mouseX;
	private int mouseY;
	private JFrame frame;
	private boolean state;
	
	public TopPanel( Controller ctrl,JFrame container) {
		state = true;
		controller = ctrl;
		frame = container;
		setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0,98,67)));
		setToolTipText("");
		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (state) {
					int x = e.getXOnScreen();
					int y = e.getYOnScreen();
					frame.setLocation(x - mouseX, y - mouseY);
				}
			}
		});
		
		btnLogo = new JButton("");
		btnLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.goToHomePanel();
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
				controller.goToProfilePanel();
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
				controller.goToCassaPanel();
			}
		});
		btnCarrello.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/icons8_shopping_cart_30px.png")));
		
		btnClose = new JButton("");

		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dialogResult =JOptionPane.showConfirmDialog (null, "Sicuro di voler uscire? La cassa verra svuotata","Warning",JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					controller.closeAll();
				}
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
				controller.goToAddArticolo();
			}
		});
		
		btnMaximize = new JButton("");

		btnMaximize.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/fullScreenIcon.png")));
		btnMaximize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				setBtnNormalSize();
				controller.resizeComponet(true);
			}
		});
	
		btnMaximize.setOpaque(false);
		btnMaximize.setContentAreaFilled(false);
		btnMaximize.setBorderPainted(false);
		
		JButton btnIconifed = new JButton("");
		btnIconifed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		btnIconifed.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/IconIconifed.png")));
		btnIconifed.setOpaque(false);
		btnIconifed.setContentAreaFilled(false);
		btnIconifed.setBorderPainted(false);
		
		btnNormalSize = new JButton("");
		btnNormalSize.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/IconNormalScreen.png")));
		btnNormalSize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setExtendedState(JFrame.NORMAL);
				setBtnMaxSize();
				controller.resizeComponet(false);
			}
		});
		btnNormalSize.setOpaque(false);
		btnNormalSize.setContentAreaFilled(false);
		btnNormalSize.setBorderPainted(false);
		btnNormalSize.setEnabled(false);
		btnNormalSize.setVisible(false);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		SimpleDateFormat formatterYear = new SimpleDateFormat("dd/MM/yyyy");   
		Date date = new Date();  

		IconCommesso = new JLabel("");
		IconCommesso.setBounds(21, 11, 102, 112);
		panel.add(IconCommesso);
		IconCommesso.setHorizontalAlignment(SwingConstants.CENTER);
		Image commessoIcon = controller.commesso.getFoto().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		IconCommesso.setIcon(new ImageIcon(commessoIcon));
		
		
		

		lblDate = new JLabel("<html><center> Ciao "+ controller.commesso.getNome()+" :) <br> Oggi è il " + formatterYear.format(date)+"<br> </center> </html>");
		lblDate.setBounds(147, 36, 208, 62);
		lblDate.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.add(lblDate);
		lblDate.setFont(new Font("Segoe Print", Font.PLAIN, 17));
		
		panel.setVisible(false);
		panel.setEnabled(false);
		
		JButton btnHome = new JButton("");
		btnHome.setIcon(new ImageIcon(TopPanel.class.getResource("/IconTopPanel/iconHome.png")));
		btnHome.setOpaque(false);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHome.setSize(45,53);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHome.setSize(30,38);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.goToHomePanel();
			}
		});
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(263)
					.addComponent(btnLogo, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
					.addGap(106)
					.addComponent(btnIconifed, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnNormalSize, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
					.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnUser, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCarrello, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnLogo, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnIconifed, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNormalSize, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnHome, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCarrello, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUser, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}
	
	private void setBtnNormalSize() {
		
		btnMaximize.setVisible(false);
		btnMaximize.setEnabled(false);
		btnNormalSize.setVisible(true);
		btnNormalSize.setEnabled(true);
		panel.setVisible(true);
		panel.setEnabled(true);
		state=false;
	}
	private void setBtnMaxSize() {
		btnMaximize.setVisible(true);
		btnMaximize.setEnabled(true);
		btnNormalSize.setVisible(false);
		btnNormalSize.setEnabled(false);
		panel.setVisible(false);
		panel.setEnabled(false);
		state=true;

	}
}
