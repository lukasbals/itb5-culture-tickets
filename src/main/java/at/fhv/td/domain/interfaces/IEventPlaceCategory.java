package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Event;
import at.fhv.td.domain.PlaceCategory;

import java.util.List;

public interface IEventPlaceCategory {
    Long getEventsPlacesCategoriesId();

    List<Event> getEvents();

    List<PlaceCategory> getPlaceCategories();
}
