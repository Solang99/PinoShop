package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entita.Articolo;


public class ArticoloDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public ArticoloDAO() {
		connection = Connessione.getConnection();
	}
	
	
	public void InserArticolo(String nome,String id,String produttore,String taglia,String colore, String collezione,int quantita, float prezzo,
							String genere, File fotoFile) throws SQLException, FileNotFoundException {
		
			String query = "INSERT INTO articolo VALUES (?,?,?::taglia_type,?,?,?,?,?::genere_type,?);";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, id);
			
			preparedStatement.setString(3,produttore);
			preparedStatement.setString(4, taglia);
			preparedStatement.setString(5, colore);
			preparedStatement.setString(6,collezione);
			preparedStatement.setInt(7,quantita);
			preparedStatement.setFloat(8, prezzo);
			preparedStatement.setString(9, genere);
			FileInputStream fotoStream = new FileInputStream(fotoFile);
			preparedStatement.setBinaryStream(10, fotoStream, (int) fotoFile.length());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();

	
	}
	
	public void UpdateArticolo(String nome,String id,String produttore,String taglia,String colore, String collezione,int quantita, float prezzo,
			String genere, File fotoFile) {

		try {
			String query = "UPDATE articolo SET id = ?, produttore = ?, taglia = ?::taglia_type, colore = ?, collezione = ?, quantita = ?, prezzo = ?,genere ?::genere_type, foto = ? WHERE id = ?;";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, id);

			preparedStatement.setString(3,produttore);
			preparedStatement.setString(4, taglia);
			preparedStatement.setString(5, colore);
			preparedStatement.setString(6,collezione);
			preparedStatement.setInt(7,quantita);
			preparedStatement.setFloat(8, prezzo);
			preparedStatement.setString(9, genere);
			FileInputStream fotoStream = new FileInputStream(fotoFile);
			preparedStatement.setBinaryStream(10, fotoStream, (int) fotoFile.length());

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

	public void DeleteArticolo(String nome,String id,String produttore,String taglia,String colore, String collezione,int quantita, float prezzo,
			String genere, File fotoFile) {

		try {
			String query = "DELETE FROM articolo WHERE id = ?;";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(2, id);

			if(preparedStatement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Articolo Eliminato");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

