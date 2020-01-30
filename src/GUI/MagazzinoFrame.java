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

		URL url = getClass().getResource("/IconRegister/notFound.png");
		fotoFile = new File(url.getPath());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1196, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	  
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

	    });
	    
	    table.setModel(model);
	    model.fireTableDataChanged();
	    scroll = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	   
	    DefaultTableCellRenderer  centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    for (int  i = 0 ; i< table.getColumnCount(); i++)
	    	table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
	    
	    table.getColumn("Foto").setCellRenderer(new FotoCellRenderer());

	    table.setRowHeight(80);
		
	    
	    
	    
		txtCollezione = new JTextField();
		txtCollezione.setColumns(10);
		txtCollezione.setBackground(new Color(191, 191, 191));
		
		txtColore = new JTextField();
		txtColore.setColumns(10);
		txtColore.setBackground(new Color(191, 191, 191));
		
		txtProduttore = new JTextField();
		txtProduttore.setColumns(10);
		txtProduttore.setBackground(new Color(191, 191, 191));
		
		txtCodice = new JTextField();
		txtCodice.setColumns(10);
		txtCodice.setBackground(new Color(191, 191, 191));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBackground(new Color(191, 191, 191));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblCodice = new JLabel("Codice:");
		lblCodice.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblProduttore = new JLabel("Produttore: ");
		lblProduttore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblColore = new JLabel("Colore:");
		lblColore.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblCollezione = new JLabel("Collezione:");
		lblCollezione.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblQuantita = new JLabel("Quantit\u00E0:");
		lblQuantita.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblTaglia = new JLabel("Taglia:");
		lblTaglia.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		comboBoxTaglia = new JComboBox<String>();
		tagliaModel = new DefaultComboBoxModel<String>(new String[] {"XS", "S", "M", "L", "XL", "XXL"});
		comboBoxTaglia.setModel(tagliaModel);
		comboBoxTaglia.setBackground(new Color(191, 191, 191));
	
		
		modelQuantita = new SpinnerNumberModel(0, 0, 300, 1);
		JSpinner spinnerQuantita = new JSpinner(modelQuantita);
		spinnerQuantita.setForeground(Color.WHITE);
		spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantita.setBackground(new Color(191, 191, 191));
		
		JLabel lblImmagine = new JLabel("Immagine:");
		lblImmagine.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
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
		
		modelPrezzo = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
		JSpinner spinnerPrezzo = new JSpinner(modelPrezzo);
		spinnerPrezzo.setForeground(Color.WHITE);
		spinnerPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerPrezzo.setBackground(new Color(191, 191, 191));
		
		JButton btnCancellaFoto = new JButton("Cancella");
		btnCancellaFoto.setForeground(Color.RED);
		btnCancellaFoto.setFont(new Font("Segoe Print", Font.BOLD, 16));
		
		comboBoxGenere = new JComboBox<String>();
		genereModel = new DefaultComboBoxModel<String>(new String[] {"MASCHILE", "FEMMINILE"});
		comboBoxGenere.setModel(genereModel);
		comboBoxGenere.setBackground(new Color(191, 191, 191));
		
		JLabel lblGenere = new JLabel("Genere:");
		lblGenere.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JButton btnAggiungi = new JButton("Aggiungi");

		btnAggiungi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.getColumn("Foto").setCellRenderer(new FotoCellRenderer());
				AggiungiArticolo();
					
			
			}
		});
		btnAggiungi.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
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
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblImmagine, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(btnFoto, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(154)
							.addComponent(btnCancellaFoto, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblCodice, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(txtCodice, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(136)
									.addComponent(txtProduttore, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblProduttore, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblColore, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtColore, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblCollezione, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtCollezione, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblQuantita, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(spinnerQuantita, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPrezzo, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(spinnerPrezzo, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTaglia, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(comboBoxTaglia, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblGenere, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(comboBoxGenere, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
					.addGap(22)
					.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(477)
					.addComponent(btnCancella, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(268)
					.addComponent(btnAggiungi, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(53)
									.addComponent(lblImmagine, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnFoto, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addComponent(btnCancellaFoto, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCodice, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(txtCodice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(txtProduttore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblProduttore, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblColore, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(txtColore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCollezione, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(txtCollezione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblQuantita, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(spinnerQuantita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrezzo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(spinnerPrezzo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTaglia, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(8)
									.addComponent(comboBoxTaglia, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGenere, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBoxGenere, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancella, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAggiungi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
		);
		contentPane.setLayout(gl_contentPane);
		
		
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

		return (Component) value;
	}
	
}
			
	
	

