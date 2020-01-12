package GUI;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Calendar;

import Database.CommessoDAO;

public class Controller {
	private static RegisterFrame registerFrame;
	private LoginFrame loginFrame;
	private static MainFrame mainFrame;
	
	private static CommessoDAO commesso;
	
	public static void main (String[] args) {
		Controller controller = new Controller ();
		
		ProfileFrame profileFrame= new ProfileFrame(controller);
		profileFrame.setVisible(true);
//		mainFrame = new MainFrame(controller);
//		mainFrame.setVisible(true);
		registerFrame = new RegisterFrame(controller);
		registerFrame.setVisible(false);

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
	
	public void CreateAccount(String nome,String cognome,String username,char[] password,Calendar date,File fotoFile,String email) throws FileNotFoundException {
		commesso = new CommessoDAO();
		String s = String.copyValueOf(password);
		commesso.AddUser(nome, cognome,username, s, date, fotoFile, email);
	}
	
	public boolean LogIn(String username, char[] password) throws SQLException  {
		commesso = new CommessoDAO();
		String s = String.copyValueOf(password);
		return commesso.LogInUser(username, s);
	}
}
