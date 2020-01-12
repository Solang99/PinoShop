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
import javax.swing.LayoutStyle.ComponentPlacement;

public class ProfileFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnLogIn;
	private JButton btnProfilo;
	private JButton btnLogOut;
	private Controller controller;
	private TopPanel topPanel;
	
	public ProfileFrame(Controller ctrl) {
		controller = ctrl;
	
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 648);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);

		topPanel = new TopPanel(controller);
		topPanel.setBounds(0, 0, 897, 133);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 131, 243, 517);
		panel.setBorder(null);
		panel.setBackground(new Color(1, 157, 73));
		panel.setForeground(Color.LIGHT_GRAY);
		
		 btnLogIn = new JButton("LOG IN");
		 btnLogIn.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		SetColor(btnLogIn);
		 		ResetColor(btnProfilo);
		 		ResetColor(btnLogOut);
		 	}
		 });
		btnLogIn.setBackground(new Color(1, 157, 73));
	
		btnLogIn.setBorderPainted(false);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
				btnLogIn.setPreferredSize(new Dimension(232, 40));
		btnLogIn.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/icons8-evergreen-tree-100.png")));
		lblNewLabel.setPreferredSize(new Dimension(232, 100));
		
		btnProfilo = new JButton("PROFILO");
		btnProfilo.setForeground(Color.WHITE);
		btnProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetColor(btnProfilo);
				ResetColor(btnLogIn);
				ResetColor(btnLogOut);
				
			}
		});
		btnProfilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProfilo.setPreferredSize(new Dimension(232, 40));
		btnProfilo.setHorizontalTextPosition(SwingConstants.CENTER);
		btnProfilo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnProfilo.setBorderPainted(false);
		btnProfilo.setBackground(new Color(1, 157, 73));
		
		btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SetColor(btnLogOut);
				ResetColor(btnProfilo);
				ResetColor(btnLogIn);
			}
		});
		btnLogOut.setPreferredSize(new Dimension(232, 40));
		btnLogOut.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBackground(new Color(1, 157, 73));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(btnProfilo, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnProfilo, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(56)
							.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addGap(5)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(topPanel);
		contentPane.add(panel);
		
		Component [] components = this.getContentPane().getComponents();
		for(Component component : components)
		{
			if (component instanceof JButton) {
				((JButton) component).setUI(new BasicButtonUI());
		}
	}

	}
	private void SetColor(JButton btn) {
		btn.setBackground(new Color(132, 225, 168));
	}
	private void ResetColor (JButton btn) {
		btn.setBackground(new Color(1, 157, 73));
	}
}
