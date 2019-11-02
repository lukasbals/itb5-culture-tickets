package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketDTOTest {
    private TicketDTO _testTicket;
    private PlaceCategoryDTO _testCategory;
    private ClientDTO _testClient;


    @Before
    public void before() {
        _testTicket = new TicketDTO();
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
        _testCategory = new PlaceCategoryDTO();
        _testCategory.setCategory("Standingplace 2");
        _testCategory.setCategoryname("Standingplace");
        _testCategory.setPrice(23.6f);
        _testTicket.setCategoryname(_testCategory);
        assertEquals(_testCategory, _testTicket.getCategoryname());
    }

    @Test
    public void getAndSetClientId() {
        _testClient = new ClientDTO();
        _testClient.setFirstname("Firstname");
        _testClient.setLastname("Lastname");
        _testClient.setAddress("Address 1");
        _testTicket.setClientId(_testClient);
        assertEquals(_testClient, _testTicket.getClientId());
    }
}


