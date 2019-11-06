package at.fhv.td.domain.interfaces;

public interface ITicket {
    Long getTicketId();

    Integer getTicketNumber();

    Integer getSold();

    IPlaceCategory getPlaceCategory();

    IClient getClient();

    IEvent getEvent();
}
