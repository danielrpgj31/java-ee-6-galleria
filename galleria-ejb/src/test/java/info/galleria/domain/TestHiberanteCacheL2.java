package info.galleria.domain;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import info.galleria.utilities.PasswordUtility;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TestHiberanteCacheL2 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestHiberanteCacheL2( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestHiberanteCacheL2.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testaHiberante()
    {
    	// create the entity manager factory.
        // Please note, the parameter should be the same as the name of the persistence unit
        // defined in persistence.xml file
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "galleria-ejb-test");
        // create entityt manager - an entry point of all the JPA related operations
        EntityManager em =  emf.createEntityManager();
        // since we have to manage transactions by ourselves, we have to start a new transaction before
        // we actually start to work with entity manager
        EntityTransaction tx = em.getTransaction();
        tx.begin();
               
        // we create a sample user objec (just ensure that it doesn't appear in the database)
        info.galleria.domain.Account account = new info.galleria.domain.Account();
        //account.setAccountNumber(null);
        account.setBalance(11.00F);
        account.setName("daniel");
      
        em.persist(account);
       
        // commit the transaction
        tx.commit();
       
        Cache cache = emf.getCache();
        System.out.println("cache.contain should return true: "+cache.contains(Account.class, account.getAccountNumber()));
        cache.evict(Account.class);
        System.out.println("cache.contain should return false: "+cache.contains(Account.class, account.getAccountNumber()));
        
        
        // close the resources
        em.close();
        emf.close();
    }
}

