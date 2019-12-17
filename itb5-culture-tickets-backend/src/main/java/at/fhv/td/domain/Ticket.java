package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.ITicket;
import at.fhv.td.persistence.broker.IModelId;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket implements ITicket, IModelId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id", updatable = false, nullable = false)
    private Long _ticketId;

    @Column(name = "ticket_number")
    private Integer _ticketNumber;

    @Column(name = "sold")
    private Integer _sold;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private PlaceCategory _placeCategory;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client _client;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event _event;

    @Override
    public Long getId() {
        return _ticketId;
    }

    @Override
    public void setId(Long id) {
        _ticketId = id;
    }

    @Override
    public Integer getTicketNumber() {
        return _ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        _ticketNumber = ticketNumber;
    }

    @Override
    public Integer getSold() {
        return _sold;
    }

    public void setSold(Integer sold) {
        _sold = sold;
    }

    @Override
    public PlaceCategory getPlaceCategory() {
        return _placeCategory;
    }

    public void setPlaceCategory(PlaceCategory categoryName) {
        _placeCategory = categoryName;
    }

    @Override
    public Client getClient() {
        return _client;
    }

    public void setClient(Client clientId) {
        _client = clientId;
    }

    @Override
    public Event getEvent() {
        return _event;
    }

    public void setEvent(Event event) {
        _event = event;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ticket) {
            Ticket comparingTicket = (Ticket) obj;
            boolean eventId = getEvent().getId().equals(comparingTicket.getEvent().getId());
            boolean ticketNumber = getTicketNumber().equals(comparingTicket.getTicketNumber());
            boolean placeCategory = getPlaceCategory().getId().equals(comparingTicket.getPlaceCategory().getId());
            return eventId && ticketNumber && placeCategory;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return getEvent().hashCode() ^ getTicketNumber().hashCode() ^ getPlaceCategory().hashCode();
    }
}
