package at.fhv.td.rmi.interfaces;

import at.fhv.td.dto.TicketDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITicketAnswerDTO extends Remote {
    String getMessage() throws RemoteException;

    void setMessage(String message) throws RemoteException;

    TicketDTO[] getTickets() throws RemoteException;

    void setTickets(TicketDTO[] tickets) throws RemoteException;
}
