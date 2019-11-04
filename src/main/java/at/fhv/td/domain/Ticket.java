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
    @JoinColumn(name = "categoryname")
    private PlaceCategory _categoryname;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client _clientId;

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
    public PlaceCategory getCategoryname() {
        return _categoryname;
    }

    public void setCategoryname(PlaceCategory categoryname) {
        _categoryname = categoryname;
    }

    @Override
    public Client getClientId() {
        return _clientId;
    }

    public void setClientId(Client clientId) {
        _clientId = clientId;
    }
}
