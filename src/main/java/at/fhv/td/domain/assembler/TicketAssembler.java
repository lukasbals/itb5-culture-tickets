package at.fhv.td.domain.assembler;

import at.fhv.td.domain.Client;
import at.fhv.td.domain.Event;
import at.fhv.td.domain.PlaceCategory;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.interfaces.ITicket;
import at.fhv.td.dto.TicketDTO;
import at.fhv.td.persistence.broker.ClientBroker;
import at.fhv.td.persistence.broker.EventBroker;
import at.fhv.td.persistence.broker.PlaceCategoryBroker;
import at.fhv.td.rmi.interfaces.ITicketDTO;

import java.rmi.RemoteException;

public class TicketAssembler {
    private TicketAssembler() {
    }

    public static Ticket toTicket(ITicketDTO ticketDto) {
        PlaceCategory placeCategory = null;
        Event event = null;
        Client client = null;

        try {
            placeCategory = PlaceCategoryBroker.getInstance().get(ticketDto.getCategoryId());
            event = EventBroker.getInstance().get(ticketDto.getEventId());

            if (ticketDto.getClientId() != null) {
                client = ClientBroker.getInstance().get(ticketDto.getClientId());
            }

            if (placeCategory != null && event != null) {
                Ticket newTicket = new Ticket();
                newTicket.setPlaceCategory(placeCategory);
                newTicket.setSold(ticketDto.getSold());
                newTicket.setEvent(event);
                newTicket.setClient(client);
                newTicket.setTicketNumber(ticketDto.getTicketNumber());
                return newTicket;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static TicketDTO toTicketDTO(ITicket ticket) {
        TicketDTO newTicketDto = null;
        try {
            newTicketDto = new TicketDTO();
            newTicketDto.setPrice(ticket.getPlaceCategory().getPrice());
            newTicketDto.setEventId(ticket.getEvent().getEventId());
            newTicketDto.setCategoryName(ticket.getPlaceCategory().getCategoryName());
            newTicketDto.setCategoryId(ticket.getPlaceCategory().getCategoryId());
            newTicketDto.setTicketNumber(ticket.getTicketNumber());
            newTicketDto.setId(ticket.getTicketId());
            if (ticket.getClient() != null) {
                newTicketDto.setClientId(ticket.getClient().getClientId());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return newTicketDto;
    }
}
