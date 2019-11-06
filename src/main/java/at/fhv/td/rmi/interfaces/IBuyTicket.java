package at.fhv.td.rmi.interfaces;

import at.fhv.td.dto.TicketAnswerDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface IBuyTicket extends Remote {
    /**
     * @param ticketDto
     * @param seatPlaceReservations first integer is placeCategoryId, integer array are selected seats for purchase (ticket number are seat numbers)
     * @return all generated tickets and success message, or an empty ticket list and failure message
     * @throws RemoteException
     */
    public TicketAnswerDTO buyTicket(ITicketDTO ticketDto, Map<Integer, Integer[]> seatPlaceReservations) throws RemoteException;
}
