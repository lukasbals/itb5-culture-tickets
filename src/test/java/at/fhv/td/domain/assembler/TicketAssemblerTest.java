package at.fhv.td.domain.assembler;

import at.fhv.td.domain.Client;
import at.fhv.td.domain.Event;
import at.fhv.td.domain.PlaceCategory;
import at.fhv.td.domain.Ticket;
import at.fhv.td.dto.TicketDTO;
import at.fhv.td.persistence.broker.ClientBroker;
import at.fhv.td.persistence.broker.EventBroker;
import at.fhv.td.persistence.broker.PlaceCategoryBroker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PlaceCategoryBroker.class, EventBroker.class, ClientBroker.class})
public class TicketAssemblerTest {
    @Mock
    PlaceCategory _mockCategory;
    @Mock
    Event _mockEvent;
    @Mock
    Client _mockClient;
    @Mock
    Ticket _ticket;
    @Mock
    TicketDTO _ticketDto;
    @Mock
    PlaceCategoryBroker _placeCatBroker;
    @Mock
    EventBroker _eventBroker;
    @Mock
    ClientBroker _clientBroker;

    private TicketDTO _expectedTicketDto;
    private Ticket _expectedTicket;

    @Before
    public void before() throws RemoteException {
        _expectedTicketDto = new TicketDTO();
        _expectedTicketDto.setId(1L);
        _expectedTicketDto.setCategoryId(1L);
        _expectedTicketDto.setEventId(1L);
        _expectedTicketDto.setTicketNumber(10);
        _expectedTicketDto.setClientId(1L);
        when(_ticket.getTicketId()).thenReturn(1L);
        when(_ticket.getClient()).thenReturn(_mockClient);
        when(_ticket.getClient().getClientId()).thenReturn(1L);
        when(_ticket.getPlaceCategory()).thenReturn(_mockCategory);
        when(_ticket.getPlaceCategory().getCategoryId()).thenReturn(1L);
        when(_ticket.getEvent()).thenReturn(_mockEvent);
        when(_ticket.getEvent().getEventId()).thenReturn(1L);
        when(_ticket.getTicketNumber()).thenReturn(10);

        _expectedTicket = new Ticket();
        _expectedTicket.setClient(_mockClient);
        _expectedTicket.setSold(0);
        _expectedTicket.setTicketNumber(10);
        _expectedTicket.setEvent(_mockEvent);
        _expectedTicket.setPlaceCategory(_mockCategory);
        mockStatic(PlaceCategoryBroker.class);
        mockStatic(EventBroker.class);
        mockStatic(ClientBroker.class);
        when(PlaceCategoryBroker.getInstance()).thenReturn(_placeCatBroker);
        when(EventBroker.getInstance()).thenReturn(_eventBroker);
        when(ClientBroker.getInstance()).thenReturn(_clientBroker);
        when(PlaceCategoryBroker.getInstance().get(1L)).thenReturn(_mockCategory);
        when(EventBroker.getInstance().get(1L)).thenReturn(_mockEvent);
        when(ClientBroker.getInstance().get(1L)).thenReturn(_mockClient);
        when(_ticketDto.getCategoryId()).thenReturn(1L);
        when(_ticketDto.getEventId()).thenReturn(1L);
        when(_ticketDto.getClientId()).thenReturn(1L);
        when(_ticketDto.getTicketNumber()).thenReturn(10);
    }

    @Test
    public void toTicket() throws RemoteException {
        assertEquals(_expectedTicket, TicketAssembler.toTicket(_ticketDto));

        when(_ticketDto.getClientId()).thenReturn(null);
        when(_ticketDto.getCategoryId()).thenReturn(null);
        assertNull(TicketAssembler.toTicket(_ticketDto));

        when(_ticketDto.getCategoryId()).thenThrow(RemoteException.class);
        assertNotEquals(_expectedTicket, TicketAssembler.toTicket(_ticketDto));
    }

    @Test
    public void toTicketDTO() throws Exception {
        assertEquals(_expectedTicketDto, TicketAssembler.toTicketDTO(_ticket));
    }
}