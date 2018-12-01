package us.kpatrick.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import us.kpatrick.LostTicket;

import static org.junit.Assert.*;

public class LostTicketTest {
    LostTicket lt;

    @Before
    public void setUp() throws Exception {
        lt = new LostTicket();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateFee() {
        assertTrue(lt.CalculateFee() == 25);
    }
}
