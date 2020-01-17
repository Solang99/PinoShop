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

import Entita.Commesso;
import GUI.Controller;

public class CommessoDAO {
	private Connection connection;
	
	private PreparedStatement preparedStatement;
	public CommessoDAO() {
		connection = Connessione.getConnection();
		
	}
	
	
	public void AddUser(Commesso commesso) throws FileNotFoundException {
		
		try {
			String query = "INSERT INTO commesso VALUES (?,?,?,?,?,?,?);";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, commesso.getNome());
			preparedStatement.setString(2, commesso.getCognome());
			preparedStatement.setString(3, commesso.getUsername());
			preparedStatement.setString(4, commesso.getMail());
			preparedStatement.setString(5, commesso.getPassword());

			FileInputStream fotoStream = new FileInputStream(commesso.getFoto());
			preparedStatement.setBinaryStream(6, fotoStream, (int) commesso.getFoto().length());
			
			long dataNascita = commesso.getDataNascita().getTime();
			long javaTime = commesso.getDataNascita().getTime();
			java.sql.Date dataSql = new java.sql.Date(javaTime);
			
			preparedStatement.setDate(7,dataSql);
			

			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		} 
		
		
	}

	public boolean LogInUser(String username, String password,Controller controller) throws SQLException, IOException {
			String query ="SELECT * "
							+ "FROM commesso "
							+ "WHERE \"username\" =  ? AND \"password\" = ? ;";
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
				InputStream fotoStream = risultato.getBinaryStream(6);
				Image fotoUser = ImageIO.read(fotoStream);
				java.util.Date dataNascitaUser = risultato.getTimestamp(7);
			
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
