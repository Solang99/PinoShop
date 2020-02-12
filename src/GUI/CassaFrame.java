package GUI;


import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


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

public class CassaFrame extends JFrame {
	
	private JPanel contentPane;
	
	private float totale;
	private float pagamentoVersato;
	
	private SpinnerNumberModel modelPagamento;
	private JCheckBox checkBoxCarta;
	private JCheckBox checkBoxContanti;
	private JLabel lblResto;
	private Controller controller;
	private TopPanel topPanel;
	private int mouseX;
	private int mouseY;
	
	public CassaFrame(Controller ctrl) {

		controller = ctrl;
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 648);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);

		topPanel = new TopPanel(controller,this);
		topPanel.setBounds(0, 0, 902, 133);
		topPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX= e.getX();
				mouseY = e.getY();
			}
		});
		topPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x =e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x-mouseX,y-mouseY);
			}
		});
		
		contentPane.add(topPanel);
	    GridBagLayout innerLayout = new GridBagLayout();
	    GridBagConstraints innerConstraints = new GridBagConstraints();
	    JPanel innerPanel = new JPanel(innerLayout);
	    
	    innerConstraints.weightx = 0.0;
	    innerConstraints.weighty = 0.0;
	    innerConstraints.gridy = 0;
  
    
       
        int i = 0;
		for (ComponetArticolo ca : controller.cassaList){
			

			innerConstraints.gridwidth =4;
      
		
			
         	innerConstraints.gridy = i++;
            innerConstraints.gridx = GridBagConstraints.RELATIVE;
           
            innerLayout.setConstraints(ca, innerConstraints);
            innerPanel.add(ca);
            
            
	    
		}
		
        contentPane.setLayout(null);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(255, 139, 475, 509);
        panel.setLayout(null);
        contentPane.add(panel);
        
        JLabel lblCassa = new JLabel("Cassa");
        lblCassa.setFont(new Font("Segoe Print", Font.PLAIN, 33));
        lblCassa.setBounds(41, 11, 96, 32);
        panel.add(lblCassa);
        
        JPanel panelTipoPagamento = new JPanel();
        panelTipoPagamento.setLayout(null);
        panelTipoPagamento.setBounds(57, 282, 396, 201);
        panel.add(panelTipoPagamento);
        
        JLabel lblTipoPagamento = new JLabel("Tipo di Pagamento:");
        lblTipoPagamento.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        lblTipoPagamento.setBounds(33, 11, 199, 30);
        panelTipoPagamento.add(lblTipoPagamento);
        
        checkBoxContanti = new JCheckBox("Contanti");
        checkBoxContanti.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        checkBoxContanti.setBounds(27, 69, 117, 23);
        panelTipoPagamento.add(checkBoxContanti);
        
        checkBoxCarta = new JCheckBox("Carta di Credito");
        checkBoxCarta.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        checkBoxCarta.setBounds(189, 69, 175, 23);
        panelTipoPagamento.add(checkBoxCarta);
        
        JLabel label_2 = new JLabel(" ");
        label_2.setIcon(new ImageIcon(CassaFrame.class.getResource("/IconCassaFrame/icons8-contanti-40.png")));
        label_2.setBounds(63, 100, 48, 30);
        panelTipoPagamento.add(label_2);
        
        JLabel label_3 = new JLabel("");
        label_3.setIcon(new ImageIcon(CassaFrame.class.getResource("/IconCassaFrame/icons8-visa-40.png")));
        label_3.setBounds(260, 99, 48, 31);
        panelTipoPagamento.add(label_3);
        
 
        
        JPanel panelDati = new JPanel();
        panelDati.setLayout(null);
        panelDati.setBounds(57, 71, 396, 200);
        panel.add(panelDati);
        
        JLabel lblTotale = new JLabel("Totale:  " +  setTotale());
        lblTotale.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        lblTotale.setBounds(10, 11, 206, 20);
        panelDati.add(lblTotale);
        
        JLabel lblPAgamento = new JLabel("Pagamento Versato:");
        lblPAgamento.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        lblPAgamento.setBounds(10, 70, 206, 32);
        panelDati.add(lblPAgamento);
        
        lblResto = new JLabel("Resto: ");
        lblResto.setFont(new Font("Segoe Print", Font.PLAIN, 20));
        lblResto.setBounds(10, 153, 189, 36);
        panelDati.add(lblResto);
        
        modelPagamento = new SpinnerNumberModel(0.0, 0.0, 1000.0, 0.5);
        JSpinner spinnerPagamento = new JSpinner(modelPagamento);
        spinnerPagamento.setBounds(226, 79, 50, 20);
        panelDati.add(spinnerPagamento);
        
        JButton button = new JButton("Calcola Resto");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tipoPagamento();
        		
        	}
        });
        button.setBounds(283, 78, 89, 23);
        panelDati.add(button);
        
		

		
		ButtonGroup bg = new ButtonGroup();
		bg.add(checkBoxCarta);
		bg.add(checkBoxContanti);
		
		JFrame cassaFrame = this;
	    JButton btnNewButton = new JButton("Paga");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
	    	}
	    });
	        btnNewButton.addMouseListener(new MouseAdapter() {
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
						controller.GoToMainFrame(cassaFrame);
						
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Tipo pagamento non valido", "Errore", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
	        		tipoPagamento();
	        		
	        	}
	        });
	        btnNewButton.setBounds(146, 152, 89, 23);
	        panelTipoPagamento.add(btnNewButton);
	        
	        JScrollPane scrollPane = new JScrollPane(innerPanel);
	        scrollPane.setBounds(10, 144, 240, 504);
	        contentPane.add(scrollPane);
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
}