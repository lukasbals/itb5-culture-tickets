package at.fhv.td.rmi;

import at.fhv.td.dto.TicketDTO;
import at.fhv.td.rmi.interfaces.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientSessionFactoryImpl extends UnicastRemoteObject implements IClientSessionFactory {

    private static final long serialVersionUID = -9132753231693520420L;

    public ClientSessionFactoryImpl() throws RemoteException {
        super();
    }

    @Override
    public ISearchEvent createSearchEvent() throws RemoteException {
        return new SearchEventImpl();
    }

    @Override
    public IBuyTicket createBuyTicket() throws RemoteException {
        return new BuyTicketImpl();
    }

    @Override
    public ILoadClient createClient() throws RemoteException {
        return new LoadClientImpl();
    }

    @Override
    public ITicketDTO createTicketDTO() throws RemoteException {
        return new TicketDTO();
    }

    @Override
    public ILoadTicket createLoadTicket() throws RemoteException {
        return new LoadTicketImpl();
    }
}
