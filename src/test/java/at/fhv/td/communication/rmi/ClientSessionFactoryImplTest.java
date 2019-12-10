package at.fhv.td.communication.rmi;

import at.fhv.td.application.UserController;
import at.fhv.td.domain.User;
import at.fhv.td.ldap.LDAP;
import at.fhv.td.communication.rmi.interfaces.IClientSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserController.class, LDAP.class})
public class ClientSessionFactoryImplTest {
    private ClientSessionFactoryImpl _impl = null;

    @Before
    public void before() throws RemoteException {
        mockStatic(UserController.class);
        mockStatic(LDAP.class);

        when(LDAP.callLDAP(any(String.class), any(String.class))).thenReturn(true);
        when(UserController.getUser(any(String.class))).thenReturn(new User());

        _impl = new ClientSessionFactoryImpl();
    }

    @Test
    public void login() throws RemoteException {
        IClientSession login = _impl.login("user", "pass", false);
        assertNotNull(login);
    }

    @Test
    public void loginFail() throws RemoteException {
        IClientSession login = _impl.login(null, "pass", false);
        assertNull(login);
    }
}