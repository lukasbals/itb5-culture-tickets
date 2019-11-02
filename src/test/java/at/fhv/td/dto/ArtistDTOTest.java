package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ArtistDTOTest {
    private ArtistDTO _testArtist;

    @Before
    public void before() {
        _testArtist = new ArtistDTO();
    }

    @Test
    public void getAndSetGenre() {
        String genre = "Theater";
        _testArtist.setGenre(genre);
        assertEquals(genre, _testArtist.getGenre());
    }
}
