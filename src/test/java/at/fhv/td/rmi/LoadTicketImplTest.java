package at.fhv.td.rmi;

import at.fhv.td.application.TicketController;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.assembler.TicketAssembler;
import at.fhv.td.dto.TicketDTO;
import at.fhv.td.persistence.broker.PlaceCategoryBroker;
import at.fhv.td.rmi.interfaces.ITicketDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest({TicketController.class, TicketAssembler.class})
public class LoadTicketImplTest {
    @Mock
    Ticket _mockTicket;
    @Mock
    Stream<Ticket> _mockStream;
    @Mock
    TicketDTO _mockTicketDto;

    List<Ticket> _tickets;
    LoadTicketImpl _load;

    @Before
    public void before() throws RemoteException {
        mockStatic(TicketController.class);
        mockStatic(TicketAssembler.class);

        _tickets = new LinkedList<Ticket>();
        _tickets.add(_mockTicket);
        _load = new LoadTicketImpl();

        when(TicketController.getUnavailableTickets(any(Long.class))).thenReturn(_tickets);
        when(TicketAssembler.toTicketDTO(any(Ticket.class))).thenReturn(_mockTicketDto);
    }

    @Test
    public void getUnavailableTickets() throws RemoteException {
        ITicketDTO[] expected = _tickets.stream().map(TicketAssembler::toTicketDTO).toArray(ITicketDTO[]::new);
        Assert.assertArrayEquals(expected, _load.getUnavailableTickets(1L));
    }
}