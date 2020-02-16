package GUI;



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

import javax.swing.JSpinner;

import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;


import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class MagazzinoFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;
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
	private JLabel lblFotoArticolo;
	
	public MagazzinoFrame(Controller ctrl) {
		
		controller = ctrl;

		URL url = getClass().getResource("/IconRegister/notFound.png");
		fotoFile = new File(url.getPath());
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1196, 668);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		

	    model = controller.fillTableMagazzinoModel("all");
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
	   

	    
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    table.setDefaultRenderer(String.class, centerRenderer);

	    table.setRowHeight(80);
		
	    
	    
	    
		txtCollezione = new JTextField();
		txtCollezione.setColumns(10);
		txtCollezione.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			       if (txtCollezione.getText().length() >= 20 ) 
			            e.consume(); 
			}
		});
		txtCollezione.setBackground(new Color(191, 191, 191));
		
		txtColore = new JTextField();
		txtColore.setColumns(10);
		txtColore.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			       if (txtColore.getText().length() >= 10 ) 
			            e.consume(); 
			}
		});
		txtColore.setBackground(new Color(191, 191, 191));
		
		txtProduttore = new JTextField();
		txtProduttore.setColumns(10);
		txtProduttore.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			       if (txtProduttore.getText().length() >= 20 ) 
			            e.consume(); 
			}
		});
		txtProduttore.setBackground(new Color(191, 191, 191));
		
		txtCodice = new JTextField();
		txtCodice.setColumns(10);
		txtCodice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			       if (txtCodice.getText().length() >= 20 ) 
			            e.consume(); 
			}
		});
		txtCodice.setBackground(new Color(191, 191, 191));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			       if (txtNome.getText().length() >= 20 ) 
			            e.consume(); 
			}
		});
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
	
		
		modelQuantita = new SpinnerNumberModel(1, 1, 300, 1);
		JSpinner spinnerQuantita = new JSpinner(modelQuantita);
		spinnerQuantita.setForeground(Color.WHITE);
		spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantita.setBackground(new Color(191, 191, 191));
		
		JLabel lblImmagine = new JLabel("Immagine:");
		lblImmagine.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		modelPrezzo = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
		JSpinner spinnerPrezzo = new JSpinner(modelPrezzo);
		spinnerPrezzo.setForeground(Color.WHITE);
		spinnerPrezzo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerPrezzo.setBackground(new Color(191, 191, 191));
		
		JButton btnCancellaFoto = new JButton("");
		Image cancellaFotoIcon;
		try {
			cancellaFotoIcon = ImageIO.read(MagazzinoFrame.class.getResource("/IconMagazzino/iconRemove.png"));
			btnCancellaFoto.setIcon(new ImageIcon(cancellaFotoIcon.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)));
			btnCancellaFoto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Image defaultFoto = ImageIO.read(MagazzinoFrame .class.getResource("/IconRegister/notFound.png"));
						lblFotoArticolo.setIcon(new ImageIcon(defaultFoto.getScaledInstance(94, 93, Image.SCALE_SMOOTH)));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
			});
			btnCancellaFoto.setOpaque(false);
			btnCancellaFoto.setContentAreaFilled(false);
			btnCancellaFoto.setBorderPainted(false);	
			btnCancellaFoto.setFont(new Font("Segoe Print", Font.BOLD, 16));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
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
				AggiungiArticolo();
					
			
			}
		});
		btnAggiungi.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JButton btnCancella = new JButton("Cancella");
		btnCancella.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dialogResult =JOptionPane.showConfirmDialog (null, "Sicuro di voler cancellare gli elementi selezionati? L'operazione non è reversibile","Warning",JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					int[] selectedRows = table.getSelectedRows();
					if (selectedRows.length > 0) {
						for (int i = selectedRows.length - 1; i >= 0; i--) {
							controller.removeArticolo(table.getValueAt(selectedRows[i], 1).toString());
						}
					} 
				}
			}
		});
	

		btnCancella.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		lblPrezzo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model = controller.fillTableMagazzinoModel(txtCodice.getText());
				
			}
		});
		btnCerca.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Segoe Print", Font.BOLD, 22));
		
		comboBoxCategoria = new JComboBox<String>();
		tipoModel = new DefaultComboBoxModel<String>(new String[] {"Maglieria" , "Pantaloni","Soprabiti","Scarpe","Accessori'"});
		comboBoxCategoria.setModel(tipoModel);
		comboBoxCategoria.setBackground(new Color(191, 191, 191));
		
		JButton btnAddFoto = new JButton("");
		btnAddFoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				caricaFoto();
			}
		});
		
		try {
			Image AddFotoIcon = ImageIO.read(MagazzinoFrame.class.getResource("/IconMagazzino/iconAdd.png"));
			btnAddFoto.setIcon(new ImageIcon(AddFotoIcon.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnAddFoto.setForeground(Color.RED);
		btnAddFoto.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnAddFoto.setOpaque(false);
		btnAddFoto.setContentAreaFilled(false);
		btnAddFoto.setBorderPainted(false);
		
		lblFotoArticolo = new JLabel("");
		Image defaultFoto;
		try {
			defaultFoto = ImageIO.read(MagazzinoFrame .class.getResource("/IconRegister/notFound.png"));
			lblFotoArticolo.setIcon(new ImageIcon(defaultFoto.getScaledInstance(94, 93, Image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblImmagine, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(lblFotoArticolo, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(154)
							.addComponent(btnCancellaFoto, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(btnAddFoto, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
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
								.addComponent(lblProduttore, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(136)
									.addComponent(txtProduttore, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
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
							.addComponent(comboBoxGenere, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(45)
							.addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addComponent(btnCerca, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(271)
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
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(38)
									.addComponent(lblImmagine, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
									.addGap(26))
								.addComponent(lblFotoArticolo, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCancellaFoto, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAddFoto, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
									.addGap(2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCodice, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
									.addGap(2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(txtCodice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblProduttore, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(txtProduttore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblColore, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
									.addGap(2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(5)
									.addComponent(txtColore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCollezione, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(txtCollezione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblQuantita, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
									.addGap(3))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(spinnerQuantita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrezzo, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(spinnerPrezzo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTaglia, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(8)
									.addComponent(comboBoxTaglia, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGenere, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
								.addComponent(comboBoxGenere, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
								.addComponent(comboBoxCategoria, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
							.addGap(3))
						.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCerca, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancella, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAggiungi, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
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
		lblFotoArticolo.setIcon(image);
		
	}
	
	private void AggiungiArticolo() {
		
		String selectedGenere =  comboBoxGenere.getSelectedItem().toString();
		String selectedTaglia =  comboBoxTaglia.getSelectedItem().toString();
		String selectedCategoira = comboBoxCategoria.getSelectedItem().toString();
		int selectedQuantita =  Integer.parseInt(modelQuantita.getValue().toString());
		float selectedPrezzo = Float.parseFloat(modelPrezzo.getValue().toString());
		
		try {
			
			model = controller.addArticolo(txtNome.getText(),txtCodice.getText(), txtProduttore.getText(), selectedTaglia, txtColore.getText(), 
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
	

	private void caricaFoto() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter fileExtensionFilter = new FileNameExtensionFilter("jpg","png");
		fileChooser.setFileFilter(fileExtensionFilter);
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			fotoFile = fileChooser.getSelectedFile();
			
			try {
				Image fotoImage = ImageIO.read(fotoFile).getScaledInstance(94, 93, Image.SCALE_SMOOTH);
				ImageIcon fotoIcon = new ImageIcon(fotoImage);
				lblFotoArticolo.setIcon(fotoIcon);
			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "Foto non valida", "Errore", 2);
				e.printStackTrace();
			}

		}
			
	}
	
}
			
	
	

