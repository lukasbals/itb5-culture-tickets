package at.fhv.td.communication.rmi;

import at.fhv.td.application.UserController;
import at.fhv.td.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserController.class})
public class ClientSessionImplTest {
    private ClientSessionRMIImpl _clientSession;

    @Before
    public void before() throws RemoteException {
        mockStatic(UserController.class);
        when(UserController.getUser(any(String.class))).thenReturn(new User());
        when(UserController.hasRole(any(User.class), any(String.class))).thenReturn(true);
        _clientSession = new ClientSessionRMIImpl("");
    }

    @Test
    public void createClient() throws RemoteException {
        assertTrue(_clientSession.createClient() instanceof LoadClientRMIImpl);
    }

    @Test
    public void createClientFail() throws RemoteException {
        when(UserController.hasRole(any(User.class), any(String.class))).thenReturn(false);
        assertNull(_clientSession.createClient());
    }

    @Test
    public void createBuyTicket() throws RemoteException {
        assertTrue(_clientSession.createBuyTicket() instanceof BuyTicketRMIImpl);
    }

    @Test
    public void createBuyTicketFail() throws RemoteException {
        when(UserController.hasRole(any(User.class), any(String.class))).thenReturn(false);
        assertNull(_clientSession.createBuyTicket());
    }

    @Test
    public void createSearchEvent() throws RemoteException {
        assertTrue(_clientSession.createSearchEvent() instanceof SearchEventRMIImpl);
    }

    @Test
    public void createSearchEventFail() throws RemoteException {
        when(UserController.hasRole(any(User.class), any(String.class))).thenReturn(false);
        assertNull(_clientSession.createSearchEvent());
    }

    @Test
    public void createLoadTicket() throws RemoteException {
        assertTrue(_clientSession.createLoadTicket() instanceof LoadTicketRMIImpl);
    }

    @Test
    public void createLoadTicketFail() throws RemoteException {
        when(UserController.hasRole(any(User.class), any(String.class))).thenReturn(false);
        assertNull(_clientSession.createLoadTicket());
    }

    @Test
    public void createMessageFeed() throws RemoteException {
        assertTrue(_clientSession.createMessageFeed() instanceof MessageFeedRMIImpl);
    }

    @Test
    public void createMessageFeedFail() throws RemoteException {
        when(UserController.hasRole(any(User.class), any(String.class))).thenReturn(false);
        assertNull(_clientSession.createLoadTicket());
    }
}