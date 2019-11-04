package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
public class EventTest {
    private Event _testEvent;
    private Tour _testTour;
    private User _testUser;
    private Location _testLocation;

    @Mock
    private Event _testEventMock;
    @Mock
    private Tour _testTourMock;
    @Mock
    private PlaceCategory _placeCategory;

    @Before
    public void before() {
        _testEvent = new Event();
    }

    @Test
    public void getAndSetDate() {
        LocalDate date = LocalDate.now();
        _testEvent.setDate(date);
        assertEquals(date, _testEvent.getDate());
    }

    @Test
    public void getAndSetSeatReservationPossible() {
        _testEvent.setSeatReservationPossible(true);
        assertEquals(true, _testEvent.getSeatReservationPossible());
    }

    @Test
    public void getAndSetTourId() {
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
        _testEvent.setSeatReservationPossible(true);
        _testEvent.setTour(_testTour);
        assertEquals(_testTour, _testEvent.getTour());
    }

    @Test
    public void getAndSetLocationId() {
        _testLocation = new Location();
        _testLocation.setAddress("Boden 11");
        _testLocation.setBuilding("Westflügel");
        _testLocation.setRoom("210");
        _testLocation.setSeats(120);
        _testLocation.setStandingPlaces(200);
        _testEvent.setLocation(_testLocation);
        assertEquals(_testLocation, _testEvent.getLocation());
    }

    @Test
    public void getEventname() {
        String name = "Boohya";
        _testTour = new Tour();
        _testTour.setTourName(name);
        _testEvent.setTour(_testTour);
        assertEquals(name, _testEvent.getEventname());
    }

    @Test
    public void getAndSetPlaceCategories() {
        Set<PlaceCategory> categories = new HashSet<>();
        categories.add(_placeCategory);
        _testEvent.setPlaceCategories(categories);
        assertTrue(_testEvent.getPlaceCategories().size() == 1);
    }
}
