package at.fhv.td.communication.rest;

import at.fhv.td.application.ClientController;
import at.fhv.td.application.TicketController;
import at.fhv.td.communication.dto.ClientDTO;
import at.fhv.td.communication.dto.TicketDTO;
import at.fhv.td.domain.Client;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.assembler.ClientAssembler;
import at.fhv.td.domain.assembler.TicketAssembler;
import at.fhv.td.persistence.broker.ClientBroker;
import at.fhv.td.persistence.broker.TicketBroker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.ws.rs.core.Response;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ClientBroker.class, ClientAssembler.class, ClientController.class,
        TicketAssembler.class, TicketController.class, TicketBroker.class})
public class VarDataRestTest {
    private List<Client> _clients = new LinkedList<>();
    private List<Ticket> _tickets = new LinkedList<>();
    private VarDataRest _rest = new VarDataRest();

    @Mock
    private Client _client;
    @Mock
    private ClientDTO _clientDto;
    @Mock
    private ClientBroker _clientBroker;
    @Mock
    private Ticket _ticket;
    @Mock
    private TicketDTO _ticketDto;
    @Mock
    private TicketBroker _ticketBroker;

    @Before
    public void before() {
        _clients.add(_client);
        _tickets.add(_ticket);

        mockStatic(ClientBroker.class);
        mockStatic(ClientAssembler.class);
        mockStatic(ClientController.class);
        mockStatic(TicketBroker.class);
        mockStatic(TicketController.class);
        mockStatic(TicketAssembler.class);
        when(ClientBroker.getInstance()).thenReturn(_clientBroker);
        when(TicketBroker.getInstance()).thenReturn(_ticketBroker);
        when(ClientAssembler.toClientDTO(any(Client.class))).thenReturn(_clientDto);
        when(TicketAssembler.toTicketDTO(any(Ticket.class))).thenReturn(_ticketDto);
        when(_clientBroker.getAll()).thenReturn(_clients);
        when(_ticketBroker.getAll()).thenReturn(_tickets);
    }

    @Test
    public void getAllClients() {
        when(ClientController.getClients()).thenReturn(_clients);
        Response res = _rest.getAllClients();
        assertTrue(res.getStatus() == 200 && res.getEntity() != null);
    }

    @Test
    public void getAllClientsFail() {
        when(ClientController.getClients()).thenReturn(null);
        Response res = _rest.getAllClients();
        assertTrue(res.getStatus() == 500 && res.getEntity() == null);
    }

    @Test
    public void getTicketsOfEvent() {
        when(TicketController.getUnavailableTickets(any(long.class))).thenReturn(_tickets);
        Response res = _rest.getTicketsOfEvent(1);
        assertTrue(res.getStatus() == 200 && res.getEntity() != null);

        res = _rest.getTicketsOfEvent(0);
        assertTrue(res.getStatus() == 500 && res.getEntity() == null);
    }

    @Test
    public void getTicketsOfEventFail() {
        when(TicketController.getUnavailableTickets(any(long.class))).thenReturn(_tickets);
        Response res = _rest.getTicketsOfEvent(0);
        assertTrue(res.getStatus() == 500 && res.getEntity() == null);
    }
}