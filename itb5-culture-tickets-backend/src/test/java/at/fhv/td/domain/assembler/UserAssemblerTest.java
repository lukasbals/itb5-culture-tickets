package at.fhv.td.domain.assembler;

import at.fhv.td.communication.dto.UserDTO;
import at.fhv.td.domain.Role;
import at.fhv.td.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class UserAssemblerTest {
    private UserDTO _expected;
    @Mock
    private User _user;
    private Long _id = 1L;
    private String _name = "Lukas";
    private Set<Role> _rolesSet = new HashSet<>();
    private List<String> _roles = new LinkedList<>();

    @Before
    public void before() {
        Role role = new Role();
        role.setRoleName("role");
        _rolesSet.add(role);
        _roles.add("role");

        _expected = new UserDTO();
        _expected.setUserId(_id);
        _expected.setUserName(_name);
        _expected.setRoles(_roles);

        when(_user.getId()).thenReturn(_id);
        when(_user.getUsername()).thenReturn(_name);
        when(_user.getRoles()).thenReturn(_rolesSet);
    }

    @Test
    public void toUserDTO() {
        UserDTO userDTO = UserAssembler.toUserDTO(_user);
        assertEquals(_expected.getUserId(), userDTO.getUserId());
        assertEquals(_expected.getUserName(), userDTO.getUserName());
        assertEquals(_expected.getRoles(), userDTO.getRoles());
    }
}