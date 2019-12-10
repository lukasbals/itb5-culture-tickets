package at.fhv.td.communication.rmi;

import at.fhv.td.application.EventController;
import at.fhv.td.domain.assembler.EventDetailAssembler;
import at.fhv.td.communication.rmi.interfaces.IEventDetailedViewDTO;
import at.fhv.td.communication.rmi.interfaces.ISearchEvent;

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

    public List<IEventDetailedViewDTO> searchForEvents(
            String searchingEventname,
            String searchingArtist,
            String searchingLocation,
            LocalDate searchingDate
    ) {
        return EventController
                .searchForEvents(searchingEventname, searchingArtist, searchingLocation, searchingDate)
                .stream()
                .map(EventDetailAssembler::toEventDetailedViewDTO)
                .collect(Collectors.toList());
    }
}
