package at.fhv.td.dto.dtoInterfaces;

import at.fhv.td.dto.LocationDTO;
import at.fhv.td.dto.TourDTO;

import java.time.LocalDate;

public interface IEvent {
    Long getEventId();

    LocalDate getDate();

    Boolean getSeatReservationPossible();

    TourDTO getTourId();

    LocationDTO getLocationId();
}
