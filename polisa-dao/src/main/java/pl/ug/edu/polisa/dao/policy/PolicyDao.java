package pl.ug.edu.polisa.dao.policy;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.ug.edu.polisa.dao.core.BaseCRUDDao;
import pl.ug.edu.polisa.dao.core.TableNameReader;
import pl.ug.edu.polisa.domain.policy.PolicyEntity;

public class PolicyDao extends BaseCRUDDao<PolicyEntity> {
	
	Log log = LogFactory.getLog(PolicyDao.class);

	public PolicyDao() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public PolicyEntity create(PolicyEntity object) throws SQLException {
		String table = TableNameReader.read(object);
		PreparedStatement ps = c.prepareStatement("INSERT INTO " + table + "(policynumber, skladka) VALUES(?,?)");
		ps.setString(1, object.getPolicyNumber());
		ps.setBigDecimal(2, object.getPremium());
		int row = ps.executeUpdate();
		log.info("Dodano " + row + " rekordów do tabeli " + table);
		return null;
	}

	@Override
	public PolicyEntity retrieve(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(PolicyEntity object) {
		// TODO Auto-generated method stub
		
	}

}
