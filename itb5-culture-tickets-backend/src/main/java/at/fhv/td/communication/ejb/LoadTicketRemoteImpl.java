package at.fhv.td.communication.ejb;

import at.fhv.td.application.TicketController;
import at.fhv.td.communication.dto.TicketDTO;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.assembler.TicketAssembler;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class LoadTicketRemoteImpl implements ILoadTicketRemote {
    @Override
    public TicketDTO[] getUnavailableTickets(long eventId) {
        List<Ticket> tickets = TicketController.getUnavailableTickets(eventId);
        return tickets.stream().map(TicketAssembler::toTicketDTO).toArray(TicketDTO[]::new);
    }
}
