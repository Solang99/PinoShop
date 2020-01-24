package GUI;

import java.awt.Image;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Database.ArticoloDAO;
import Database.CommessoDAO;
import Database.MagazzinoDAO;
import Entita.Articolo;
import Entita.Commesso;
import Entita.Magazzino;

public class Controller {
	private static LoginFrame loginFrame;
	private  RegisterFrame registerFrame;
	private static  MainFrame mainFrame;
	private UtenteFrame profileFrame;

	private MagazzinoFrame magazzinoFrame;
	private static ArticoloDAO articoloDao; 
	private static Magazzino magazzino;
	private static MagazzinoDAO magazzinoDao;
	private static  CommessoDAO commessoDao;
	public Commesso commesso;
	static ArrayList<Articolo> articoli;
	public static void main (String[] args) {
		Controller controller = new Controller ();

		articoloDao = new ArticoloDAO();
		commessoDao = new CommessoDAO();
		
		mainFrame = new MainFrame(controller);
		mainFrame.setVisible(true);
		
		magazzino = new Magazzino();
		magazzinoDao = new MagazzinoDAO();
		magazzinoDao.fillMagazzino(magazzino.getArticolo()); 
	    articoli = magazzino.getArticolo();
	    loginFrame = new LoginFrame(controller);
	    loginFrame.setVisible(false);

		
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

	public DefaultTableModel FillTableModel() {
		magazzino = new Magazzino();
		String headers[] = {"Nome","id","Produttore","Taglia","Colore","Collezione","Disponibili","Prezzo","genere"};
		DefaultTableModel tableModel = new DefaultTableModel();
	    tableModel.setColumnIdentifiers(headers);
	    

		for (Articolo a :articoli)
			System.out.println(a);
	
	    for (int i = 0 ; i< articoli.size();i++) {
	    	;
	    	tableModel.addRow(new Object[] {articoli.get(i).getNome() ,
	    									articoli.get(i).getId(),
	    									articoli.get(i).getProduttore(),
	    									articoli.get(i).getTaglia(),
	    									articoli.get(i).getColore(),
	    									articoli.get(i).getCollezione(),
	    									articoli.get(i).getQuantita(),
	    									articoli.get(i).getPrezzo(),
	    									articoli.get(i).getGenere()
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
	
	public void AddArticolo(String nome,String id, String produttore, String taglia, String colore, String collezione, int quantita, float prezzo,String genere,File foto) throws FileNotFoundException, SQLException {

		articoloDao.InserArticolo(nome,id, produttore, taglia, colore, collezione, quantita, prezzo, genere,foto);
		magazzino = new Magazzino();
		magazzinoDao = new MagazzinoDAO();
		magazzinoDao.fillMagazzino(magazzino.getArticolo());
		
		
	}
	
	public void EditArticolo(String nome,String id, String produttore, String taglia, String colore, String collezione, int quantita, float prezzo,String genere,File foto) {
		
		articoloDao.UpdateArticolo(nome,id,produttore,taglia,colore,collezione,quantita,prezzo,genere,foto);
	}

	
	public void RemoveArticolo(String nome,String id, String produttore, String taglia, String colore, String collezione, int quantita, float prezzo,String genere,File foto) {
		
		articoloDao.DeleteArticolo(nome,id,produttore,taglia,colore,collezione,quantita,prezzo,genere,foto);
	}
	
	
}
