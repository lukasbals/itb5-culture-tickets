package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TourTest {
    private Tour _testTour;
    private User _testUser;

    @Before
    public void before() {
        _testTour = new Tour();
    }

    @Test
    public void getAndSetUsername() {
        _testUser = new User();
        _testUser.setUsername("admin");
        _testUser.setEmail("admin@gmail.com");
        _testUser.setPassword("Password+1234!");
        _testUser.setAddress("Address 1");
        _testUser.setMobile("+43 664/123455");
        _testTour.setUsername(_testUser);
        assertEquals(_testUser, _testTour.getUsername());
    }

    @Test
    public void getAndSetDescription() {
        String description = "it is an amazing play.";
        _testTour.setDescription(description);
        assertEquals(description, _testTour.getDescription());
    }

    @Test
    public void getAndSetCategory() {
        String category = "Theatre";
        _testTour.setCategory(category);
        assertEquals(category, _testTour.getCategory());
    }

    @Test
    public void getAndSetArtists() {
        Artist newArtist = new Artist();
        newArtist.setArtistName("BakaBoing");
        Set<Artist> artists = new HashSet<>();
        artists.add(newArtist);

        _testTour.setArtists(artists);
        assertEquals(artists, _testTour.getArtists());
    }
}
