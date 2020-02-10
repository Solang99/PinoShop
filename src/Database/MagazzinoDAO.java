package Database;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Entita.Articolo;
import Entita.Magazzino;

public class MagazzinoDAO {
		
	
		private Connection connection;
		
		private PreparedStatement preparedStatement;
		
		private Magazzino magazzino ;
		public MagazzinoDAO() {
			connection = Connessione.getConnection();
		}
		
		public void fillMagazzino (ArrayList<Articolo> articoloList) {
			String query = "SELECT * FROM articolo;";
			try {
				preparedStatement = connection.prepareStatement(query);
				ResultSet risultato = preparedStatement.executeQuery();
				articoloList.clear();

				while (risultato.next()) {
					Articolo a = CreateArticolo(risultato);
					articoloList.add(a);

				}
				
				
				preparedStatement.execute();
				preparedStatement.close();
				
				magazzino = new Magazzino();
				magazzino.setArticolo(articoloList);

			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
	

		}
		
		public ArrayList<Articolo> SearchByID(String id){
			String query = "select * FROM selectAllOrFilter (?);";	

			ArrayList<Articolo> itemFilter = new ArrayList<Articolo>();
			
			try {
				
						
					preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, id);
			
				ResultSet risultato = preparedStatement.executeQuery();
				itemFilter.clear();

				while (risultato.next()) {
					Articolo a = CreateArticolo(risultato);
					itemFilter.add(a);

				}
				
				preparedStatement.execute();
				preparedStatement.close();
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
	
			return itemFilter;
		}
		
		public void RemoveFromMagazzino(String id, int quantita) {
			String query = "UPDATE magazzino SET quantita = quantita - ? WHERE codA = ?";	

				
			try {
				
						
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, quantita);
				
				ResultSet risultato = preparedStatement.executeQuery();
			

				while (risultato.next()) {
				

				}
				
				preparedStatement.execute();
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		
		
		
		
		private Articolo CreateArticolo(ResultSet risultato) throws SQLException, IOException {			
			Articolo articolo = new Articolo();																
			articolo.setNome(risultato.getString(1));													
			articolo.setId(risultato.getString(2));														
			articolo.setProduttore(risultato.getString(3));												
			articolo.setTaglia(risultato.getString(4));
			articolo.setColore(risultato.getString(5));
			articolo.setCollezione(risultato.getString(6));
			articolo.setQuantita(risultato.getInt(7));
			articolo.setPrezzo(risultato.getFloat(8));
			articolo.setGenere(risultato.getString(9));
			InputStream fotoStream = risultato.getBinaryStream(10);
			Image fotoUser = ImageIO.read(fotoStream);
			articolo.setFoto(fotoUser);
			articolo.setCategoria(risultato.getString(11));

			return articolo;
		}
		
	
}
