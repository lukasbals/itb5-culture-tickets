package at.fhv.td.persistence.broker;

import at.fhv.td.domain.User;

public class UserBroker extends Broker<User> {
    private static UserBroker _userBroker = null;

    private UserBroker() {
    }

    public static UserBroker getInstance() {
        if (_userBroker == null) {
            _userBroker = new UserBroker();
        }
        return _userBroker;
    }

    @Override
    protected Class<User> getModelClass() {
        return User.class;
    }
}
