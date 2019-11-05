package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketDTOTest {
    private TicketDTO _testTicketDTO;
    private int _ticketNumber = 23;
    private String _categoryname = "Sitzplatz A";
    private String _client = "Vani Durig";
    private Float _price = 23.0f;
    private Long _id = 2l;

    @Before
    public void before() {
        _testTicketDTO = new TicketDTO(_ticketNumber, _categoryname, _client, _price, _id);
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
    public void getCategoryname() {
        assertEquals(_categoryname, _testTicketDTO.getCategoryname());
    }

    @Test
    public void setCategoryname() {
        String categoryName = "Sitzplatz B";
        _testTicketDTO.setCategoryname(categoryName);
        assertEquals(categoryName, _testTicketDTO.getCategoryname());
    }

    @Test
    public void getClient() {
        assertEquals(_client, _testTicketDTO.getClient());
    }

    @Test
    public void setClient() {
        String newClient = "Lukas Bals";
        _testTicketDTO.setClient(newClient);
        assertEquals(newClient, _testTicketDTO.getClient());
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
        assertEquals(_id, _testTicketDTO.getId(),0);
    }

    @Test
    public void setId() {
        Long newId = 4l;
        _testTicketDTO.setId(newId);
        assertEquals(newId, _testTicketDTO.getId(),0);
    }
}
