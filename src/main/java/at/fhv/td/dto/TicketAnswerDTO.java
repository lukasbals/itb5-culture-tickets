package at.fhv.td.dto;

import at.fhv.td.rmi.interfaces.ITicketAnswerDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TicketAnswerDTO extends UnicastRemoteObject implements ITicketAnswerDTO {
    private TicketDTO[] _tickets;
    private String _message;

    public TicketAnswerDTO() throws RemoteException {
        super();
    }

    @Override
    public TicketDTO[] getTickets() throws RemoteException {
        return _tickets;
    }

    @Override
    public void setTickets(TicketDTO[] tickets) throws RemoteException {
        _tickets = tickets;
    }

    @Override
    public String getMessage() throws RemoteException {
        return _message;
    }

    @Override
    public void setMessage(String message) throws RemoteException {
        _message = message;
    }
}
