package at.fhv.td.dto;

import at.fhv.td.rmi.interfaces.IEventDetailedViewDTO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class EventDetailedViewDTO extends UnicastRemoteObject implements IEventDetailedViewDTO {
    private static final long serialVersionUID = 7761986907619195612L;
    private String _artists;
    private String _eventName;
    private String _description;
    private String[] _genres;
    private String _location;
    private Float[] _prices;
    private Boolean _isSeatReservationPossible;
    private String[] _placeCategories;
    private String _category;
    private LocalDate _date;
    private Long _eventId;

    public EventDetailedViewDTO() throws RemoteException {
        super();
    }

    @Override
    public String getEventName() throws RemoteException {
        return _eventName;
    }

    public void setEventName(String eventName) throws RemoteException {
        _eventName = eventName;
    }

    @Override
    public String getArtists() throws RemoteException {
        return _artists;
    }

    @Override
    public void setArtists(String artists) throws RemoteException {
        _artists = artists;
    }

    @Override
    public String getDescription() throws RemoteException {
        return _description;
    }

    @Override
    public void setDescription(String description) throws RemoteException {
        _description = description;
    }

    @Override
    public String[] getGenres() throws RemoteException {
        return _genres;
    }

    @Override
    public void setGenres(String[] genres) throws RemoteException {
        _genres = genres;
    }

    @Override
    public String getLocation() throws RemoteException {
        return _location;
    }

    @Override
    public void setLocation(String location) throws RemoteException {
        _location = location;
    }

    @Override
    public Float[] getPrices() throws RemoteException {
        return _prices;
    }

    @Override
    public void setPrices(Float[] prices) throws RemoteException {
        _prices = prices;
    }

    @Override
    public Float getMinPrice() {
        return Collections.min(Arrays.asList(_prices));
    }

    @Override
    public Boolean isSeatReservationPossible() throws RemoteException {
        return _isSeatReservationPossible;
    }

    @Override
    public void setSeatReservationPossible(Boolean seatReservationPossible) throws RemoteException {
        _isSeatReservationPossible = seatReservationPossible;
    }

    @Override
    public String[] getPlaceCategories() throws RemoteException {
        return _placeCategories;
    }

    @Override
    public void setPlaceCategories(String[] placeCategories) throws RemoteException {
        _placeCategories = placeCategories;
    }

    @Override
    public String getCategory() throws RemoteException {
        return _category;
    }

    @Override
    public void setCategory(String category) throws RemoteException {
        _category = category;
    }

    @Override
    public LocalDate getDate() throws RemoteException {
        return _date;
    }

    @Override
    public void setDate(LocalDate date) throws RemoteException {
        _date = date;
    }

    @Override
    public Long getEventId() throws RemoteException {
        return _eventId;
    }

    @Override
    public void setEventId(Long id) throws RemoteException {
        _eventId = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof EventDetailedViewDTO) {
            try {
                return getEventId().equals(((EventDetailedViewDTO) obj).getEventId());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_eventId);
    }
}
