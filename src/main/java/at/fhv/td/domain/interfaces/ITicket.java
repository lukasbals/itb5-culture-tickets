package at.fhv.td.domain.interfaces;

import at.fhv.td.domain.Client;
import at.fhv.td.domain.Event;
import at.fhv.td.domain.PlaceCategory;

public interface ITicket {
    Long getTicketId();

    Integer getTicketNumber();

    Integer getSold();

    IPlaceCategory getPlaceCategory();

    IClient getClient();

    IEvent getEvent();
}
