package at.fhv.td.dto;

import at.fhv.td.dto.dtoInterfaces.IEvent;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class EventDTO implements IEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", updatable = false, nullable = false)
    private Long _eventId;

    @Column(name = "date")
    private LocalDate _date;

    @Column(name = "seat_reservation_possible")
    private Boolean _seatReservationPossible;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourDTO _tourId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationDTO _locationId;

    @Override
    public Long getEventId() {
        return _eventId;
    }

    @Override
    public LocalDate getDate() {
        return _date;
    }

    public void setDate(LocalDate date) {
        _date = date;
    }

    @Override
    public Boolean getSeatReservationPossible() {
        return _seatReservationPossible;
    }

    public void setSeatReservationPossible(Boolean seatReservationPossible) {
        _seatReservationPossible = seatReservationPossible;
    }

    @Override
    public TourDTO getTourId() {
        return _tourId;
    }

    public void setTourId(TourDTO tourId) {
        _tourId = tourId;
    }

    @Override
    public LocationDTO getLocationId() {
        return _locationId;
    }

    public void setLocationId(LocationDTO locationId) {
        _locationId = locationId;
    }
}
