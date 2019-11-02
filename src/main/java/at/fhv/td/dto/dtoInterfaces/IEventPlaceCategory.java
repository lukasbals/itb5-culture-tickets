package at.fhv.td.dto.dtoInterfaces;

import at.fhv.td.dto.EventDTO;
import at.fhv.td.dto.PlaceCategoryDTO;

import java.util.List;

public interface IEventPlaceCategory {
    Long getEventsPlacesCategoriesId();

    List<EventDTO> getEvents();

    List<PlaceCategoryDTO> getPlaceCategories();
}
