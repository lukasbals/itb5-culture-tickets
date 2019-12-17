package at.fhv.td.communication.rmi;

import at.fhv.td.communication.dto.ClientDTO;
import at.fhv.td.domain.Client;
import at.fhv.td.persistence.broker.ClientBroker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBroker.class)
public class LoadClientImplTest {
    private String _fname1 = "Patrick";
    private String _lname1 = "Poiger";
    private String _address1 = "Zuhause 1";
    private Long _id1 = 1l;
    private String _fname2 = "Lukas";
    private String _lname2 = "Bals";
    private String _address2 = "Zuhause 2";
    private Long _id2 = 2l;

    private LoadClientRMIImpl _loadClientImpl;
    private List<Client> _clients = new LinkedList<>();
    @Mock
    private Client _client1;
    @Mock
    private Client _client2;
    @Mock
    private ClientBroker _clientBroker;

    @Before
    public void before() throws RemoteException {
        _loadClientImpl = new LoadClientRMIImpl();
        _clients.add(_client1);
        _clients.add(_client2);

        mockStatic(ClientBroker.class);
        when(ClientBroker.getInstance()).thenReturn(_clientBroker);
        when(_clientBroker.getAll()).thenReturn(_clients);

        when(_client1.getFirstname()).thenReturn(_fname1);
        when(_client1.getLastname()).thenReturn(_lname1);
        when(_client1.getAddress()).thenReturn(_address1);
        when(_client1.getId()).thenReturn(_id1);
        when(_client2.getFirstname()).thenReturn(_fname2);
        when(_client2.getLastname()).thenReturn(_lname2);
        when(_client2.getAddress()).thenReturn(_address2);
        when(_client2.getId()).thenReturn(_id2);
    }

    @Test
    public void loadClients() throws RemoteException {
        List<ClientDTO> clients = _loadClientImpl.loadClients();
        assertEquals(2, clients.size());
        assertEquals(_fname1, clients.get(0).getFirstName());
        assertEquals(_fname2, clients.get(1).getFirstName());
    }
}