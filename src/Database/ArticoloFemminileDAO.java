package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticoloFemminileDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public ArticoloFemminileDAO() {
		connection = Connessione.getConnection();
	}
	
	public void AddArticoloFemminile(String id, String produttore, String taglia, String colore, String stagione, String collezione, Integer quantita, Integer prezzo, File foto) {
		
			try {
				preparedStatement = connection.prepareStatement("INSERT INTO articolofemminile (id, produttore, taglia, colore, stagione, collezione, quantita, prezzo, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			
			int idinteger = Integer.parseInt(id);
		
			preparedStatement.setInt(1, idinteger);
			preparedStatement.setString(2, produttore);
			preparedStatement.setString(3, taglia);
			preparedStatement.setString(4, colore);
			preparedStatement.setString(5, stagione);
			preparedStatement.setString(6, collezione);
			preparedStatement.setInt(7, quantita);
			preparedStatement.setInt(8, prezzo);
			
			FileInputStream fotoStream = new FileInputStream(foto);
			preparedStatement.setBinaryStream(9, fotoStream, (int) foto.length());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
}
