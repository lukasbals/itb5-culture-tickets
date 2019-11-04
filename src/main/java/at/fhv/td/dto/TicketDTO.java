package at.fhv.td.dto;

import at.fhv.td.rmi.interfaces.ITicketDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class TicketDTO extends UnicastRemoteObject implements ITicketDTO {
    private static final long serialVersionUID = 9213181597647725759L;
    private int _ticketNumber;
    private String _categoryname;
    private String _client;
    private Float _price;
    private Long _id;

    public TicketDTO() throws RemoteException {
        super();
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
    public String getCategoryname() throws RemoteException {
        return _categoryname;
    }

    @Override
    public void setCategoryname(String categoryname) throws RemoteException {
        _categoryname = categoryname;
    }

    @Override
    public String getClient() throws RemoteException {
        return _client;
    }

    @Override
    public void setClient(String client) throws RemoteException {
        _client = client;
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
