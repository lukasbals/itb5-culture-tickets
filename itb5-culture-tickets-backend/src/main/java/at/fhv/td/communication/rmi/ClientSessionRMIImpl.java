package at.fhv.td.communication.rmi;

import at.fhv.td.application.UserController;
import at.fhv.td.communication.ILoadClient;
import at.fhv.td.communication.ILoadTicket;
import at.fhv.td.communication.IMessageFeed;
import at.fhv.td.communication.ISearchEvent;
import at.fhv.td.domain.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientSessionRMIImpl extends UnicastRemoteObject implements IClientSessionRMI {
    private static final String SELLER_ROLE_NAME = "seller";
    private static final String NEWS_READER_ROLE_NAME = "news-reader";
    private static final String NEWS_WRITER_ROLE_NAME = "news-writer";
    private static final long serialVersionUID = -8635265718445391597L;

    private User _user;

    public ClientSessionRMIImpl(String userName) throws RemoteException {
        super();
        _user = UserController.getUser(userName);
    }

    @Override
    public ISearchEvent createSearchEvent() throws RemoteException {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            try {
                return new SearchEventRMIImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public IBuyTicketRMI createBuyTicket() throws RemoteException {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            try {
                return new BuyTicketRMIImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ILoadClient createClient() throws RemoteException {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            try {
                return new LoadClientRMIImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ILoadTicket createLoadTicket() throws RemoteException {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            try {
                return new LoadTicketRMIImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public IMessageFeed createMessageFeed() throws RemoteException {
        if (UserController.hasRole(_user, NEWS_READER_ROLE_NAME)) {
            try {
                return new MessageFeedRMIImpl();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean isFeedWriter() throws RemoteException {
        return UserController.hasRole(_user, NEWS_WRITER_ROLE_NAME);
    }
}
