package at.fhv.td.communication;

import at.fhv.td.communication.dto.TicketDTO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Map;

public interface IBuyTicket extends Serializable {
    boolean buyTicket(TicketDTO ticketDto, Map<Long, Integer[]> seatPlaceReservations) throws RemoteException;

    boolean reserveTicket(TicketDTO ticketDto, Map<Long, Integer[]> seatPlaceReservations) throws RemoteException;

    TicketDTO[] getTickets() throws RemoteException;

    String getMessage() throws RemoteException;
}
