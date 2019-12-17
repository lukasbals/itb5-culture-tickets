package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Event;

public class EventBroker extends Broker<Event> {
    private static EventBroker _eventBroker = null;

    private EventBroker() {
    }

    public static EventBroker getInstance() {
        if (_eventBroker == null) {
            _eventBroker = new EventBroker();
        }
        return _eventBroker;
    }

    @Override
    protected Class<Event> getModelClass() {
        return Event.class;
    }
}
