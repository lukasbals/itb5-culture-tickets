package at.fhv.td.dto;

import at.fhv.td.dto.dtoInterfaces.IGoingOn;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "going_on")
public class GoingOnDTO implements IGoingOn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "going_on_id", updatable = false, nullable = false)
    private Long _goingOnId;

    @OneToMany(mappedBy = "_tourId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TourDTO> _tours = new LinkedList<>();

    @OneToMany(mappedBy = "_artistname", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ArtistDTO> _artists = new LinkedList<>();

    @Override
    public Long getGoingOnId() {
        return _goingOnId;
    }

    @Override
    public List<TourDTO> getTours() {
        return _tours;
    }

    public void setTours(List<TourDTO> tours) {
        _tours = tours;
    }

    @Override
    public List<ArtistDTO> getArtists() {
        return _artists;
    }

    public void setArtists(List<ArtistDTO> artists) {
        _artists = artists;
    }
}
