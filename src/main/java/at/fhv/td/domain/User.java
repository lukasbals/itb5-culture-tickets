package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IUser;
import at.fhv.td.persistence.broker.IModelId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements IUser, IModelId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long _userId;
    @Column(name = "username", nullable = false)
    private String _username;
    @Column(name = "email")
    private String _email;
    @ManyToMany
    @JoinTable(
            name = "has_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> _roles;

    @ManyToMany
    @JoinTable(
            name = "users_topics",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "topic_id")}
    )
    private Set<Topic> _topics;

    @Override
    public Long getId() {
        return _userId;
    }

    @Override
    public void setId(Long id) {
        _userId = id;
    }

    @Override
    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        _username = username;
    }

    @Override
    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    @Override
    public Set<Role> getRoles() {
        return _roles;
    }

    @Override
    public Set<Topic> getTopics() {
        return _topics;
    }

    public void setRoles(Set<Role> roles) {
        _roles = roles;
    }

    public void setTopics(Set<Topic> topics) {
        _topics = topics;
    }
}
