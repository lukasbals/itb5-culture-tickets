package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Location;
import at.fhv.td.domain.Tour;

import java.time.LocalDate;

public interface IEvent {
    Long getEventId();

    LocalDate getDate();

    Boolean getSeatReservationPossible();

    Tour getTourId();

    Location getLocationId();
}
