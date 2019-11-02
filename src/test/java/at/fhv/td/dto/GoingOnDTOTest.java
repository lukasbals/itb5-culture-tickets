package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GoingOnDTOTest {
    private GoingOnDTO _testGoingOn;
    private UserDTO _testUser;
    private TourDTO _testTour;
    private ArtistDTO _testArtist;

    @Before
    public void before() {
        _testGoingOn = new GoingOnDTO();
    }

    @Test
    public void getAndSetTour() {
        _testUser = new UserDTO();
        _testUser.setUsername("admin");
        _testUser.setEmail("admin@gmail.com");
        _testUser.setPassword("Password+1234!");
        _testUser.setAddress("Address 1");
        _testUser.setMobile("+43 664/123455");

        _testTour = new TourDTO();
        _testTour.setCategory("Theatre");
        _testTour.setDescription("it is an amazing play");
        _testTour.setUsername(_testUser);

        ArrayList<TourDTO> tours = new ArrayList<>();
        tours.add(_testTour);
        _testGoingOn.setTours(tours);
        assertEquals(tours, _testGoingOn.getTours());
    }

    @Test
    public void getAndSetRoom() {
        _testArtist = new ArtistDTO();
        _testArtist.setGenre("Pop");
        ArrayList<ArtistDTO> artists = new ArrayList<>();
        artists.add(_testArtist);
        _testGoingOn.setArtists(artists);
        assertEquals(artists, _testGoingOn.getArtists());
    }
}


