package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Database.ArticoloDAO;
import Entita.Articolo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MagazzinoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JButton btnFoto;
	private JComboBox<String> comboBoxTaglia;
	private JComboBox<String> comboBoxGenere;
	private JComboBox<String> comboBoxCategoria;
	private File fotoFile;

	private JTextField txtCollezione;
	private JTextField txtColore;
	private JTextField txtProduttore;
	private JTextField txtCodice;
	private JTextField txtNome;

	
	
	
	private JScrollPane scroll;
	private JTable table;
	private DefaultTableModel model;
	private DefaultComboBoxModel<String> tagliaModel;
	private DefaultComboBoxModel<String> genereModel;
	private DefaultComboBoxModel<String> tipoModel;
	private SpinnerNumberModel modelQuantita;
	private SpinnerNumberModel modelPrezzo;
	private JButton btnCerca;
	
	public MagazzinoFrame(Controller ctrl) {
		
		controller = ctrl;

		URL url = getClass().getResource("/IconRegister/notFound.png");
		fotoFile = new File(url.getPath());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1196, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

	    model = controller.FillTableMagazzinoModel("all");
	    table = new JTable(){

			@Override
	        public boolean isCellEditable(int row, int column) {
	           return false;
	        }
	    };
	    
	    table.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
				int selectedRow = table.rowAtPoint(e.getPoint());
				
				if(selectedRow >= 0 )
					FillSideBox();
			
	    	}

	    });
	    
	    table.setModel(model);
	    model.fireTableDataChanged();
	    scroll = new JScrollPane(table);
	    scroll.setBounds(328, 10, 842, 531);
	    table.setFillsViewportHeight(true);
	   

	    
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    table.setDefaultRenderer(String.class, centerRenderer);

	    table.setRowHeight(80);
		
	    
	    
	    
		txtCollezione = new JTextField();
		txtCollezione.setBounds(151, 326, 151, 20);
		txtCollezione.setColumns(10);
		txtCollezione.setBackground(new Color(191, 191, 191));
		
		txtColore = new JTextField();
		txtColore.setBounds(151, 292, 151, 20);
		txtColore.setColumns(10);
		txtColore.setBackground(new Color(191, 191, 191));
		
		txtProduttore = new JTextField();
		txtProduttore.setBounds(151, 256, 151, 20);
		txtProduttore.setColumns(10);
		txtProduttore.setBackground(new Color(191, 191, 191));
		
		txtCodice = new JTextField();
		txtCodice.setBounds(151, 222, 151, 20);
		txtCodice.setColumns(10);
		txtCodice.setBackground(new Color(191, 191, 191));
		
		txtNome = new JTextField();
		txtNome.setBounds(151, 186, 151, 20);
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(191, 191, 191));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(15, 181, 87, 23);
		lblNome.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblCodice = new JLabel("Codice:");
		lblCodice.setBounds(15, 217, 87, 23);
		lblCodice.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblProduttore = new JLabel("Produttore: ");
		lblProduttore.setBounds(15, 253, 160, 23);
		lblProduttore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblColore = new JLabel("Colore:");
		lblColore.setBounds(15, 287, 126, 23);
		lblColore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblCollezione = new JLabel("Collezione:");
		lblCollezione.setBounds(15, 323, 126, 23);
		lblCollezione.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblQuantita = new JLabel("Quantit\u00E0:");
		lblQuantita.setBounds(15, 357, 126, 23);
		lblQuantita.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblTaglia = new JLabel("Taglia:");
		lblTaglia.setBounds(15, 426, 87, 30);
		lblTaglia.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		comboBoxTaglia = new JComboBox<String>();
		comboBoxTaglia.setBounds(147, 434, 110, 22);
		tagliaModel = new DefaultComboBoxModel<String>(new String[] {"XS", "S", "M", "L", "XL", "XXL"});
		comboBoxTaglia.setModel(tagliaModel);
		comboBoxTaglia.setBackground(new Color(191, 191, 191));
	
		
		modelQuantita = new SpinnerNumberModel(1, 1, 300, 1);
		JSpinner spinnerQuantita = new JSpinner(modelQuantita);
		spinnerQuantita.setBounds(151, 359, 75, 24);
		spinnerQuantita.setForeground(Color.WHITE);
		spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantita.setBackground(new Color(191, 191, 191));
		
		JLabel lblImmagine = new JLabel("Immagine:");
		lblImmagine.setBounds(15, 63, 126, 30);
		lblImmagine.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		btnFoto = new JButton("");
		btnFoto.setIcon(new ImageIcon(MagazzinoFrame.class.getResource("/IconRegister/addFoto.png")));
		btnFoto.setBounds(151, 10, 160, 132);
		
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaricaFoto();
			}
		});
		btnFoto.setOpaque(false);
		btnFoto.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnFoto.setContentAreaFilled(false);
		btnFoto.setBorderPainted(false);
		btnFoto.setBackground(SystemColor.menu);
		
		modelPrezzo = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
		JSpinner spinnerPrezzo = new JSpinner(modelPrezzo);
		spinnerPrezzo.setBounds(151, 394, 75, 24);
		spinnerPrezzo.setForeground(Color.WHITE);
		spinnerPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerPrezzo.setBackground(new Color(191, 191, 191));
		
		JButton btnCancellaFoto = new JButton("Cancella");
		btnCancellaFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFoto.setIcon(new ImageIcon(MagazzinoFrame.class.getResource("/IconRegister/addFoto.png")));
			}
		});
		btnCancellaFoto.setBounds(164, 147, 116, 23);
		btnCancellaFoto.setForeground(Color.RED);
		btnCancellaFoto.setFont(new Font("Segoe Print", Font.BOLD, 16));
		
		comboBoxGenere = new JComboBox<String>();
		comboBoxGenere.setBounds(147, 467, 110, 22);
		genereModel = new DefaultComboBoxModel<String>(new String[] {"MASCHILE", "FEMMINILE"});
		comboBoxGenere.setModel(genereModel);
		comboBoxGenere.setBackground(new Color(191, 191, 191));
		
		JLabel lblGenere = new JLabel("Genere:");
		lblGenere.setBounds(15, 467, 87, 30);
		lblGenere.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JButton btnAggiungi = new JButton("Aggiungi");
	
	
		btnAggiungi.setBounds(876, 567, 137, 40);

		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AggiungiArticolo();
					
			
			}
		});
		btnAggiungi.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JButton btnCancella = new JButton("Cancella");
	
		btnCancella.setBounds(482, 567, 126, 40);
		btnCancella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dialogResult =JOptionPane.showConfirmDialog (null, "Sicuro di voler cancellare gli elementi selezionati? L'operazione non è reversibile","Warning",JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					int[] selectedRows = table.getSelectedRows();
					if (selectedRows.length > 0) {
						for (int i = selectedRows.length - 1; i >= 0; i--) {
							controller.RemoveArticolo(table.getValueAt(selectedRows[i], 1).toString());
						}
					} 
				}
			}
		});
	

		btnCancella.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setBounds(10, 391, 87, 30);
		lblPrezzo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCerca.setBounds(85, 567, 126, 40);
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = controller.FillTableMagazzinoModel(txtCodice.getText());
				
			}
		});
		btnCerca.setFont(new Font("Segoe Print", Font.BOLD, 22));
		contentPane.setLayout(null);
		contentPane.add(lblImmagine);
		contentPane.add(btnFoto);
		contentPane.add(btnCancellaFoto);
		contentPane.add(lblNome);
		contentPane.add(txtNome);
		contentPane.add(lblCodice);
		contentPane.add(txtCodice);
		contentPane.add(txtProduttore);
		contentPane.add(lblProduttore);
		contentPane.add(lblColore);
		contentPane.add(txtColore);
		contentPane.add(lblCollezione);
		contentPane.add(txtCollezione);
		contentPane.add(lblQuantita);
		contentPane.add(spinnerQuantita);
		contentPane.add(lblPrezzo);
		contentPane.add(spinnerPrezzo);
		contentPane.add(lblTaglia);
		contentPane.add(comboBoxTaglia);
		contentPane.add(lblGenere);
		contentPane.add(comboBoxGenere);
		contentPane.add(scroll);
		contentPane.add(btnCerca);
		contentPane.add(btnCancella);
		contentPane.add(btnAggiungi);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblTipo.setBounds(15, 508, 87, 30);
		contentPane.add(lblTipo);
		
		comboBoxCategoria = new JComboBox<String>();
		tipoModel = new DefaultComboBoxModel<String>(new String[] {"Maglieria" , "Pantaloni","Soprabiti","Scarpe","Accessori'"});
		comboBoxCategoria.setModel(tipoModel);
		comboBoxCategoria.setBackground(new Color(191, 191, 191));
		comboBoxCategoria.setBounds(147, 508, 110, 22);
		contentPane.add(comboBoxCategoria);
		
		
		
		
	}
	
	
	
	
	
	
	
	private void CaricaFoto() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter fileExtensionFilter = new FileNameExtensionFilter("jpg","png");
		fileChooser.setFileFilter(fileExtensionFilter);
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			fotoFile = fileChooser.getSelectedFile();
			
			try {
				Image fotoImage = ImageIO.read(fotoFile);
				ImageIcon fotoIcon = new ImageIcon(fotoImage);
				btnFoto.setIcon(fotoIcon);
			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "Foto non valida", "Errore", 2);
				e.printStackTrace();
			}

		}
			
	}
	
	
	private void FillSideBox() {
		int selectedRow = table.getSelectedRow();
		txtNome.setText(table.getValueAt(selectedRow, 0).toString());
		txtCodice.setText(table.getValueAt(selectedRow, 1).toString());
		txtProduttore.setText(table.getValueAt(selectedRow, 2).toString());
		
		String selectedTaglia = table.getValueAt(selectedRow, 3).toString();
		tagliaModel.setSelectedItem(selectedTaglia);
		
		txtColore.setText(table.getValueAt(selectedRow, 4).toString());
		txtCollezione.setText(table.getValueAt(selectedRow, 5).toString());
		
		int selectedQuantita = (int) table.getValueAt(selectedRow, 6);
		modelQuantita.setValue(selectedQuantita);
		
		float selectedPrezzo = (float) table.getValueAt(selectedRow, 7);
		modelPrezzo.setValue(selectedPrezzo);
		
		String selectedGenere = table.getValueAt(selectedRow, 8).toString();
		genereModel.setSelectedItem(selectedGenere);
		
		String selectedTipo = table.getValueAt(selectedRow, 9).toString();
		tipoModel.setSelectedItem(selectedTipo);
		
		ImageIcon image = (ImageIcon) table.getValueAt(selectedRow, 10);
		btnFoto.setIcon(image);
		
	}
	
	private void AggiungiArticolo() {
		
		String selectedGenere =  comboBoxGenere.getSelectedItem().toString();
		String selectedTaglia =  comboBoxTaglia.getSelectedItem().toString();
		String selectedCategoira = comboBoxCategoria.getSelectedItem().toString();
		int selectedQuantita =  Integer.parseInt(modelQuantita.getValue().toString());
		float selectedPrezzo = Float.parseFloat(modelPrezzo.getValue().toString());
		
		try {
			
			model = controller.AddArticolo(txtNome.getText(),txtCodice.getText(), txtProduttore.getText(), selectedTaglia, txtColore.getText(), 
								 txtCollezione.getText(),selectedQuantita ,selectedPrezzo,selectedGenere,selectedCategoira, fotoFile);
		
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



	
}
			
	
	

