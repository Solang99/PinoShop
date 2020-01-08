package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import datechooser.beans.DateChooserCombo;
import datechooser.beans.DateChooserDialog;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	/**
	 * @wbp.nonvisual location=76,349
	 */
	private final DateChooserDialog dateChooserDialog = new DateChooserDialog();


	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 906, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TopPanel toppanel = new TopPanel();
		toppanel.setBounds(0, 0, 906, 133);
		contentPane.add(toppanel);
		
		CenterPanel centerpanel = new CenterPanel();
		centerpanel.setBounds(0, 133, 906, 546);
		contentPane.add(centerpanel);
		centerpanel.setLayout(null);
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo();
		dateChooserCombo.setBounds(92, 140, 155, 20);
		centerpanel.add(dateChooserCombo);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

