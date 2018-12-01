package us.kpatrick.test;
import us.kpatrick.SpecialEventTicket;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class SpecialEventTicketTest {
    SpecialEventTicket sp;

    @Before
    public void setUp() throws Exception {
        sp = new SpecialEventTicket();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateFee() {
        assertTrue(sp.CalculateFee() == 20);
    }
}
