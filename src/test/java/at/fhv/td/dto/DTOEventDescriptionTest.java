package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DTOEventDescriptionTest {
    private DTOEventDescription _testEventDescription;
    private String _artistname = "ArtistPia";
    private String _description = "a play about something interesting";
    private String _location = "Boden 11";
    private float _price = 33.0f;
    private boolean _isSeatReservationPossible = false;
    private String _categoryName = "Sitzplatzkategorie B";
    private String _category = "Sitzplatz";
    private int[] _notSoldTicketNumbers = {1, 2, 3, 45, 5};

    @Before
    public void before() {
        _testEventDescription = new DTOEventDescription(_artistname, _description, _location, _price,
                _isSeatReservationPossible, _categoryName, _category, _notSoldTicketNumbers);
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
        float newPrice = 30.5f;
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
    public void getNotSoldTickets() {
        assertEquals(_notSoldTicketNumbers, _testEventDescription.getNotSoldTicketNumbers());
    }

    @Test
    public void setNotSoldTickets() {
        int[] newSoldOnes = {12, 21, 32, 45, 5};
        _testEventDescription.setNotSoldTicketNumbers(newSoldOnes);
        assertEquals(newSoldOnes, _testEventDescription.getNotSoldTicketNumbers());
    }
}
