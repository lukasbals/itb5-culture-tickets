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
        return controller.processRequest(basicTicket, seatPlaceReservations, InteractionType.BUY);
    }

    public static TicketAnswer reserveTicket(ITicket basicTicket, Map<Long, Integer[]> seatPlaceReservations) {
        TicketController controller = new TicketController();
        return controller.processRequest(basicTicket, seatPlaceReservations, InteractionType.RESERVE);
    }

    public static List<Ticket> getUnavailableTickets(long eventId) {
        List<PersistenceFilter> filters = new LinkedList<>();
        filters.add(new PersistenceFilter(FilterType.EQ, "_event", eventId));
        return TicketBroker.getInstance().getAll(filters);
    }

    TicketAnswer processRequest(ITicket basicTicket, Map<Long, Integer[]> seatPlaceReservations, InteractionType type) {
        _ticketAnswer = new TicketAnswer();
        _ticketAnswer.setTickets(new LinkedList<>());

        if (basicTicket != null && seatPlaceReservations != null) {
            List<Ticket> tickets = new LinkedList<>();

            switch (type) {
                default:
                case BUY:
                    tickets = createTickets((Ticket) basicTicket, seatPlaceReservations, 1);
                    break;
                case RESERVE:
                    if (basicTicket.getClient() == null) {
                        _ticketAnswer.setMessage("Ticket generation failed: no client set");
                    } else {
                        tickets = createTickets((Ticket) basicTicket, seatPlaceReservations, 0);
                    }
                    break;
            }

            _ticketAnswer.setTickets(saveTickets(tickets));
        }

        return _ticketAnswer;
    }

    List<Ticket> saveTickets(List<Ticket> tickets) {
        if (_ticketAnswer.getMessage() == null) {
            tickets = TicketBroker.getInstance().saveMultiple(tickets);
            if (tickets == null) {
                _ticketAnswer.setMessage("Tickets generation failed: database error");
            } else {
                _ticketAnswer.setMessage("Tickets successfully reserved");
            }
        }

        return tickets;
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
                    } else {
                        _ticketAnswer.setMessage("Ticket generation failed: place category not found");
                        tickets.clear();
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
            if (_ticketAnswer.getMessage() == null) {
                _ticketAnswer.setMessage("Ticket generation failed: Place already taken:" + seat);
            } else {
                _ticketAnswer.setMessage(_ticketAnswer.getMessage() + ", " + seat);
            }
        } else {
            return newTicket;
        }

        return null;
    }

    enum InteractionType {
        BUY, RESERVE;
    }
}
