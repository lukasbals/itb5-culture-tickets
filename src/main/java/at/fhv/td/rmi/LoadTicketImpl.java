package at.fhv.td.rmi;

import at.fhv.td.application.TicketController;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.assembler.TicketAssembler;
import at.fhv.td.rmi.interfaces.ILoadTicket;
import at.fhv.td.rmi.interfaces.ITicketDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class LoadTicketImpl extends UnicastRemoteObject implements ILoadTicket {

    protected LoadTicketImpl() throws RemoteException {
        super();
    }

    @Override
    public ITicketDTO[] getUnavailableTickets(long eventId) throws RemoteException {
        List<Ticket> tickets = TicketController.getUnavailableTickets(eventId);
        return tickets.stream().map(TicketAssembler::toTicketDTO).toArray(ITicketDTO[]::new);
    }
}
