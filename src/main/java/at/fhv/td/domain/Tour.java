package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.ITour;
import at.fhv.td.persistence.broker.IModelId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tours")
public class Tour implements ITour, IModelId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id", updatable = false, nullable = false)
    private Long _tourId;

    @Column(name = "tourname")
    private String _tourName;

    @Column(name = "description")
    private String _description;

    @Column(name = "category")
    private String _category;

    @ManyToOne
    @JoinColumn(name = "username")
    private User _username;

    @ManyToMany
    @JoinTable(name = "going_on", joinColumns = {@JoinColumn(name = "tour_id")}, inverseJoinColumns = {
            @JoinColumn(name = "artist_id")})
    private Set<Artist> _artists;

    @Override
    public Long getId() {
        return _tourId;
    }

    @Override
    public void setId(Long id){
        _tourId = id;
    }

    @Override
    public String getTourName() {
        return _tourName;
    }

    public void setTourName(String newTourName) {
        _tourName = newTourName;
    }

    @Override
    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    @Override
    public String getCategory() {
        return _category;
    }

    public void setCategory(String category) {
        _category = category;
    }

    @Override
    public User getUsername() {
        return _username;
    }

    public void setUsername(User username) {
        _username = username;
    }

    @Override
    public Set<Artist> getArtists() {
        return _artists;
    }

    public void setArtists(Set<Artist> artists) {
        _artists = artists;
    }
}
