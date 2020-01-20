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
				
				while (risultato.next()) {
					Articolo a = CreateArticolo(risultato);
					articoloList.add(a);

				}
				
				
				preparedStatement.execute();
				preparedStatement.close();
				
				magazzino.setArticolo(articoloList);

			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
	

		}
		
		
		private Articolo CreateArticolo(ResultSet risultato) throws SQLException, IOException {
			Articolo articolo = new Articolo();
			articolo.setId(risultato.getString(1));
			articolo.setProduttore(risultato.getString(2));
			articolo.setTaglia(risultato.getString(3));
			articolo.setColore(risultato.getString(4));
			articolo.setCollezione(risultato.getString(5));
			articolo.setQuantita(risultato.getInt(6));
			articolo.setPrezzo(risultato.getFloat(7));
			articolo.setGenere(risultato.getString(8));
			InputStream fotoStream = risultato.getBinaryStream(9);
			Image fotoUser = ImageIO.read(fotoStream);
			articolo.setFoto(fotoUser);

			return articolo;
		}
}
