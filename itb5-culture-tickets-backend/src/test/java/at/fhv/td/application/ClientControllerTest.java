package at.fhv.td.application;

import at.fhv.td.domain.Client;
import at.fhv.td.persistence.broker.ClientBroker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBroker.class)
public class ClientControllerTest {
    private List<Client> _clients = new LinkedList<>();

    @Mock
    private Client _client;
    @Mock
    private ClientBroker _clientBroker;

    @Before
    public void before() {
        _clients.add(_client);

        mockStatic(ClientBroker.class);
        when(ClientBroker.getInstance()).thenReturn(_clientBroker);
        when(_clientBroker.getAll()).thenReturn(_clients);
    }

    @Test
    public void getClients() {
        assertEquals(_clients, ClientController.getClients());
    }
}