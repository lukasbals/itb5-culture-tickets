package at.fhv.td.communication.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(PowerMockRunner.class)
public class TicketDTOTest {
    private TicketDTO _testTicketDTO;
    private int _ticketNumber = 23;
    private String _categoryname = "Sitzplatz A";
    private Long _client = 2L;
    private Float _price = 23.0f;
    private Long _id = 2l;
    private Long _eventId = 4L;

    @Mock
    private TicketDTO _anotherTestTicketDTO;

    @Before
    public void before() {
        _testTicketDTO = new TicketDTO();
        _testTicketDTO.setTicketNumber(_ticketNumber);
        _testTicketDTO.setCategoryName(_categoryname);
        _testTicketDTO.setClientId(_client);
        _testTicketDTO.setPrice(_price);
        _testTicketDTO.setId(_id);
    }

    @Test
    public void getTicketNumber() {
        assertEquals(_ticketNumber, _testTicketDTO.getTicketNumber());
    }

    @Test
    public void setTicketNumber() {
        int newTicketNr = 25;
        _testTicketDTO.setTicketNumber(newTicketNr);
        assertEquals(newTicketNr, _testTicketDTO.getTicketNumber());
    }

    @Test
    public void getCategoryName() {
        assertEquals(_categoryname, _testTicketDTO.getCategoryName());
    }

    @Test
    public void setCategoryName() {
        String categoryName = "Sitzplatz B";
        _testTicketDTO.setCategoryName(categoryName);
        assertEquals(categoryName, _testTicketDTO.getCategoryName());
    }

    @Test
    public void getClient() {
        assertEquals(_client, _testTicketDTO.getClientId());
    }

    @Test
    public void setClient() {
        Long newClient = 2L;
        _testTicketDTO.setClientId(newClient);
        assertEquals(newClient, _testTicketDTO.getClientId());
    }

    @Test
    public void getPrice() {
        assertEquals(_price, _testTicketDTO.getPrice(), 0);
    }

    @Test
    public void setPrice() {
        Float newPrice = 30.5f;
        _testTicketDTO.setPrice(newPrice);
        assertEquals(newPrice, _testTicketDTO.getPrice(), 0f);
    }

    @Test
    public void getId() {
        assertEquals(_id, _testTicketDTO.getId(), 0);
    }

    @Test
    public void setId() {
        Long newId = 4l;
        _testTicketDTO.setId(newId);
        assertEquals(newId, _testTicketDTO.getId(), 0);
    }

    @Test
    public void getAndSetEventId() {
        Long eventId = 4L;
        _testTicketDTO.setEventId(eventId);
        assertEquals(eventId, _testTicketDTO.getEventId());
    }

    @Test
    public void getAndSetSold() {
        int sold = 1;
        _testTicketDTO.setSold(sold);
        assertEquals(sold, _testTicketDTO.getSold());
    }

    @Test
    public void getAndSetCategoryId() {
        Long catId = 5L;
        _testTicketDTO.setCategoryId(catId);
        assertEquals(catId, _testTicketDTO.getCategoryId());
    }

    @Test
    public void hashCodeAndEqualsTest() {
        _testTicketDTO.setId(_id);
        _testTicketDTO.setTicketNumber(_ticketNumber);
        TicketDTO compareDto = new TicketDTO();
        compareDto.setId(_id);
        compareDto.setTicketNumber(_ticketNumber);

        assertEquals(_testTicketDTO, compareDto);
        assertEquals(compareDto.hashCode(), _testTicketDTO.hashCode());
    }

    @Test
    public void equalsFailTest() {
        _testTicketDTO.setId(_id);
        _testTicketDTO.setTicketNumber(_ticketNumber);

        assertNotEquals(_testTicketDTO, "");
        assertNotEquals(_testTicketDTO, _anotherTestTicketDTO);
    }
}
