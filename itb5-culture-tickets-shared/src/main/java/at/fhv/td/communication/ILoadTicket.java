package at.fhv.td.communication;

import at.fhv.td.communication.dto.TicketDTO;

import java.io.Serializable;
import java.rmi.RemoteException;

public interface ILoadTicket extends Serializable {
    TicketDTO[] getUnavailableTickets(long eventId) throws RemoteException;
}
