package pl.ug.edu.polisa.dao.risk;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.ug.edu.polisa.dao.core.BaseCRUDDao;
import pl.ug.edu.polisa.dao.core.TableNameReader;
import pl.ug.edu.polisa.domain.risk.RiskEntity;

public class RiskDao extends BaseCRUDDao<RiskEntity> {
	
	Log log = LogFactory.getLog(RiskDao.class);

	public RiskDao() throws Exception {
		super();
	}

	@Override
	public RiskEntity create(RiskEntity object) throws SQLException {
		String table = TableNameReader.read(object);
		PreparedStatement ps = c.prepareStatement("INSERT INTO " + table + "(riskpremium) VALUES(?)");
		ps.setBigDecimal(1, object.getRiskPremium());
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
	public RiskEntity retrieve(Long id) throws SQLException {
		RiskEntity re = new RiskEntity();
		String table = TableNameReader.read(re);
		PreparedStatement ps = c.prepareStatement("SELECT riskpremium FROM " + table + " WHERE id = ?");
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			re.setId(id);
			re.setRiskPremium(rs.getBigDecimal(1));
			return re;
		} else {
			return null;
		}
	}

	@Override
	public void update(RiskEntity object) throws SQLException {
		String table = TableNameReader.read(object);
		PreparedStatement ps = c.prepareStatement("UPDATE " + table + 
				" SET riskpremium = ?" + 
				" WHERE id=?");
		ps.setBigDecimal(1, object.getRiskPremium());
		ps.setLong(2, object.getId());
		int row = ps.executeUpdate();
		log.info("Zaktualizowano " + row + " rekordów do tabeli " + table);
	}

}
