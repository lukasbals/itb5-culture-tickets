package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Ticket;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketBrokerTest {

    @Test
    public void getModelClass() {
        TicketBroker ticketBroker = TicketBroker.getInstance();
        assertEquals(Ticket.class, ticketBroker.getModelClass());
    }

    @Test
    public void getInstance() {
        TicketBroker ticketBroker1 = TicketBroker.getInstance();
        TicketBroker ticketBroker2 = TicketBroker.getInstance();
        assertEquals(ticketBroker1, ticketBroker2);
    }
}