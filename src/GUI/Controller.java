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

import Database.CommessoDAO;
import Entita.Commesso;

public class Controller {
	private static RegisterFrame registerFrame;
	private LoginFrame loginFrame;
	private static MainFrame mainFrame;
	private ProfileFrame profileFrame;
	private static CommessoDAO commessoDao;
	private Commesso commesso;
	
	public static void main (String[] args) {
		Controller controller = new Controller ();
		

//		mainFrame = new MainFrame(controller);
//		mainFrame.setVisible(true);
		registerFrame = new RegisterFrame(controller);
		registerFrame.setVisible(true);

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
		profileFrame= new ProfileFrame(this);
		profileFrame.setVisible(true);
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
}
