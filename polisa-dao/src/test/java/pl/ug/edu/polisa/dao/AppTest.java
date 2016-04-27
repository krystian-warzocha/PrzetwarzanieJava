package pl.ug.edu.polisa.dao;

import java.math.BigDecimal;
import java.sql.SQLException;

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
    
    public void testDao() {
    	PolicyEntity policy = new PolicyEntity();
    	policy.setId(new Long(1));
    	policyDao.delete(policy);    
    }
    
    public void testPolicyCreate() throws SQLException {
    	PolicyEntity policy = new PolicyEntity();
    	//policy.setId(1L);
    	policy.setPolicyNumber("numer polisy");
    	policy.setPremium(BigDecimal.valueOf(100.0));
    	policyDao.create(policy);
    }
}
