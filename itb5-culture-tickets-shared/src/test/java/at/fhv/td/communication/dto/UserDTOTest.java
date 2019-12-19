package at.fhv.td.communication.dto;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserDTOTest {

    @Test
    public void getAndSetUserId() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1L);
        assertEquals(1L, userDTO.getUserId());
    }

    @Test
    public void getAndSetUserName() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("name");
        assertEquals("name", userDTO.getUserName());
    }

    @Test
    public void getAndSetRoles() {
        UserDTO userDTO = new UserDTO();
        List<String> roles = new LinkedList<>();
        userDTO.setRoles(roles);
        assertEquals(roles, userDTO.getRoles());
    }
}