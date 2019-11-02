package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EventPlaceCategoryDTOTest {
    private EventPlaceCategoryDTO _testEventPlaceCategory;
    private EventDTO _testEvent;
    private TourDTO _testTour;
    private UserDTO _testUser;
    private LocationDTO _testLocation;
    private PlaceCategoryDTO _testPlaceCategory;

    @Before
    public void before() {
        _testEventPlaceCategory = new EventPlaceCategoryDTO();
    }

    @Test
    public void getAndSetEvent() {
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

        _testLocation = new LocationDTO();
        _testLocation.setAddress("Boden 11");
        _testLocation.setBuilding("Westflügel");
        _testLocation.setRoom("210");
        _testLocation.setSeats(120);
        _testLocation.setStandingPlaces(200);

        _testEvent = new EventDTO();
        _testEvent.setTourId(_testTour);
        _testEvent.setLocationId(_testLocation);
        _testEvent.setSeatReservationPossible(true);
        _testEvent.setDate(LocalDate.now());

        ArrayList<EventDTO> events = new ArrayList<>();
        events.add(_testEvent);
        _testEventPlaceCategory.setEvents(events);
        assertEquals(events, _testEventPlaceCategory.getEvents());
    }

    @Test
    public void getAndSetPlaceCategory() {
        _testPlaceCategory = new PlaceCategoryDTO();
        _testPlaceCategory.setPrice(23.6f);
        _testPlaceCategory.setCategoryname("standingplace A");
        _testPlaceCategory.setCategory("Standingplace");

        ArrayList<PlaceCategoryDTO>  placeCategories = new ArrayList<>();
        placeCategories.add(_testPlaceCategory);
        _testEventPlaceCategory.setPlaceCategories(placeCategories);
        assertEquals(placeCategories, _testEventPlaceCategory.getPlaceCategories());
    }
}
