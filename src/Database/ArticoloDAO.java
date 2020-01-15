package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Entita.Articolo;

public class ArticoloDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public ArticoloDAO() {
		connection = Connessione.getConnection();
	}
	
	public void InserArticolo(String id, String produttore, String taglia, String colore, String collezione, int quantita, float prezzo, File foto) {
		
			try {
				preparedStatement = connection.prepareStatement("INSERT INTO articolofemminile (id, produttore, taglia, colore, stagione, collezione, quantita, prezzo, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
			
			
			preparedStatement.setString(1, id);
			
			preparedStatement.setString(2,produttore);
			preparedStatement.setString(3, taglia);
			preparedStatement.setString(4, colore);
			preparedStatement.setString(5,collezione);
			preparedStatement.setInt(6,quantita);
			preparedStatement.setFloat(7, prezzo);
			
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
