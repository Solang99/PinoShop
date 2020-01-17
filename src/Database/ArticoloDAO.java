package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Entita.Articolo;

public class ArticoloDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public ArticoloDAO() {
		connection = Connessione.getConnection();
	}
	
	public void InserArticolo(Articolo articolo) {
		
			try {
				String query = "INSERT INTO articolo VALUES (?,?,?::taglia_type,?,?,?,?,?::genere_type,?);";
				preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setString(1, articolo.getId());
			
			preparedStatement.setString(2,articolo.getProduttore());
			preparedStatement.setString(3, articolo.getTaglia());
			preparedStatement.setString(4, articolo.getColore());
			preparedStatement.setString(5,articolo.getCollezione());
			preparedStatement.setInt(6,articolo.getQuantita());
			preparedStatement.setFloat(7, articolo.getPrezzo());
			preparedStatement.setString(8, articolo.getGenere());
			FileInputStream fotoStream = new FileInputStream(articolo.getFoto());
			preparedStatement.setBinaryStream(9, fotoStream, (int) articolo.getFoto().length());
			
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
	
	public void UpdateArticolo(Articolo articolo) {
		
		try {
			String query = "UPDATE articolo SET id = ?, produttore = ?, taglia = taglia_type, colore = ?, collezione = ?, quantita = ?, prezzo = ?,genere = genere_type, foto = ? WHERE id = ?;";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, articolo.getId());
			
			preparedStatement.setString(2,articolo.getProduttore());
			preparedStatement.setString(3, articolo.getTaglia());
			preparedStatement.setString(4, articolo.getColore());
			preparedStatement.setString(5,articolo.getCollezione());
			preparedStatement.setInt(6,articolo.getQuantita());
			preparedStatement.setFloat(7, articolo.getPrezzo());
			preparedStatement.setString(8, articolo.getGenere());
			FileInputStream fotoStream = new FileInputStream(articolo.getFoto());
			preparedStatement.setBinaryStream(9, fotoStream, (int) articolo.getFoto().length());
			
			if(preparedStatement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Articolo Aggiornato");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DeleteArticolo(Articolo articolo) {
			
		try {
			String query = "DELETE FROM articolo WHERE id = ?;";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, articolo.getId());
			
			if(preparedStatement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Articolo Eliminato");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
