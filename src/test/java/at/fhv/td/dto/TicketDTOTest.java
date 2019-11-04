package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class TicketDTOTest {
    private TicketDTO _testTicketDTO;
    private int _ticketNumber = 23;
    private String _categoryname = "Sitzplatz A";
    private String _client = "Vani Durig";
    private Float _price = 23.0f;
    private Long _id = 2l;

    @Mock
    private TicketDTO _anotherTestTicketDTO;

    @Before
    public void before() {
        try {
            _testTicketDTO = new TicketDTO();
            _testTicketDTO.setTicketNumber(_ticketNumber);
            _testTicketDTO.setCategoryname(_categoryname);
            _testTicketDTO.setClient(_client);
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
    public void getCategoryname() throws RemoteException {
        assertEquals(_categoryname, _testTicketDTO.getCategoryname());
    }

    @Test
    public void setCategoryname() throws RemoteException {
        String categoryName = "Sitzplatz B";
        _testTicketDTO.setCategoryname(categoryName);
        assertEquals(categoryName, _testTicketDTO.getCategoryname());
    }

    @Test
    public void getClient() throws RemoteException {
        assertEquals(_client, _testTicketDTO.getClient());
    }

    @Test
    public void setClient() throws RemoteException {
        String newClient = "Lukas Bals";
        _testTicketDTO.setClient(newClient);
        assertEquals(newClient, _testTicketDTO.getClient());
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
    public void hashCodeAndEqualsTest() throws RemoteException {
        _testTicketDTO.setId(_id);
        _testTicketDTO.setTicketNumber(_ticketNumber);
        TicketDTO compareDto = new TicketDTO();
        compareDto.setId(_id);
        compareDto.setTicketNumber(_ticketNumber);

        assertTrue(_testTicketDTO.equals(compareDto));
        assertEquals(compareDto.hashCode(), _testTicketDTO.hashCode());
    }

    @Test
    public void equalsFailTest() throws RemoteException {
        _testTicketDTO.setId(_id);
        _testTicketDTO.setTicketNumber(_ticketNumber);

        when(_anotherTestTicketDTO.getId()).thenThrow(RemoteException.class);

        assertFalse(_testTicketDTO.equals(new String("")));
        assertFalse(_testTicketDTO.equals(_anotherTestTicketDTO));
    }
}
