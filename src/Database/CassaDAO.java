package Database;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Entita.Articolo;
import Entita.Cassa;

public class CassaDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public CassaDAO() {
		connection = Connessione.getConnection();
	}
	
	
	public void insertOrdine(String pagamentoType, float pagamentoDovuto, float pagamentoVersato,float resto,String username) throws SQLException  {
		String query = "INSERT INTO cassa(pagamento, pagamentodovuto, pagamentoversato, resto,usernamecommesso) VALUES (?::pagamento_type, ?, ?, ?,?);";
	
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, pagamentoType);
				preparedStatement.setFloat(2, pagamentoDovuto);
				preparedStatement.setFloat(3, pagamentoVersato);
				preparedStatement.setFloat(4, resto);
				preparedStatement.setString(5, username);
				
				preparedStatement.executeUpdate();
				preparedStatement.close();
			
		
			
			
		
		
	}
	
	public ArrayList<Cassa> getOrdini()  {
		String query = "SELECT * FROM cassa;";
	
		ArrayList<Cassa> ordiniList = new ArrayList<Cassa>();
		
		
		try {
			
					
				preparedStatement = connection.prepareStatement(query);
				
		
				ResultSet risultato = preparedStatement.executeQuery();
			

			while (risultato.next()) {
				Cassa a = creaOrdine(risultato);
				ordiniList.add(a);
			

			}
			
			preparedStatement.execute();
			preparedStatement.close();
			
		} catch (SQLException  e) {
			
			e.printStackTrace();
		}

		return ordiniList;
	}
	
	private Cassa creaOrdine(ResultSet risultato) throws SQLException {			
		Cassa cassa = new Cassa();		
		cassa.setPagamentoType(risultato.getString(1));
		cassa.setPagamentoDovuto(risultato.getFloat(2));
		cassa.setPagamentoVersato(risultato.getFloat(3));
		cassa.setResto(risultato.getFloat(4));
		cassa.setNumeroOrdine(risultato.getInt(5));
		cassa.setUsernameCommesso(risultato.getString(6));
		
		return cassa;
	}
	
	
	
}
