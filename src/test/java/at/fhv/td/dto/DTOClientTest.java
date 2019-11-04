package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DTOClientTest {
    private DTOClient _testClient;
    private String _fname = "Patrick";
    private String _lname = "Poiger";
    private String _address = "Zuhause 1";

    @Before
    public void before() {
        _testClient = new DTOClient(_fname, _lname, _address);
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
}
