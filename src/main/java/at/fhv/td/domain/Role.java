package at.fhv.td.domain;

import at.fhv.td.domain.interfaces.IRole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements IRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", updatable = false, nullable = false)
    private Long _roleId;

    @Column(name = "role_name")
    private String _roleName;

    @Column(name = "rights")
    private String _rights;

    @Override
    public Long getRoleId() {
        return _roleId;
    }

    @Override
    public String getRoleName() {
        return _roleName;
    }

    public void setRoleName(String roleName) {
        _roleName = roleName;
    }

    @Override
    public String getRights() {
        return _rights;
    }

    public void setRights(String rights) {
        _rights = rights;
    }
}
