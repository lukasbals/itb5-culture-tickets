package at.fhv.td.domain;

import java.util.LinkedList;
import java.util.List;

public class TicketAnswer {
    private List<Ticket> _tickets;
    private String _message;

    public TicketAnswer() {
        _tickets = new LinkedList<>();
    }

    public List<Ticket> getTickets() {
        return _tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        _tickets = tickets;
    }

    public String getMessage() {
        return _message;
    }

    public void setMessage(String message) {
        _message = message;
    }
}
