package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DTOArtistTest {
    private DTOArtist _testArtist;
    private String _artistname = "Vaniii Hase";
    private String _genre = "Alternative Pop";

    @Before
    public void before() {
        _testArtist = new DTOArtist(_artistname, _genre);
    }

    @Test
    public void getArtistname() {
        assertEquals(_artistname, _testArtist.getArtistname());
    }

    @Test
    public void setArtistname() {
        String newName = "BalsiBals";
        _testArtist.setArtistname(newName);
        assertEquals(newName, _testArtist.getArtistname());
    }

    @Test
    public void getGenre() {

        assertEquals(_genre, _testArtist.getGenre());
    }

    @Test
    public void setGenre() {
        String newGenre = "Sachkundevortrag";
        _testArtist.setGenre(newGenre);
        assertEquals(newGenre, _testArtist.getGenre());
    }
}
