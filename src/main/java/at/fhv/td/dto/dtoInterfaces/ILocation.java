package at.fhv.td.dto.dtoInterfaces;

public interface ILocation {
    Long getLocationId();

    String getAddress();

    String getRoom();

    String getBuilding();

    Integer getSeats();

    Integer getStandingPlaces();
}
