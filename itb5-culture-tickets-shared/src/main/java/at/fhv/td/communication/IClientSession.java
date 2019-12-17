package at.fhv.td.communication;

import java.io.Serializable;
import java.rmi.RemoteException;

public interface IClientSession extends Serializable {
    ISearchEvent createSearchEvent() throws RemoteException;

    IBuyTicket createBuyTicket() throws RemoteException;

    ILoadClient createClient() throws RemoteException;

    ILoadTicket createLoadTicket() throws RemoteException;

    IMessageFeed createMessageFeed() throws RemoteException;
}
