package Database;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
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
			String query = "INSERT INTO commesso VALUES (?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cognome);
			preparedStatement.setString(3, username);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, password);

			FileInputStream fotoStream = new FileInputStream(fotoFile);
			preparedStatement.setBinaryStream(7, fotoStream, (int) fotoFile.length());
			
			java.util.Date dataNascita = date.getTime();
			long javaTime = dataNascita.getTime();
			java.sql.Date dataSql = new java.sql.Date(javaTime);
			
			preparedStatement.setDate(6,dataSql);
	
			
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		} 
		
		
	}

	public boolean LogInUser(String username, String password,Controller controller) throws SQLException, IOException {
			
			String query ="SELECT * "
							+ "FROM commesso "
							+ "WHERE \"username\" =  ? AND chiave= ? ;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			preparedStatement.executeQuery();

			ResultSet risultato = preparedStatement.executeQuery();
			
	
			
			if (risultato.next()) {
				String nomeUser = risultato.getString(1);
				String cognomeUser= risultato.getString(2);
				String usernameUser = risultato.getString(3);
				String emailUser = risultato.getString(4);
				String passwordUser = risultato.getString(5);
				java.util.Date dataNascitaUser = risultato.getTimestamp(6);
				InputStream fotoStream = risultato.getBinaryStream(7);
				Image fotoUser = ImageIO.read(fotoStream);
			
			
				controller.CreateUser(nomeUser,cognomeUser,usernameUser,passwordUser,dataNascitaUser,fotoUser,emailUser);
				
				preparedStatement.close();
				return true;
			}
				
			else {
				preparedStatement.close();
				return false; 
			}
	}
	
	
	
	
	
	public boolean CheckUsername(String username) {
		
		String query ="SELECT * FROM commesso WHERE \"username\"  = ? ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.executeQuery();

			ResultSet risultato = preparedStatement.executeQuery();
			if (risultato.next()) {		
					preparedStatement.close();
					return true;
			}
		
			else {
					preparedStatement.close();
					return false; 
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;

	}

	
	
}
