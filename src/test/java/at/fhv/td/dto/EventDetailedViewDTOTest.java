package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EventDetailedViewDTOTest {
    private EventDetailedViewDTO _testEventDescription;
    private String _artistname = "ArtistPia";
    private String _description = "a play about something interesting";
    private String _location = "Boden 11";
    private Float _price = 33.0f;
    private Boolean _isSeatReservationPossible = false;
    private String _categoryName = "Sitzplatzkategorie B";
    private String _category = "Sitzplatz";
    private String _date = "2020-12-12";
    private String _genre = "play";
    private TicketDTO ticket1 = new TicketDTO(23, "Sitzplatz A", "Vani Durig", 23.0f, 3l);
    private TicketDTO ticket2 = new TicketDTO(24, "Sitzplatz A", "Pia-Maria Weiß", 23.0f, 4l);
    private TicketDTO[] _ticketNumbers = {ticket1, ticket2};
    private Long _id = 12l;

    @Before
    public void before() {
        _testEventDescription = new EventDetailedViewDTO(_artistname, _description, _genre, _location, _price,
                _isSeatReservationPossible, _categoryName, _category, _date, _ticketNumbers, _id);
    }

    @Test
    public void getArtistname() {
        assertEquals(_artistname, _testEventDescription.getArtistname());
    }

    @Test
    public void setArtistname() {
        String newArtistname = "Pia the Artist";
        _testEventDescription.setArtistname(newArtistname);
        assertEquals(newArtistname, _testEventDescription.getArtistname());
    }

    @Test
    public void getDescription() {
        assertEquals(_description, _testEventDescription.getDescription());
    }

    @Test
    public void setDescription() {
        String newDesc = "now it is a play";
        _testEventDescription.setDescription(newDesc);
        assertEquals(newDesc, _testEventDescription.getDescription());
    }

    @Test
    public void getLocation() {
        assertEquals(_location, _testEventDescription.getLocation());
    }

    @Test
    public void setLocation() {
        String newLocation = "Conrad Sohm";
        _testEventDescription.setLocation(newLocation);
        assertEquals(newLocation, _testEventDescription.getLocation());
    }

    @Test
    public void getPrice() {
        assertEquals(_price, _testEventDescription.getPrice(), 0);
    }

    @Test
    public void setPrice() {
        Float newPrice = 30.5f;
        _testEventDescription.setPrice(newPrice);
        assertEquals(newPrice, _testEventDescription.getPrice(), 0f);
    }

    @Test
    public void getIsSeatReservationPossible() {
        assertEquals(_isSeatReservationPossible, _testEventDescription.isSeatReservationPossible());
    }

    @Test
    public void setIsSeatReservationPossible() {
        _testEventDescription.setSeatReservationPossible(true);
        assertTrue(_testEventDescription.isSeatReservationPossible());
    }

    @Test
    public void getCategoryName() {
        assertEquals(_categoryName, _testEventDescription.getCategoryName());
    }

    @Test
    public void setCategoryName() {
        String newCatName = "Sitzplatzkategorie A";
        _testEventDescription.setCategoryName(newCatName);
        assertEquals(newCatName, _testEventDescription.getCategoryName());
    }

    @Test
    public void getCategory() {
        assertEquals(_category, _testEventDescription.getCategory());
    }

    @Test
    public void setCategory() {
        String newCategory = "Stehplatz";
        _testEventDescription.setCategory(newCategory);
        assertEquals(newCategory, _testEventDescription.getCategory());
    }

    @Test
    public void getTicketNumbers() {
        assertEquals(_ticketNumbers, _testEventDescription.getTicket());
    }

    @Test
    public void setTicketNumbers() {
        TicketDTO newTicket1 = new TicketDTO(25, "Sitzplatz A", "Patrick Poiger", 23.0f, 6l);
        TicketDTO newTicket2 = new TicketDTO(26, "Sitzplatz A", "Lukas Bals", 23.0f, 7l);
        TicketDTO[] _ticketNumbers = {newTicket1, newTicket2};
        _testEventDescription.setTicket(_ticketNumbers);
        assertEquals(_ticketNumbers, _testEventDescription.getTicket());
    }

    @Test
    public void getDate() {
        assertEquals(_date, _testEventDescription.getDate());
    }

    @Test
    public void setDate() {
        String newDate = "2020-01-01";
        _testEventDescription.setDate(newDate);
        assertEquals(newDate, _testEventDescription.getDate());
    }

    @Test
    public void getGenre() {
        assertEquals(_genre, _testEventDescription.getGenre());
    }

    @Test
    public void setGenre() {
        String newGenre = "Theater";
        _testEventDescription.setGenre(newGenre);
        assertEquals(newGenre, _testEventDescription.getGenre());
    }

    @Test
    public void getId() {
        assertEquals(_id, _testEventDescription.getId(),0);
    }

    @Test
    public void setId() {
        Long newId = 34l;
        _testEventDescription.setId(newId);
        assertEquals(newId, _testEventDescription.getId(),0);
    }

}
