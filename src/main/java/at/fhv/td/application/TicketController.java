package at.fhv.td.application;

import at.fhv.td.domain.*;
import at.fhv.td.domain.interfaces.ITicket;
import at.fhv.td.persistence.PersistenceFilter;
import at.fhv.td.persistence.PersistenceFilter.FilterType;
import at.fhv.td.persistence.broker.PlaceCategoryBroker;
import at.fhv.td.persistence.broker.TicketBroker;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TicketController {
    private TicketAnswer _ticketAnswer;

    TicketController() {
        _ticketAnswer = new TicketAnswer();
    }

    public static TicketAnswer buyTicket(ITicket basicTicket, Map<Long, Integer[]> seatPlaceReservations) {
        TicketController controller = new TicketController();
        return controller.buyTickets(basicTicket, seatPlaceReservations);
    }

    public static List<Ticket> getUnavailableTickets(long eventId) {
        List<PersistenceFilter> filters = new LinkedList<>();
        filters.add(new PersistenceFilter(FilterType.EQ, "_event", eventId));
        return TicketBroker.getInstance().getAll(filters);
    }

    TicketAnswer buyTickets(ITicket basicTicket, Map<Long, Integer[]> seatPlaceReservations) {
        LinkedList<Ticket> tickets;
        _ticketAnswer = new TicketAnswer();

        tickets = createTickets((Ticket) basicTicket, seatPlaceReservations, 1);

        if (_ticketAnswer.getMessage() == null) {
            tickets.forEach(ticket -> ticket.setTicketId(TicketBroker.getInstance().save(ticket)));
            _ticketAnswer.setTickets(tickets);
            _ticketAnswer.setMessage("Tickets successfully bought");
        }

        return _ticketAnswer;
    }

    LinkedList<Ticket> createTickets(Ticket basicTicket, Map<Long, Integer[]> seatPlaceReservations, int sold) {
        LinkedList<Ticket> tickets = new LinkedList<>();
        seatPlaceReservations.forEach((placeCat, seats) -> {
                    PlaceCategory placeCategory = PlaceCategoryBroker.getInstance().get(placeCat);
                    if (placeCategory != null) {
                        basicTicket.setPlaceCategory(placeCategory);
                        for (int seat : seats) {
                            Ticket newTicket = createSingleTicket(basicTicket, seat, sold);
                            if (newTicket != null) {
                                tickets.add(newTicket);
                            }
                        }
                    }
                    else {
                        _ticketAnswer.setMessage("Ticket generation failed: place category not found");
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
            if(_ticketAnswer.getMessage() == null) {
                _ticketAnswer.setMessage("Ticket generation failed: Place already taken:" + seat);
            }
            else{
                _ticketAnswer.setMessage(_ticketAnswer.getMessage() + ", " + seat);
            }
        } else {
            return newTicket;
        }

        return null;
    }
}
