package at.fhv.td.dto;

import at.fhv.td.dto.dtoInterfaces.ITicket;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class TicketDTO implements ITicket {
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
    private PlaceCategoryDTO _categoryname;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientDTO _clientId;

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
    public PlaceCategoryDTO getCategoryname() {
        return _categoryname;
    }

    public void setCategoryname(PlaceCategoryDTO categoryname) {
        _categoryname = categoryname;
    }

    @Override
    public ClientDTO getClientId() {
        return _clientId;
    }

    public void setClientId(ClientDTO clientId) {
        _clientId = clientId;
    }
}
