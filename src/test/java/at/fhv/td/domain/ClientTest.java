package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientTest {
    private Client testClient;

    @Before
    public void before() {
        testClient = new Client();
    }

    @Test
    public void getAndSetClientId() {
        Long id = 12L;
        testClient.setClientId(id);
        assertEquals(id, testClient.getClientId());
    }

    @Test
    public void getAndSetFirstname() {
        String firstname = "Firstname";
        testClient.setFirstname(firstname);
        assertEquals(firstname, testClient.getFirstname());
    }

    @Test
    public void getAndSetLastname() {
        String lastname = "Lastname";
        testClient.setLastname(lastname);
        assertEquals(lastname, testClient.getLastname());
    }

    @Test
    public void getAndSetAddress() {
        String address = "Address 1";
        testClient.setAddress(address);
        assertEquals(address, testClient.getAddress());
    }

    @Test
    public void testToString() {
        testClient.setFirstname("Firstname");
        testClient.setLastname("Lastname");
        assertEquals("Firstname Lastname", testClient.toString());
    }
}