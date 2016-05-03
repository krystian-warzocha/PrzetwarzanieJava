package pl.ug.edu.polisa.dao.core;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConnectionFactory {
	
	private Log log = LogFactory.getLog(ConnectionFactory.class);
	
	private static ConnectionFactory connectionFactory;
	
	private Connection conn;
	
	private ConnectionFactory() throws Exception {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/Krystian/git/PrzetwarzanieJava/mydatabase.db");
			log.info("Udało się  nawiązać połączenie z bazą danych");
		} catch (Exception e) {
			log.error("Błąd przy nawiązaniu połączenia z bazą danych");
			throw new Exception(e);
		}
	}
	
	public static ConnectionFactory instance() throws Exception {
		if(connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
}
