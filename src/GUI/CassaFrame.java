package GUI;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JList;

public class CassaFrame extends JFrame {

	private JPanel contentPane;
	private Controller controller;


	public CassaFrame(Controller ctrl) {
		controller = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 701, 544);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCassa = new JLabel("Cassa");
		lblCassa.setFont(new Font("Segoe Print", Font.PLAIN, 33));
		lblCassa.setBounds(288, 11, 96, 32);
		panel.add(lblCassa);
		
		JPanel panelScelta = new JPanel();
		panelScelta.setBounds(305, 278, 396, 201);
		panel.add(panelScelta);
		panelScelta.setLayout(null);
		
		JLabel lblTipoPagamento = new JLabel("Tipo di Pagamento:");
		lblTipoPagamento.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblTipoPagamento.setBounds(33, 11, 199, 30);
		panelScelta.add(lblTipoPagamento);
		
		
		JCheckBox ckContanti = new JCheckBox("Contanti");
		ckContanti.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		ckContanti.setBounds(27, 69, 117, 23);
		panelScelta.add(ckContanti);
		
		JCheckBox ckCartadiCredito = new JCheckBox("Carta di Credito");
		ckCartadiCredito.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		ckCartadiCredito.setBounds(189, 69, 175, 23);
		panelScelta.add(ckCartadiCredito);
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setIcon(new ImageIcon(CassaFrame.class.getResource("/IconCassaFrame/icons8-contanti-40.png")));
		lblNewLabel_5.setBounds(63, 100, 48, 30);
		panelScelta.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(CassaFrame.class.getResource("/IconCassaFrame/icons8-visa-40.png")));
		lblNewLabel_6.setBounds(260, 99, 48, 31);
		panelScelta.add(lblNewLabel_6);
		
		JPanel panelDati = new JPanel();
		panelDati.setBounds(305, 67, 396, 200);
		panel.add(panelDati);
		panelDati.setLayout(null);
		
		JLabel lblTotale = new JLabel("Totale:");
		lblTotale.setBounds(10, 11, 88, 20);
		panelDati.add(lblTotale);
		lblTotale.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		JLabel lblPagamentoVersato = new JLabel("Pagamento Versato:");
		lblPagamentoVersato.setBounds(10, 70, 206, 32);
		panelDati.add(lblPagamentoVersato);
		lblPagamentoVersato.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		
		JLabel lblResto = new JLabel("Resto:");
		lblResto.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblResto.setBounds(10, 153, 72, 36);
		panelDati.add(lblResto);
		
		JSpinner spinnerPagamento = new JSpinner();
		spinnerPagamento.setBounds(226, 79, 50, 20);
		panelDati.add(spinnerPagamento);
		
		JLabel lblGetPrezzo = new JLabel("T");
		lblGetPrezzo.setBounds(108, 17, 57, 14);
		panelDati.add(lblGetPrezzo);
		
		JLabel lblGetResto = new JLabel("New label");
		lblGetResto.setBounds(89, 167, 76, 14);
		panelDati.add(lblGetResto);
		ButtonGroup bg = new ButtonGroup();
		bg.add(ckCartadiCredito);
		bg.add(ckContanti);
		
		JList list = new JList();
		list.setBounds(20, 478, 271, -410);
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 67, 268, 452);
		panel.add(panel_1);
		//list.setModel(controller.fillJlist());
		
	
	}
	public void getResto(){
		
	}
}
