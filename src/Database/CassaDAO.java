package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CassaDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public CassaDAO() {
		connection = Connessione.getConnection();
	}
	public void insertOrdine(String pagamentoType, float pagamentoDovuto, float pagamentoVersato,float resto) throws SQLException {
		String query = "INSERT INTO cassa(pagamento, pagamentodovuto, pagamentoversato, resto) VALUES (?::pagamento_type, ?, ?, ?);";
	
			preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setString(1, pagamentoType);
			preparedStatement.setFloat(2, pagamentoDovuto);
			preparedStatement.setFloat(3, pagamentoVersato);
			preparedStatement.setFloat(4, resto);
			
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
		
		
	}
}
