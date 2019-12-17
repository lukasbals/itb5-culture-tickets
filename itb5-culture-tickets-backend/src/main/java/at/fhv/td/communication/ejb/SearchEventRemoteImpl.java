package at.fhv.td.communication.ejb;

import at.fhv.td.application.EventController;
import at.fhv.td.communication.dto.EventDetailedViewDTO;
import at.fhv.td.domain.assembler.EventDetailAssembler;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class SearchEventRemoteImpl implements ISearchEventRemote {
    public List<EventDetailedViewDTO> searchForEvents(
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
