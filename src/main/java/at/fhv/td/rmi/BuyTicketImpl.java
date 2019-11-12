package at.fhv.td.rmi;

import at.fhv.td.application.TicketController;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.TicketAnswer;
import at.fhv.td.domain.assembler.TicketAssembler;
import at.fhv.td.rmi.interfaces.IBuyTicket;
import at.fhv.td.rmi.interfaces.ITicketDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BuyTicketImpl extends UnicastRemoteObject implements IBuyTicket {
    private TicketAnswer _answer;

    public BuyTicketImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean buyTicket(ITicketDTO ticketDto, Map<Long, Integer[]> seatPlaceReservations) throws RemoteException {
        Ticket basicTicket = TicketAssembler.toTicket(ticketDto);
        _answer = TicketController.buyTicket(basicTicket, seatPlaceReservations);
        AtomicInteger ticketAmount = new AtomicInteger();
        seatPlaceReservations.forEach((cat, seats) -> ticketAmount.addAndGet(seats.length));
        return _answer.getTickets().size() == ticketAmount.get();
    }

    @Override
    public ITicketDTO[] getTickets() throws RemoteException {
        return _answer.getTickets().stream().map(TicketAssembler::toTicketDTO).toArray(ITicketDTO[]::new);
    }

    @Override
    public String getMessage() throws RemoteException {
        return _answer.getMessage();
    }
}
