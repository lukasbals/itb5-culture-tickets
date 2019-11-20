package at.fhv.td.rmi;

import at.fhv.td.application.UserController;
import at.fhv.td.domain.User;
import at.fhv.td.dto.TicketDTO;
import at.fhv.td.rmi.interfaces.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientSessionImpl extends UnicastRemoteObject implements IClientSession {
    private static final String SELLER_ROLE_NAME = "seller";
    private User _user;

    public ClientSessionImpl(String userName) throws RemoteException {
        super();
        _user = UserController.getUser(userName);
    }

    @Override
    public ISearchEvent createSearchEvent() throws RemoteException {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            return new SearchEventImpl();
        }
        return null;
    }

    @Override
    public IBuyTicket createBuyTicket() throws RemoteException {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            return new BuyTicketImpl();
        }
        return null;
    }

    @Override
    public ILoadClient createClient() throws RemoteException {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            return new LoadClientImpl();
        }
        return null;
    }

    @Override
    public ITicketDTO createTicketDTO() throws RemoteException {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            return new TicketDTO();
        }
        return null;
    }

    @Override
    public ILoadTicket createLoadTicket() throws RemoteException {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            return new LoadTicketImpl();
        }
        return null;
    }
}
