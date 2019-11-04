package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IArtist;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artists")
public class Artist implements IArtist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id", updatable = false, nullable = false)
    private Long _artistId;

    @Column(name = "artistname")
    private String _artistname;

    @Column(name = "genre")
    private String _genre;

    @ManyToMany(mappedBy = "_artists", fetch = FetchType.LAZY)
    private Set<Tour> _tours;

    @Override
    public Long getArtistId() {
        return _artistId;
    }

    @Override
    public String getArtistname() {
        return _artistname;
    }

    public void setArtistName(String artistname) {
        _artistname = artistname;
    }

    @Override
    public String getGenre() {
        return _genre;
    }

    public void setGenre(String genre) {
        _genre = genre;
    }

    @Override
    public Set<Tour> getTours() {
        return _tours;
    }

    public void setTours(Set<Tour> tours) {
        _tours = tours;
    }
}
