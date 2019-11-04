package at.fhv.td.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITicketDTO extends Remote {

    int getTicketNumber() throws RemoteException;

    void setTicketNumber(int ticketNumber) throws RemoteException;

    String getCategoryname() throws RemoteException;

    void setCategoryname(String categoryname) throws RemoteException;

    String getClient() throws RemoteException;

    void setClient(String client) throws RemoteException;

    Float getPrice() throws RemoteException;

    void setPrice(Float price) throws RemoteException;

    Long getId() throws RemoteException;

    void setId(Long id) throws RemoteException;

}