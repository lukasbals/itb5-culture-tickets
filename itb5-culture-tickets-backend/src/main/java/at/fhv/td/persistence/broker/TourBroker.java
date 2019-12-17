package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Tour;

public class TourBroker extends Broker<Tour> {
    private static TourBroker _tourBroker = null;

    private TourBroker() {
    }

    public static TourBroker getInstance() {
        if (_tourBroker == null) {
            _tourBroker = new TourBroker();
        }
        return _tourBroker;
    }

    @Override
    protected Class<Tour> getModelClass() {
        return Tour.class;
    }
}
