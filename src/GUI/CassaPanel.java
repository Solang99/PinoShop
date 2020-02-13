package GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CassaPanel extends JPanel {
	
	
	private float totale;
	private float pagamentoVersato;
	private JCheckBox checkBoxCarta;
	private JCheckBox checkBoxContanti;
	
	private SpinnerNumberModel modelPagamento;
	private JLabel lblResto;
	private Controller controller;
	private GridBagLayout innerLayout;
    private GridBagConstraints innerConstraints;
    private JPanel innerPanel ;
	public CassaPanel(Controller ctrl) {

		controller = ctrl;
		
		setBorder(null);
		setSize(514, 298);
		setBounds(0, 144, 906, 541);
		
		

	    innerLayout = new GridBagLayout();
	    innerConstraints = new GridBagConstraints();
	    innerPanel = new JPanel(innerLayout);
	    
	    innerConstraints.weightx = 0.0;
	    innerConstraints.weighty = 0.0;
	    innerConstraints.gridy = 0;
  
    
       
        int i = 0;
        

		

        
        JPanel panel = new JPanel();
        
        JLabel lblCassa = new JLabel("Cassa");
        lblCassa.setFont(new Font("Segoe Print", Font.PLAIN, 33));
        
        
        JPanel panelTipoPagamento = new JPanel();
        panelTipoPagamento.setLayout(null);
        
        JLabel lblTipoPagamento = new JLabel("Tipo di Pagamento:");
        lblTipoPagamento.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        lblTipoPagamento.setBounds(33, 11, 199, 30);
        
        checkBoxContanti = new JCheckBox("Contanti");
        checkBoxContanti.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        checkBoxContanti.setBounds(27, 69, 117, 23);
        panelTipoPagamento.add(checkBoxContanti);
        
        checkBoxCarta = new JCheckBox("Carta di Credito");
        checkBoxCarta.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        checkBoxCarta.setBounds(189, 69, 175, 23);
        panelTipoPagamento.add(checkBoxCarta);
        
        JButton btnPaga = new JButton("Paga");
        btnPaga.setIcon(new ImageIcon(CassaPanel.class.getResource("/IconCassaFrame/iconPaga.png")));

	        btnPaga.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	    
	        		
	        		try {
	            		String pagamentoType= " ";
		        		if (checkBoxCarta.isSelected())
		        			pagamentoType = "Carta";
		        		else if (checkBoxContanti.isSelected()) 
		        			pagamentoType = "Contanti";
		        			
		        		float tot = Float.parseFloat(setTotale());
		        		float rest = Float.parseFloat(setResto());
						
		        		controller.aggiungiOrdine(pagamentoType,tot, pagamentoVersato,rest );
						
						
		        		
		        		
						JOptionPane.showMessageDialog(null, "Pagamento effetuato");
						//controller.GoToMainFrame(cassaFrame);
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Tipo pagamento non valido", "Errore", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
	        		tipoPagamento();
	        		
	        	}
	        });
	        btnPaga.setBounds(133, 152, 175, 38);
	        panelTipoPagamento.add(btnPaga);
        
        JLabel IconContanti = new JLabel(" ");
        IconContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/IconCassaFrame/icons8-contanti-40.png")));
        IconContanti.setBounds(63, 100, 48, 30);
        panelTipoPagamento.add(IconContanti);
        
        JLabel IconcCartaCredito = new JLabel("");
        IconcCartaCredito.setIcon(new ImageIcon(CassaPanel.class.getResource("/IconCassaFrame/icons8-visa-40.png")));
        IconcCartaCredito.setBounds(260, 99, 48, 31);
        panelTipoPagamento.add(IconcCartaCredito);
        
        
        JPanel panelDati = new JPanel();
        panelDati.setLayout(null);
        
        JLabel lblTotale = new JLabel("Totale:  " +  setTotale());
        lblTotale.setBounds(10, 11, 206, 20);
        lblTotale.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        panelDati.add(lblTotale);
        
        JLabel lblPAgamento = new JLabel("Pagamento Versato:");
        lblPAgamento.setBounds(10, 70, 206, 32);
        lblPAgamento.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        panelDati.add(lblPAgamento);
        
        lblResto = new JLabel("Resto: ");
        lblResto.setBounds(10, 153, 189, 36);
        lblResto.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        panelDati.add(lblResto);
        
        modelPagamento = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
        JSpinner spinnerPagamento = new JSpinner(modelPagamento);
        spinnerPagamento.setBounds(226, 79, 50, 20);
        spinnerPagamento.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               tipoPagamento();
            }
        });
        panelDati.add(spinnerPagamento);
        
        JButton btnResto = new JButton("Calcola Resto");
        btnResto.setIcon(new ImageIcon(CassaPanel.class.getResource("/IconCassaFrame/icibResto.png")));
        btnResto.setBounds(283, 78, 143, 23);
        btnResto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tipoPagamento();
        		
        	}
        });
        panelDati.add(btnResto);
        
		

		
		ButtonGroup bg = new ButtonGroup();
		bg.add(checkBoxCarta);
		bg.add(checkBoxContanti);
		
	        JScrollPane scrollPane = new JScrollPane(innerPanel);
	        GroupLayout groupLayout = new GroupLayout(this);
	        groupLayout.setHorizontalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
	        			.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
	        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 581, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap())
	        );
	        groupLayout.setVerticalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
	        			.addGap(11))
	        );
	        GroupLayout gl_panel = new GroupLayout(panel);
	        gl_panel.setHorizontalGroup(
	        	gl_panel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panel.createSequentialGroup()
	        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
	        				.addComponent(lblCassa, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(panelTipoPagamento, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
	        				.addComponent(panelDati, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        			.addContainerGap(100, Short.MAX_VALUE))
	        );
	        gl_panel.setVerticalGroup(
	        	gl_panel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panel.createSequentialGroup()
	        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	        				.addComponent(lblCassa, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
	        				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
	        					.addGap(1)
	        					.addComponent(panelDati, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
	        					.addPreferredGap(ComponentPlacement.UNRELATED)
	        					.addComponent(panelTipoPagamento, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)))
	        			.addContainerGap())
	        );
	        panel.setLayout(gl_panel);
	        setLayout(groupLayout);
	}
	
	
	
		private String setTotale() {
			totale = controller.TotaleCassa();
			Float totaleWrapper = totale;
			return totaleWrapper.toString();
		}
		
		
		
		private String setResto() {
			pagamentoVersato =  Float.parseFloat(modelPagamento.getValue().toString());
			float resto = 0;
			resto = pagamentoVersato - totale;
			Float restoWrapper = resto;
			
			return restoWrapper.toString();
		}
		
		private void tipoPagamento() {
			if(checkBoxContanti.isSelected()) {
				lblResto.setText("Resto: " + setResto());
				lblResto.revalidate();
				lblResto.repaint();
			}
			else if(checkBoxCarta.isSelected()) {
				lblResto.setText("Resto: "+ 0);
			
			}
			else {
				JOptionPane.showMessageDialog(null, "Selezione un metodo di pagamento valido", "Errore", JOptionPane.ERROR_MESSAGE);
			}
		}
		private void AggiornaResto(){
			
		}
	
		
		public void AggiornaCassa() {
	        int i = 0;
	        innerPanel.removeAll();
			for (ComponetArticolo ca : controller.cassaList){
		

				innerConstraints.gridwidth =4;
	      
			
				
	         	innerConstraints.gridy = i++;
	            innerConstraints.gridx = GridBagConstraints.RELATIVE;
	           
	            innerLayout.setConstraints(ca, innerConstraints);
	            innerPanel.add(ca);
	           
	            
		    
			}
			
		}

}
