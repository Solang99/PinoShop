package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JLabel;
import java.awt.FlowLayout;

import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.GridBagLayout;

import java.awt.GridBagConstraints;

import java.awt.Dimension;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CenterPanel extends JPanel {


	private final JPanel panel = new JPanel();
	private JTextField txtCerca;
	private JPanel innerPanel;

	private GridBagConstraints innerConstraints;
	private GridBagLayout innerLayout;
	private Controller controller;
	
	
	public CenterPanel(Controller ctrl) {
		controller = ctrl;
		setBorder(null);
		setSize(514, 298);
	//	setBounds(0, 144, 906, 541);
		
	
        innerLayout = new GridBagLayout();
        innerConstraints = new GridBagConstraints();
        innerPanel = new JPanel(innerLayout);

        innerConstraints.gridy = 0;

        innerConstraints.insets = new Insets(5, 5, 5, 5);
        
        ArrayList<ComponetArticolo> component = controller.FillComponentList();
       
		for ( int i = component.size()-1; i >= 0;i--) {

			innerConstraints.anchor = GridBagConstraints.FIRST_LINE_START;

			if( i%4 == 0)
            	 innerConstraints.gridy =i;
            innerConstraints.gridx = GridBagConstraints.RELATIVE;
          
            innerLayout.setConstraints(component.get(i), innerConstraints);
            innerPanel.add(component.get(i));
            
            
	    
		}
		
		
        JScrollPane scrollPanel = new JScrollPane(innerPanel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JPanel panel_1 = new JPanel();
        panel_1.setPreferredSize(new Dimension(400, 50));
        panel.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblCerca = new JLabel("Cerca");
        
        lblCerca.setFont(new Font("Segoe Print", Font.PLAIN, 24));
        panel_1.add(lblCerca);
        
        txtCerca = new JTextField();
        txtCerca.setColumns(20);
        panel_1.add(txtCerca);
        
        JButton btnCerca = new JButton();
        btnCerca.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCerca.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		controller.Search(txtCerca.getText());
        	}
        });
        btnCerca.setOpaque(false);
        btnCerca.setContentAreaFilled(false);
        btnCerca.setBorderPainted(false);
		btnCerca.setPreferredSize(new Dimension(50, 50));
        ImageIcon searchIcon =   new ImageIcon(CenterPanel.class.getResource("/IconTopPanel/Group 1.png"));
        btnCerca.setIcon(new ImageIcon(searchIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
     
      
        panel_1.add(btnCerca);
        
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        		.addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(481, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(59)
        			.addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
        );
        setLayout(groupLayout);
	
	
	}
	
	public void AggiornaHome() {
        ArrayList<ComponetArticolo> component = controller.FillComponentList();
        innerPanel.removeAll();
		for ( int i = component.size()-1; i >= 0;i--) {

			innerConstraints.anchor = GridBagConstraints.FIRST_LINE_START;

			if( i%4 == 0)
            	 innerConstraints.gridy =i;
            innerConstraints.gridx = GridBagConstraints.RELATIVE;
          
            innerLayout.setConstraints(component.get(i), innerConstraints);
            innerPanel.add(component.get(i));
            
            
	    
		}
	}
}
