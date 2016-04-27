package pl.ug.edu.polisa.dao.core;

import java.sql.Connection;
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
	public abstract T retrieve(Long id);
	
	/**
	 * Aktualizacja obiektu.
	 * @param object
	 */
	public abstract void update(T object);
	
	/**
	 * Usuniecie obiektu. 
	 * @param object
	 */
	public void delete(T object) {
		if(object == null) {
			return;
		}
		
//		StringBuilder sb = new StringBuilder();
//		sb.append("DELETE TABLE ").append(object.tableName()).append(" WHERE id=").append(object.getId());
		
		String tableName = TableNameReader.read(object);
		log.info("table = " + tableName);
		
		if(tableName != null) {
			StringBuilder sb2 = new StringBuilder();
			sb2.append("DELETE TABLE ").append(tableName).append(" WHERE id=").append(object.getId());
			log.info(sb2);
		}
		
//		PreparedStatement ps = c.prepareStatement("DELETE FROM " + table + " WHERE id = ?");
//		ps.setLong(1, object.);
		
		//FIXME do zrobienia odpalenie na bazie
	}
}
