package at.fhv.td.dto.dtoInterfaces;

import at.fhv.td.dto.ClientDTO;
import at.fhv.td.dto.PlaceCategoryDTO;

public interface ITicket {
    Long getTicketId();

    Integer getTicketNumber();

    Integer getSold();

    PlaceCategoryDTO getCategoryname();

    ClientDTO getClientId();
}
