package at.fhv.td.rmi;

import at.fhv.td.application.TicketController;
import at.fhv.td.domain.Event;
import at.fhv.td.domain.PlaceCategory;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.TicketAnswer;
import at.fhv.td.domain.assembler.TicketAssembler;
import at.fhv.td.dto.TicketDTO;
import at.fhv.td.persistence.broker.PlaceCategoryBroker;
import at.fhv.td.rmi.interfaces.ITicketDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TicketAssembler.class, PlaceCategoryBroker.class, TicketController.class})
public class BuyTicketImplTest {
    @Mock
    ITicketDTO _mockTicketDTOInterface;
    @Mock
    TicketDTO _mockTicketDTO;
    @Mock
    Ticket _mockTicket;
    @Mock
    Event _mockEvent;
    @Mock
    List<Ticket> _mockTickets;
    @Mock
    PlaceCategoryBroker _placeCatBroker;
    @Mock
    PlaceCategory _mockPlaceCat;
    @Mock
    TicketAnswer _mockAnswer;

    private BuyTicketImpl _buyTicket;

    @Before
    public void before() throws RemoteException {
        _buyTicket = new BuyTicketImpl();

        List<Ticket> tickets = new LinkedList<>();
        tickets.add(_mockTicket);

        mockStatic(TicketAssembler.class);
        mockStatic(PlaceCategoryBroker.class);
        mockStatic(TicketController.class);
        when(TicketAssembler.toTicket(_mockTicketDTOInterface)).thenReturn(_mockTicket);
        when(TicketAssembler.toTicketDTO(_mockTicket)).thenReturn(_mockTicketDTO);
        when(_mockTicket.getEvent()).thenReturn(_mockEvent);
        when(_mockTicket.getEvent().getTickets()).thenReturn(_mockTickets);
        when(PlaceCategoryBroker.getInstance()).thenReturn(_placeCatBroker);
        when(PlaceCategoryBroker.getInstance().get(any(Long.class))).thenReturn(_mockPlaceCat);
        when(_mockPlaceCat.getId()).thenReturn(1L);
        when(TicketController.buyTicket(any(Ticket.class),any(Map.class))).thenReturn(_mockAnswer);
        when(TicketController.reserveTicket(any(Ticket.class),any(Map.class))).thenReturn(_mockAnswer);
        when(_mockAnswer.getTickets()).thenReturn(tickets);
    }

    @Test
    public void buyTicket() throws RemoteException {
        Map<Long, Integer[]> _seatPlaceReservations = new HashMap<>();
        _seatPlaceReservations.put(1L, new Integer[]{10});
        when(_mockTicket.getEvent().getTickets().contains(_mockTicket)).thenReturn(false);
        assertTrue(_buyTicket.buyTicket(_mockTicketDTOInterface, _seatPlaceReservations));

        when(_mockAnswer.getTickets()).thenReturn(new LinkedList<>());
        assertFalse(_buyTicket.buyTicket(_mockTicketDTOInterface, _seatPlaceReservations));
    }

    @Test
    public void reserveTicket() throws RemoteException {
        Map<Long, Integer[]> _seatPlaceReservations = new HashMap<>();
        _seatPlaceReservations.put(1L, new Integer[]{10});
        when(_mockTicket.getEvent().getTickets().contains(_mockTicket)).thenReturn(false);
        assertEquals(true, _buyTicket.reserveTicket(_mockTicketDTOInterface, _seatPlaceReservations));

        when(_mockAnswer.getTickets()).thenReturn(new LinkedList<>());
        assertFalse(_buyTicket.reserveTicket(_mockTicketDTOInterface, _seatPlaceReservations));
    }

    @Test
    public void getTickets() throws RemoteException {
        _buyTicket.setTicketAnswer(_mockAnswer);
        ITicketDTO[] tickets = _buyTicket.getTickets();
        assertEquals(1, tickets.length);
    }

    @Test
    public void getMessage() throws RemoteException {
        when(_mockAnswer.getMessage()).thenReturn("boing");
        _buyTicket.setTicketAnswer(_mockAnswer);
        assertEquals("boing", _buyTicket.getMessage());
    }
}