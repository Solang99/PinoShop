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
import java.awt.Dialog.ModalExclusionType;

public class MagazzinoFrame extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private static JTable table;
	private Controller controller;
	private JButton btnImmagine;
	private JComboBox comboBoxTaglia;
	private JComboBox comboBoxGenere;
	private File fotoFile;
	private JTextField textField_1;
	private JTextField txtCollezione;
	private JTextField txtColore;
	private JTextField txtProduttore;
	private JTextField txtCodice;
	private JTextField txtNome;
	private JSpinner spinnerQuantita;
	private JSpinner spinnerPrezzo;
	
	public MagazzinoFrame(Controller ctrl) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1196, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane.setBounds(323, 74, 847, 435);
		contentPane.add(scrollPane);
		
		
		SpinnerNumberModel modelQuantita = new SpinnerNumberModel(0, 0, 300, 1);
		spinnerQuantita = new JSpinner(modelQuantita);
		spinnerQuantita.setBounds(586, 220, 75, 24);
		spinnerQuantita.setForeground(Color.WHITE);
		spinnerQuantita.setBackground(new Color(191,191,191));
		spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(spinnerQuantita);
		
		SpinnerNumberModel modelPrezzo = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
		spinnerPrezzo = new JSpinner(modelPrezzo);
		spinnerPrezzo.setBounds(586, 447, 75, 24);	
		spinnerPrezzo.setForeground(Color.WHITE);
		spinnerPrezzo.setBackground(new Color(191,191,191));
		spinnerPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
					     spinnerQuantita .setValue(Integer.valueOf(table.getValueAt(rowIndex, 6).toString()));
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
				 spinnerQuantita.setValue(Integer.valueOf(table.getValueAt(rowIndex, 6).toString()));
				 spinnerPrezzo.setValue(Integer.valueOf(table.getValueAt(rowIndex, 7).toString()));
				 comboBoxGenere.getSelectedItem().toString(); //errore
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

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(191, 191, 191));
		textField_1.setBounds(604, 11, 210, 40);
		contentPane.add(textField_1);
		
		JLabel lblCerca = new JLabel("Cerca");
		lblCerca.setFont(new Font("Segoe Print", Font.BOLD, 39));
		lblCerca.setBounds(466, 11, 116, 40);
		contentPane.add(lblCerca);
		
		txtCollezione = new JTextField();
		txtCollezione.setColumns(10);
		txtCollezione.setBackground(new Color(191, 191, 191));
		txtCollezione.setBounds(146, 351, 151, 20);
		contentPane.add(txtCollezione);
		
		txtColore = new JTextField();
		txtColore.setColumns(10);
		txtColore.setBackground(new Color(191, 191, 191));
		txtColore.setBounds(146, 317, 151, 20);
		contentPane.add(txtColore);
		
		txtProduttore = new JTextField();
		txtProduttore.setColumns(10);
		txtProduttore.setBackground(new Color(191, 191, 191));
		txtProduttore.setBounds(146, 281, 151, 20);
		contentPane.add(txtProduttore);
		
		txtCodice = new JTextField();
		txtCodice.setColumns(10);
		txtCodice.setBackground(new Color(191, 191, 191));
		txtCodice.setBounds(146, 247, 151, 20);
		contentPane.add(txtCodice);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(191, 191, 191));
		txtNome.setBounds(146, 211, 151, 20);
		contentPane.add(txtNome);
		
		JLabel label = new JLabel("Nome:");
		label.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label.setBounds(10, 206, 87, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Codice:");
		label_1.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label_1.setBounds(10, 242, 87, 23);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Produttore: ");
		label_2.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label_2.setBounds(10, 278, 160, 23);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Colore:");
		label_3.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label_3.setBounds(10, 312, 126, 23);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Collezione:");
		label_4.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label_4.setBounds(10, 348, 126, 23);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Quantit\u00E0:");
		label_5.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label_5.setBounds(10, 382, 126, 23);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Taglia:");
		label_6.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label_6.setBounds(10, 451, 87, 30);
		contentPane.add(label_6);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(191, 191, 191));
		comboBox.setBounds(142, 459, 110, 22);
		contentPane.add(comboBox);
		
		JSpinner spinnerQuantita = new JSpinner((SpinnerModel) null);
		spinnerQuantita.setForeground(Color.WHITE);
		spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantita.setBackground(new Color(191, 191, 191));
		spinnerQuantita.setBounds(146, 384, 75, 24);
		contentPane.add(spinnerQuantita);
		
		JLabel label_7 = new JLabel("Immagine:");
		label_7.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label_7.setBounds(10, 88, 126, 30);
		contentPane.add(label_7);
		
		JButton button = new JButton("");
		button.setOpaque(false);
		button.setFont(new Font("Tahoma", Font.PLAIN, 21));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBackground(SystemColor.menu);
		button.setBounds(146, 35, 160, 132);
		contentPane.add(button);
		
		JButton btnCancellaFoto = new JButton("Cancella");
		btnCancellaFoto.setForeground(Color.RED);
		btnCancellaFoto.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnCancellaFoto.setBounds(159, 172, 116, 23);
		contentPane.add(btnCancellaFoto);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBackground(new Color(191, 191, 191));
		comboBox_1.setBounds(142, 492, 110, 22);
		contentPane.add(comboBox_1);
		
		JLabel label_8 = new JLabel("Genere:");
		label_8.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label_8.setBounds(10, 492, 87, 30);
		contentPane.add(label_8);
		
		JButton button_2 = new JButton("Modifica");
		button_2.setFont(new Font("Segoe Print", Font.BOLD, 22));
		button_2.setBounds(685, 545, 126, 40);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Aggiungi");
		button_3.setFont(new Font("Segoe Print", Font.BOLD, 22));
		button_3.setBounds(875, 545, 137, 40);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Cancella");
		button_4.setFont(new Font("Segoe Print", Font.BOLD, 22));
		button_4.setBounds(481, 545, 126, 40);
		contentPane.add(button_4);
		
		JLabel label_9 = new JLabel("Prezzo:");
		label_9.setFont(new Font("Segoe Print", Font.BOLD, 22));
		label_9.setBounds(10, 416, 87, 30);
		contentPane.add(label_9);
		
		JSpinner spinner_1 = new JSpinner((SpinnerModel) null);
		spinner_1.setForeground(Color.WHITE);
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_1.setBackground(new Color(191, 191, 191));
		spinner_1.setBounds(146, 419, 75, 24);
		contentPane.add(spinner_1);
	}
	private void ResetValori() {
		txtCodice.setText(" ");
		txtProduttore.setText(" ");
		txtCollezione.setText(" ");
		txtColore.setText(" ");
		btnImmagine.setIcon(new ImageIcon(AddArticoloFrame.class.getResource("/IconRegister/notfound.png")));
		spinnerPrezzo.setValue(0);
		spinnerQuantita.setValue(0);
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
