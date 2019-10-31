package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientTest {
    private Client _testClient;

    @Before
    public void before() {
        _testClient = new Client();
    }

    @Test
    public void getAndSetClientId() {
        Long id = 12L;
        _testClient.setClientId(id);
        assertEquals(id, _testClient.getClientId());
    }

    @Test
    public void getAndSetFirstname() {
        String firstname = "Firstname";
        _testClient.setFirstname(firstname);
        assertEquals(firstname, _testClient.getFirstname());
    }

    @Test
    public void getAndSetLastname() {
        String lastname = "Lastname";
        _testClient.setLastname(lastname);
        assertEquals(lastname, _testClient.getLastname());
    }

    @Test
    public void getAndSetAddress() {
        String address = "Address 1";
        _testClient.setAddress(address);
        assertEquals(address, _testClient.getAddress());
    }

    @Test
    public void testToString() {
        _testClient.setFirstname("Firstname");
        _testClient.setLastname("Lastname");
        assertEquals("Firstname Lastname", _testClient.toString());
    }
}