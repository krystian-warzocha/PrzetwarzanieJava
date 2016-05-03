package pl.ug.edu.polisa.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.ug.edu.polisa.dao.risk.RiskDao;
import pl.ug.edu.polisa.domain.risk.RiskEntity;

/**
 * Unit test for simple App.
 */
public class RiskTest 
    extends TestCase
{
	RiskDao riskDao;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @throws Exception 
     */
    public RiskTest( String testName ) throws Exception
    {
        super( testName );
        riskDao = new RiskDao();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RiskTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testRiskCreate() throws SQLException {
    	RiskEntity risk = new RiskEntity();
    	risk.setRiskPremium(BigDecimal.valueOf(50.0));
    	riskDao.create(risk);
    	
    	RiskEntity actual = riskDao.retrieve(risk.getId());
    	assertEquals(risk.getRiskPremium(), actual.getRiskPremium());
    }
    
    public void testPolicyUpdate() throws SQLException {
    	RiskEntity risk = new RiskEntity();
    	risk.setRiskPremium(BigDecimal.valueOf(50.0));
    	riskDao.create(risk);
    	
    	risk.setRiskPremium(BigDecimal.valueOf(60.0));
    	riskDao.update(risk);
    	
    	RiskEntity actual = riskDao.retrieve(risk.getId());
    	assertEquals(risk.getRiskPremium(), actual.getRiskPremium());
    }
    
    public void testPolicyDelete() throws SQLException {
    	RiskEntity risk = new RiskEntity();
    	risk.setRiskPremium(BigDecimal.valueOf(50.0));
    	riskDao.create(risk);
    	
    	riskDao.delete(risk);
    	
    	assertNull(riskDao.retrieve(risk.getId()));
    }
}
