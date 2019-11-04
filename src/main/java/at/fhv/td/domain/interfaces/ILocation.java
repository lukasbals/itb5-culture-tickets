package at.fhv.td.domain.interfaces;

public interface ILocation {
    Long getLocationId();

    String getAddress();

    String getRoom();

    String getBuilding();

    Integer getSeats();

    Integer getStandingPlaces();
}
