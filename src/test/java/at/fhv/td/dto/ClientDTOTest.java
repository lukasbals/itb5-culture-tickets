package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;

public class ClientDTOTest {
    private ClientDTO _testClient;
    private String _fname = "Patrick";
    private String _lname = "Poiger";
    private String _address = "Zuhause 1";
    private Long _id = 1l;

    @Before
    public void before() throws RemoteException {
        _testClient = new ClientDTO();
        _testClient.setFirstName(_fname);
        _testClient.setLastName(_lname);
        _testClient.setAddress(_address);
        _testClient.setId(_id);
    }

    @Test
    public void getFirstName() {
        assertEquals(_fname, _testClient.getFirstName());
    }

    @Test
    public void setFirstName() {
        String newFname = "Gudrun";
        _testClient.setFirstName(newFname);
        assertEquals(newFname, _testClient.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(_lname, _testClient.getLastName());
    }

    @Test
    public void setLastName() {
        String newLname = "Hofer";
        _testClient.setLastName(newLname);
        assertEquals(newLname, _testClient.getLastName());
    }

    @Test
    public void getAddress() {
        assertEquals(_address, _testClient.getAddress());
    }

    @Test
    public void setAddress() {
        String newAdd = "Bludenzerweg 1";
        _testClient.setAddress(newAdd);
        assertEquals(newAdd, _testClient.getAddress());
    }

    @Test
    public void getId() {
        assertEquals(_id, _testClient.getId());
    }

    @Test
    public void setId() {
        Long newId = 2l;
        _testClient.setId(newId);
        assertEquals(newId, _testClient.getId());
    }
}
