package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
public class UserTest {
    private User _testUser;

    @Mock
    private Role _role;

    @Before
    public void before() {
        _testUser = new User();
    }

    @Test
    public void getAndSetId(){
        Long id = 10L;
        _testUser.setId(id);
        assertEquals(id, _testUser.getId());
    }

    @Test
    public void getAndSetUsername() {
        String username = "admin";
        _testUser.setUsername(username);
        assertEquals(username, _testUser.getUsername());
    }

    @Test
    public void getAndSetEmail() {
        String mail = "admin@gmail.com";
        _testUser.setEmail(mail);
        assertEquals(mail, _testUser.getEmail());
    }

    @Test
    public void getAndSetRoles() {
        Set<Role> roles = new HashSet<>();
        roles.add(_role);
        _testUser.setRoles(roles);
        assertTrue(_testUser.getRoles().size() == 1);
    }
}

