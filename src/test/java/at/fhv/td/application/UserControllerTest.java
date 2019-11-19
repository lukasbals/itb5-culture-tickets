package at.fhv.td.application;

import at.fhv.td.domain.Role;
import at.fhv.td.domain.User;
import at.fhv.td.persistence.broker.UserBroker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserBroker.class)
public class UserControllerTest {

    @Mock
    UserBroker _broker;

    @Before
    public void before() {
        mockStatic(UserBroker.class);

        List<User> users = new LinkedList<>();
        users.add(new User());

        when(UserBroker.getInstance()).thenReturn(_broker);
        when(_broker.getAll(any(List.class))).thenReturn(users);
    }

    @Test
    public void getUser() {
        assertTrue(UserController.getUser("test") instanceof User);
    }

    @Test
    public void getUserFail() {
        when(_broker.getAll(any(List.class))).thenReturn(new LinkedList());
        assertNull(UserController.getUser("test"));
    }

    @Test
    public void hasRole() {
        assertFalse(UserController.hasRole(null, "admin"));

        Role newRole = new Role();
        newRole.setRoleName("admin");
        Set<Role> roles = new HashSet<>();
        roles.add(newRole);
        User newUser = new User();
        newUser.setRoles(roles);

        assertTrue(UserController.hasRole(newUser, "admin"));
    }
}