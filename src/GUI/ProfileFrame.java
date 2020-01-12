package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ProfileFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private TopPanel topPanel;

	public ProfileFrame(Controller ctrl) {
		controller = ctrl;
	
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		topPanel = new TopPanel(controller);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 153));
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setOpaque(false);
		panel_1.setPreferredSize(new Dimension(230, 200));
		panel.add(panel_1);
		
		JButton button_1 = new JButton("PROFILO");
		button_1.setSelectedIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle.png")));
		button_1.setPressedIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle.png")));
		button_1.setBorderPainted(false);
		button_1.setRolloverIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle.png")));
		button_1.setIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle 1.png")));
		button_1.setPreferredSize(new Dimension(232, 40));
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(button_1);
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setPressedIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle.png")));
		btnLogIn.setSelectedIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle.png")));
		btnLogIn.setBorderPainted(false);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogIn.setIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle 1.png")));
		btnLogIn.setRolloverIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle.png")));
		btnLogIn.setPreferredSize(new Dimension(232, 40));
		btnLogIn.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(btnLogIn);
		
		JButton btnNewButton = new JButton("LOG OUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setPressedIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle.png")));
		btnNewButton.setSelectedIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle.png")));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setRolloverIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/Rectangle 1.png")));
		btnNewButton.setPreferredSize(new Dimension(232, 40));
		panel.add(btnNewButton);
		
		JButton button = new JButton("LOG OUT");
		button.setBackground(new Color(0, 255, 153));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button.setBackground(new Color(46, 139, 87));
			}
		});
		button.setPreferredSize(new Dimension(232, 40));
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBorderPainted(false);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/icons8-evergreen-tree-100.png")));
		lblNewLabel.setPreferredSize(new Dimension(232, 100));
		panel.add(lblNewLabel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(topPanel, GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(505, Short.MAX_VALUE))
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		Component [] components = this.getContentPane().getComponents();
		for(Component component : components)
		{
			if (component instanceof JButton) {
				((JButton) component).setUI(new BasicButtonUI());
		}
	}
	
}
}
