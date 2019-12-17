package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
public class RoleTest {
    private Role _testRole;

    @Mock
    private User _user;

    @Before
    public void before() {
        _testRole = new Role();
    }

    @Test
    public void getAndSetId(){
        Long id = 10L;
        _testRole.setId(id);
        assertEquals(id, _testRole.getId());
    }

    @Test
    public void getAndSetRoleName() {
        String name = "admin";
        _testRole.setRoleName(name);
        assertEquals(name, _testRole.getRoleName());
    }

    @Test
    public void getAndSetRights() {
        String rights = "rwx";
        _testRole.setRights(rights);
        assertEquals(rights, _testRole.getRights());
    }

    @Test
    public void getAndSetUsers() {
        Set<User> users = new HashSet<>();
        users.add(_user);
        _testRole.setUsers(users);
        assertEquals(1, _testRole.getUsers().size());
    }
}


