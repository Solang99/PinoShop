package GUI;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class AddArticoloFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panelArticolo;
	private JTextField txtId;
	private JTextField txtProduttore;
	private JTextField txtCollezione;
	private JTextField txtColore;
	private File fotoFile;
	private JButton btnFoto;
	private Controller controller;
	private JSpinner spinnerPrezzo;
	private JSpinner spinnerQuantita;
	
	public AddArticoloFrame(Controller ctrl) {
		
		controller = ctrl;
		
		URL url = getClass().getResource("/IconRegister/notfound.png");
		File fotoFile = new File(url.getPath());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 783, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelArticolo = new JPanel();
		panelArticolo.setBackground(Color.WHITE);
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
		lblColore.setBounds(20, 366, 126, 23);
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
		txtProduttore.setBounds(165, 294, 151, 20);
		txtProduttore.setColumns(10);
		txtProduttore.setBackground(new Color(191, 191, 191));
		panelArticolo.add(txtProduttore);
		
		txtCollezione = new JTextField();
		txtCollezione.setBounds(165, 448, 151, 20);
		txtCollezione.setColumns(10);
		txtCollezione.setBackground(new Color(191, 191, 191));
		panelArticolo.add(txtCollezione);
		
		SpinnerNumberModel modelQuantita = new SpinnerNumberModel(0, 0, 300, 1);
		spinnerQuantita = new JSpinner(modelQuantita);
		spinnerQuantita.setBounds(586, 220, 75, 24);
		spinnerQuantita.setForeground(Color.WHITE);
		spinnerQuantita.setBackground(new Color(191,191,191));
		spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelArticolo.add(spinnerQuantita);
	
		SpinnerNumberModel modelPrezzo = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
		spinnerPrezzo = new JSpinner(modelPrezzo);
		spinnerPrezzo.setBounds(586, 447, 75, 24);	
		spinnerPrezzo.setForeground(Color.WHITE);
		spinnerPrezzo.setBackground(new Color(191,191,191));
		spinnerPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		panelArticolo.add(spinnerPrezzo);
		
		btnFoto = new JButton("");
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaFoto();
			}
		});
		btnFoto.setIcon(new ImageIcon(AddArticoloFrame.class.getResource("/IconRegister/notfound.png")));
		btnFoto.setBounds(156, 67, 160, 132);
		btnFoto.setOpaque(false);
		btnFoto.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnFoto.setContentAreaFilled(false);
		btnFoto.setBorderPainted(false);
		btnFoto.setBackground(SystemColor.menu);
		panelArticolo.add(btnFoto);
		
		JComboBox<String> comboBoxTaglia = new JComboBox<String>();
		comboBoxTaglia.setBounds(586, 297, 110, 22);
		comboBoxTaglia.setModel(new DefaultComboBoxModel<String>(new String[] {"XS", "S", "M", "L", "XL", "XXL", "XXXL"}));
		comboBoxTaglia.setBackground(new Color(191,191,191));
		panelArticolo.add(comboBoxTaglia);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setBounds(412, 441, 87, 30);
		lblPrezzo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		panelArticolo.add(lblPrezzo);
		
		txtColore = new JTextField();
		txtColore.setBounds(165, 371, 151, 20);
		txtColore.setColumns(10);
		txtColore.setBackground(new Color(191, 191, 191));
		panelArticolo.add(txtColore);
		
		JLabel lblGenere = new JLabel("Genere");
		lblGenere.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblGenere.setBounds(412, 371, 87, 30);
		panelArticolo.add(lblGenere);
		
		JComboBox<String> comboBoxGenere = new JComboBox<String>();
		comboBoxGenere.setModel(new DefaultComboBoxModel<String>(new String[] {"MASCHILE","FEMMILE"}));
		comboBoxGenere.setBackground(new Color(191, 191, 191));
		comboBoxGenere.setBounds(586, 379, 110, 22);
		panelArticolo.add(comboBoxGenere);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setFont(new Font("Segoe Print", Font.BOLD, 22));
		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				String selectedGenere =  comboBoxGenere.getSelectedItem().toString();
				String selectedTaglia =  comboBoxTaglia.getSelectedItem().toString(); 
				int selectedQuantita =  Integer.parseInt(modelQuantita.getValue().toString());
				float selectedPrezzo = Float.parseFloat(modelPrezzo.getValue().toString());
				
				try {
					controller.AddArticolo(txtId.getText(), txtProduttore.getText(), selectedTaglia, txtColore.getText(), 
										 txtCollezione.getText(),selectedQuantita ,selectedPrezzo,selectedGenere, fotoFile);
						JOptionPane.showMessageDialog(null, "Articolo aggiunto correttamentoe", "Errore", JOptionPane.INFORMATION_MESSAGE
					);
				} catch (FileNotFoundException e1 ) {
					JOptionPane.showMessageDialog(null, "File non trovato", "Errore", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				catch (SQLException sq){
					JOptionPane.showMessageDialog(null, "Contatta un amministratore", "Errore", JOptionPane.ERROR_MESSAGE);
					sq.printStackTrace();
				}
			}
		});
		btnAggiungi.setBounds(435, 526, 160, 40);
		panelArticolo.add(btnAggiungi);
		
		JButton btnCancella = new JButton("Svuota");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetValori();
			}
		});
		btnCancella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnCancella.setBounds(259, 526, 126, 40);
		btnCancella.setFont(new Font("Segoe Print", Font.BOLD, 22));
	
	
		panelArticolo.add(btnCancella);
		

		
		JButton btnRimuovi = new JButton("Cancella");
		btnRimuovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFoto.setIcon(new ImageIcon(AddArticoloFrame.class.getResource("/IconRegister/notfound.png")));

			}
		});
		btnRimuovi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnRimuovi.setForeground(Color.RED);
		btnRimuovi.setBounds(317, 171, 116, 23);
		btnRimuovi.setFont(new Font("Segoe Print", Font.BOLD, 16));
		panelArticolo.add(btnRimuovi);
	}
	
	private void CaricaFoto() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter fileExtensionFilter = new FileNameExtensionFilter("jpg","png");
		fileChooser.setFileFilter(fileExtensionFilter);
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			fotoFile = fileChooser.getSelectedFile();
			Image fotoImage;
			try {
				fotoImage = ImageIO.read(fotoFile);
				ImageIcon fotoIcon = new ImageIcon(fotoImage);
				btnFoto.setIcon(fotoIcon);
			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "Foto non valida", "Errore", 2);
				e.printStackTrace();
			}

		}
			
	}
	
	private void ResetValori() {
		txtId.setText(" ");
		txtProduttore.setText(" ");
		txtCollezione.setText(" ");
		txtColore.setText(" ");
		btnFoto.setIcon(new ImageIcon(AddArticoloFrame.class.getResource("/IconRegister/notfound.png")));
		spinnerPrezzo.setValue(0);
		spinnerQuantita.setValue(0);
	}	
}
