package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.ArticoloDAO;
import Entita.Articolo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MagazzinoFrame extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTextField txtCodice;
	private JTextField txtProduttore;
	private JTextField txtColore;
	private JTextField txtCollezione;
	private static JTable table;
	private Controller controller;
	private JButton btnImmagine;
	private JSpinner spinnerPrezzo;
	private JSpinner spinnerQuantità;
	private JComboBox comboBoxTaglia;
	private JComboBox comboBoxGenere;
	private File fotoFile;
	public MagazzinoFrame(Controller ctrl) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1611, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(464, 159, 1121, 841);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			
			int rowIndex;
			public void keyReleased(KeyEvent e) {
				 rowIndex = table.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN)
					{
						 txtCodice.setText(model.getValueAt(rowIndex, 1).toString());
						 txtProduttore.setText(model.getValueAt(rowIndex, 2).toString());
						 comboBoxTaglia.getSelectedItem(); // errore
						 txtColore.setText(model.getValueAt(rowIndex, 4).toString());
						 txtCollezione.setText(model.getValueAt(rowIndex, 5).toString());
						 spinnerQuantità.setValue(Integer.valueOf(table.getValueAt(rowIndex, 6).toString()));
						 spinnerPrezzo.setValue(Integer.valueOf(table.getValueAt(rowIndex, 7).toString()));
						 comboBoxGenere.getSelectedItem(); //errore
						 btnImmagine.getSelectedIcon();// errore
			}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			int rowIndex;
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				 rowIndex = table.getSelectedRow();
				 txtCodice.setText(model.getValueAt(rowIndex, 1).toString());
				 txtProduttore.setText(model.getValueAt(rowIndex, 2).toString());
				 comboBoxTaglia.getSelectedItem(); // errore
				 txtColore.setText(model.getValueAt(rowIndex, 4).toString());
				 txtCollezione.setText(model.getValueAt(rowIndex, 5).toString());
				 spinnerQuantità.setValue(Integer.valueOf(table.getValueAt(rowIndex, 6).toString()));
				 spinnerPrezzo.setValue(Integer.valueOf(table.getValueAt(rowIndex, 7).toString()));
				 comboBoxGenere.getSelectedItem(); //errore
				 btnImmagine.getSelectedIcon();// errore
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice", "Produttore", "Taglia", "Colore", "Collezione", "Quantit\u00E0", "Prezzo", "Genere", "Immagine"
			}
		));
		controller.FillTable(table);
		scrollPane.setViewportView(table);
		
		JLabel lblMagazzino = new JLabel("Magazzino");
		lblMagazzino.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblMagazzino.setBounds(565, 0, 193, 50);
		contentPane.add(lblMagazzino);
		
		JLabel lblCodice = new JLabel("Codice :");
		lblCodice.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblCodice.setBounds(0, 336, 87, 23);
		contentPane.add(lblCodice);
		
		txtCodice = new JTextField();
		txtCodice.setColumns(10);
		txtCodice.setBackground(new Color(191, 191, 191));
		txtCodice.setBounds(155, 336, 151, 20);
		contentPane.add(txtCodice);
		
		JLabel lblProduttore = new JLabel("Produttore: ");
		lblProduttore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblProduttore.setBounds(0, 394, 160, 23);
		contentPane.add(lblProduttore);
		
		txtProduttore = new JTextField();
		txtProduttore.setColumns(10);
		txtProduttore.setBackground(new Color(191, 191, 191));
		txtProduttore.setBounds(155, 397, 151, 20);
		contentPane.add(txtProduttore);
		
		JLabel lblColore = new JLabel("Colore:");
		lblColore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblColore.setBounds(0, 444, 126, 23);
		contentPane.add(lblColore);
		
		txtColore = new JTextField();
		txtColore.setColumns(10);
		txtColore.setBackground(new Color(191, 191, 191));
		txtColore.setBounds(155, 449, 151, 20);
		contentPane.add(txtColore);
		
		JLabel lblCollezione = new JLabel("Collezione:");
		lblCollezione.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblCollezione.setBounds(0, 498, 126, 23);
		contentPane.add(lblCollezione);
		
		txtCollezione = new JTextField();
		txtCollezione.setColumns(10);
		txtCollezione.setBackground(new Color(191, 191, 191));
		txtCollezione.setBounds(155, 501, 151, 20);
		contentPane.add(txtCollezione);
		
		JLabel lblQuantità = new JLabel("Quantit\u00E0:");
		lblQuantità.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblQuantità.setBounds(0, 563, 126, 23);
		contentPane.add(lblQuantità);
		SpinnerNumberModel modelQuantita = new SpinnerNumberModel(0, 0, 300, 1);
		spinnerQuantità = new JSpinner(modelQuantita);
		spinnerQuantità.setForeground(Color.WHITE);
		spinnerQuantità.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantità.setBackground(new Color(191, 191, 191));
		spinnerQuantità.setBounds(155, 565, 75, 24);
		contentPane.add(spinnerQuantità);
		
		JLabel lblTaglia = new JLabel("Taglia:");
		lblTaglia.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblTaglia.setBounds(10, 622, 87, 30);
		contentPane.add(lblTaglia);
		
		JComboBox<String> comboBoxTaglia = new JComboBox<String>();
		comboBoxTaglia.setModel(new DefaultComboBoxModel(new String[] {"NULL", "XS", "S", "M", "L", "XL", "XXL", "XXL"}));
		comboBoxTaglia.setBackground(new Color(191, 191, 191));
		comboBoxTaglia.setBounds(155, 630, 110, 22);
		contentPane.add(comboBoxTaglia);
		
		JComboBox<String> comboBoxGenere = new JComboBox<String>();
		comboBoxGenere.setModel(new DefaultComboBoxModel(new String[] {"MASCHILE", "FEMMINILE", "UNISEX"}));
		comboBoxGenere.setBackground(new Color(191, 191, 191));
		comboBoxGenere.setBounds(155, 697, 110, 22);
		contentPane.add(comboBoxGenere);
		
		JLabel lblGenere = new JLabel("Genere");
		lblGenere.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblGenere.setBounds(10, 689, 87, 30);
		contentPane.add(lblGenere);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblPrezzo.setBounds(10, 766, 87, 30);
		contentPane.add(lblPrezzo);
		
		SpinnerNumberModel modelPrezzo = new SpinnerNumberModel(0, 0, 300, 1);
		spinnerPrezzo = new JSpinner(modelPrezzo);
		spinnerPrezzo.setForeground(Color.WHITE);
		spinnerPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerPrezzo.setBackground(new Color(191, 191, 191));
		spinnerPrezzo.setBounds(155, 772, 75, 24);
		contentPane.add(spinnerPrezzo);
		
		JLabel lblImmagine = new JLabel("Immagine:");
		lblImmagine.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblImmagine.setBounds(0, 212, 126, 30);
		contentPane.add(lblImmagine);
		
		JButton btnImmagine = new JButton("");
		btnImmagine.setOpaque(false);
		btnImmagine.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnImmagine.setContentAreaFilled(false);
		btnImmagine.setBorderPainted(false);
		btnImmagine.setBackground(SystemColor.menu);
		btnImmagine.setBounds(136, 159, 160, 132);
		contentPane.add(btnImmagine);
		
		JButton button_1 = new JButton("Cancella");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("Segoe Print", Font.BOLD, 16));
		button_1.setBounds(312, 258, 116, 23);
		contentPane.add(button_1);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.GoToAddArticolo();
				
			}
		});
		btnAggiungi.setFont(new Font("Segoe Print", Font.BOLD, 22));
		btnAggiungi.setBounds(291, 870, 137, 40);
		contentPane.add(btnAggiungi);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedGenere =  comboBoxGenere.getSelectedItem().toString();
				String selectedTaglia =  comboBoxTaglia.getSelectedItem().toString(); 
				int selectedQuantita =  Integer.parseInt(modelQuantita.getValue().toString());
				float selectedPrezzo = Float.parseFloat(modelPrezzo.getValue().toString());
					if(VerifyText()) {
						controller.EditArticolo(txtCodice.getText(), txtProduttore.getText(), selectedTaglia, txtColore.getText(), 
								 txtCollezione.getText(),selectedQuantita ,selectedPrezzo,selectedGenere, fotoFile);
						MagazzinoFrame.table.setModel(new DefaultTableModel(null, new Object[] {"Codice", "Produttore", "Taglia", "Colore", "Collezione", "Quantit\u00E0", "Prezzo", "Genere", "Immagine"}));
						controller.FillTable(MagazzinoFrame.table);
					}
			}
		});
		btnModifica.setFont(new Font("Segoe Print", Font.BOLD, 22));
		btnModifica.setBounds(155, 870, 126, 40);
		contentPane.add(btnModifica);
		
		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblCodice.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Articolo non selezionato");
				}else  {
					String id = txtCodice.getText();
				}
				
			}
		});
		btnCancella.setFont(new Font("Segoe Print", Font.BOLD, 22));
		btnCancella.setBounds(10, 870, 126, 40);
		contentPane.add(btnCancella);
	}
	private void ResetValori() {
		txtCodice.setText(" ");
		txtProduttore.setText(" ");
		txtCollezione.setText(" ");
		txtColore.setText(" ");
		btnImmagine.setIcon(new ImageIcon(AddArticoloFrame.class.getResource("/IconRegister/notfound.png")));
		spinnerPrezzo.setValue(0);
		spinnerQuantità.setValue(0);
	}	
	private boolean VerifyText() {
		if(txtCodice.getText().equals("") || txtProduttore.getText().equals("") || txtCollezione.getText().equals("") || txtColore.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Uno o più campi vuoti");
			return false;
		}else {
			return true;
		}
	}
}
