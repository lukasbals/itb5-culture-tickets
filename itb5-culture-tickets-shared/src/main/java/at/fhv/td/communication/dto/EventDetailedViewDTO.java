package at.fhv.td.communication.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class EventDetailedViewDTO implements Serializable {
    private String _artists;
    private String _eventName;
    private String _description;
    private String[] _genres;
    private String _location;
    private Float[] _prices;
    private Boolean _isSeatReservationPossible;
    private Long[] _placeCategoriesId;
    private String[] _placeCategories;
    private Integer[] _placeCategoriesAmount;
    private String _category;
    private LocalDate _date;
    private Long _eventId;

    public EventDetailedViewDTO() {
        super();
    }

    public String getEventName() {
        return _eventName;
    }

    public void setEventName(String eventName) {
        _eventName = eventName;
    }

    public String getArtists() {
        return _artists;
    }

    public void setArtists(String artists) {
        _artists = artists;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String[] getGenres() {
        return _genres;
    }

    public void setGenres(String[] genres) {
        _genres = genres;
    }

    public String getLocation() {
        return _location;
    }

    public void setLocation(String location) {
        _location = location;
    }

    public Float[] getPrices() {
        return _prices;
    }

    public void setPrices(Float[] prices) {
        _prices = prices;
    }

    public Float getMinPrice() {
        return Collections.min(Arrays.asList(_prices));
    }

    public Boolean isSeatReservationPossible() {
        return _isSeatReservationPossible;
    }

    public void setSeatReservationPossible(Boolean seatReservationPossible) {
        _isSeatReservationPossible = seatReservationPossible;
    }

    public Long[] getPlaceCategoriesId() {
        return _placeCategoriesId;
    }

    public void setPlaceCategoriesId(Long[] placeCategoriesId) {
        _placeCategoriesId = placeCategoriesId;
    }

    public String[] getPlaceCategories() {
        return _placeCategories;
    }

    public void setPlaceCategories(String[] placeCategories) {
        _placeCategories = placeCategories;
    }

    public Integer[] getPlaceCategoriesAmount() {
        return _placeCategoriesAmount;
    }

    public void setPlaceCategoriesAmount(Integer[] amounts) {
        _placeCategoriesAmount = amounts;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    public LocalDate getDate() {
        return _date;
    }

    public void setDate(LocalDate date) {
        _date = date;
    }

    public Long getEventId() {
        return _eventId;
    }

    public void setEventId(Long id) {
        _eventId = id;
    }

    public boolean equals(Object obj) {
        if (obj instanceof EventDetailedViewDTO) {
            return getEventId().equals(((EventDetailedViewDTO) obj).getEventId());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(_eventId);
    }
}
