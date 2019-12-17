package at.fhv.td.persistence.broker;

import at.fhv.td.domain.PlaceCategory;

public class PlaceCategoryBroker extends Broker<PlaceCategory> {
    private static PlaceCategoryBroker _placeCategoryBroker = null;

    private PlaceCategoryBroker() {
    }

    public static PlaceCategoryBroker getInstance() {
        if (_placeCategoryBroker == null) {
            _placeCategoryBroker = new PlaceCategoryBroker();
        }
        return _placeCategoryBroker;
    }

    @Override
    protected Class<PlaceCategory> getModelClass() {
        return PlaceCategory.class;
    }
}
