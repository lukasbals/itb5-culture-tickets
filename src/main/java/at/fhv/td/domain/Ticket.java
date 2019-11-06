package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.ITicket;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket implements ITicket {
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
    public Long getTicketId() {
        return _ticketId;
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
    public Event getEvent() { return _event; }

    public void setEvent(Event event) { _event = event; }
}
