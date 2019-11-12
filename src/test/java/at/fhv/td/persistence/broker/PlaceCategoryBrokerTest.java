package at.fhv.td.persistence.broker;

import at.fhv.td.domain.PlaceCategory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceCategoryBrokerTest {

    @Test
    public void getModelClass() {
        PlaceCategoryBroker placeCatBroker = PlaceCategoryBroker.getInstance();
        assertEquals(PlaceCategory.class, placeCatBroker.getModelClass());
    }

    @Test
    public void getInstance() {
        PlaceCategoryBroker placeCatBroker1 = PlaceCategoryBroker.getInstance();
        PlaceCategoryBroker placeCatBroker2 = PlaceCategoryBroker.getInstance();
        assertEquals(placeCatBroker1, placeCatBroker2);
    }
}