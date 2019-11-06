package at.fhv.td.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClientSessionFactory extends Remote {
    public abstract ISearchEvent createSearchEvent() throws RemoteException;
    public abstract IBuyTicket createBuyTicket() throws RemoteException;
    public abstract ILoadClient createClient() throws RemoteException;
    public abstract ITicketDTO createTicketDTO() throws RemoteException;
}
