package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Event;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EventBrokerTest {

    @Test
    public void getModelClass() {
        EventBroker eventBroker = EventBroker.getInstance();
        assertEquals(Event.class, eventBroker.getModelClass());
    }

    @Test
    public void getInstance() {
        EventBroker eventBroker1 = EventBroker.getInstance();
        EventBroker eventBroker2 = EventBroker.getInstance();
        assertEquals(eventBroker1, eventBroker2);
    }
}