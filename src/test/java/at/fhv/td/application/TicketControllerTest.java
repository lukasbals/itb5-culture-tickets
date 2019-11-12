package at.fhv.td.application;

import at.fhv.td.domain.Client;
import at.fhv.td.domain.Event;
import at.fhv.td.domain.PlaceCategory;
import at.fhv.td.domain.Ticket;
import at.fhv.td.persistence.broker.PlaceCategoryBroker;
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

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TicketBroker.class, PlaceCategoryBroker.class})
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
    PlaceCategoryBroker _placeCatBroker;
    @Mock
    Ticket _basicTicket;
    @Mock
    Client _mockClient;
    @Mock
    PlaceCategory _mockCategory;

    private TicketController _ticketController;
    private Map<Long, Integer[]> _seatPlaceReservations;

    @Before
    public void before() {
        _ticketController = new TicketController();

        mockStatic(TicketBroker.class);
        mockStatic(PlaceCategoryBroker.class);
        when(_mockTicket.getEvent()).thenReturn(_mockEvent);
        when(_mockTicket.getEvent().getTickets()).thenReturn(_mockTickets);

        when(TicketBroker.getInstance()).thenReturn(_ticketBroker);
        when(TicketBroker.getInstance().save(any(Ticket.class))).thenReturn(new Random().nextLong());
        when(TicketBroker.getInstance().getAll(any(List.class))).thenReturn(_mockTickets);
        when(PlaceCategoryBroker.getInstance()).thenReturn(_placeCatBroker);
        when(PlaceCategoryBroker.getInstance().get(any(Long.class))).thenReturn(_mockCategory);

        when(_basicTicket.getClient()).thenReturn(_mockClient);
        when(_basicTicket.getPlaceCategory()).thenReturn(_mockCategory);
        when(_basicTicket.getEvent()).thenReturn(_mockEvent);

        when(_mockCategory.getCategoryId()).thenReturn(1L);
    }

    @Test
    public void createSingleTicket() {
        when(_mockTicket.getEvent().getTickets().contains(any(Ticket.class))).thenReturn(true);
        assertNull(_ticketController.createSingleTicket(_basicTicket, 10, 1));

        when(_mockTicket.getEvent().getTickets().contains(any(Ticket.class))).thenReturn(false);
        Ticket newTicket = new Ticket();
        newTicket.setTicketNumber(10);
        newTicket.setSold(1);
        newTicket.setClient(_basicTicket.getClient());
        newTicket.setEvent(_basicTicket.getEvent());
        newTicket.setPlaceCategory(_basicTicket.getPlaceCategory());
        assertEquals(newTicket, _ticketController.createSingleTicket(_basicTicket, 10, 1));
    }

    @Test
    public void createTickets() {
        _seatPlaceReservations = new HashMap<>();
        _seatPlaceReservations.put(1L, new Integer[]{10});

        when(_mockTicket.getEvent().getTickets().contains(any(Ticket.class))).thenReturn(true);
        assertEquals(0, _ticketController.createTickets(_basicTicket, _seatPlaceReservations, 1).size());

        when(_mockTicket.getEvent().getTickets().contains(any(Ticket.class))).thenReturn(false);
        assertEquals(1, _ticketController.createTickets(_basicTicket, _seatPlaceReservations, 1).size());

        _seatPlaceReservations.put(2L, new Integer[]{1, 2});
        assertEquals(3, _ticketController.createTickets(_basicTicket, _seatPlaceReservations, 1).size());
    }

    @Test
    public void buyTickets() {
        _seatPlaceReservations = new HashMap<>();
        _seatPlaceReservations.put(1L, new Integer[]{10});
        when(_mockTicket.getEvent().getTickets().contains(_mockTicket)).thenReturn(false);
        assertEquals(1, _ticketController.buyTickets(_basicTicket, _seatPlaceReservations).getTickets().size());
    }

    @Test
    public void getUnavailableTickets() {
        assertNotNull(TicketController.getUnavailableTickets(1L));
    }
}