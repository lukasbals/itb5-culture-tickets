package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationTest {
    private Location _testLocation;

    @Before
    public void before() {
        _testLocation = new Location();
    }

    @Test
    public void getAndSetId(){
        Long id = 10L;
        _testLocation.setId(id);
        assertEquals(id, _testLocation.getId());
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
    public void getAndSetLocationId() {
        Long id = 10L;
        _testLocation.setId(id);
        assertEquals(id, _testLocation.getId());
    }

    @Test
    public void toStringTest() {
        String address = "boingweg 9";
        String building = "boingtower";
        String expected = "Location [_address=" + address + ", _building=" + building + "]";
        _testLocation.setAddress(address);
        _testLocation.setBuilding(building);
        assertEquals(expected, _testLocation.toString());
    }
}
