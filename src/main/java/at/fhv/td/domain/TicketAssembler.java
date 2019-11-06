package at.fhv.td.domain;

import at.fhv.td.persistence.broker.ClientBroker;
import at.fhv.td.persistence.broker.EventBroker;
import at.fhv.td.persistence.broker.PlaceCategoryBroker;
import at.fhv.td.rmi.interfaces.ITicketDTO;

import java.rmi.RemoteException;

public class TicketAssembler {
    public Ticket TicketDTOtoTicket(ITicketDTO ticketDto, int sold) {
        PlaceCategory placeCategory = null;
        Event event = null;
        Client client = null;

        try {
            placeCategory = PlaceCategoryBroker.getInstance().get(ticketDto.getCategoryId());
            event = EventBroker.getInstance().get(ticketDto.getEventId());
            client = null;

            if (ticketDto.getClientId() != null) {
                client = ClientBroker.getInstance().get(ticketDto.getClientId());
            }

            Ticket newTicket = new Ticket();
            if (placeCategory != null && event != null) {
                newTicket.setPlaceCategory(placeCategory);
                newTicket.setSold(sold);
                newTicket.setEvent(event);
                newTicket.setClient(client);
                newTicket.setTicketNumber(10);
            }

            return newTicket;
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }
}
