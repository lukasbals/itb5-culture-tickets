package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Location;
import at.fhv.td.domain.PlaceCategory;
import at.fhv.td.domain.Ticket;
import at.fhv.td.domain.Tour;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IEvent {
    Long getId();

    LocalDate getDate();

    Boolean getSeatReservationPossible();

    Tour getTour();

    Location getLocation();

    Set<PlaceCategory> getPlaceCategories();

    String getEventName();

    List<Ticket> getTickets();
}
