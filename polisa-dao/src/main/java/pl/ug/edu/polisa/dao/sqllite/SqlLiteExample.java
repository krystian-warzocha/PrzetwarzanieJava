package pl.ug.edu.polisa.dao.sqllite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SqlLiteExample {
	
	Log log = LogFactory.getLog(getClass());
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		return DriverManager.getConnection("jdbc:sqlite:/home/studpoz/kwarzocha/mydatabase.db");
	}
	
	public void createDatabase() throws ClassNotFoundException, SQLException {
		Statement statement = getConnection().createStatement();
		statement.executeUpdate("DROP TABLE IF EXISTS PERSON");
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS PERSON(id integer, name string)");
		statement.executeUpdate("INSERT INTO PERSON VALUES(1, 'Stefan')");
		statement.executeUpdate("INSERT INTO PERSON VALUES(2, 'Katarzyna')");
		
		ResultSet rs = statement.executeQuery("SELECT * FROM PERSON");
		while(rs.next()) {
			StringBuilder sb = new StringBuilder();
			sb.append("id = ").append(rs.getInt("id")).append(", name = ").append(rs.getString("name"));
			log.info(sb);
		}
	}
	
	public static void main(String[] argv) {
		SqlLiteExample e = new SqlLiteExample();
		try {
			e.createDatabase();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
