package at.fhv.td.application;

import at.fhv.td.domain.EventDetailAssembler;
import at.fhv.td.domain.interfaces.IEvent;
import at.fhv.td.persistence.broker.EventBroker;
import at.fhv.td.rmi.interfaces.IEventDetailedViewDTO;
import at.fhv.td.rmi.interfaces.ISearchEvent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEventImpl extends UnicastRemoteObject implements ISearchEvent {

    private static final long serialVersionUID = 2682440981477041481L;

    public SearchEventImpl() throws RemoteException {
        super();
    }

    public List<IEventDetailedViewDTO> searchForEvents(String searchingEventname, String searchingArtist,
                                                       String searchingLocation, LocalDate searchingDate) throws RemoteException {
        return EventBroker.getInstance().getAll().stream()
                .filter(e -> checkEvent(e, searchingEventname, searchingArtist, searchingLocation, searchingDate))
                .map(e -> new EventDetailAssembler().toEventDetailedViewDTO(e))
                .collect(Collectors.toList());
    }

    boolean checkEvent(IEvent actualEvent, String searchingEventname, String searchingArtist, String searchingLocation,
                       LocalDate searchingDate) {
        boolean checksPassed = true;

        if (searchingDate == null) {
            searchingDate = LocalDate.now();
        }

        if (!searchingDate.equals(LocalDate.MIN)) {
            checksPassed &= actualEvent.getDate().isAfter(searchingDate)
                    || actualEvent.getDate().isEqual(searchingDate);
        }

        if (searchingEventname != null && !searchingEventname.equals("")) {
            checksPassed &= actualEvent.getEventname().toLowerCase().contains(searchingEventname.toLowerCase());
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
