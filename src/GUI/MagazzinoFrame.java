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

public class MagazzinoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JButton btnFoto;
	private JComboBox<String> comboBoxTaglia;
	private JComboBox<String> comboBoxGenere;
	private File fotoFile;
	private JTextField textField_1;
	private JTextField txtCollezione;
	private JTextField txtColore;
	private JTextField txtProduttore;
	private JTextField txtCodice;
	private JTextField txtNome;
	private JSpinner spinnerQuantita;
	private JSpinner spinnerPrezzo;
	
	
	
	private JScrollPane scroll;
	private JTable table;
	private DefaultTableModel model;
	private DefaultComboBoxModel<String> tagliaModel;
	private DefaultComboBoxModel<String> genereModel;
	private SpinnerNumberModel modelQuantita;
	private SpinnerNumberModel modelPrezzo;
	
	public MagazzinoFrame(Controller ctrl) {
		
		controller = ctrl;

		URL url = getClass().getResource("/IconRegister/addFoto.png");
		fotoFile = new File(url.getPath());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1196, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    contentPane.setLayout(null);
		
	  
	    model = controller.FillTableModel();
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

	    });;
	    table.setModel(model);
	    model.fireTableDataChanged();
	    scroll = new JScrollPane(table);
	    scroll.setBounds(328, 10, 842, 531);
	    table.setFillsViewportHeight(true);
	    table.getColumn("Foto").setCellRenderer(new FotoCellRenderer());
	    contentPane.add(scroll);
		
	    
	    
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
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblNome.setBounds(10, 206, 87, 23);
		contentPane.add(lblNome);
		
		JLabel lblCodice = new JLabel("Codice:");
		lblCodice.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblCodice.setBounds(10, 242, 87, 23);
		contentPane.add(lblCodice);
		
		JLabel lblProduttore = new JLabel("Produttore: ");
		lblProduttore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblProduttore.setBounds(10, 278, 160, 23);
		contentPane.add(lblProduttore);
		
		JLabel lblColore = new JLabel("Colore:");
		lblColore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblColore.setBounds(10, 312, 126, 23);
		contentPane.add(lblColore);
		
		JLabel lblCollezione = new JLabel("Collezione:");
		lblCollezione.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblCollezione.setBounds(10, 348, 126, 23);
		contentPane.add(lblCollezione);
		
		JLabel lblQuantita = new JLabel("Quantit\u00E0:");
		lblQuantita.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblQuantita.setBounds(10, 382, 126, 23);
		contentPane.add(lblQuantita);
		
		JLabel lblTaglia = new JLabel("Taglia:");
		lblTaglia.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblTaglia.setBounds(10, 451, 87, 30);
		contentPane.add(lblTaglia);
		
		comboBoxTaglia = new JComboBox<String>();
		tagliaModel = new DefaultComboBoxModel<String>(new String[] {"XS", "S", "M", "L", "XL", "XXL"});
		comboBoxTaglia.setModel(tagliaModel);
		comboBoxTaglia.setBackground(new Color(191, 191, 191));
		comboBoxTaglia.setBounds(142, 459, 110, 22);
		contentPane.add(comboBoxTaglia);
	
		
		modelQuantita = new SpinnerNumberModel(0, 0, 300, 1);
		JSpinner spinnerQuantita = new JSpinner(modelQuantita);
		spinnerQuantita.setForeground(Color.WHITE);
		spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantita.setBackground(new Color(191, 191, 191));
		spinnerQuantita.setBounds(146, 384, 75, 24);
		contentPane.add(spinnerQuantita);
		
		JLabel lblImmagine = new JLabel("Immagine:");
		lblImmagine.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblImmagine.setBounds(10, 88, 126, 30);
		contentPane.add(lblImmagine);
		
		btnFoto = new JButton("");
		
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
		btnFoto.setBounds(146, 35, 160, 132);
		contentPane.add(btnFoto);
		
		modelPrezzo = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
		JSpinner spinnerPrezzo = new JSpinner(modelPrezzo);
		spinnerPrezzo.setForeground(Color.WHITE);
		spinnerPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerPrezzo.setBackground(new Color(191, 191, 191));
		spinnerPrezzo.setBounds(146, 419, 75, 24);
		contentPane.add(spinnerPrezzo);
		
		JButton btnCancellaFoto = new JButton("Cancella");
		btnCancellaFoto.setForeground(Color.RED);
		btnCancellaFoto.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnCancellaFoto.setBounds(159, 172, 116, 23);
		contentPane.add(btnCancellaFoto);
		
		comboBoxGenere = new JComboBox<String>();
		genereModel = new DefaultComboBoxModel<String>(new String[] {"MASCHILE", "FEMMINILE"});
		comboBoxGenere.setModel(genereModel);
		comboBoxGenere.setBackground(new Color(191, 191, 191));
		comboBoxGenere.setBounds(142, 492, 110, 22);
		contentPane.add(comboBoxGenere);
		
		JLabel lblGenere = new JLabel("Genere:");
		lblGenere.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblGenere.setBounds(10, 492, 87, 30);
		contentPane.add(lblGenere);
		
		JButton btnAggiungi = new JButton("Aggiungi");

		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.getColumn("Foto").setCellRenderer(new FotoCellRenderer());
				AggiungiArticolo();
					
			
			}
		});
		btnAggiungi.setFont(new Font("Segoe Print", Font.BOLD, 22));
		btnAggiungi.setBounds(876, 567, 137, 40);
		contentPane.add(btnAggiungi);
		
		JButton btnCancella = new JButton("Cancella");
		btnCancella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int[] selectedRows = table.getSelectedRows();
		        if (selectedRows.length > 0) {
		            for (int i = selectedRows.length - 1; i >= 0; i--) {
		                controller.RemoveArticolo(table.getValueAt(selectedRows[i], 1).toString());
		            }
		        }
			}
		});
	

		btnCancella.setFont(new Font("Segoe Print", Font.BOLD, 22));
		btnCancella.setBounds(482, 567, 126, 40);
		contentPane.add(btnCancella);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		lblPrezzo.setBounds(10, 416, 87, 30);
		contentPane.add(lblPrezzo);
		
		
	}
	
	
	
	
	
	
	
	private void CaricaFoto() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter fileExtensionFilter = new FileNameExtensionFilter("jpg","png");
		fileChooser.setFileFilter(fileExtensionFilter);
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			fotoFile = fileChooser.getSelectedFile();
			
			try {
				BufferedImage fotoImage = ImageIO.read(fotoFile);
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
		
	}
	
	private void AggiungiArticolo() {
		
		String selectedGenere =  comboBoxGenere.getSelectedItem().toString();
		String selectedTaglia =  comboBoxTaglia.getSelectedItem().toString(); 
		int selectedQuantita =  Integer.parseInt(modelQuantita.getValue().toString());
		float selectedPrezzo = Float.parseFloat(modelPrezzo.getValue().toString());
		
		try {
			
			model = controller.AddArticolo(txtNome.getText(),txtCodice.getText(), txtProduttore.getText(), selectedTaglia, txtColore.getText(), 
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


		

		
	

}

class FotoCellRenderer implements TableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		table.setRowHeight(60);
		return (Component) value;
	}
	
}
			
	
	

