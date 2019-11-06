package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Ticket;

public class TicketBroker extends Broker<Ticket> {
    private static TicketBroker _ticketBroker = null;

    private TicketBroker() {
    }

    public static TicketBroker getInstance() {
        if (_ticketBroker == null) {
            _ticketBroker = new TicketBroker();
        }
        return _ticketBroker;
    }

    @Override
    protected Class<Ticket> getModelClass() {
        return Ticket.class;
    }
}
