package GUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.Color;


public class CenterPanel extends JPanel {

	private DefaultTableModel tableModel;

	/**
	 * Create the panel.
	 */
	public CenterPanel(Controller controller) {
		setBorder(null);
		setSize(514, 298);
		setBounds(0, 144, 906, 541);
		setLayout(new BorderLayout(0, 0));
		
	
        GridBagLayout innerLayout = new GridBagLayout();
        GridBagConstraints innerConstraints = new GridBagConstraints();
        JPanel innerPanel = new JPanel(innerLayout);
        
        innerConstraints.weightx = 0.0;
        innerConstraints.weighty = 0.0;
        innerConstraints.gridy = 0;
		
        ArrayList<ComponetArticolo> component = controller.FillComponentList();
        int i = 0;
		for (ComponetArticolo ca : component){
			

            innerConstraints.weightx = 0.5;
            innerConstraints.weighty = 0.2;
            innerConstraints.fill = GridBagConstraints.HORIZONTAL;
			innerConstraints.gridwidth =4;
            //innerConstraints.gridy = i + 1;
			if( i%3 == 0)
            	 innerConstraints.gridy = i++;
            innerConstraints.gridx = GridBagConstraints.RELATIVE;
           
            innerLayout.setConstraints(ca, innerConstraints);
            innerPanel.add(ca);
            
            
	    
		}
		
		
        JScrollPane scrollPanel = new JScrollPane(innerPanel);
        add(scrollPanel, BorderLayout.CENTER);
	
		//scrollPane.setViewportView(table);
	}
}
