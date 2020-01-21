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
		
		
		private Articolo CreateArticolo(ResultSet risultato) throws SQLException, IOException {			// la funzione non  so se è giusta nel caso si potrebbe fare anche cosi
			Articolo articolo = new Articolo();															// Object rowData[]	 = new Object [9];		
			articolo.setNome(risultato.getString(1));													//	for (int i = 0; i<articoloList.size();i++)
			articolo.setId(risultato.getString(2));														//	{ rowData[0] = aticoloList.get[i].nome;
			articolo.setProduttore(risultato.getString(3));												// rowData[1] = articoloList.get(i).id; e cosi via alla fine scrivere model.addRow(rowData);
			articolo.setTaglia(risultato.getString(4));
			articolo.setColore(risultato.getString(5));
			articolo.setCollezione(risultato.getString(6));
			articolo.setQuantita(risultato.getInt(7));
			articolo.setPrezzo(risultato.getFloat(8));
			articolo.setGenere(risultato.getString(9));
			InputStream fotoStream = risultato.getBinaryStream(10);
			Image fotoUser = ImageIO.read(fotoStream);
			articolo.setFoto(fotoUser);

			return articolo;
		}
}
