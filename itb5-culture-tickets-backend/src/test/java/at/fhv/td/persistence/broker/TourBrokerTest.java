package at.fhv.td.persistence.broker;

import at.fhv.td.domain.Tour;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TourBrokerTest {

    @Test
    public void getModelClass() {
        TourBroker tourBroker = TourBroker.getInstance();
        assertEquals(Tour.class, tourBroker.getModelClass());
    }

    @Test
    public void getInstance() {
        TourBroker tourBroker1 = TourBroker.getInstance();
        TourBroker tourBroker2 = TourBroker.getInstance();
        assertEquals(tourBroker1, tourBroker2);
    }
}