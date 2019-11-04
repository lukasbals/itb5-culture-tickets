package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ArtistTest {
    private Artist _testArtist;

    @Before
    public void before() {
        _testArtist = new Artist();
    }

    @Test
    public void getAndSetGenre() {
        String genre = "Theater";
        _testArtist.setGenre(genre);
        assertEquals(genre, _testArtist.getGenre());
    }
}
