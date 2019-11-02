package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationDTOTest {
    private LocationDTO _testLocation;

    @Before
    public void before() {
        _testLocation = new LocationDTO();
    }

    @Test
    public void getAndSetAddress() {
        String address = "Address 1";
        _testLocation.setAddress(address);
        assertEquals(address, _testLocation.getAddress());
    }

    @Test
    public void getAndSetRoom() {
        String room = "140";
        _testLocation.setRoom(room);
        assertEquals(room, _testLocation.getRoom());
    }

    @Test
    public void getAndSetBuilding() {
        String building = "Building A";
        _testLocation.setBuilding(building);
        assertEquals(building, _testLocation.getBuilding());
    }

    @Test
    public void getAndSetSeats() {
        Integer seats = 230;
        _testLocation.setSeats(seats);
        assertEquals(seats, _testLocation.getSeats());
    }

    @Test
    public void getAndSetStandingPlaces() {
        Integer standingPlaces = 100;
        _testLocation.setStandingPlaces(standingPlaces);
        assertEquals(standingPlaces, _testLocation.getStandingPlaces());
    }
}
