package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EventPlaceCategoryTest {
    private EventPlaceCategory _testEventPlaceCategory;
    private Event _testEvent;
    private Tour _testTour;
    private User _testUser;
    private Location _testLocation;
    private PlaceCategory _testPlaceCategory;

    @Before
    public void before() {
        _testEventPlaceCategory = new EventPlaceCategory();
    }

    @Test
    public void getAndSetEvent() {
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

        _testLocation = new Location();
        _testLocation.setAddress("Boden 11");
        _testLocation.setBuilding("Westflügel");
        _testLocation.setRoom("210");
        _testLocation.setSeats(120);
        _testLocation.setStandingPlaces(200);

        _testEvent = new Event();
        _testEvent.setTourId(_testTour);
        _testEvent.setLocationId(_testLocation);
        _testEvent.setSeatReservationPossible(true);
        _testEvent.setDate(LocalDate.now());

        ArrayList<Event> events = new ArrayList<>();
        events.add(_testEvent);
        _testEventPlaceCategory.setEvents(events);
        assertEquals(events, _testEventPlaceCategory.getEvents());
    }

    @Test
    public void getAndSetPlaceCategory() {
        _testPlaceCategory = new PlaceCategory();
        _testPlaceCategory.setPrice(23.6f);
        _testPlaceCategory.setCategoryname("standingplace A");
        _testPlaceCategory.setCategory("Standingplace");

        ArrayList<PlaceCategory>  placeCategories = new ArrayList<>();
        placeCategories.add(_testPlaceCategory);
        _testEventPlaceCategory.setPlaceCategories(placeCategories);
        assertEquals(placeCategories, _testEventPlaceCategory.getPlaceCategories());
    }
}
