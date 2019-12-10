package at.fhv.td.communication.dto;

import at.fhv.td.communication.rmi.interfaces.ITicketDTO;

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
    private int _sold;

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

    @Override
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

    @Override
    public void setId(Long id) throws RemoteException {
        _id = id;
    }

    @Override
    public int getSold() throws RemoteException {
        return _sold;
    }

    @Override
    public void setSold(int sold) throws RemoteException {
        _sold = sold;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TicketDTO) {
            TicketDTO comparing = (TicketDTO) obj;
            try {
                return getId().equals(comparing.getId()) && getTicketNumber() == comparing.getTicketNumber();
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
