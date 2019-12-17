package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
public class ArtistTest {
    private Artist _testArtist;

    @Mock
    private Tour _tour;

    @Before
    public void before() {
        _testArtist = new Artist();
    }

    @Test
    public void getAndSetArtistId(){
        Long id = 10L;
        _testArtist.setId(id);
        assertEquals(id, _testArtist.getId());
    }

    @Test
    public void getAndSetGenre() {
        String genre = "Theater";
        _testArtist.setGenre(genre);
        assertEquals(genre, _testArtist.getGenre());
    }

    @Test
    public void getAndSetArtistname() {
        String name = "MoD";
        _testArtist.setArtistName(name);
        assertEquals(name, _testArtist.getArtistname());
    }

    @Test
    public void getAndSetTours() {
        Set<Tour> tours = new HashSet<>();
        tours.add(_tour);
        _testArtist.setTours(tours);
        assertTrue(_testArtist.getTours().size() == 1);
    }
}
