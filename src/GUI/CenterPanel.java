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
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;

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

        innerConstraints.gridy = 0;

        innerConstraints.insets = new Insets(5, 5, 5, 5);
        
        ArrayList<ComponetArticolo> component = controller.FillComponentList();
        
		for (int i = component.size()-1; i >= 0;i--) {

			innerConstraints.anchor = GridBagConstraints.FIRST_LINE_START;

			if( i%4 == 0)
            	 innerConstraints.gridy =i;
            innerConstraints.gridx = GridBagConstraints.RELATIVE;
          
            innerLayout.setConstraints(component.get(i), innerConstraints);
            innerPanel.add(component.get(i));
            
            
	    
		}
		
		
        JScrollPane scrollPanel = new JScrollPane(innerPanel);
        add(scrollPanel, BorderLayout.CENTER);
	
	
	}
}
