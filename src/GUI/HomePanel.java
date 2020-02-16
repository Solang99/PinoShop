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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class HomePanel extends JPanel {


	private final JPanel topPanel = new JPanel();
	private JTextField txtCerca;
	private JPanel innerPanel;

	private GridBagConstraints innerConstraints;
	private GridBagLayout innerLayout;
	private Controller controller;
	private int componetPerLine;
	
	public HomePanel(Controller ctrl) {
		componetPerLine =4;
		controller = ctrl;
		setBorder(null);

	
	
        innerLayout = new GridBagLayout();
        innerConstraints = new GridBagConstraints();
        innerPanel = new JPanel(innerLayout);

        innerConstraints.gridy = 0;

        innerConstraints.insets = new Insets(5, 5, 5, 5);
        
//        ArrayList<ComponetArticolo> component = controller.FillComponentList();
//       
//		for ( int i = component.size()-1; i >= 0;i--) {
//
//			innerConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
//
//			if( i%4 == 0)
//            	 innerConstraints.gridy =i;
//            innerConstraints.gridx = GridBagConstraints.RELATIVE;
//          
//            innerLayout.setConstraints(component.get(i), innerConstraints);
//            innerPanel.add(component.get(i));
//            
//            
//	    
//		}
		aggiornaHome();
		
        JScrollPane scrollPanel = new JScrollPane(innerPanel);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JPanel centerPanel = new JPanel();
        centerPanel.setPreferredSize(new Dimension(400, 50));
        topPanel.add(centerPanel);
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblCerca = new JLabel("Cerca");
        
        lblCerca.setFont(new Font("Segoe Print", Font.PLAIN, 24));
        centerPanel.add(lblCerca);
        
        txtCerca = new JTextField();
        txtCerca.setToolTipText("Digita \"all\" per azzerare i filtri");
        txtCerca.setColumns(20);
        centerPanel.add(txtCerca);
        
        JButton btnCerca = new JButton();
  
        btnCerca.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		controller.search(txtCerca.getText());
        	}
        });
        btnCerca.setOpaque(false);
        btnCerca.setContentAreaFilled(false);
        btnCerca.setBorderPainted(false);
		btnCerca.setPreferredSize(new Dimension(50, 50));
        ImageIcon searchIcon =   new ImageIcon(HomePanel.class.getResource("/IconTopPanel/Group 1.png"));
        btnCerca.setIcon(new ImageIcon(searchIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
     
      
        centerPanel.add(btnCerca);
        
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(topPanel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        		.addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(240, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(59)
        			.addComponent(scrollPanel, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
        );
        setLayout(groupLayout);
	
	
	}
	
	public void aggiornaHome() {
		
        ArrayList<ComponentArticolo> component = controller.FillComponentList();
        innerPanel.removeAll();
		for ( int i = component.size()-1; i >= 0;i--) {

			innerConstraints.anchor = GridBagConstraints.FIRST_LINE_START;

			if( i%componetPerLine == 0)
            	 innerConstraints.gridy =i;
            innerConstraints.gridx = GridBagConstraints.RELATIVE;
          
            innerLayout.setConstraints(component.get(i), innerConstraints);
            innerPanel.add(component.get(i));
            
            
	    
		}
	}
	public void setComponetPerLine(boolean isMax , int min , int max) {
		if (isMax)
			this.componetPerLine = max;
		else
			this.componetPerLine = min;
		
		aggiornaHome();
		
	}

}
