package at.fhv.td.persistence.broker;

import at.fhv.td.domain.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserBrokerTest {

    @Test
    public void getModelClass() {
        UserBroker userBroker = UserBroker.getInstance();
        assertEquals(User.class, userBroker.getModelClass());
    }

    @Test
    public void getInstance() {
        UserBroker userBroker1 = UserBroker.getInstance();
        UserBroker userBroker2 = UserBroker.getInstance();
        assertEquals(userBroker1, userBroker2);
    }
}