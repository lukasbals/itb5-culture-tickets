package at.fhv.td.dto;

import at.fhv.td.dto.dtoInterfaces.ITour;

import javax.persistence.*;

@Entity
@Table(name = "tours")
public class TourDTO implements ITour {

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
    private UserDTO _username;

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
    public UserDTO getUsername() {
        return _username;
    }

    public void setUsername(UserDTO username) {
        _username = username;
    }
}
