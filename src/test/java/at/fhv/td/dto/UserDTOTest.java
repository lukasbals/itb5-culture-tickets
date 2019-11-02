package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class UserDTOTest {
    private UserDTO _testUser;

    @Before
    public void before() {
        _testUser = new UserDTO();
    }

    @Test
    public void getAndSetUsername() {
        String username = "admin";
        _testUser.setUsername(username);
        assertEquals(username, _testUser.getUsername());
    }

    @Test
    public void getAndSetPassword() {
        String password = "Password+12!";
        _testUser.setPassword(password);
        assertEquals(password, _testUser.getPassword());
    }

    @Test
    public void getAndSetAddress() {
        String address = "Adresse 1";
        _testUser.setAddress(address);
        assertEquals(address, _testUser.getAddress());
    }

    @Test
    public void getAndSetMobile() {
        String mobileNr = "+43 664/1234567";
        _testUser.setMobile(mobileNr);
        assertEquals(mobileNr, _testUser.getMobile());
    }

    @Test
    public void getAndSetEmail() {
        String mail = "admin@gmail.com";
        _testUser.setEmail(mail);
        assertEquals(mail, _testUser.getEmail());
    }

}

