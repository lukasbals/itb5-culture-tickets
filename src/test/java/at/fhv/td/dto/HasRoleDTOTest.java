package at.fhv.td.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HasRoleDTOTest {
    private HasRoleDTO _testHasRole;
    private UserDTO _testUser;
    private RoleDTO _testRole;


    @Before
    public void before() {
        _testHasRole = new HasRoleDTO();
    }

    @Test
    public void getAndSetRoles() {
        _testRole = new RoleDTO();
        _testRole.setRights("rwx");
        _testRole.setRoleName("admin");

        ArrayList<RoleDTO> roles = new ArrayList<>();
        roles.add(_testRole);
        _testHasRole.setRoles(roles);
        assertEquals(roles, _testHasRole.getRoles());
    }

    @Test
    public void getAndSetUsers() {
        _testUser = new UserDTO();
        _testUser.setUsername("admin");
        _testUser.setEmail("admin@gmail.com");
        _testUser.setPassword("Password+1234!");
        _testUser.setAddress("Address 1");
        _testUser.setMobile("+43 664/123455");

        ArrayList<UserDTO> users = new ArrayList<>();
        users.add(_testUser);
        _testHasRole.setUsers(users);
        assertEquals(users, _testHasRole.getUsers());
    }

}


