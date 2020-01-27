package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CassaDAO {
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public CassaDAO() {
		connection = Connessione.getConnection();
	}
	
}
