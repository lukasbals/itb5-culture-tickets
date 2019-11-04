package at.fhv.td.dto;

public class DTOEventDescription {
    private String _artistname;
    private String _description;
    private String _location;
    private float _price;
    private boolean _isSeatReservationPossible;
    private String _categoryName;
    private String _category;
    private int[] _notSoldTicketNumbers;

    public DTOEventDescription(String artistname, String description, String location, float price,
                               boolean isSeatReservationPossible, String categoryName, String category,
                               int[] notSoldTicketNumbers) {
        _artistname = artistname;
        _description = description;
        _location = location;
        _price = price;
        _isSeatReservationPossible = isSeatReservationPossible;
        _categoryName = categoryName;
        _category = category;
        _notSoldTicketNumbers = notSoldTicketNumbers;
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

    public String getLocation() {
        return _location;
    }

    public void setLocation(String location) {
        _location = location;
    }

    public float getPrice() {
        return _price;
    }

    public void setPrice(float price) {
        _price = price;
    }

    public boolean isSeatReservationPossible() {
        return _isSeatReservationPossible;
    }

    public void setSeatReservationPossible(boolean seatReservationPossible) {
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

    public int[] getNotSoldTicketNumbers() {
        return _notSoldTicketNumbers;
    }

    public void setNotSoldTicketNumbers(int[] notSoldTicketNumbers) {
        _notSoldTicketNumbers = notSoldTicketNumbers;
    }
}
