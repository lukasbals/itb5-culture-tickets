package at.fhv.td.communication.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoadTicket extends Remote {
    ITicketDTO[] getUnavailableTickets(long eventId) throws RemoteException;
}
