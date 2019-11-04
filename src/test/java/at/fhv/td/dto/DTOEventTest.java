package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DTOEventTest {
    private DTOEvent _testEvent;
    private String _category ="Sitzplatz";
    private String _artistname = "Bakaboing";
    private String _location = "Spielboden Kantine";
    private String _date = "2020-12-12";
    private float _price = 50.0f;
    @Before
    public void before() {
        _testEvent = new DTOEvent(_category,_artistname,_location,_date,_price);
    }

    @Test
    public void getCategory() {
        assertEquals(_category, _testEvent.getCategory());
    }

    @Test
    public void setCategory() {
        String newCategory = "Stehplatz";
        _testEvent.setCategory(newCategory);
        assertEquals(newCategory, _testEvent.getCategory());
    }

    @Test
    public void getArtistname() {
        assertEquals(_artistname, _testEvent.getArtistname());
    }

    @Test
    public void setArtistname() {
        String newName = "Baka Booooing";
        _testEvent.setArtistname(newName);
        assertEquals(newName, _testEvent.getArtistname());
    }

    @Test
    public void getLocation() {
        assertEquals(_location, _testEvent.getLocation());
    }

    @Test
    public void setLocation() {
        String newLocation = "Conrad Sohm";
        _testEvent.setLocation(newLocation);
        assertEquals(newLocation, _testEvent.getLocation());
    }

    @Test
    public void getDate() {
        assertEquals(_date, _testEvent.getDate());
    }

    @Test
    public void setDate() {
        String newDate = "2020-01-01";
        _testEvent.setDate(newDate);
        assertEquals(newDate, _testEvent.getDate());
    }

    @Test
    public void getPrice() {
        assertEquals(_price, _testEvent.getPrice(),0);
    }

    @Test
    public void setPrice() {
        float newPrice = 30.5f;
        _testEvent.setPrice(newPrice);
        assertEquals(newPrice, _testEvent.getPrice(),0f);
    }
}
