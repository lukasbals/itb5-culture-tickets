package at.fhv.td.application;

import at.fhv.td.domain.Topic;
import at.fhv.td.persistence.broker.TopicBroker;

import java.util.List;

public class TopicController {
    private TopicController() {
    }

    public static List<Topic> getTopics() {
        return TopicBroker.getInstance().getAll();
    }

}