package GUI;



//TODO vedi register -> verify-Field


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.ArticoloDAO;
import Database.CassaDAO;
import Database.CommessoDAO;
import Database.MagazzinoDAO;
import Entita.Articolo;
import Entita.Cassa;
import Entita.Commesso;
import Entita.Magazzino;
import GUI.ComponetArticolo;

public class Controller {
	private static LoginFrame loginFrame;
	private  RegisterFrame registerFrame;
	private static  MainFrame mainFrame;
	public Cassa cassa;
	private MagazzinoFrame magazzinoFrame;
	
	private  ArticoloDAO articoloDao; 
	private   Magazzino magazzino;
	private   MagazzinoDAO magazzinoDao;
	private  CommessoDAO commessoDao;
	private CassaDAO cassaDao;
	public Commesso commesso;
    private ArrayList<Articolo> articoli;
   
	public ArrayList<ComponetArticolo> componetList;
	public ArrayList<ComponetArticolo> cassaList;
	private String selectItem ;
	private  DefaultTableModel tableMagazzino;
	private  DefaultTableModel tableCassa;
	
	
	
	public static void main (String[] args) {
		Controller controller = new Controller ();


		
		
		

//		
		loginFrame = new LoginFrame(controller);	
		loginFrame.setVisible(true);

		
	}
	
	public Controller() {
		selectItem = "all";
		articoli = new ArrayList<Articolo>();
		componetList = new ArrayList<ComponetArticolo>();
		cassaList = new ArrayList<ComponetArticolo>();
		articoloDao = new ArticoloDAO();
		commessoDao = new CommessoDAO();
		
		magazzino = new Magazzino();
		magazzinoDao = new MagazzinoDAO();
		magazzinoDao.fillMagazzino(magazzino.getArticolo());
		cassaDao = new CassaDAO();
		
		
		tableMagazzino = new DefaultTableModel( ) {
			@Override
			public Class<?> getColumnClass (int column){
				switch (column) {
				case 10 : return ImageIcon.class;
				default : return String.class;
				}
			}
		};
		
		tableCassa = new DefaultTableModel( );
		
		
		

	}
	
	public void GoToMainFrame (JFrame frame) {
		frame.dispose();
		mainFrame = new MainFrame(this);
		mainFrame.setVisible(true);
	}
	
	public void GoToLoginFrame(JFrame frame) {
		frame.dispose();
		loginFrame= new LoginFrame(this);
		loginFrame.setVisible(true);
		
	}
	
	
	
	public void GoToRegisterFrame() {
		loginFrame.dispose();
		registerFrame= new RegisterFrame(this);
		registerFrame.setVisible(true);
		
	}
	
	public void GoToProfilePanel() {
		mainFrame.showProfile();
	}
	
	public void GoToHomePanel() {
		mainFrame.showHome();
	}
	public void GoToCassaPanel() {
		mainFrame.showCassa();
	}
	

	
	public void Search(String id) {
		mainFrame.dispose();
		selectItem=id;
		mainFrame = new MainFrame(this);
		mainFrame.setVisible(true);
	
		

	}
	
	public void GoToAddArticolo() {
		magazzinoFrame = new MagazzinoFrame(this);
		magazzinoFrame.setVisible(true);
	
	}

	
	public void CreateUser(String nome,String cognome,String username,String password, 
							Date dataNascita, Image foto,String email) {
		commesso = new Commesso(nome,cognome,username,password,dataNascita,foto,email);
		
	}
	
	public boolean UsernameAlredyExists(String username) {
		
		return commessoDao.CheckUsername(username);
	}

	public DefaultTableModel FillTableMagazzinoModel(String id) {
		tableMagazzino.setRowCount(0);
		articoli.clear();
	
		
		String headers[] = {"Nome","id","Produttore","Taglia","Colore","Collezione","Disponibili","Prezzo","Genere","Categoria","Foto"};
		

		tableMagazzino.setColumnIdentifiers(headers);
		
		
		
		for (Articolo a : magazzinoDao.SearchByID(id))
			articoli.add(a);
		
	    for (int i = 0 ; i< articoli.size();i++) {
	  
	    
	    	ImageIcon img = new ImageIcon (articoli.get(i).getFoto().getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH));
	    	tableMagazzino.addRow(new Object[] {articoli.get(i).getNome() ,
	    									articoli.get(i).getId(),
	    									articoli.get(i).getProduttore(),
	    									articoli.get(i).getTaglia(),
	    									articoli.get(i).getColore(),
	    									articoli.get(i).getCollezione(),
	    									articoli.get(i).getQuantita(),
	    									articoli.get(i).getPrezzo(),
	    									articoli.get(i).getGenere(),
	    									articoli.get(i).getCategoria(),									
	    									img
	    									});
	    }
	    selectItem= "all";
	    return tableMagazzino;
	    
	}
	
	public DefaultTableModel FillTableRecentiModel() {
		
		tableCassa.setRowCount(0);
		articoli.clear();
	
		
		String headers[] = {"Codice Ordine","Commesso","Tipo pagamento","Pagamento dovuto","Pagamento versato","Resto"};

		tableCassa.setColumnIdentifiers(headers);
		
		ArrayList<Cassa> recentiList = new ArrayList<Cassa>();
		
		for (Cassa c : cassaDao.getOrdini()) {
			recentiList.add(c);
			
		}
		
	    for (int i = 0 ; i< recentiList.size();i++) {
	    	
	    	
	    	tableCassa.addRow(new Object[] {
	    									recentiList.get(i).getNumeroOrdine(),
	    									recentiList.get(i).getUsernameCommesso(),
	    									recentiList.get(i).getPagamentoType(),
	    									recentiList.get(i).getPagamentoDovuto(),
	    									recentiList.get(i).getPagamentoVersato(),
	    									recentiList.get(i).getResto()
	    									
	    									});
	    }
	    return tableCassa;
		
	}
	
	//DATABASE
	public void CreateAccount(String nome,String cognome,String username,char[] password,Calendar date,File fotoFile,String email) throws FileNotFoundException {
		
		String s = String.copyValueOf(password);
		commessoDao.AddUser(nome, cognome,username, s, date, fotoFile, email);
		
	}

	
	public boolean LogIn(String username, char[] password) throws SQLException, IOException  {
		
		String s = String.copyValueOf(password);
		return commessoDao.LogInUser(username, s,this);
	}
	
	public DefaultTableModel  AddArticolo(String nome,String id, String produttore, String taglia, String colore, String collezione, int quantita, float prezzo,String genere,String categoria,File foto) throws FileNotFoundException, SQLException {
		
		articoloDao.InsertArticolo(nome,id, produttore, taglia, colore, collezione, quantita, prezzo, genere,categoria,foto);
		tableMagazzino = FillTableMagazzinoModel(selectItem);
		
		
		selectItem="all";
		
		Image image;
		try {
			image = ImageIO.read(foto);
			
			mainFrame.AggiornaHome();
			mainFrame.revalidate();
			mainFrame.repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
		return tableMagazzino;
		
		
	}
	

	public DefaultTableModel RemoveArticolo(String id) {
		
		articoloDao.DeleteArticolo(id);
	
		tableMagazzino = FillTableMagazzinoModel(selectItem);
		selectItem="all";
		mainFrame.AggiornaHome();
		mainFrame.revalidate();
		mainFrame.repaint();
		return tableMagazzino;
	}
	
	public void aggiungiOrdine(String pagamentoType, float pagamentoDovuto, float pagamentoVersato,float resto) throws SQLException {
		cassaDao.insertOrdine(pagamentoType, pagamentoDovuto, pagamentoVersato, resto,commesso.getUsername());
		
	}
	
	public void CloseAll() {
		for(ComponetArticolo c : cassaList)
			magazzinoDao.AddToMagazzino(c.getId(), c.getQuantita());
		System.exit(0);
	}
	



	public void RemoveFromCassa(String id,int quantita) {
		
	
		 
		
		 for (int i = 0 ;  i<cassaList.size() ; i++) {

			 if (cassaList.get(i).getId().equals(id)) {
				 magazzinoDao.AddToMagazzino(id, quantita);
				 if (cassaList.get(i).getQuantita() == quantita)
					 cassaList.remove(i);
				 else {
					 cassaList.get(i).setQuantita( cassaList.get(i).getQuantita()-quantita);
					 
				 }
			 }
			
			
			 
		 }
		 mainFrame.AggiornaCassa();
		 mainFrame.revalidate();
		 mainFrame.repaint();
//		
//		cassaFrame = new CassaFrame(this);
//		cassaFrame.setVisible(true);
	}
	
	public ArrayList<ComponetArticolo> FillComponentList(){
		 componetList.clear();
		
		 
		 for (Articolo a : magazzinoDao.SearchByID(selectItem))
			 	componetList.add(new ComponetArticolo(a.getFoto(),a.getNome(),a.getId(),a.getPrezzo(),a.getQuantita(),this,0));
		 return componetList;
	}
	
	
	
	
	public void FillCassaList(String id , int quantita){
		
		magazzinoDao.fillMagazzino(magazzino.getArticolo());
		if ( !FindInCassaList(id, quantita)) { 
			for (int i = 0; i < magazzino.getArticolo().size(); i++) {

				if (magazzino.getArticolo().get(i).getId().equals(id)) {

					cassaList.add(new ComponetArticolo(magazzino.getArticolo().get(i).getFoto(),
							magazzino.getArticolo().get(i).getNome(), magazzino.getArticolo().get(i).getId(),
							magazzino.getArticolo().get(i).getPrezzo(), quantita, this, 1));

					

				}

			} 
		}
		magazzinoDao.RemoveFromMagazzino(id, quantita);
		mainFrame.AggiornaHome();
		mainFrame.AggiornaCassa();
		mainFrame.revalidate();
		mainFrame.repaint();
		
	}
	

	
	public float TotaleCassa() {
		float totale = 0;
		
		 for (ComponetArticolo c : cassaList) {
			totale+=c.getPrezzo()*c.getQuantita();
		}
		return totale;
	}
	

	
	private boolean  FindInCassaList(String id, int quantita) {
		for (ComponetArticolo c : cassaList)
			if(c.getId().equals(id)) {
				c.setQuantita( c.getQuantita() + quantita);

				return true;
			}
		return false;
	}
	


}

