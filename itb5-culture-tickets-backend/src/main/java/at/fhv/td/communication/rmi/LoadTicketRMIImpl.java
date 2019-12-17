package at.fhv.td.communication.rmi;

import at.fhv.td.application.TicketController;
import at.fhv.td.communication.dto.TicketDTO;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.assembler.TicketAssembler;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class LoadTicketRMIImpl extends UnicastRemoteObject implements ILoadTicketRMI {
    private static final long serialVersionUID = 998329308129098297L;

    protected LoadTicketRMIImpl() throws RemoteException {
        super();
    }

    @Override
    public TicketDTO[] getUnavailableTickets(long eventId) throws RemoteException {
        List<Ticket> tickets = TicketController.getUnavailableTickets(eventId);
        return tickets.stream().map(TicketAssembler::toTicketDTO).toArray(TicketDTO[]::new);
    }
}
