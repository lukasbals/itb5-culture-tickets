package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.ITour;

import javax.persistence.*;

@Entity
@Table(name = "tours")
public class Tour implements ITour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id", updatable = false, nullable = false)
    private Long _tourId;

    @Column(name = "description")
    private String _description;

    @Column(name = "category")
    private String _category;

    @ManyToOne
    @JoinColumn(name = "username")
    private User _username;

    @Override
    public Long getTourId() {
        return _tourId;
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
}
