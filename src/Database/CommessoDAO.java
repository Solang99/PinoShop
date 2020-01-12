package Database;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

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
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		} 
		
		
	}

	public boolean LogInUser(String username, String password) throws SQLException {
	
			preparedStatement = connection.prepareStatement("SELECT  \"username\", \"password\" FROM commesso WHERE \"username\" =  ? AND \"password\" = ? ;");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			preparedStatement.executeQuery();

			ResultSet risultato = preparedStatement.executeQuery();
			
			if (risultato.next())
				return true;
			else 
				return false;
	}

	
}
