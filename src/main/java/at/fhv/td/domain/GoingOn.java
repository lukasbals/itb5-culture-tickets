package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IGoingOn;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "going_on")
public class GoingOn implements IGoingOn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "going_on_id", updatable = false, nullable = false)
    private Long _goingOnId;

    @OneToMany(mappedBy = "_tourId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tour> _tours = new LinkedList<>();

    @OneToMany(mappedBy = "_artistname", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Artist> _artists = new LinkedList<>();

    @Override
    public Long getGoingOnId() {
        return _goingOnId;
    }

    @Override
    public List<Tour> getTours() {
        return _tours;
    }

    public void setTours(List<Tour> tours) {
        _tours = tours;
    }

    @Override
    public List<Artist> getArtists() {
        return _artists;
    }

    public void setArtists(List<Artist> artists) {
        _artists = artists;
    }
}
