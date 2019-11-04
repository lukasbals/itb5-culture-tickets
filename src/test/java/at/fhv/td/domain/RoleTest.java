package at.fhv.td.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoleTest {
    private Role _testRole;


    @Before
    public void before() {
        _testRole = new Role();
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
}


