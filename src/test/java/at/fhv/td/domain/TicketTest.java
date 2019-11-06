package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class TicketTest {
    private Ticket _testTicket;
    private PlaceCategory _testCategory;
    private Client _testClient;

    @Mock
    Event _mockEvent;

    @Before
    public void before() {
        _testTicket = new Ticket();
        _testCategory = new PlaceCategory();
        _testCategory.setCategoryId(1L);
        _testCategory.setCategory("Standingplace 2");
        _testCategory.setCategoryname("Standingplace");
        _testCategory.setPrice(23.6f);
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

    @Test
    public void getAndSetEvent(){
        _testTicket.setEvent(_mockEvent);
        assertEquals(_mockEvent, _testTicket.getEvent());
    }

    @Test
    public void equalsAndHashCode(){
        when(_mockEvent.getEventId()).thenReturn(1L);
        int ticketNumber = 10;
        _testTicket.setTicketNumber(ticketNumber);
        _testTicket.setEvent(_mockEvent);
        _testTicket.setPlaceCategory(_testCategory);

        Ticket testTicket = new Ticket();
        testTicket.setTicketNumber(ticketNumber);
        testTicket.setEvent(_mockEvent);
        testTicket.setPlaceCategory(_testCategory);

        assertEquals(testTicket, _testTicket);
        assertNotEquals("", _testTicket);
        assertEquals(testTicket.hashCode(), _testTicket.hashCode());
    }

    @Test
    public void getTicketId(){
        Long testId = 5L;
        _testTicket.setTicketId(testId);
        assertEquals(testId, _testTicket.getTicketId());
    }
}


