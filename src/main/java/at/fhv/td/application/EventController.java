package at.fhv.td.application;

import at.fhv.td.domain.Event;
import at.fhv.td.domain.interfaces.IEvent;
import at.fhv.td.persistence.broker.EventBroker;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Lukas Bals
 */
public class EventController {
    private EventController() {
    }

    public static List<Event> searchForEvents(
            String searchingEventname,
            String searchingArtist,
            String searchingLocation,
            LocalDate searchingDate
    ) {
        return EventBroker.getInstance().getAll().stream()
                .filter(e -> checkEvent(e, searchingEventname, searchingArtist, searchingLocation, searchingDate))
                .collect(Collectors.toList());
    }

    static boolean checkEvent(
            IEvent actualEvent,
            String searchingEventname,
            String searchingArtist,
            String searchingLocation,
            LocalDate searchingDate
    ) {
        boolean checksPassed = true;

        if (searchingDate == null) {
            searchingDate = LocalDate.now();
        }

        if (!searchingDate.equals(LocalDate.MIN)) {
            checksPassed &= actualEvent.getDate().isAfter(searchingDate)
                    || actualEvent.getDate().isEqual(searchingDate);
        }

        if (searchingEventname != null && !searchingEventname.equals("")) {
            checksPassed &= actualEvent.getEventName().toLowerCase().contains(searchingEventname.toLowerCase());
        }

        if (searchingLocation != null && !searchingLocation.equals("")) {
            checksPassed &= actualEvent.getLocation().getLocationString().toLowerCase()
                    .contains(searchingLocation.toLowerCase());
        }

        if (searchingArtist != null && !searchingArtist.equals("") && actualEvent.getTour() != null) {
            checksPassed &= actualEvent.getTour().getArtists().stream()
                    .anyMatch(a -> a.getArtistname().toLowerCase().contains(searchingArtist.toLowerCase()));
        }

        return checksPassed;
    }
}
