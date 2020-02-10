package GUI;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.SpinnerModel;

public class ComponetArticolo extends JPanel {

	
	private float prezzo;
	private String id;
	private String nome;
	private int tipo;
	private int quantita;
	private int selectedQuantia;
	private SpinnerNumberModel modelQuantita;
	public ComponetArticolo(Image foto , String nome,String id, float prezzo ,int quantia,Controller controller,int tipo) {
		
		this.prezzo = prezzo;
		this.id= id;
		this.tipo=tipo;
		this.nome= nome;
		this.quantita = quantia;
		setBorder(new LineBorder(new Color(44, 85, 69), 1, true));
		setLayout(null);
		setPreferredSize(new Dimension(211, 174));
		JLabel lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblIcon.setBounds(15, 9, 89, 123);
		
	
		lblIcon.setIcon(new ImageIcon(foto.getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(), java.awt.Image.SCALE_SMOOTH)));
		add(lblIcon);
		
		

		
		JLabel lblNome = new JLabel("");
		lblNome.setText(nome);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(112, 24, 89, 23);
		add(lblNome);
		
		JLabel lblId = new JLabel("");
		lblId.setText(id);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setBounds(111, 52, 89, 23);
		add(lblId);
		
		JLabel lblPrezzo = new JLabel("");
		lblPrezzo.setHorizontalAlignment(SwingConstants.CENTER);
		Float p = prezzo;
		lblPrezzo.setText(p.toString());
		lblPrezzo.setBounds(114, 86, 89, 23);
		add(lblPrezzo);
		
		JButton btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon(ComponetArticolo.class.getResource("/IconComponentArticolo/25pxEdit.png")));
		btnEdit.setOpaque(false);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setBounds(28, 143, 33, 23);
		add(btnEdit);
		
		JLabel lblQuantita = new JLabel("x");
		lblQuantita.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantita.setBounds(124, 110, 23, 23);
		add(lblQuantita);

		
		
		if (tipo == 0) {
			
			modelQuantita = new SpinnerNumberModel(0, 0, 300, 1);
			JSpinner spinnerQuantita = new JSpinner(modelQuantita);
			spinnerQuantita.setForeground(Color.WHITE);
			spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinnerQuantita.setBackground(new Color(191, 191, 191));
			spinnerQuantita.setValue(quantita);
			
			spinnerQuantita.setBounds(147, 108, 50, 24);
			add(spinnerQuantita);
			
			JButton btnAggiungi = new JButton("");
			btnAggiungi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null, "Articolo Aggiunto");
					selectedQuantia = Integer.parseInt(spinnerQuantita.getValue().toString());
					controller.FillCassaList(id,selectedQuantia);
				}
		
			});
			btnAggiungi.setOpaque(false);
			btnAggiungi.setContentAreaFilled(false);
			btnAggiungi.setBorderPainted(false);
			btnAggiungi.setBounds(168, 143, 33, 23);
			btnAggiungi.setIcon(new ImageIcon(ComponetArticolo.class.getResource("/IconComponentArticolo/25pxadd.png")));
			add(btnAggiungi);
		
			

		}
		else
		{
			
			modelQuantita = new SpinnerNumberModel(0, 0, quantita, 1);
			JSpinner spinnerQuantita = new JSpinner(modelQuantita);
			spinnerQuantita.setForeground(Color.WHITE);
			spinnerQuantita.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinnerQuantita.setBackground(new Color(191, 191, 191));
			spinnerQuantita.setValue(quantita);
			
			spinnerQuantita.setBounds(147, 108, 50, 24);
			add(spinnerQuantita);
			
			
			JButton btnRimuovi = new JButton("");
			btnRimuovi.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JOptionPane.showMessageDialog(null, "Articolo Rimosso");
					selectedQuantia = Integer.parseInt(spinnerQuantita.getValue().toString());
				//modelQuantita = new SpinnerNumberModel(0, 0, quantia, 1);
					controller.RemoveFromCassa(id,selectedQuantia);
					spinnerQuantita.setValue(quantita);
				}
		
			});
			btnRimuovi.setOpaque(false);
			btnRimuovi.setContentAreaFilled(false);
			btnRimuovi.setBorderPainted(false);
			btnRimuovi.setBounds(168, 143, 33, 23);
			btnRimuovi.setIcon(new ImageIcon(ComponetArticolo.class.getResource("/IconComponentArticolo/25pxRemove.png")));
			add(btnRimuovi);
		}
		
		setVisible(true);

	}




	public float getPrezzo() {
		return prezzo;
	}





	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantita() {
		return quantita;
	}


	public int getTipo() {
		return tipo;
	}
	
	public void setQuantita (int quantita) {
		this.quantita -=quantita; 
	}
}
