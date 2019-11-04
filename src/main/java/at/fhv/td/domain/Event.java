package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IEvent;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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
    private Tour _tour;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location _location;

    @ManyToMany
    @JoinTable(name = "events_places_categories", joinColumns = {
            @JoinColumn(name = "event_id")}, inverseJoinColumns = {@JoinColumn(name = "categoryname")})
    private Set<PlaceCategory> _placeCategories;

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
    public Tour getTour() {
        return _tour;
    }

    public void setTour(Tour tour) {
        _tour = tour;
    }

    @Override
    public Location getLocation() {
        return _location;
    }

    public void setLocation(Location locationId) {
        _location = locationId;
    }

    @Override
    public Set<PlaceCategory> getPlaceCategories() {
        return _placeCategories;
    }

    public void setPlaceCategories(Set<PlaceCategory> placeCategories) {
        _placeCategories = placeCategories;
    }

    @Override
    public String getEventname() {
        return _tour.getTourName();
    }
}
