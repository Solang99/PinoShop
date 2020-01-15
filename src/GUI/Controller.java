package GUI;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;

import Database.ArticoloFemminileDAO;
import Database.CommessoDAO;
import Entita.ArticoloFemminile;
import Entita.Commesso;

public class Controller {
	private static LoginFrame loginFrame;
	private  RegisterFrame registerFrame;
	private  MainFrame mainFrame;
	private UtenteFrame profileFrame;
	private ArticoloFemminileDAO articoloFemminileDao; 
	private  CommessoDAO commessoDao;
	public Commesso commesso;
	private ArticoloFemminile articoloFemminile;
	
	public static void main (String[] args) {
		Controller controller = new Controller ();
		loginFrame = new LoginFrame(controller);
		loginFrame.setVisible(true);
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
	
	public void GoToMainFrame() {
		loginFrame.dispose();
		mainFrame = new MainFrame(this);
		mainFrame.setVisible(true);
	}
	
	public void CreateUser(String nome,String cognome,String username,String password, 
							Date dataNascita, Image foto,String email) {
		commesso = new Commesso(nome,cognome,username,password,dataNascita,foto,email);
		System.out.println(commesso);
	}
	

	
	
	//DATABASE
	public void CreateAccount(String nome,String cognome,String username,char[] password,Calendar date,File fotoFile,String email) throws FileNotFoundException {
		commessoDao = new CommessoDAO();
		String s = String.copyValueOf(password);
		commessoDao.AddUser(nome, cognome,username, s, date, fotoFile, email);
	}

	
	public boolean LogIn(String username, char[] password) throws SQLException, IOException  {
		commessoDao = new CommessoDAO();
		String s = String.copyValueOf(password);
		return commessoDao.LogInUser(username, s,this);
	}
	
	public void AddArticolo(String id, String produttore, String taglia, String colore, String stagione, String collezione, Integer quantita, Integer prezzo, File foto) {
		articoloFemminileDao = new ArticoloFemminileDAO();
		articoloFemminileDao.AddArticoloFemminile(id, produttore, taglia, colore, stagione, collezione, quantita, prezzo, foto);
	}
}
