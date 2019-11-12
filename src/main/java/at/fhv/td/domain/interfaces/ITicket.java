package at.fhv.td.domain.interfaces;

public interface ITicket {
    Long getId();

    Integer getTicketNumber();

    Integer getSold();

    IPlaceCategory getPlaceCategory();

    IClient getClient();

    IEvent getEvent();
}
