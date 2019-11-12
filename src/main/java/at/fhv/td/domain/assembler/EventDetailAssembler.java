package at.fhv.td.domain.assembler;

import at.fhv.td.domain.Artist;
import at.fhv.td.domain.PlaceCategory;
import at.fhv.td.domain.interfaces.IEvent;
import at.fhv.td.dto.EventDetailedViewDTO;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class EventDetailAssembler {
    private EventDetailAssembler() {
    }

    public static EventDetailedViewDTO toEventDetailedViewDTO(IEvent event) {
        String eventName = event.getEventName();
        String artists = event.getTour().getArtists().stream().map(Artist::getArtistname).collect(Collectors.joining(", "));
        String description = event.getTour().getDescription();
        String[] genres = event.getTour().getArtists().stream().map(Artist::getGenre).distinct().toArray(String[]::new);
        String location = event.getLocation().getLocationString();
        String category = event.getTour().getCategory();
        boolean isSeatReservationPossible = event.getSeatReservationPossible();
        LocalDate date = event.getDate();
        Long eventId = event.getId();
        Long[] placeCategoriesId = event.getPlaceCategories().stream().map(PlaceCategory::getId).toArray(Long[]::new);
        String[] placeCategories = event.getPlaceCategories().stream().map(PlaceCategory::getCategoryName).toArray(String[]::new);
        Integer[] placeCategoriesAmounts = event.getPlaceCategories().stream().map(PlaceCategory::getAmount).toArray(Integer[]::new);
        Float[] prices = event.getPlaceCategories().stream().map(PlaceCategory::getPrice).toArray(Float[]::new);

        EventDetailedViewDTO newDto = null;
        try {
            newDto = new EventDetailedViewDTO();
            newDto.setEventName(eventName);
            newDto.setArtists(artists);
            newDto.setDescription(description);
            newDto.setCategory(category);
            newDto.setPlaceCategoriesId(placeCategoriesId);
            newDto.setPlaceCategories(placeCategories);
            newDto.setPlaceCategoriesAmount(placeCategoriesAmounts);
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
