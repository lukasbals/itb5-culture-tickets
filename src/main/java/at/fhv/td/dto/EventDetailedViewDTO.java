package at.fhv.td.dto;

public class EventDetailedViewDTO {
    private String _artistname;
    private String _description;
    private String _genre;
    private String _location;
    private Float _price;
    private Boolean _isSeatReservationPossible;
    private String _categoryName;
    private String _category;
    private String _date;
    private TicketDTO[] _ticket;
    private Long _id;


    public EventDetailedViewDTO(String artistname, String description, String genre, String location, Float price,
                                Boolean isSeatReservationPossible, String categoryName, String category, String date,
                                TicketDTO[] tickets, Long id) {
        _artistname = artistname;
        _description = description;
        _genre = genre;
        _location = location;
        _price = price;
        _isSeatReservationPossible = isSeatReservationPossible;
        _categoryName = categoryName;
        _category = category;
        _date = date;
        _ticket = tickets;
        _id = id;
    }

    public String getArtistname() {
        return _artistname;
    }

    public void setArtistname(String artistname) {
        _artistname = artistname;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getGenre() {
        return _genre;
    }

    public void setGenre(String genre) {
        _genre = genre;
    }

    public String getLocation() {
        return _location;
    }

    public void setLocation(String location) {
        _location = location;
    }

    public Float getPrice() {
        return _price;
    }

    public void setPrice(Float price) {
        _price = price;
    }

    public Boolean isSeatReservationPossible() {
        return _isSeatReservationPossible;
    }

    public void setSeatReservationPossible(Boolean seatReservationPossible) {
        _isSeatReservationPossible = seatReservationPossible;
    }

    public String getCategoryName() {
        return _categoryName;
    }

    public void setCategoryName(String categoryName) {
        _categoryName = categoryName;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        _date = date;
    }

    public TicketDTO[] getTicket() {
        return _ticket;
    }

    public void setTicket(TicketDTO[] tickets) {
        _ticket = tickets;
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        _id = id;
    }
}
