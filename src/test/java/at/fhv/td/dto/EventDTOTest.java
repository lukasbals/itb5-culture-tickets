package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;


import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class EventDTOTest {
    private EventDTO _testEvent;
    private TourDTO _testTour;
    private UserDTO _testUser;
    private LocationDTO _testLocation;

    @Before
    public void before() {
        _testEvent = new EventDTO();
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
        _testEvent.setSeatReservationPossible(true);
        _testEvent.setTourId(_testTour);
        assertEquals(_testTour, _testEvent.getTourId());
    }

    @Test
    public void getAndSetLocationId() {
        _testLocation = new LocationDTO();
        _testLocation.setAddress("Boden 11");
        _testLocation.setBuilding("Westflügel");
        _testLocation.setRoom("210");
        _testLocation.setSeats(120);
        _testLocation.setStandingPlaces(200);
        _testEvent.setLocationId(_testLocation);
        assertEquals(_testLocation, _testEvent.getLocationId());
    }
}

