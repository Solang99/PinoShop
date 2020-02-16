package GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Cursor;

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
    private JScrollPane scrollPane ;
    private  int componetPerLine;
    
	public CassaPanel(Controller ctrl) {

		componetPerLine =1;
		controller = ctrl;
		
		setBorder(null);
	
		setBounds(0, 144, 906, 541);
		
		

	    innerLayout = new GridBagLayout();
	    innerConstraints = new GridBagConstraints();
	    innerPanel = new JPanel(innerLayout);
	    
	    innerConstraints.weightx = 0.0;
	    innerConstraints.weighty = 0.0;
	    innerConstraints.gridy = 0;
  
    

		

        
        JPanel panel = new JPanel();
        
        JLabel lblCassa = new JLabel("Cassa");
        lblCassa.setFont(new Font("Segoe Print", Font.PLAIN, 33));
        
        
        JPanel panelTipoPagamento = new JPanel();
        
        JLabel lblTipoPagamento = new JLabel("Tipo di Pagamento:");
        lblTipoPagamento.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        lblTipoPagamento.setBounds(33, 11, 199, 30);
        
        checkBoxContanti = new JCheckBox("Contanti");
        checkBoxContanti.setFont(new Font("Segoe Print", Font.PLAIN, 25));
        
        checkBoxCarta = new JCheckBox("Carta di Credito");
        checkBoxCarta.setFont(new Font("Segoe Print", Font.PLAIN, 25));
        
        JButton btnPaga = new JButton("Paga");
        btnPaga.setBorderPainted(false);
        btnPaga.setFont(new Font("Segoe Print", Font.PLAIN, 25));
        btnPaga.setForeground(Color.WHITE);
        btnPaga.setBackground(new Color (98, 156, 133));
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
	        	
	        				
	        	
	       
	        		
	        	}
	        	@Override
	        	public void mouseEntered(MouseEvent e) {
	        	       btnPaga.setBackground(new Color (238,232,170));
	        	       btnPaga.setForeground(Color.BLACK);
	        	       btnPaga.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        	}
	        	@Override
	        	public void mouseExited(MouseEvent e) {
	        	    btnPaga.setBackground(new Color (98, 156, 133));
	        	    btnPaga.setForeground(Color.WHITE);
	        		
	        	}
	        });
        
        JLabel IconContanti = new JLabel(" ");
        IconContanti.setIcon(new ImageIcon(CassaPanel.class.getResource("/IconCassaFrame/icons8-contanti-40.png")));
        
        JLabel IconcCartaCredito = new JLabel("");
        IconcCartaCredito.setIcon(new ImageIcon(CassaPanel.class.getResource("/IconCassaFrame/icons8-visa-40.png")));
        
        
        JPanel panelDati = new JPanel();
        
        JLabel lblTotale = new JLabel("Totale:  " +  setTotale());
        lblTotale.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        
        JLabel lblPAgamento = new JLabel("Pagamento Versato:");
        lblPAgamento.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        
        lblResto = new JLabel("Resto: ");
        lblResto.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        
        modelPagamento = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
        JSpinner spinnerPagamento = new JSpinner(modelPagamento);
        spinnerPagamento.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               tipoPagamento();
            }
        });
        
		

		
		ButtonGroup bg = new ButtonGroup();
		bg.add(checkBoxCarta);
		bg.add(checkBoxContanti);
		
	        scrollPane = new JScrollPane(innerPanel);
	        GroupLayout groupLayout = new GroupLayout(this);
	        groupLayout.setHorizontalGroup(
	        	groupLayout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
	        			.addGap(49)
	        			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
	        			.addContainerGap())
	        );
	        groupLayout.setVerticalGroup(
	        	groupLayout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
	        			.addGap(11))
	        		.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
	        );
	        GroupLayout gl_panel = new GroupLayout(panel);
	        gl_panel.setHorizontalGroup(
	        	gl_panel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panel.createSequentialGroup()
	        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	        				.addComponent(lblCassa, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(panelTipoPagamento, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
	        				.addComponent(panelDati, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        			.addGap(53))
	        );
	        gl_panel.setVerticalGroup(
	        	gl_panel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panel.createSequentialGroup()
	        			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
	        				.addComponent(lblCassa, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
	        				.addGroup(gl_panel.createSequentialGroup()
	        					.addGap(1)
	        					.addComponent(panelDati, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
	        					.addPreferredGap(ComponentPlacement.UNRELATED)
	        					.addComponent(panelTipoPagamento, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
	        			.addContainerGap())
	        );
	        GroupLayout gl_panelDati = new GroupLayout(panelDati);
	        gl_panelDati.setHorizontalGroup(
	        	gl_panelDati.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panelDati.createSequentialGroup()
	        			.addGap(10)
	        			.addGroup(gl_panelDati.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_panelDati.createSequentialGroup()
	        					.addComponent(lblTotale, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
	        					.addGap(60))
	        				.addGroup(gl_panelDati.createSequentialGroup()
	        					.addComponent(lblPAgamento, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
	        					.addGap(10)
	        					.addComponent(spinnerPagamento, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
	        				.addGroup(gl_panelDati.createSequentialGroup()
	        					.addComponent(lblResto, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
	        					.addGap(77)))
	        			.addGap(252))
	        );
	        gl_panelDati.setVerticalGroup(
	        	gl_panelDati.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panelDati.createSequentialGroup()
	        			.addGap(11)
	        			.addComponent(lblTotale, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
	        			.addGap(39)
	        			.addGroup(gl_panelDati.createParallelGroup(Alignment.LEADING)
	        				.addComponent(lblPAgamento, GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
	        				.addGroup(gl_panelDati.createSequentialGroup()
	        					.addGap(9)
	        					.addComponent(spinnerPagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	        			.addGap(51)
	        			.addComponent(lblResto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        			.addGap(81))
	        );
	        panelDati.setLayout(gl_panelDati);
	        GroupLayout gl_panelTipoPagamento = new GroupLayout(panelTipoPagamento);
	        gl_panelTipoPagamento.setHorizontalGroup(
	        	gl_panelTipoPagamento.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panelTipoPagamento.createSequentialGroup()
	        			.addGap(32)
	        			.addGroup(gl_panelTipoPagamento.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_panelTipoPagamento.createSequentialGroup()
	        					.addComponent(checkBoxContanti, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
	        					.addGap(36)
	        					.addComponent(checkBoxCarta))
	        				.addGroup(gl_panelTipoPagamento.createSequentialGroup()
	        					.addGap(70)
	        					.addComponent(IconContanti, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
	        					.addGap(227)
	        					.addComponent(IconcCartaCredito, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
	        			.addContainerGap())
	        		.addGroup(gl_panelTipoPagamento.createSequentialGroup()
	        			.addGap(150)
	        			.addComponent(btnPaga, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
	        			.addGap(203))
	        );
	        gl_panelTipoPagamento.setVerticalGroup(
	        	gl_panelTipoPagamento.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_panelTipoPagamento.createSequentialGroup()
	        			.addGap(49)
	        			.addGroup(gl_panelTipoPagamento.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(checkBoxContanti, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
	        				.addComponent(checkBoxCarta, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
	        			.addGap(8)
	        			.addGroup(gl_panelTipoPagamento.createParallelGroup(Alignment.LEADING)
	        				.addComponent(IconContanti, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(IconcCartaCredito, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
	        			.addGap(60)
	        			.addComponent(btnPaga, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap())
	        );
	        panelTipoPagamento.setLayout(gl_panelTipoPagamento);
	        panel.setLayout(gl_panel);
	        setLayout(groupLayout);
	}
	
	
	
		private String setTotale() {
			totale = controller.totaleCassa();
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

	
		
		public void aggiornaCassa() {
	  

	        innerPanel.removeAll();
	        ArrayList<ComponentArticolo> cassaComponet = controller.cassaList;
			for ( int i = cassaComponet.size()-1; i >= 0;i--) {
				
				innerConstraints.gridwidth =4;
				
				if( i%componetPerLine == 0)
	            	 innerConstraints.gridy =i;
	            innerConstraints.gridx = GridBagConstraints.RELATIVE;
	          
	            innerLayout.setConstraints(cassaComponet.get(i), innerConstraints);
	            innerPanel.add(cassaComponet.get(i));
	            
	            
		    
			}
			
		}
		
		public void setComponetPerLine(boolean isMax , int min , int max) {
			if (isMax)
				this.componetPerLine = max;
			else
				this.componetPerLine = min;
			aggiornaCassa();
			
		}

}
