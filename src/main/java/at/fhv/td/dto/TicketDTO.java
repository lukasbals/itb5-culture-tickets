package at.fhv.td.dto;

import at.fhv.td.rmi.interfaces.ITicketDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class TicketDTO extends UnicastRemoteObject implements ITicketDTO {
    private static final long serialVersionUID = 9213181597647725759L;
    private int _ticketNumber;
    private Long _categoryId;
    private String _categoryName;
    private Long _clientId;
    private Float _price;
    private Long _id;
    private Long _eventId;

    public TicketDTO() throws RemoteException {
        super();
    }

    @Override
    public Long getCategoryId() throws RemoteException {
        return _categoryId;
    }

    @Override
    public void setCategoryId(Long categoryId) throws RemoteException {
        _categoryId = categoryId;
    }

    @Override
    public Long getEventId() throws RemoteException {
        return _eventId;
    }

    @Override
    public void setEventId(Long eventId) throws RemoteException {
        _eventId = eventId;
    }

    @Override
    public int getTicketNumber() throws RemoteException {
        return _ticketNumber;
    }

    @Override
    public void setTicketNumber(int ticketNumber) throws RemoteException {
        _ticketNumber = ticketNumber;
    }

    @Override
    public String getCategoryName() throws RemoteException {
        return _categoryName;
    }

    @Override
    public void setCategoryName(String categoryname) throws RemoteException {
        _categoryName = categoryname;
    }

    @Override
    public Long getClientId() throws RemoteException {
        return _clientId;
    }

    public void setClientId(Long clientId) throws RemoteException {
        _clientId = clientId;
    }

    @Override
    public Float getPrice() throws RemoteException {
        return _price;
    }

    @Override
    public void setPrice(Float price) throws RemoteException {
        _price = price;
    }

    @Override
    public Long getId() throws RemoteException {
        return _id;
    }

    public void setId(Long id) throws RemoteException {
        _id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TicketDTO) {
            TicketDTO comparing = (TicketDTO) obj;
            try {
                return _id == comparing.getId() && _ticketNumber == comparing.getTicketNumber();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _ticketNumber);
    }
}
