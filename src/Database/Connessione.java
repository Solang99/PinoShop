package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connessione {
	private static Connection con;
	private static Properties props;
	
	private static String url = "jdbc:postgresql://localhost/pinoshop";
	private static String user = "postgres";
	private static String driverName ="org.postgresql.Driver";
	
	
	
	public static Connection getConnection() {
    	try {
    		Class.forName("org.postgresql.Driver");
    	}
		catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
    	props= new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","laka");
    	
		try {
			con = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return con;
	}
}
