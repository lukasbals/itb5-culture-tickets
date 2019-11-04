package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IHasRole;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "has_roles")
public class HasRole implements IHasRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "has_role_id", updatable = false, nullable = false)
    private Long _hasRoleId;

    @OneToMany(mappedBy = "_roleId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Role> _roles = new LinkedList<>();

    @OneToMany(mappedBy = "_username", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> _users = new LinkedList<>();

    @Override
    public Long getHasRoleId() {
        return _hasRoleId;
    }

    @Override
    public List<Role> getRoles() {
        return _roles;
    }

    public void setRoles(List<Role> roles) {
        _roles = roles;
    }

    @Override
    public List<User> getUsers() {
        return _users;
    }

    public void setUsers(List<User> users) {
        _users = users;
    }
}
