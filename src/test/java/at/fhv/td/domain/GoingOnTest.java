package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GoingOnTest {
    private GoingOn _testGoingOn;
    private User _testUser;
    private Tour _testTour;
    private Artist _testArtist;

    @Before
    public void before() {
        _testGoingOn = new GoingOn();
    }

    @Test
    public void getAndSetTour() {
        _testUser = new User();
        _testUser.setUsername("admin");
        _testUser.setEmail("admin@gmail.com");
        _testUser.setPassword("Password+1234!");
        _testUser.setAddress("Address 1");
        _testUser.setMobile("+43 664/123455");

        _testTour = new Tour();
        _testTour.setCategory("Theatre");
        _testTour.setDescription("it is an amazing play");
        _testTour.setUsername(_testUser);

        ArrayList<Tour> tours = new ArrayList<>();
        tours.add(_testTour);
        _testGoingOn.setTours(tours);
        assertEquals(tours, _testGoingOn.getTours());
    }

    @Test
    public void getAndSetRoom() {
        _testArtist = new Artist();
        _testArtist.setGenre("Pop");
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(_testArtist);
        _testGoingOn.setArtists(artists);
        assertEquals(artists, _testGoingOn.getArtists());
    }
}


