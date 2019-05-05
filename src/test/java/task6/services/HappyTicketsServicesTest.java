package task6.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HappyTicketsServicesTest {
    private HappyTicketsServices happyTicketsServices;

    @Before
    public void setUp() throws Exception {
        happyTicketsServices = new HappyTicketsServices();
    }

    @Test
    public void countNumberOfLuckyTicketsMoskowTest() {
        //GIVEN
        long expectedNumberOfLuckyTickets = 55251;
        String algorithm = "Moskow";

        //WHEN
        long numberOfLuckyTickets = happyTicketsServices.countNumberOfLuckyTickets(algorithm);

        //THEN
        assertEquals(expectedNumberOfLuckyTickets, numberOfLuckyTickets);
    }

    @Test
    public void countNumberOfLuckyTicketsPiterTest() {
        //GIVEN
        long expectedNumberOfLuckyTickets = 25080;
        String algorithm = "Piter";

        //WHEN
        long numberOfLuckyTickets = happyTicketsServices.countNumberOfLuckyTickets(algorithm);

        //THEN
        assertEquals(expectedNumberOfLuckyTickets, numberOfLuckyTickets);
    }
}