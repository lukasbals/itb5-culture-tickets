package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IEvent;
import at.fhv.td.dto.EventDetailedViewDTO;
import at.fhv.td.rmi.interfaces.IEventDetailedViewDTO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class EventDetailAssembler {
    public IEventDetailedViewDTO toEventDetailedViewDTO(IEvent event) {
        String artists = event.getTour().getArtists().stream().map(Artist::getArtistname).collect(Collectors.joining(", "));
        String description = event.getTour().getDescription();
        String[] genres = event.getTour().getArtists().stream().map(Artist::getGenre).distinct().toArray(String[]::new);
        String location = String.join(", ", event.getLocation().getAddress(), event.getLocation().getBuilding());
        String category = event.getTour().getCategory();
        boolean isSeatReservationPossible = event.getSeatReservationPossible();
        LocalDate date = event.getDate();
        Long eventId = event.getEventId();
        String[] placeCategories = event.getPlaceCategories().stream().map(PlaceCategory::getCategoryname).toArray(String[]::new);
        Float[] prices = event.getPlaceCategories().stream().map(PlaceCategory::getPrice).toArray(Float[]::new);

        EventDetailedViewDTO newDto = null;
        try {
            newDto = new EventDetailedViewDTO();
            newDto.setArtists(artists);
            newDto.setDescription(description);
            newDto.setCategory(category);
            newDto.setPlaceCategories(placeCategories);
            newDto.setDate(date);
            newDto.setEventId(eventId);
            newDto.setGenres(genres);
            newDto.setLocation(location);
            newDto.setPrices(prices);
            newDto.setSeatReservationPossible(isSeatReservationPossible);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return newDto;
    }
}
