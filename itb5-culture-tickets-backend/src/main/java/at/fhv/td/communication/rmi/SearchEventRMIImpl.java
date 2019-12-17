package at.fhv.td.communication.rmi;

import at.fhv.td.application.EventController;
import at.fhv.td.communication.dto.EventDetailedViewDTO;
import at.fhv.td.domain.assembler.EventDetailAssembler;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEventRMIImpl extends UnicastRemoteObject implements ISearchEventRMI {

    private static final long serialVersionUID = 2682440981477041481L;

    public SearchEventRMIImpl() throws RemoteException {
        super();
    }

    @Override
    public List<EventDetailedViewDTO> searchForEvents(
            String searchingEventname,
            String searchingArtist,
            String searchingLocation,
            LocalDate searchingDate
    ) throws RemoteException {
        return EventController
                .searchForEvents(searchingEventname, searchingArtist, searchingLocation, searchingDate)
                .stream()
                .map(EventDetailAssembler::toEventDetailedViewDTO)
                .collect(Collectors.toList());
    }
}
