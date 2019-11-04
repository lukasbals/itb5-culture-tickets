package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IEventPlaceCategory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "events_places_categories")
public class EventPlaceCategory implements IEventPlaceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "events_places_categories_id", updatable = false, nullable = false)
    private Long _eventsPlacesCategoriesId;

    @OneToMany(mappedBy = "_eventId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> _events = new LinkedList<>();

    @OneToMany(mappedBy = "_categoryname", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PlaceCategory> _placeCategories = new LinkedList<>();

    @Override
    public Long getEventsPlacesCategoriesId() {
        return _eventsPlacesCategoriesId;
    }

    @Override
    public List<Event> getEvents() {
        return _events;
    }

    public void setEvents(List<Event> events) {
        _events = events;
    }

    @Override
    public List<PlaceCategory> getPlaceCategories() {
        return _placeCategories;
    }

    public void setPlaceCategories(List<PlaceCategory> placeCategories) {
        _placeCategories = placeCategories;
    }
}