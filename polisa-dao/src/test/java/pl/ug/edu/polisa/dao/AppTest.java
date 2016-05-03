package pl.ug.edu.polisa.dao;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import pl.ug.edu.polisa.dao.core.BaseCRUDDao;
import pl.ug.edu.polisa.dao.policy.PolicyDao;
import pl.ug.edu.polisa.domain.policy.PolicyEntity;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	PolicyDao policyDao;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     * @throws Exception 
     */
    public AppTest( String testName ) throws Exception
    {
        super( testName );
        policyDao = new PolicyDao();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testDao() throws SQLException {
    	PolicyEntity policy = new PolicyEntity();
    	policy.setId(new Long(1));
    	policyDao.delete(policy);    
    }
    
    public void testPolicyCreate() throws SQLException {
    	PolicyEntity policy = new PolicyEntity();
    	policy.setPolicyNumber("numer polisy");
    	policy.setPremium(BigDecimal.valueOf(100.0));
    	policy.setData_od(new Date());
    	policy.setData_do(new Date());
    	policyDao.create(policy);
    	
    	PolicyEntity actual = policyDao.retrieve(policy.getId());
    	assertEquals(policy.getPolicyNumber(), actual.getPolicyNumber());
    	assertEquals(policy.getPremium().doubleValue(), actual.getPremium().doubleValue());
    	assertEquals(policy.getData_od(), actual.getData_od());
    	assertEquals(policy.getData_do(), actual.getData_do());
    }
    
    public void testPolicyUpdate() throws SQLException {
    	PolicyEntity policy = new PolicyEntity();
    	policy.setPolicyNumber("numer polisy");
    	policy.setPremium(BigDecimal.valueOf(100.0));
    	policy.setData_od(new Date());
    	policy.setData_do(new Date());
    	policyDao.create(policy);
    	
    	policy.setPolicyNumber("nowy numer polisy");
    	policy.setPremium(BigDecimal.valueOf(200.0));
    	policyDao.update(policy);
    	
    	PolicyEntity actual = policyDao.retrieve(policy.getId());
    	assertEquals(policy.getPolicyNumber(), actual.getPolicyNumber());
    	assertEquals(policy.getPremium().doubleValue(), actual.getPremium().doubleValue());
    	assertEquals(policy.getData_od(), actual.getData_od());
    	assertEquals(policy.getData_do(), actual.getData_do());
    }
    
    public void testPolicyDelete() throws SQLException {
    	PolicyEntity policy = new PolicyEntity();
    	policy.setPolicyNumber("numer polisy");
    	policy.setPremium(BigDecimal.valueOf(100.0));
    	policy.setData_od(new Date());
    	policy.setData_do(new Date());
    	policyDao.create(policy);
    	
    	policyDao.delete(policy);
    	
    	assertNull(policyDao.retrieve(policy.getId()));
    }
}
