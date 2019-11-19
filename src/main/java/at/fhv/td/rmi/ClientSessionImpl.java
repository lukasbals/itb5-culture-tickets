package at.fhv.td.rmi;

import at.fhv.td.application.UserController;
import at.fhv.td.domain.User;
import at.fhv.td.dto.TicketDTO;
import at.fhv.td.rmi.interfaces.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientSessionImpl extends UnicastRemoteObject implements IClientSession {

    private User _user;

    public ClientSessionImpl(String userName) throws RemoteException {
        super();
        _user = UserController.getUser(userName);
    }

    @Override
    public ISearchEvent createSearchEvent() throws RemoteException {
        return new SearchEventImpl();
    }

    @Override
    public IBuyTicket createBuyTicket() throws RemoteException {
        if (UserController.hasRole(_user, "admin")) {
            return new BuyTicketImpl();
        }

        return null;
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
