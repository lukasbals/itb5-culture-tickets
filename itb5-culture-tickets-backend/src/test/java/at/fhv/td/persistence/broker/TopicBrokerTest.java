package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Topic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TopicBrokerTest {

    @Test
    public void getInstance() {
        TopicBroker topicBroker1 = TopicBroker.getInstance();
        TopicBroker topicBroker2 = TopicBroker.getInstance();
        assertEquals(topicBroker1, topicBroker2);
    }

    @Test
    public void getModelClass() {
        TopicBroker topicBroker = TopicBroker.getInstance();
        assertEquals(Topic.class, topicBroker.getModelClass());
    }
}