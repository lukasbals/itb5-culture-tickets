package at.fhv.td.communication.dto;

import java.io.Serializable;
import java.util.Objects;

public class TicketDTO implements Serializable {
    private int _ticketNumber;
    private Long _categoryId;
    private String _categoryName;
    private Long _clientId;
    private Float _price;
    private Long _id;
    private Long _eventId;
    private int _sold;

    public TicketDTO() {
        super();
    }

    public Long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(Long categoryId) {
        _categoryId = categoryId;
    }

    public Long getEventId() {
        return _eventId;
    }

    public void setEventId(Long eventId) {
        _eventId = eventId;
    }

    public int getTicketNumber() {
        return _ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        _ticketNumber = ticketNumber;
    }

    public String getCategoryName() {
        return _categoryName;
    }

    public void setCategoryName(String categoryname) {
        _categoryName = categoryname;
    }

    public Long getClientId() {
        return _clientId;
    }

    public void setClientId(Long clientId) {
        _clientId = clientId;
    }

    public Float getPrice() {
        return _price;
    }

    public void setPrice(Float price) {
        _price = price;
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }

    public int getSold() {
        return _sold;
    }

    public void setSold(int sold) {
        _sold = sold;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TicketDTO) {
            TicketDTO comparing = (TicketDTO) obj;
            return getId().equals(comparing.getId()) && getTicketNumber() == comparing.getTicketNumber();
        }

        return false;
    }

    public int hashCode() {
        return Objects.hash(_id, _ticketNumber);
    }
}
