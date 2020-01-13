package Database;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.imageio.ImageIO;

import GUI.Controller;

public class CommessoDAO {
	private Connection connection;
	
	private PreparedStatement preparedStatement;
	public CommessoDAO() {
		connection = Connessione.getConnection();
		
	}
	
	
	public void AddUser(String nome,String cognome,String username,String password, Calendar date, File fotoFile,String email) throws FileNotFoundException {
		
		try {
		
			preparedStatement = connection.prepareStatement("INSERT INTO commesso VALUES (?,?,?,?,?,?,?)");
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cognome);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, password);

			FileInputStream fotoStream = new FileInputStream(fotoFile);
			preparedStatement.setBinaryStream(6, fotoStream, (int) fotoFile.length());
			
			java.util.Date dataNascita = date.getTime();
			long javaTime = dataNascita.getTime();
			java.sql.Date dataSql = new java.sql.Date(javaTime);
			
			preparedStatement.setDate(7,dataSql);
			

			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		} 
		
		
	}

	public boolean LogInUser(String username, String password,Controller controller) throws SQLException, IOException {
	
			preparedStatement = connection.prepareStatement("SELECT  * FROM commesso WHERE \"username\" =  ? AND \"password\" = ? ;");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			preparedStatement.executeQuery();

			ResultSet risultato = preparedStatement.executeQuery();
			
	
			
			if (risultato.next()) {
				String nomeUser = risultato.getString(1);
				String cognomeUser= risultato.getString(2);
				String usernameUser = risultato.getString(3);
				String passwordUser = risultato.getString(4);
				java.util.Date dataNascitaUser = new java.util.Date (risultato.getDate(5).getTime());
				
				InputStream fotoStream = risultato.getBinaryStream(6);
				Image fotoUser = ImageIO.read(fotoStream);
				String emailUser = risultato.getString(7);
				controller.CreateUser(nomeUser,cognomeUser,usernameUser,passwordUser,dataNascitaUser,fotoUser,emailUser);
				
				preparedStatement.close();
				return true;
			}
				
			else {
				preparedStatement.close();
				return false; 
			}
	}

	
}
