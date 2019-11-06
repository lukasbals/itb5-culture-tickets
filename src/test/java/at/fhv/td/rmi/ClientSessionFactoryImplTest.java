package at.fhv.td.rmi;

import at.fhv.td.dto.TicketDTO;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.assertTrue;

public class ClientSessionFactoryImplTest {
    private ClientSessionFactoryImpl _clientSessionFactory;

    @Before
    public void before() throws RemoteException {
        _clientSessionFactory = new ClientSessionFactoryImpl();
    }

    @Test
    public void createClient() throws RemoteException {
        assertTrue(_clientSessionFactory.createClient() instanceof LoadClientImpl);
    }

    @Test
    public void createBuyTicket() throws RemoteException {
        assertTrue(_clientSessionFactory.createBuyTicket() instanceof BuyTicketImpl);
    }

    @Test
    public void createSearchEvent() throws RemoteException {
        assertTrue(_clientSessionFactory.createSearchEvent() instanceof SearchEventImpl);
    }

    @Test
    public void createTicketDTO() throws RemoteException {
        assertTrue(_clientSessionFactory.createTicketDTO() instanceof TicketDTO);
    }
}