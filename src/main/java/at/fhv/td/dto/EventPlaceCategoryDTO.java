package at.fhv.td.dto;

import at.fhv.td.dto.dtoInterfaces.IEventPlaceCategory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "events_places_categories")
public class EventPlaceCategoryDTO implements IEventPlaceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "events_places_categories_id", updatable = false, nullable = false)
    private Long _eventsPlacesCategoriesId;

    @OneToMany(mappedBy = "_eventId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EventDTO> _events = new LinkedList<>();

    @OneToMany(mappedBy = "_categoryname", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PlaceCategoryDTO> _placeCategories = new LinkedList<>();

    @Override
    public Long getEventsPlacesCategoriesId() {
        return _eventsPlacesCategoriesId;
    }

    @Override
    public List<EventDTO> getEvents() {
        return _events;
    }

    public void setEvents(List<EventDTO> events) {
        _events = events;
    }

    @Override
    public List<PlaceCategoryDTO> getPlaceCategories() {
        return _placeCategories;
    }

    public void setPlaceCategories(List<PlaceCategoryDTO> placeCategories) {
        _placeCategories = placeCategories;
    }
}