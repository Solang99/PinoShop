package GUI;

import java.awt.Image;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private UtenteFrame profileFrame;
	public Cassa cassa;
	private MagazzinoFrame magazzinoFrame;
	private CassaFrame cassaFrame;
	private  ArticoloDAO articoloDao; 
	private   Magazzino magazzino;
	private   MagazzinoDAO magazzinoDao;
	private  CommessoDAO commessoDao;
	private CassaDAO cassaDao;
	public Commesso commesso;
    private ArrayList<Articolo> articoli;
    private int position = -1;
	public ArrayList<ComponetArticolo> componetList;
	public ArrayList<ComponetArticolo> cassaList;
	private String selectItem ;
	static DefaultTableModel tableModel;
	
	
	
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
		cassaDao = new CassaDAO();
		
		
		tableModel = new DefaultTableModel( ) {
			@Override
			public Class<?> getColumnClass (int column){
				switch (column) {
				case 10 : return ImageIcon.class;
				default : return String.class;
				}
			}
		};
		

	}
	
	public void GoToLoginFrame() {
		registerFrame.dispose();
		loginFrame= new LoginFrame(this);
		loginFrame.setVisible(true);
		
	}
	
	public void GoToRegisterFrame() {
		loginFrame.dispose();
		registerFrame= new RegisterFrame(this);
		registerFrame.setVisible(true);
		
	}
	
	public void GoToProfileFrame(JFrame frame) {
		frame.dispose();
		profileFrame= new UtenteFrame(this);
		profileFrame.setVisible(true);
	}
	
	public void GoToMainFrame(JFrame frame) {
		frame.dispose();
	
	
		mainFrame = new MainFrame(this);
		mainFrame.setVisible(true);
	}
	
	public void Search(String id) {
		mainFrame.dispose();
		selectItem=id;
	
	//	mainFrame = new MainFrame(this,fotoList, nomiList,idList,prezzoList);
		mainFrame.setVisible(true);

	}
	
	public void GoToAddArticolo() {
		magazzinoFrame = new MagazzinoFrame(this);
		magazzinoFrame.setVisible(true);
	
	}
	
	public void GoToCassaFrame() {
	
		
		cassaFrame = new CassaFrame(this);
		cassaFrame.setVisible(true);
	}
	
	public void CreateUser(String nome,String cognome,String username,String password, 
							Date dataNascita, Image foto,String email) {
		commesso = new Commesso(nome,cognome,username,password,dataNascita,foto,email);
		
	}
	
	public boolean UsernameAlredyExists(String username) {
		
		return commessoDao.CheckUsername(username);
	}

	public DefaultTableModel FillTableModel(String id) {
		tableModel.setRowCount(0);
		articoli.clear();
	
		
		String headers[] = {"Nome","id","Produttore","Taglia","Colore","Collezione","Disponibili","Prezzo","Genere","Categoria","Foto"};
		

		tableModel.setColumnIdentifiers(headers);
		
		
		
		for (Articolo a : magazzinoDao.SearchByID(id))
			articoli.add(a);
		
	    for (int i = 0 ; i< articoli.size();i++) {
	  
	    
	    	ImageIcon img = new ImageIcon (articoli.get(i).getFoto().getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH));
	    	tableModel.addRow(new Object[] {articoli.get(i).getNome() ,
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
	   
	    return tableModel;
	    
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
		tableModel = FillTableModel(selectItem);
		return tableModel;
		
	}
	

	public DefaultTableModel RemoveArticolo(String id) {
		
		articoloDao.DeleteArticolo(id);
	
		tableModel = FillTableModel(selectItem);
		return tableModel;
	}
	
	public void aggiungiOrdine(String pagamentoType, float pagamentoDovuto, float pagamentoVersato,float resto) throws SQLException {
		cassaDao.insertOrdine(pagamentoType, pagamentoDovuto, pagamentoVersato, resto);
		
	}
	
	public void FiltrByID(String id) {
		magazzinoDao.SearchByID(id);
	}
	



	public void RemoveFromCassa(String id,int quantita) {
		
	
		 magazzinoDao.fillMagazzino(magazzino.getArticolo());
		
		 for (int i = 0 ;  i<cassaList.size() ; i++) {

			 if (cassaList.get(i).getId().equals(id)) {
				 if (cassaList.get(i).getQuantita() == quantita)
					 cassaList.remove(i);
				 else {
					 cassaList.get(i).setQuantita( cassaList.get(i).getQuantita()-quantita);
					 
				 }
			 }
			
			
			 
		 }
		 
		cassaFrame.dispose();
		cassaFrame = new CassaFrame(this);
		cassaFrame.setVisible(true);
	}
	
	public ArrayList<ComponetArticolo> FillComponentList(){
		 componetList.clear();
		 magazzinoDao.fillMagazzino(magazzino.getArticolo());

		 for (Articolo a : magazzino.getArticolo())
			 componetList.add(new ComponetArticolo(a.getFoto(),a.getNome(),a.getId(),a.getPrezzo(),0,this,0));
		 return componetList;
	}
	
	
	
	
	public ArrayList<ComponetArticolo> FillCassaList(String id , int quantia){
		 magazzinoDao.fillMagazzino(magazzino.getArticolo());
		 for (int i = 0; i<magazzino.getArticolo().size();i++) {
			 if (magazzino.getArticolo().get(i).getId().equals(id)) {
			 	cassaList.add(new ComponetArticolo(magazzino.getArticolo().get(i).getFoto(),
			 			magazzino.getArticolo().get(i).getNome(),magazzino.getArticolo().get(i).getId(),
			 			magazzino.getArticolo().get(i).getPrezzo(),quantia,this,1));
			 	
			 	magazzino.getArticolo().get(i).setQuantita(magazzino.getArticolo().get(i).getQuantita()-quantia);
			 	
			 	
			 }
		 }

		 
		 return cassaList;
	}
	

	
	public float TotaleCassa() {
		float totale = 0;
		
		 for (ComponetArticolo c : cassaList) {
			totale+=c.getPrezzo()*c.getQuantita();
		}
		return totale;
	}
	
	
	
	
	
	
	private void FindInMagazzino(String id) {
		
		 magazzinoDao.fillMagazzino(magazzino.getArticolo());
		 for (int i = magazzino.getArticolo().size()-1; i>0;i--) {
			 if (magazzino.getArticolo().get(i).getId().equals(id))
			 	position = i;
		 }
		
	}
	


}

