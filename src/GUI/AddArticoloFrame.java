package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddArticoloFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panelArticolo;
	private JTextField txtId;
	private JTextField txtMarca;
	private JTextField txtStagione;
	private JTextField txtCollezione;
	private JTextField txtPrezzo;
	private JTextField txtColore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddArticoloFrame frame = new AddArticoloFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddArticoloFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelArticolo = new JPanel();
		panelArticolo.setBounds(0, 0, 815, 694);
		contentPane.add(panelArticolo);
		panelArticolo.setLayout(null);
		
		JLabel lblAggiungiArticolo = new JLabel("AGGIUNGI ARTICOLO");
		lblAggiungiArticolo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblAggiungiArticolo.setBounds(255, 21, 317, 40);
		panelArticolo.add(lblAggiungiArticolo);
		
		JLabel lblIdarticolo = new JLabel("IdArticolo:");
		lblIdarticolo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblIdarticolo.setBounds(20, 99, 126, 23);
		panelArticolo.add(lblIdarticolo);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblMarca.setBounds(20, 170, 87, 23);
		panelArticolo.add(lblMarca);
		
		JLabel lblTaglia = new JLabel("Taglia:");
		lblTaglia.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblTaglia.setBounds(20, 240, 87, 30);
		panelArticolo.add(lblTaglia);
		
		JLabel lblColore = new JLabel("Colore:");
		lblColore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblColore.setBounds(20, 316, 126, 23);
		panelArticolo.add(lblColore);
		
		JLabel lblStagione = new JLabel("Stagione:");
		lblStagione.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblStagione.setBounds(20, 385, 126, 30);
		panelArticolo.add(lblStagione);
		
		JLabel lblCollezione = new JLabel("Collezione:");
		lblCollezione.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblCollezione.setBounds(20, 459, 126, 23);
		panelArticolo.add(lblCollezione);
		
		JLabel lblQuantità = new JLabel("Quantit\u00E0:");
		lblQuantità.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblQuantità.setBounds(20, 547, 126, 23);
		panelArticolo.add(lblQuantità);
		
		JLabel lblImmagine = new JLabel("Immagine:");
		lblImmagine.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblImmagine.setBounds(580, 95, 126, 30);
		panelArticolo.add(lblImmagine);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBackground(new Color(191, 191, 191));
		txtId.setBounds(156, 104, 87, 20);
		panelArticolo.add(txtId);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBackground(new Color(191, 191, 191));
		txtMarca.setBounds(156, 175, 151, 20);
		panelArticolo.add(txtMarca);
		
		txtStagione = new JTextField();
		txtStagione.setColumns(10);
		txtStagione.setBackground(new Color(191, 191, 191));
		txtStagione.setBounds(156, 394, 143, 20);
		panelArticolo.add(txtStagione);
		
		txtCollezione = new JTextField();
		txtCollezione.setColumns(10);
		txtCollezione.setBackground(new Color(191, 191, 191));
		txtCollezione.setBounds(156, 464, 143, 20);
		panelArticolo.add(txtCollezione);
		
		JSpinner spinnerQuantità = new JSpinner();
		spinnerQuantità.setEnabled(false);
		spinnerQuantità.setForeground(Color.WHITE);
		spinnerQuantità.setBackground(new Color(191,191,191));
		spinnerQuantità.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantità.setModel(new SpinnerNumberModel(0, 0, 300, 1));
		spinnerQuantità.setBounds(156, 547, 67, 24);
		panelArticolo.add(spinnerQuantità);
		
		JButton buttonImage = new JButton("");
		buttonImage.setOpaque(false);
		buttonImage.setFont(new Font("Tahoma", Font.PLAIN, 21));
		buttonImage.setContentAreaFilled(false);
		buttonImage.setBorderPainted(false);
		buttonImage.setBackground(SystemColor.menu);
		buttonImage.setBounds(511, 170, 243, 254);
		panelArticolo.add(buttonImage);
		
		JComboBox comboBoxTaglia = new JComboBox();
		comboBoxTaglia.setModel(new DefaultComboBoxModel(new String[] {"XS", "S", "M", "L", "XL", "XXL", "XXXL"}));
		comboBoxTaglia.setEnabled(false);
		comboBoxTaglia.setBackground(new Color(191,191,191));
		comboBoxTaglia.setBounds(156, 248, 75, 22);
		panelArticolo.add(comboBoxTaglia);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblPrezzo.setBounds(511, 543, 87, 30);
		panelArticolo.add(lblPrezzo);
		
		txtPrezzo = new JTextField();
		txtPrezzo.setColumns(10);
		txtPrezzo.setBackground(new Color(191, 191, 191));
		txtPrezzo.setBounds(611, 552, 143, 20);
		panelArticolo.add(txtPrezzo);
		
		txtColore = new JTextField();
		txtColore.setColumns(10);
		txtColore.setBackground(new Color(191, 191, 191));
		txtColore.setBounds(156, 319, 143, 20);
		panelArticolo.add(txtColore);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(446, 614, 126, 40);
		panelArticolo.add(btnAggiungi);
		
		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancella.setBounds(270, 614, 126, 40);
		panelArticolo.add(btnCancella);
	}
}
