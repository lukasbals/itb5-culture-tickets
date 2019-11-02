package at.fhv.td.dto;

import at.fhv.td.dto.dtoInterfaces.IArtist;

import javax.persistence.*;

@Entity
@Table(name = "artist")
public class ArtistDTO implements IArtist {
    @Id
    @Column(name = "artistname", updatable = false, nullable = false)
    private String _artistname;

    @Column(name = "genre")
    private String _genre;

    @Override
    public String getArtistname() {
        return _artistname;
    }

    @Override
    public String getGenre() {
        return _genre;
    }

    public void setGenre(String genre) {
        _genre = genre;
    }
}
