package pl.ug.edu.polisa.dao.policy;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	}

	@Override
	public PolicyEntity create(PolicyEntity object) throws SQLException {
		String table = TableNameReader.read(object);
		PreparedStatement ps = c.prepareStatement("INSERT INTO " + table + "(policynumber, premium, data_od, data_do) VALUES(?,?,?,?)");
		ps.setString(1, object.getPolicyNumber());
		ps.setBigDecimal(2, object.getPremium());
		ps.setDate(3, new Date(object.getData_od().getTime()));
		ps.setDate(4, new Date(object.getData_do().getTime()));
		int row = ps.executeUpdate();
		
		ResultSet generatedKeys = ps.getGeneratedKeys();
		if(generatedKeys.next()) {
			object.setId(generatedKeys.getLong(1));
		} else {
			throw new SQLException("Nie udało się dodać ");
		}
		
		log.info("Dodano " + row + " rekordów do tabeli " + table);
		return null;
	}

	@Override
	public PolicyEntity retrieve(Long id) throws SQLException {
		PolicyEntity pe = new PolicyEntity();
		String table = TableNameReader.read(pe);
		PreparedStatement ps = c.prepareStatement("SELECT policynumber, premium, data_od, data_do FROM " + table + " WHERE id = ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			pe.setId(id);
			pe.setPolicyNumber(rs.getString(1));
			pe.setPremium(rs.getBigDecimal(2));
			pe.setData_od(rs.getDate(3));
			pe.setData_do(rs.getDate(4));
			return pe;
		} else {
			return null;
		}
	}

	@Override
	public void update(PolicyEntity object) throws SQLException {
		String table = TableNameReader.read(object);
		PreparedStatement ps = c.prepareStatement("UPDATE " + table + 
				" SET policynumber = ?, premium = ?, data_od = ?, data_do = ? " + 
				" WHERE id=?");
		ps.setString(1, object.getPolicyNumber());
		ps.setBigDecimal(2, object.getPremium());
		ps.setDate(3, new Date(object.getData_od().getTime()));
		ps.setDate(4, new Date(object.getData_do().getTime()));
		ps.setLong(5, object.getId());
		int row = ps.executeUpdate();
		log.info("Zaktualizowano " + row + " rekordów do tabeli " + table);
	}

}
