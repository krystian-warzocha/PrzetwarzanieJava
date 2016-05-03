package pl.ug.edu.polisa.dao.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.ug.edu.polisa.domain.core.BaseEntity;

/**
 * Klasa bazowa dla CRUD.
 * 
 * @author kwarzocha
 *
 */
public abstract class BaseCRUDDao <T extends BaseEntity> {
	
	private Log log = LogFactory.getLog(BaseCRUDDao.class);
	
	protected Connection c;
	
	public BaseCRUDDao() throws Exception {
		c = ConnectionFactory.instance().getConnection();
	}

	/**
	 * Metoda tworzy obiekt.
	 * 
	 * @param object
	 * @return
	 * @throws SQLException 
	 */
	public abstract T create(T object) throws SQLException;

	/**
	 * Metoda zwraca obiekt.
	 * @param id
	 * @return
	 */
	public abstract T retrieve(Long id) throws SQLException;
	
	/**
	 * Aktualizacja obiektu.
	 * @param object
	 * @throws SQLException 
	 */
	public abstract void update(T object) throws SQLException;
	
	/**
	 * Usuniecie obiektu. 
	 * @param object
	 * @throws SQLException 
	 */
	public void delete(T object) throws SQLException {
		if(object == null) {
			return;
		}
		
//		StringBuilder sb = new StringBuilder();
//		sb.append("DELETE TABLE ").append(object.tableName()).append(" WHERE id=").append(object.getId());
		
		String tableName = TableNameReader.read(object);
		log.info("table = " + tableName);
		
//		if(tableName != null) {
//			StringBuilder sb2 = new StringBuilder();
//			sb2.append("DELETE TABLE ").append(tableName).append(" WHERE id=").append(object.getId());
//			log.info(sb2);
//		}
		
		if(tableName != null) {
			PreparedStatement ps = c.prepareStatement("DELETE FROM " + tableName + " WHERE id = ?");
			ps.setLong(1, object.getId());
			int row = ps.executeUpdate();
			log.info("Usunięto " + row + " rekordów tabeli " + tableName);
		}
	}
}
