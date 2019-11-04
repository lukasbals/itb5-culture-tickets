package at.fhv.td.dto;

public class DTOArtist {
    private String _artistname;
    private String _genre;

    public DTOArtist(String artistname, String genre) {
        _artistname = artistname;
        _genre = genre;
    }

    public String getArtistname() {
        return _artistname;
    }

    public void setArtistname(String artistname) {
        _artistname = artistname;
    }

    public String getGenre() {
        return _genre;
    }

    public void setGenre(String genre) {
        _genre = genre;
    }
}
