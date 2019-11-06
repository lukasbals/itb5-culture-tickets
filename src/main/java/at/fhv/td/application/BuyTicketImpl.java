package at.fhv.td.application;

import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.TicketAssembler;
import at.fhv.td.persistence.broker.TicketBroker;
import at.fhv.td.rmi.interfaces.IBuyTicket;
import at.fhv.td.rmi.interfaces.ITicketDTO;
import javafx.util.Pair;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BuyTicketImpl extends UnicastRemoteObject implements IBuyTicket {
    public BuyTicketImpl() throws RemoteException {
        super();
    }

    @Override
    public Pair<Boolean, String> buyTicket(ITicketDTO ticketDto) throws RemoteException {
        Ticket newTicket = new TicketAssembler().TicketDTOtoTicket(ticketDto, 1);

        if (newTicket != null) {
            int availableTickets = newTicket.getPlaceCategory().getAmount();
            int existingTickets = newTicket.getEvent().getTickets().stream()
                    .filter(t -> t.getPlaceCategory().equals(newTicket.getPlaceCategory()))
                    .map(t -> t.getPlaceCategory().getAmount())
                    .reduce(0, Integer::sum);

            if (existingTickets < availableTickets) {
                TicketBroker.getInstance().save(newTicket);
                return new Pair<>(true, "Ticket generator successful");
            }

            return new Pair<>(false, "No tickets available");
        }

        return new Pair<>(false, "Ticket generator failed");
    }
}
