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
}