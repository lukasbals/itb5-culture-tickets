package at.fhv.td.dto;

public class DTOEvent {
    private String _category;
    private String _artistname;
    private String _location;
    private String _date;
    private float _price;

    public DTOEvent(String category, String artistname, String location, String date, Float price) {
        _category = category;
        _artistname = artistname;
        _location = location;
        _date = date;
        _price = price;
    }

    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    public String getArtistname() {
        return _artistname;
    }

    public void setArtistname(String artistname) {
        _artistname = artistname;
    }

    public String getLocation() {
        return _location;
    }

    public void setLocation(String location) {
        _location = location;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        _date = date;
    }

    public float getPrice() {
        return _price;
    }

    public void setPrice(float price) {
        _price = price;
    }
}
