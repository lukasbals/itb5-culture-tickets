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

    @Transient
    public String getLocationString() {
        return String.join(", ", _address, _building);
    }

    @Override
    public String toString() {
        return "Location [_address=" + _address + ", _building=" + _building + "]";
    }
}