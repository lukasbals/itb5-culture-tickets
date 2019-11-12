package at.fhv.td.rmi;

import at.fhv.td.domain.Event;
import at.fhv.td.domain.PlaceCategory;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.assembler.TicketAssembler;
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
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TicketAssembler.class, PlaceCategoryBroker.class})
public class BuyTicketImplTest {
    @Mock
    ITicketDTO _mockTicketDTO;
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

    private BuyTicketImpl _buyTicket;

    @Before
    public void before() throws RemoteException {
        _buyTicket = new BuyTicketImpl();

        mockStatic(TicketAssembler.class);
        mockStatic(PlaceCategoryBroker.class);
        when(TicketAssembler.toTicket(_mockTicketDTO)).thenReturn(_mockTicket);
        when(_mockTicket.getEvent()).thenReturn(_mockEvent);
        when(_mockTicket.getEvent().getTickets()).thenReturn(_mockTickets);
        when(PlaceCategoryBroker.getInstance()).thenReturn(_placeCatBroker);
        when(PlaceCategoryBroker.getInstance().get(any(Long.class))).thenReturn(_mockPlaceCat);
        when(_mockPlaceCat.getCategoryId()).thenReturn(1L);
    }

    @Test
    public void buyTicket() throws RemoteException {
        Map<Long, Integer[]> _seatPlaceReservations = new HashMap<>();
        _seatPlaceReservations.put(1L, new Integer[]{10});
        when(_mockTicket.getEvent().getTickets().contains(_mockTicket)).thenReturn(false);
        assertEquals(true, _buyTicket.buyTicket(_mockTicketDTO, _seatPlaceReservations));
    }

    @Test
    public void getTickets() {
        // TODO
    }

    @Test
    public void getMessage() throws RemoteException {
        // TODO
//        assertEquals("Boing", _buyTicket.getMessage());
    }
}