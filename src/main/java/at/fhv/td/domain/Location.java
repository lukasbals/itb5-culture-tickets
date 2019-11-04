package at.fhv.td.domain;


import at.fhv.td.domain.interfaces.ILocation;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location implements ILocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", updatable = false, nullable = false)
    private Long _locationId;

    @Column(name = "address")
    private String _address;

    @Column(name = "room")
    private String _room;

    @Column(name = "building")
    private String _building;

    @Column(name = "seats")
    private Integer _seats;

    @Column(name = "standing_places")
    private Integer _standingPlaces;

    @Override
    public Long getLocationId() {
        return _locationId;
    }

    @Override
    public String getAddress() {
        return _address;
    }

    public void setAddress(String address) {
        _address = address;
    }

    @Override
    public String getRoom() {
        return _room;
    }

    public void setRoom(String room) {
        _room = room;
    }

    @Override
    public String getBuilding() {
        return _building;
    }

    public void setBuilding(String building) {
        _building = building;
    }

    @Override
    public Integer getSeats() {
        return _seats;
    }

    public void setSeats(Integer seats) {
        _seats = seats;
    }

    @Override
    public Integer getStandingPlaces() {
        return _standingPlaces;
    }

    public void setStandingPlaces(Integer standingPlaces) {
        _standingPlaces = standingPlaces;
    }

    @Override
    public String toString() {
        return "Location [_address=" + _address + ", _building=" + _building + "]";
    }
}