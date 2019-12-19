package at.fhv.td.communication.rmi;

import at.fhv.td.application.TicketController;
import at.fhv.td.communication.dto.TicketDTO;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.TicketAnswer;
import at.fhv.td.domain.assembler.TicketAssembler;

import javax.persistence.Transient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BuyTicketRMIImpl extends UnicastRemoteObject implements IBuyTicketRMI {
    private static final long serialVersionUID = -8441397028955328501L;
    private TicketAnswer _answer;

    public BuyTicketRMIImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean buyTicket(TicketDTO ticketDto, Map<Long, Integer[]> seatPlaceReservations) throws RemoteException {
        Ticket basicTicket = TicketAssembler.toTicket(ticketDto);
        setTicketAnswer(TicketController.buyTicket(basicTicket, seatPlaceReservations));
        AtomicInteger ticketAmount = new AtomicInteger();
        seatPlaceReservations.forEach((cat, seats) -> ticketAmount.addAndGet(seats.length));
        return _answer.getTickets().size() == ticketAmount.get();
    }

    @Override
    public boolean reserveTicket(TicketDTO ticketDto, Map<Long, Integer[]> seatPlaceReservations) throws RemoteException {
        Ticket basicTicket = TicketAssembler.toTicket(ticketDto);
        setTicketAnswer(TicketController.reserveTicket(basicTicket, seatPlaceReservations));
        AtomicInteger ticketAmount = new AtomicInteger();
        seatPlaceReservations.forEach((cat, seats) -> ticketAmount.addAndGet(seats.length));
        return _answer.getTickets().size() == ticketAmount.get();
    }

    @Override
    public TicketDTO[] getTickets() throws RemoteException {
        return _answer.getTickets().stream().map(TicketAssembler::toTicketDTO).toArray(TicketDTO[]::new);
    }

    @Override
    public String getMessage() throws RemoteException {
        return _answer.getMessage();
    }

    void setTicketAnswer(TicketAnswer answer) {
        _answer = answer;
    }
}
