package at.fhv.td.dto;

import at.fhv.td.dto.dtoInterfaces.IHasRole;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "has_roles")
public class HasRoleDTO implements IHasRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "has_role_id", updatable = false, nullable = false)
    private Long _hasRoleId;

    @OneToMany(mappedBy = "_roleId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoleDTO> _roles = new LinkedList<>();

    @OneToMany(mappedBy = "_username", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserDTO> _users = new LinkedList<>();

    @Override
    public Long getHasRoleId() {
        return _hasRoleId;
    }

    @Override
    public List<RoleDTO> getRoles() {
        return _roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        _roles = roles;
    }

    @Override
    public List<UserDTO> getUsers() {
        return _users;
    }

    public void setUsers(List<UserDTO> users) {
        _users = users;
    }
}
