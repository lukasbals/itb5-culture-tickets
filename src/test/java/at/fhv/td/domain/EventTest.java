package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
    @Mock
    private List<Ticket> _tickets;

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
        _testEvent.setLocation(_testLocation);
        assertEquals(_testLocation, _testEvent.getLocation());
    }

    @Test
    public void getEventname() {
        String name = "Boohya";
        _testTour = new Tour();
        _testTour.setTourName(name);
        _testEvent.setTour(_testTour);
        assertEquals(name, _testEvent.getEventName());
    }

    @Test
    public void getAndSetPlaceCategories() {
        Set<PlaceCategory> categories = new HashSet<>();
        categories.add(_placeCategory);
        _testEvent.setPlaceCategories(categories);
        assertEquals(1, _testEvent.getPlaceCategories().size());
    }

    @Test
    public void getAndSetTickets() {
        _testEvent.setTickets(_tickets);
        assertEquals(_tickets, _testEvent.getTickets());
    }

    @Test
    public void getEventId() {
        Long testId = 3L;
        _testEvent.setId(testId);
        assertEquals(testId, _testEvent.getId());
    }

    @Test
    public void equalsAndHashCode() {
        Long testId = 3L;
        _testEvent.setId(testId);
        Event testEvent = new Event();
        testEvent.setId(testId);
        assertEquals(testEvent, _testEvent);
        assertEquals(testEvent.hashCode(), _testEvent.hashCode());
        assertNotEquals("", _testEvent);
    }
}
