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
import Database.CommessoDAO;
import Database.MagazzinoDAO;
import Entita.Articolo;
import Entita.Cassa;
import Entita.Commesso;
import Entita.Magazzino;

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
	public Commesso commesso;
    private ArrayList<Articolo> articoli;
    private ArrayList<String> nomiList ;
    private ArrayList<String> idList ;
    private ArrayList<Float> prezzoList ;
	private ArrayList<Image> fotoList;
	private String selectItem ;
	static DefaultTableModel tableModel;
	
	
	
	public static void main (String[] args) {
		Controller controller = new Controller ();


		
//		mainFrame = new MainFrame(controller);
//		mainFrame.setVisible(true);
		

		
		loginFrame = new LoginFrame(controller);
	    loginFrame.setVisible(true);

		
	}
	
	public Controller() {
		selectItem = "all";
		articoli = new ArrayList<Articolo>();
		
		articoloDao = new ArticoloDAO();
		commessoDao = new CommessoDAO();
		
		magazzino = new Magazzino();
		magazzinoDao = new MagazzinoDAO();
		
		
		tableModel = new DefaultTableModel( );
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
		nomiList = new ArrayList<String>();
		fotoList = new ArrayList<Image>();
		idList = new ArrayList<String>();
		prezzoList = new ArrayList<Float>();
		fillArrayList(selectItem);
		mainFrame = new MainFrame(this,fotoList, nomiList,idList,prezzoList);
		mainFrame.setVisible(true);
	}
	
	public void Search(String id) {
		mainFrame.dispose();
		selectItem=id;
		fillArrayList(selectItem);
		nomiList = new ArrayList<String>();
		fotoList = new ArrayList<Image>();
		idList = new ArrayList<String>();
		prezzoList = new ArrayList<Float>();
		fillArrayList(selectItem);
		mainFrame = new MainFrame(this,fotoList, nomiList,idList,prezzoList);
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
		//magazzinoDao.fillMagazzino(magazzino.getArticolo());
		
		String headers[] = {"Nome","id","Produttore","Taglia","Colore","Collezione","Disponibili","Prezzo","Genere","Categoria","Foto"};
		

		tableModel.setColumnIdentifiers(headers);
		
		
		
		for (Articolo a : magazzinoDao.SearchByID(id))
			articoli.add(a);
		
	    for (int i = 0 ; i< articoli.size();i++) {
	    	JLabel lbl = new JLabel ();
	    	lbl.setIcon(new ImageIcon (articoli.get(i).getFoto().getScaledInstance(80, 80,  java.awt.Image.SCALE_SMOOTH)));
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
	    									lbl
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
		
		articoloDao.InserArticolo(nome,id, produttore, taglia, colore, collezione, quantita, prezzo, genere,categoria,foto);
		tableModel = FillTableModel(selectItem);
		return tableModel;
		
	}
	

	public DefaultTableModel RemoveArticolo(String id) {
		
		articoloDao.DeleteArticolo(id);
	
		tableModel = FillTableModel(selectItem);
		return tableModel;
	}
	
	public void FiltrByID(String id) {
		magazzinoDao.SearchByID(id);
	}
	
	private void fillArrayList(String id) {
	
	
		for (Articolo a : magazzinoDao.SearchByID(id)) {
			nomiList.add(a.getNome());
			fotoList.add(a.getFoto());
			idList.add(a.getId());
			prezzoList.add(a.getPrezzo());
			
		}

	}


}
