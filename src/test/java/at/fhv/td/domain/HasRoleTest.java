package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HasRoleTest {
    private HasRole _testHasRole;
    private User _testUser;
    private Role _testRole;


    @Before
    public void before() {
        _testHasRole = new HasRole();
    }

    @Test
    public void getAndSetRoles() {
        _testRole = new Role();
        _testRole.setRights("rwx");
        _testRole.setRoleName("admin");

        ArrayList<Role> roles = new ArrayList<>();
        roles.add(_testRole);
        _testHasRole.setRoles(roles);
        assertEquals(roles, _testHasRole.getRoles());
    }

    @Test
    public void getAndSetUsers() {
        _testUser = new User();
        _testUser.setUsername("admin");
        _testUser.setEmail("admin@gmail.com");
        _testUser.setPassword("Password+1234!");
        _testUser.setAddress("Address 1");
        _testUser.setMobile("+43 664/123455");

        ArrayList<User> users = new ArrayList<>();
        users.add(_testUser);
        _testHasRole.setUsers(users);
        assertEquals(users, _testHasRole.getUsers());
    }

}


