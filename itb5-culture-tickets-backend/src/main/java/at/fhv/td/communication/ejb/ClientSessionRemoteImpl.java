package at.fhv.td.communication.ejb;

import at.fhv.td.application.UserController;
import at.fhv.td.domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateful;

@Stateful
public class ClientSessionRemoteImpl implements IClientSessionRemote {
    private static final String SELLER_ROLE_NAME = "seller";
    private static final String MESSAGE_FEED_ROLE_NAME = "message-feed";

    @EJB
    private ISearchEventRemote _searchEventRemote;
    @EJB
    private IBuyTicketRemote _buyTicketRemote;
    @EJB
    private ILoadClientRemote _loadClientRemote;
    @EJB
    private ILoadTicketRemote _loadTicketRemote;
    @EJB
    private IMessageFeedRemote _messageFeedRemote;

    private User _user;

    public boolean login(String userName) {
        _user = UserController.getUser(userName);
        return _user != null;
    }

    @Override
    public ISearchEventRemote createSearchEvent() {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            return _searchEventRemote;
        }
        return null;
    }

    @Override
    public IBuyTicketRemote createBuyTicket() {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            return _buyTicketRemote;
        }
        return null;
    }

    @Override
    public ILoadClientRemote createClient() {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            return _loadClientRemote;
        }
        return null;
    }

    @Override
    public ILoadTicketRemote createLoadTicket() {
        if (UserController.hasRole(_user, SELLER_ROLE_NAME)) {
            return _loadTicketRemote;
        }
        return null;
    }

    @Override
    public IMessageFeedRemote createMessageFeed() {
        if (UserController.hasRole(_user, MESSAGE_FEED_ROLE_NAME)) {
            return _messageFeedRemote;
        }
        return null;
    }
}
