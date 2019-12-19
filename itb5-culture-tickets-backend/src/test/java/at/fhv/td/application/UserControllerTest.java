package at.fhv.td.application;

import at.fhv.td.domain.Role;
import at.fhv.td.domain.Topic;
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
    Set<Topic> _topics = new HashSet<>();

    @Mock
    UserBroker _broker;
    @Mock
    User _user;

    private static User mockUser(String role) {
        Role newRole = new Role();
        newRole.setRoleName(role);
        Set<Role> roles = new HashSet<>();
        roles.add(newRole);
        User newUser = new User();
        newUser.setRoles(roles);
        return newUser;
    }

    @Before
    public void before() {
        mockStatic(UserBroker.class);
        Topic topic = new Topic();
        topic.setName("name");
        _topics.add(topic);
        when(_user.getTopics()).thenReturn(_topics);
        List<User> users = new LinkedList<>();
        users.add(_user);

        when(UserBroker.getInstance()).thenReturn(_broker);
        when(_broker.getAll(any(List.class))).thenReturn(users);
    }

    @Test
    public void getUser() {
        assertTrue(UserController.getUser("test") instanceof User);
    }

    @Test
    public void getTopics() {
        assertEquals("name", UserController.getTopics("test").get(0).getName());
    }

    @Test
    public void getUserFail() {
        when(_broker.getAll(any(List.class))).thenReturn(new LinkedList());
        assertNull(UserController.getUser("test"));
    }

    @Test
    public void getTopicsFail() {
        when(_broker.getAll(any(List.class))).thenReturn(new LinkedList());
        assertEquals(new LinkedList<>(), UserController.getTopics("test"));
    }

    @Test
    public void hasRoleNullGivenAdmin() {
        assertFalse(UserController.hasRole(null, "admin"));
    }

    @Test
    public void hasRoleUnknownGivenAdmin() {
        assertFalse(UserController.hasRole(mockUser("unknown"), "admin"));
    }

    @Test
    public void hasRoleAdminGivenAdmin() {
        assertTrue(UserController.hasRole(mockUser("admin"), "admin"));
    }

    @Test
    public void hasRoleAdminGivenSeller() {
        assertTrue(UserController.hasRole(mockUser("admin"), "seller"));
    }

    @Test
    public void hasRoleSellerGivenSeller() {
        assertTrue(UserController.hasRole(mockUser("seller"), "seller"));
    }
}