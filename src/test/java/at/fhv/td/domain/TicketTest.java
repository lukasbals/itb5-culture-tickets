package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketTest {
    private Ticket _testTicket;
    private PlaceCategory _testCategory;
    private Client _testClient;


    @Before
    public void before() {
        _testTicket = new Ticket();
    }

    @Test
    public void getAndSetTicketNumber() {
        Integer integer = 1234;
        _testTicket.setTicketNumber(integer);
        assertEquals(integer, _testTicket.getTicketNumber());
    }

    @Test
    public void getAndSetSold() {
        Integer integer = 1;
        _testTicket.setSold(integer);
        assertEquals(integer, _testTicket.getSold());
    }

    @Test
    public void getAndSetCategoryname() {
        _testCategory = new PlaceCategory();
        _testCategory.setCategory("Standingplace 2");
        _testCategory.setCategoryname("Standingplace");
        _testCategory.setPrice(23.6f);
        _testTicket.setPlaceCategory(_testCategory);
        assertEquals(_testCategory, _testTicket.getPlaceCategory());
    }

    @Test
    public void getAndSetClientId() {
        _testClient = new Client();
        _testClient.setFirstname("Firstname");
        _testClient.setLastname("Lastname");
        _testClient.setAddress("Address 1");
        _testTicket.setClient(_testClient);
        assertEquals(_testClient, _testTicket.getClient());
    }
}


