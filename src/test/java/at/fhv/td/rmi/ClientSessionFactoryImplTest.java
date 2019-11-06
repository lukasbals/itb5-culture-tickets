package at.fhv.td.rmi;

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
    public void createConnection() throws RemoteException {
        assertTrue(_clientSessionFactory.createConnection() instanceof SearchEventImpl);
    }

    @Test
    public void createClient() throws RemoteException {
        assertTrue(_clientSessionFactory.createClient() instanceof LoadClientImpl);
    }
}