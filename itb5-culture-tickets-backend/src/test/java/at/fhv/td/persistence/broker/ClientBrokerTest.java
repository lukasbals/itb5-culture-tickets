package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Client;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientBrokerTest {

    @Test
    public void getModelClass() {
        ClientBroker clientBroker = ClientBroker.getInstance();
        assertEquals(Client.class, clientBroker.getModelClass());
    }

    @Test
    public void getInstance() {
        ClientBroker clientBroker1 = ClientBroker.getInstance();
        ClientBroker clientBroker2 = ClientBroker.getInstance();
        assertEquals(clientBroker1, clientBroker2);
    }
}