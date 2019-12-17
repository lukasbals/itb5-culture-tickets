package at.fhv.td.communication.ejb;

import at.fhv.td.application.TicketController;
import at.fhv.td.communication.dto.TicketDTO;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.TicketAnswer;
import at.fhv.td.domain.assembler.TicketAssembler;

import javax.ejb.Stateless;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Stateless
public class BuyTicketRemoteImpl implements IBuyTicketRemote {
    private TicketAnswer _answer;

    @Override
    public boolean buyTicket(TicketDTO ticketDto, Map<Long, Integer[]> seatPlaceReservations) {
        Ticket basicTicket = TicketAssembler.toTicket(ticketDto);
        setTicketAnswer(TicketController.buyTicket(basicTicket, seatPlaceReservations));
        AtomicInteger ticketAmount = new AtomicInteger();
        seatPlaceReservations.forEach((cat, seats) -> ticketAmount.addAndGet(seats.length));
        return _answer.getTickets().size() == ticketAmount.get();
    }

    @Override
    public boolean reserveTicket(TicketDTO ticketDto, Map<Long, Integer[]> seatPlaceReservations) {
        Ticket basicTicket = TicketAssembler.toTicket(ticketDto);
        setTicketAnswer(TicketController.reserveTicket(basicTicket, seatPlaceReservations));
        AtomicInteger ticketAmount = new AtomicInteger();
        seatPlaceReservations.forEach((cat, seats) -> ticketAmount.addAndGet(seats.length));
        return _answer.getTickets().size() == ticketAmount.get();
    }

    @Override
    public TicketDTO[] getTickets() {
        return _answer.getTickets().stream().map(TicketAssembler::toTicketDTO).toArray(TicketDTO[]::new);
    }

    @Override
    public String getMessage() {
        return _answer.getMessage();
    }

    void setTicketAnswer(TicketAnswer answer) {
        _answer = answer;
    }
}
