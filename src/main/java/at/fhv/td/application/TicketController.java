package at.fhv.td.application;

import at.fhv.td.domain.*;
import at.fhv.td.domain.interfaces.ITicket;
import at.fhv.td.persistence.broker.TicketBroker;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TicketController {
    private TicketAnswer _ticketAnswer;

    TicketController() {
        _ticketAnswer = new TicketAnswer();
    }

    public static TicketAnswer buyTicket(ITicket basicTicket, Map<Integer, Integer[]> seatPlaceReservations) {
        TicketController controller = new TicketController();
        return controller.buyTickets(basicTicket, seatPlaceReservations);
    }

    TicketAnswer buyTickets(ITicket basicTicket, Map<Integer, Integer[]> seatPlaceReservations) {
        LinkedList<Ticket> tickets;
        _ticketAnswer = new TicketAnswer();

        tickets = createTickets(basicTicket, seatPlaceReservations, 1);

        if (_ticketAnswer.getMessage() == null) {
            tickets.forEach(ticket -> ticket.setTicketId(TicketBroker.getInstance().save(ticket)));
            _ticketAnswer.setTickets(tickets);
            _ticketAnswer.setMessage("Tickets successfully bought");
        }

        return _ticketAnswer;
    }

    LinkedList<Ticket> createTickets(ITicket basicTicket, Map<Integer, Integer[]> seatPlaceReservations, int sold) {
        LinkedList<Ticket> tickets = new LinkedList<>();
        seatPlaceReservations.forEach((placeCategory, seats) -> {
                    for (int seat : seats) {
                        Ticket newTicket = createSingleTicket(basicTicket, seat, sold);
                        if (newTicket == null) {
                            break;
                        } else {
                            tickets.add(newTicket);
                        }
                    }
                }
        );

        return tickets;
    }

    Ticket createSingleTicket(ITicket basicTicket, int seat, int sold) {
        Ticket newTicket = new Ticket();
        newTicket.setTicketNumber(seat);
        newTicket.setSold(sold);
        newTicket.setClient((Client) basicTicket.getClient());
        newTicket.setEvent((Event) basicTicket.getEvent());
        newTicket.setPlaceCategory((PlaceCategory) basicTicket.getPlaceCategory());

        List<Ticket> eventTickets = newTicket.getEvent().getTickets();
        if (eventTickets.contains(newTicket)) {
            _ticketAnswer.setMessage("Ticket generation failed: Place " + seat + " already taken");
        } else {
            return newTicket;
        }

        return null;
    }
}
