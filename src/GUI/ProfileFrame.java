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
		panel.setBackground(new Color(155, 220, 193));
		
		
		 btnLogIn = new JButton("LOG IN");
		 btnLogIn.setForeground(Color.BLACK);
		 btnLogIn.setBounds(0, 119, 242, 65);
		 btnLogIn.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		SetColor(btnLogIn);
		 		ResetColor(btnProfilo);
		 		ResetColor(btnLogOut);
		 	}
		 });
		btnLogIn.setBackground(new Color(155, 220, 193));
	
		btnLogIn.setBorderPainted(false);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
				btnLogIn.setPreferredSize(new Dimension(232, 40));
		btnLogIn.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogIn.setFont(new Font("Segoe Print", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 278, 216, 228);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(ProfileFrame.class.getResource("/IconProfile/PineIcon+.png")));
		lblNewLabel.setPreferredSize(new Dimension(232, 100));
		
		btnProfilo = new JButton("PROFILO");
		btnProfilo.setBounds(0, 69, 242, 65);
		btnProfilo.setForeground(Color.BLACK);
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
		btnProfilo.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnProfilo.setBorderPainted(false);
		btnProfilo.setBackground(new Color(155, 220, 193));
		
		btnLogOut = new JButton("LOG OUT");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setBounds(0, 181, 242, 65);
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
		btnLogOut.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnLogOut.setBorderPainted(false);
		btnLogOut.setBackground(new Color(155, 220, 193));
		contentPane.setLayout(null);
		contentPane.add(topPanel);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(btnProfilo);
		panel.add(btnLogIn);
		panel.add(btnLogOut);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(315, 246, 503, 290);
		panel_1.setBackground(new Color (220,255,192));
		contentPane.add(panel_1);
		
		Component [] components = this.getContentPane().getComponents();
		for(Component component : components)
		{
			if (component instanceof JButton) {
				((JButton) component).setUI(new BasicButtonUI());
		}
	}

	}
	private void SetColor(JButton btn) {
		btn.setBackground(new Color(131,181,160));
	}
	private void ResetColor (JButton btn) {
		btn.setBackground(new Color(155, 220, 193));
	}
}
