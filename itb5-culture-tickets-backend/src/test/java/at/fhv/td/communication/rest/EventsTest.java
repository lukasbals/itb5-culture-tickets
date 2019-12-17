package at.fhv.td.communication.rest;

import at.fhv.td.application.EventController;
import at.fhv.td.application.TicketController;
import at.fhv.td.communication.dto.TicketDTO;
import at.fhv.td.domain.*;
import at.fhv.td.domain.assembler.TicketAssembler;
import at.fhv.td.persistence.broker.EventBroker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({EventBroker.class, EventController.class, TicketController.class, TicketAssembler.class})
public class EventsTest {
    private Set<Artist> _artists = new HashSet<>();
    private List<Event> _events = new LinkedList<>();
    private List<Ticket> _tickets = new LinkedList<>();

    @Mock
    private Event _event1;
    @Mock
    private Artist _artist1;
    @Mock
    private Ticket _ticket;
    @Mock
    private TicketDTO _ticketDto;
    @Mock
    private Tour _tour1;
    @Mock
    private Location _location;
    @Mock
    private EventBroker _eventBroker;

    @Before
    public void before() {
        _artists.add(_artist1);
        _events.add(_event1);
        _tickets.add(_ticket);

        mockStatic(EventBroker.class);
        mockStatic(TicketController.class);
        mockStatic(TicketAssembler.class);

        when(EventBroker.getInstance()).thenReturn(_eventBroker);
        when(_eventBroker.getAll()).thenReturn(_events);

        when(_artist1.getArtistname()).thenReturn("Sondaschule");

        when(_event1.getDate()).thenReturn(LocalDate.of(2020, 11, 14));
        when(_event1.getEventName()).thenReturn("PPPPPPPoetry");
        when(_event1.getLocation()).thenReturn(_location);
        when(_event1.getLocation().toString()).thenReturn("Spielboden");
        when(_event1.getTour()).thenReturn(_tour1);
        when(_event1.getTour().getArtists()).thenReturn(_artists);

        when(TicketAssembler.toTicketDTO(any(Ticket.class))).thenReturn(_ticketDto);

        _events.add(_event1);

        mockStatic(EventController.class);
    }

    @Test
    public void searchForEvents() {
        when(EventController.searchForEvents(any(String.class), any(String.class), any(String.class), any(LocalDate.class))).thenReturn(_events);
        Events events = new Events();

        Response resp = events.getEvents(2020, 11, 14, "", "", "");
        assertTrue(resp.hasEntity() && resp.getStatus() == 200);
    }

    @Test
    public void searchForEventsFail() {
        when(EventController.searchForEvents(any(String.class), any(String.class), any(String.class), any(LocalDate.class))).thenReturn(null);
        Events events = new Events();

        Response resp = events.getEvents(0, 0, 0, "", "", "");
        assertFalse(resp.hasEntity() && resp.getStatus() == 200);
    }

    @Test
    public void getTickets() {
        Events events = new Events();

        when(TicketController.getUnavailableTickets(any(long.class))).thenReturn(_tickets);
        Response res = events.getTickets(1);
        assertTrue(res.getStatus() == 200 && res.getEntity() != null);

        res = events.getTickets(0);
        assertTrue(res.getStatus() == 500 && res.getEntity() == null);
    }

    @Test
    public void getTicketsFail() {
        Events events = new Events();

        when(TicketController.getUnavailableTickets(any(long.class))).thenReturn(_tickets);
        Response res = events.getTickets(0);
        assertTrue(res.getStatus() == 500 && res.getEntity() == null);
    }
}