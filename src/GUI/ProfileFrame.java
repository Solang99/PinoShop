package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class ProfileFrame extends JFrame {

	private JPanel contentPane;
	private TopPanel topPanel;
	private Controller controller;
	
	public ProfileFrame(Controller ctrl) {
		controller=ctrl;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		topPanel = new TopPanel(controller);
		contentPane.add(topPanel);
		
	}
}
