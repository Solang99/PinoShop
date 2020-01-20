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
	public void UpdateArticolo(String id,String produttore,String taglia,String colore, String collezione,int quantita, float prezzo,
			String genere, File fotoFile) {

		try {
			String query = "UPDATE articolo SET id = ?, produttore = ?, taglia = taglia_type, colore = ?, collezione = ?, quantita = ?, prezzo = ?,genere = genere_type, foto = ? WHERE id = ?;";
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

	public void DeleteArticolo(String id,String produttore,String taglia,String colore, String collezione,int quantita, float prezzo,
			String genere, File fotoFile) {

		try {
			String query = "DELETE FROM articolo WHERE id = ?;";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, id);

			if(preparedStatement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Articolo Eliminato");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void FillJTable(JTable table)
	{
		try {
			String query = "SELECT * FROM articolo ";
			preparedStatement = connection.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
		

			
			Object[] row;
			
			while(rs.next()) {
				row = new Object[8];
				row [0] = rs.getString(1);
				row [1] = rs.getString(2);
				row [2] = rs.getString(3);
				row [3] = rs.getString(4);
				row [4] = rs.getString(5);
				row [5] = rs.getInt(6);
				row [6] = rs.getFloat(7);
				row [7] = rs.getString(8);
			//	row [8] = rs.getBinaryStream(9);
				
				model.addRow(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}

