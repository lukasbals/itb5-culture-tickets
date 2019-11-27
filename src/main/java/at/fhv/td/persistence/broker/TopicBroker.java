package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Topic;

public class TopicBroker extends Broker<Topic> {
    private static TopicBroker _topicBroker = null;

    private TopicBroker() {
    }

    public static TopicBroker getInstance() {
        if (_topicBroker == null) {
            _topicBroker = new TopicBroker();
        }
        return _topicBroker;
    }

    @Override
    protected Class<Topic> getModelClass() {
        return Topic.class;
    }
}
