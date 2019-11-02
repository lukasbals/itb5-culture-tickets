package at.fhv.td.dto;

import at.fhv.td.domain.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ClientDTOTest {
    private ClientDTO _testClient;

    @Before
    public void before() {
        _testClient = new ClientDTO();
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