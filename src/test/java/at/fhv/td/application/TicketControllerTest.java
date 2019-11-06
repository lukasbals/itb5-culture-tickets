package at.fhv.td.application;

import at.fhv.td.domain.Client;
import at.fhv.td.domain.Event;
import at.fhv.td.domain.PlaceCategory;
import at.fhv.td.domain.Ticket;
import at.fhv.td.persistence.broker.TicketBroker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(TicketBroker.class)
public class TicketControllerTest {
    @Mock
    Ticket _mockTicket;
    @Mock
    Event _mockEvent;
    @Mock
    List<Ticket> _mockTickets;
    @Mock
    TicketBroker _ticketBroker;
    @Mock
    Ticket _basicTicket;
    @Mock
    Client _mockClient;
    @Mock
    PlaceCategory _mockCategory;

    private TicketController _buyTicket;
    private Map<Integer, Integer[]> _seatPlaceReservations;

    @Before
    public void before() {
        _buyTicket = new TicketController();

        mockStatic(TicketBroker.class);
        when(_mockTicket.getEvent()).thenReturn(_mockEvent);
        when(_mockTicket.getEvent().getTickets()).thenReturn(_mockTickets);

        when(TicketBroker.getInstance()).thenReturn(_ticketBroker);
        when(TicketBroker.getInstance().save(any(Ticket.class))).thenReturn(new Random().nextLong());

        when(_basicTicket.getClient()).thenReturn(_mockClient);
        when(_basicTicket.getPlaceCategory()).thenReturn(_mockCategory);
        when(_basicTicket.getEvent()).thenReturn(_mockEvent);
    }

    @Test
    public void createSingleTicket() {
        when(_mockTicket.getEvent().getTickets().contains(any(Ticket.class))).thenReturn(true);
        assertNull(_buyTicket.createSingleTicket(_basicTicket, 10, 1));

        when(_mockTicket.getEvent().getTickets().contains(any(Ticket.class))).thenReturn(false);
        Ticket newTicket = new Ticket();
        newTicket.setTicketNumber(10);
        newTicket.setSold(1);
        newTicket.setClient(_basicTicket.getClient());
        newTicket.setEvent(_basicTicket.getEvent());
        newTicket.setPlaceCategory(_basicTicket.getPlaceCategory());
        assertEquals(newTicket, _buyTicket.createSingleTicket(_basicTicket, 10, 1));
    }

    @Test
    public void createTickets() {
        _seatPlaceReservations = new HashMap<>();
        _seatPlaceReservations.put(1, new Integer[]{10});

        when(_mockTicket.getEvent().getTickets().contains(any(Ticket.class))).thenReturn(true);
        assertEquals(0, _buyTicket.createTickets(_basicTicket, _seatPlaceReservations, 1).size());

        when(_mockTicket.getEvent().getTickets().contains(any(Ticket.class))).thenReturn(false);
        assertEquals(1, _buyTicket.createTickets(_basicTicket, _seatPlaceReservations, 1).size());

        _seatPlaceReservations.put(2, new Integer[]{1, 2});
        assertEquals(3, _buyTicket.createTickets(_basicTicket, _seatPlaceReservations, 1).size());
    }

    @Test
    public void buyTickets() {
        _seatPlaceReservations = new HashMap<>();
        _seatPlaceReservations.put(1, new Integer[]{10});
        when(_mockTicket.getEvent().getTickets().contains(_mockTicket)).thenReturn(false);
        assertEquals(1, _buyTicket.buyTickets(_basicTicket, _seatPlaceReservations).getTickets().size());
    }
}