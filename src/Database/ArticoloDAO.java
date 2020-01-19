package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ArticoloDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public ArticoloDAO() {
		connection = Connessione.getConnection();
	}
	
	
	public void InserArticolo(String id,String produttore,String taglia,String colore, String collezione,int quantita, float prezzo,
							String genere, File fotoFile) throws SQLException, FileNotFoundException {
		
			String query = "INSERT INTO articolo VALUES (?,?,?::taglia_type,?,?,?,?,?::genere_type,?);";
			preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setString(1, id);
			
			preparedStatement.setString(2,produttore);
			preparedStatement.setString(3, taglia);
			preparedStatement.setString(4, colore);
			preparedStatement.setString(5,collezione);
			preparedStatement.setInt(6,quantita);
			preparedStatement.setFloat(7, prezzo);
			preparedStatement.setString(8, genere);
			FileInputStream fotoStream = new FileInputStream(fotoFile);
			preparedStatement.setBinaryStream(9, fotoStream, (int) fotoFile.length());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();

	
	}
}
