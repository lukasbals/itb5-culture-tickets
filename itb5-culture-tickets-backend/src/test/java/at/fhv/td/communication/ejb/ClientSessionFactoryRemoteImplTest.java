package at.fhv.td.communication.ejb;

import at.fhv.td.application.UserController;
import at.fhv.td.domain.User;
import at.fhv.td.ldap.LDAP;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserController.class, LDAP.class})
public class ClientSessionFactoryRemoteImplTest {
    @Mock
    private ClientSessionFactoryRemoteImpl _mockFactory;
    @Mock
    private IClientSessionRemote _mockSession;

    @Before
    public void before() {
        mockStatic(UserController.class);
        mockStatic(LDAP.class);

        when(LDAP.callLDAP(any(String.class), any(String.class))).thenReturn(true);
        when(UserController.getUser(any(String.class))).thenReturn(new User());
    }

    @Test
    public void login() {
        when(_mockFactory.login(any(String.class), any(String.class), any(Boolean.class))).thenReturn(_mockSession);
        IClientSessionRemote login = _mockFactory.login("user", "pass", false);
        assertNotNull(login);
    }

    @Test
    public void loginFail() {
        when(_mockFactory.login(any(String.class), any(String.class), any(Boolean.class))).thenReturn(null);
        IClientSessionRemote login = _mockFactory.login(null, "pass", false);
        assertNull(login);
    }
}