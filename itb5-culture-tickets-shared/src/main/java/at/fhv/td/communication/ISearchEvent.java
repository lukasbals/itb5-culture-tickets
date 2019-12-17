package at.fhv.td.communication;

import at.fhv.td.communication.dto.EventDetailedViewDTO;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

public interface ISearchEvent extends Serializable {
    List<EventDetailedViewDTO> searchForEvents(String eventName, String artistName, String location, LocalDate eventDate) throws RemoteException;
}
