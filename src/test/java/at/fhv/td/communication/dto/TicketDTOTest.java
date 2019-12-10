package at.fhv.td.communication.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

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
        try {
            _testTicketDTO = new TicketDTO();
            _testTicketDTO.setTicketNumber(_ticketNumber);
            _testTicketDTO.setCategoryName(_categoryname);
            _testTicketDTO.setClientId(_client);
            _testTicketDTO.setPrice(_price);
            _testTicketDTO.setId(_id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTicketNumber() throws RemoteException {
        assertEquals(_ticketNumber, _testTicketDTO.getTicketNumber());
    }

    @Test
    public void setTicketNumber() throws RemoteException {
        int newTicketNr = 25;
        _testTicketDTO.setTicketNumber(newTicketNr);
        assertEquals(newTicketNr, _testTicketDTO.getTicketNumber());
    }

    @Test
    public void getCategoryName() throws RemoteException {
        assertEquals(_categoryname, _testTicketDTO.getCategoryName());
    }

    @Test
    public void setCategoryName() throws RemoteException {
        String categoryName = "Sitzplatz B";
        _testTicketDTO.setCategoryName(categoryName);
        assertEquals(categoryName, _testTicketDTO.getCategoryName());
    }

    @Test
    public void getClient() throws RemoteException {
        assertEquals(_client, _testTicketDTO.getClientId());
    }

    @Test
    public void setClient() throws RemoteException {
        Long newClient = 2L;
        _testTicketDTO.setClientId(newClient);
        assertEquals(newClient, _testTicketDTO.getClientId());
    }

    @Test
    public void getPrice() throws RemoteException {
        assertEquals(_price, _testTicketDTO.getPrice(), 0);
    }

    @Test
    public void setPrice() throws RemoteException {
        Float newPrice = 30.5f;
        _testTicketDTO.setPrice(newPrice);
        assertEquals(newPrice, _testTicketDTO.getPrice(), 0f);
    }

    @Test
    public void getId() throws RemoteException {
        assertEquals(_id, _testTicketDTO.getId(), 0);
    }

    @Test
    public void setId() throws RemoteException {
        Long newId = 4l;
        _testTicketDTO.setId(newId);
        assertEquals(newId, _testTicketDTO.getId(), 0);
    }

    @Test
    public void getAndSetEventId() throws RemoteException {
        Long eventId = 4L;
        _testTicketDTO.setEventId(eventId);
        assertEquals(eventId, _testTicketDTO.getEventId());
    }

    @Test
    public void getAndSetSold() throws RemoteException {
        int sold = 1;
        _testTicketDTO.setSold(sold);
        assertEquals(sold, _testTicketDTO.getSold());
    }

    @Test
    public void getAndSetCategoryId() throws RemoteException {
        Long catId = 5L;
        _testTicketDTO.setCategoryId(catId);
        assertEquals(catId, _testTicketDTO.getCategoryId());
    }

    @Test
    public void hashCodeAndEqualsTest() throws RemoteException {
        _testTicketDTO.setId(_id);
        _testTicketDTO.setTicketNumber(_ticketNumber);
        TicketDTO compareDto = new TicketDTO();
        compareDto.setId(_id);
        compareDto.setTicketNumber(_ticketNumber);

        assertEquals(_testTicketDTO, compareDto);
        assertEquals(compareDto.hashCode(), _testTicketDTO.hashCode());
    }

    @Test
    public void equalsFailTest() throws RemoteException {
        _testTicketDTO.setId(_id);
        _testTicketDTO.setTicketNumber(_ticketNumber);

        when(_anotherTestTicketDTO.getId()).thenThrow(RemoteException.class);

        assertNotEquals(_testTicketDTO, "");
        assertNotEquals(_testTicketDTO, _anotherTestTicketDTO);
    }
}
