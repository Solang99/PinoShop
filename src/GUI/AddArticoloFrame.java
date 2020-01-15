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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class AddArticoloFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panelArticolo;
	private JTextField txtId;
	private JTextField txtProduttore;
	private JTextField txtCollezione;
	private JTextField txtColore;

	private Controller controller;

	public AddArticoloFrame(Controller ctrl) {
		
		controller = ctrl;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelArticolo = new JPanel();
		panelArticolo.setBounds(0, 0, 767, 604);
		contentPane.add(panelArticolo);
		panelArticolo.setLayout(null);
		
		JLabel lblAggiungiArticolo = new JLabel("AGGIUNGI ARTICOLO");
		lblAggiungiArticolo.setBounds(255, 21, 317, 40);
		lblAggiungiArticolo.setFont(new Font("Tahoma", Font.BOLD, 28));
		panelArticolo.add(lblAggiungiArticolo);
		
		JLabel lblIdarticolo = new JLabel("Codice :");
		lblIdarticolo.setBounds(20, 218, 87, 23);
		lblIdarticolo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		panelArticolo.add(lblIdarticolo);
		
		JLabel lblMarca = new JLabel("Produttore: ");
		lblMarca.setBounds(20, 289, 160, 23);
		lblMarca.setFont(new Font("Segoe Print", Font.BOLD, 22));
		panelArticolo.add(lblMarca);
		
		JLabel lblTaglia = new JLabel("Taglia:");
		lblTaglia.setBounds(412, 289, 87, 30);
		lblTaglia.setFont(new Font("Segoe Print", Font.BOLD, 22));
		panelArticolo.add(lblTaglia);
		
		JLabel lblColore = new JLabel("Colore:");
		lblColore.setBounds(20, 377, 126, 23);
		lblColore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		panelArticolo.add(lblColore);
		
		JLabel lblCollezione = new JLabel("Collezione:");
		lblCollezione.setBounds(20, 448, 126, 23);
		lblCollezione.setFont(new Font("Segoe Print", Font.BOLD, 22));
		panelArticolo.add(lblCollezione);
		
		JLabel lblQuantità = new JLabel("Quantit\u00E0:");
		lblQuantità.setBounds(412, 223, 126, 23);
		lblQuantità.setFont(new Font("Segoe Print", Font.BOLD, 22));
		panelArticolo.add(lblQuantità);
		
		JLabel lblImmagine = new JLabel("Immagine:");
		lblImmagine.setBounds(20, 109, 126, 30);
		lblImmagine.setFont(new Font("Segoe Print", Font.BOLD, 22));
		panelArticolo.add(lblImmagine);
		
		txtId = new JTextField();
		txtId.setBounds(165, 223, 151, 20);
		txtId.setColumns(10);
		txtId.setBackground(new Color(191, 191, 191));
		panelArticolo.add(txtId);
		
		txtProduttore = new JTextField();
		txtProduttore.setBounds(165, 453, 151, 20);
		txtProduttore.setColumns(10);
		txtProduttore.setBackground(new Color(191, 191, 191));
		panelArticolo.add(txtProduttore);
		
		txtCollezione = new JTextField();
		txtCollezione.setBounds(165, 294, 151, 20);
		txtCollezione.setColumns(10);
		txtCollezione.setBackground(new Color(191, 191, 191));
		panelArticolo.add(txtCollezione);
		
		SpinnerNumberModel modelQuantita = new SpinnerNumberModel(0, 0, 300, 1);
		JSpinner spinnerQuantita = new JSpinner(modelQuantita);
		spinnerQuantita.setBounds(586, 379, 75, 24);
		spinnerQuantita.setForeground(Color.WHITE);
		spinnerQuantita.setBackground(new Color(191,191,191));
		spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelArticolo.add(spinnerQuantita);
	
		SpinnerNumberModel modelPrezzo = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
		JSpinner spinnerPrezzo = new JSpinner(modelPrezzo);
		spinnerPrezzo.setBounds(586, 225, 75, 24);	
		spinnerPrezzo.setForeground(Color.WHITE);
		spinnerPrezzo.setBackground(new Color(191,191,191));
		spinnerPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		panelArticolo.add(spinnerPrezzo);
		
		JButton buttonImage = new JButton("");
		buttonImage.setBounds(156, 67, 160, 132);
		buttonImage.setOpaque(false);
		buttonImage.setFont(new Font("Tahoma", Font.PLAIN, 21));
		buttonImage.setContentAreaFilled(false);
		buttonImage.setBorderPainted(false);
		buttonImage.setBackground(SystemColor.menu);
		panelArticolo.add(buttonImage);
		
		JComboBox<String> comboBoxTaglia = new JComboBox<String>();
		comboBoxTaglia.setBounds(586, 297, 75, 22);
		comboBoxTaglia.setModel(new DefaultComboBoxModel<String>(new String[] {"XS", "S", "M", "L", "XL", "XXL", "XXXL"}));
		comboBoxTaglia.setBackground(new Color(191,191,191));
		panelArticolo.add(comboBoxTaglia);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setBounds(412, 377, 87, 30);
		lblPrezzo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		panelArticolo.add(lblPrezzo);
		
		txtColore = new JTextField();
		txtColore.setBounds(165, 382, 151, 20);
		txtColore.setColumns(10);
		txtColore.setBackground(new Color(191, 191, 191));
		panelArticolo.add(txtColore);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println(modelQuantita.getValue());
				File c = new File(" ");
				String selectedTaglia =  comboBoxTaglia.getSelectedItem().toString(); 
				int selectedQuantita =  Integer.parseInt(modelQuantita.getValue().toString());
				float selectedPrezzo = Float.parseFloat(modelPrezzo.getValue().toString());
				
				controller.AddArticolo(txtId.getText(), txtProduttore.getText(), selectedTaglia, txtColore.getText(), 
									 txtCollezione.getText(),selectedQuantita ,selectedPrezzo, c);
			}
		});
		btnAggiungi.setBounds(435, 526, 126, 40);
		panelArticolo.add(btnAggiungi);
		
		JButton btnCancella = new JButton("Cancella");
		btnCancella.setBounds(259, 526, 126, 40);
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		panelArticolo.add(btnCancella);
	}
}
