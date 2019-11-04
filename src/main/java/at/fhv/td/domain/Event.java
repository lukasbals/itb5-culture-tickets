package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IEvent;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event implements IEvent {
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
    private Tour _tourId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location _locationId;

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
    public Tour getTourId() {
        return _tourId;
    }

    public void setTourId(Tour tourId) {
        _tourId = tourId;
    }

    @Override
    public Location getLocationId() {
        return _locationId;
    }

    public void setLocationId(Location locationId) {
        _locationId = locationId;
    }
}
